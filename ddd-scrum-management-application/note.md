See https://www.dddcommunity.org/wp-content/uploads/files/pdf_articles/Vernon_2011_1.pdf
See https://www.dddcommunity.org/wp-content/uploads/files/pdf_articles/Vernon_2011_2.pdf
See https://www.dddcommunity.org/wp-content/uploads/files/pdf_articles/Vernon_2011_3.pdf

See https://www.mirkosertic.de/blog/2013/04/domain-driven-design-example/

## Designing a Scrum Management Application

product, product owner, team, backlog items, planned releases, and sprints.

> The Scrum terminology forms the starting point of the **ubiquitous language**.

<br/>

> It is a subscription-based application hosted using the software as a service (SaaS) model. 

<br/>

> Each subscribing organization is registered as a tenant, another term for our **ubiquitous language**.

<br/>

The team considered the following statements in the ubiquitous language:

- Products have backlog items, releases, and sprints.
- New product backlog items are planned.
- New product releases are scheduled.
- New product sprints are scheduled.
- A planned backlog item may be scheduled for release.
- A scheduled backlog item may be committed to a sprint

### First Attempt: Large-Cluster Aggregate 

The team put a lot of weight on the words **Products have** in the first statement. It sounded to some like composition, that objects needed to be interconnected like an object graph. Maintaining these object life cycles together was considered very important. So, the developers added the following consistency rules into the specification:

- if a backlog item is committed to a sprint, we must not allow it to be removed from the system.
- If a sprint has committed backlog items, we must not allow it to be removed from the system.
- If a release has scheduled backlog items, we must not allow it to be removed from the system.
- If a backlog item is scheduled for release, we mus not allow it to be removed from the system.

As a result, Product was first modeled as a very large aggregate.

![](image_01.png)

Consider a common simultaneous, multi-client usage scenario:

- Two users, Bill and Joe, view the same Product marked as version 1, and begin to work on it.
- Bill plans a new BacklogItem and commits. The Product version is incremented to 2.
- Joe schedules a new Release and tries to save, but his commit fails because it was based on Product version 1.

Failing all but one of their requests on an ongoing basis is completely unacceptable.

**Nothing about planning a new backlog item should logically interfere with scheduling a new release! Why did Joe's commit fail?** 

**At the heart of the issue, the large cluster aggregate was designed with false invariants in mind, not real business rules.**

### Second Attempt: Multiple Aggregates

![](image_02.png)

Each of the dependencies is associated by inference using a common ProductId, which is the identity of Product considered the parent of the other three.

With the large cluster aggregate design the method signatures looked like this:

```java
public class Product ... {
...
    public void planBacklogItem(String aSummary, String aCategory,
            BacklogItemType aType, StoryPoints aStoryPoints) {
    }
    public void scheduleRelease(String aName, String aDescription,
            Date aBegins, Date anEnds) {
    ...
    }
    public void scheduleSprint(String aName, String aGoals,
        Date aBegins, Date anEnds) {
    ...
    }
...
}    
...
```

All of these methods are [CQS] commands. That is, they
modify the state of the Product by adding the new ele-
ment to a collection, so they have a void return type. But
with the multiple aggregate design, we have:

```java
public class Product ... {
    ...
    public BacklogItem planBacklogItem(String aSummary, String aCategory,
        BacklogItemType aType, StoryPoints aStoryPoints) {
        ...
    }
    public Release scheduleRelease(String aName, String aDescription,
                Date aBegins, Date anEnds) {
        ...
    }
    public Sprint scheduleSprint(String aName, String aGoals,
            Date aBegins, Date anEnds) {
        ...
    }
    ...
}

```

These redesigned methods have a [CQS] query contract,
and act as factories. That is, they each respectively create a
new aggregate instance and return a reference to it. Now
when a client wants to plan a backlog item, the transaction-
al application service must do the following:

```java
@RequiredArgsConstructor
public class ProductBacklogItemService {

    private final ProductRepository productRepository;
    private final BacklogItemRepository backlogItemRepository;

    @Transactional
    public void planProductBacklogItem(String aTenantId, String aProductId,
            String aSummary, String aCategory,
            String aBacklogItemType, String aStoryPoints) {

        Product product = productRepository.productOfId(
                new TenantId(aTenantId),
                new ProductId(aProductId));

        BacklogItem plannedBacklogItem = product.planBacklogItem(
                aSummary,
                aCategory,
                BacklogItemType.valueOf(aBacklogItemType),
                StoryPoints.valueOf(aStoryPoints));

        backlogItemRepository.add(plannedBacklogItem);
    }
}
```

### Rule: Model True Invariants In Consistency Boundaries

When trying to discover the **aggregates** in a **bounded context**, we must understand the model's true invariants. Only with that knowledge can we determine which objects should be clustered into a given **aggregate**.

**An invariant is a business rule that must always be consistent.**

> There are different kinds of consistency.  


>> One is transactional, which is considered immediate and atomic.  

>> There is also eventual consistency.  

**When discussing invariants, we are referring to transactional consistency.**

We might have the invariant:

```
c = a + b
```

Therefore, when a is 2 and b is 3, c must be 5.

**According to that rule and conditions, if c is anything but 5, a system invariant is violated.** 

To ensure that c is consistent, we model a boundary around these specific attributes of the model:

```java
AggregateType1 {
    int a;
    int b;
    int c;

    operations...
}
```

**The consistency boundary logically asserts that everything inside adheres to a specific set of business invariant rules no matter what operations are performed.**

The consistency of everything outside this boundary is irrelevant to the **aggregate**. 

Thus, **aggregate** is synonymous with transactional consistency boundary.

When employing a typical persistence mechanism we use a single transaction3 to manage consistency.

**When the transaction commits, everything inside one boundary must be consistent.**

A properly designed **aggregate** is one that can be modified in any way required by the business with its invariants completely consistent within a single transaction.

**And a properly designed bounded context modifies only one aggregate instance per transaction in all cases.**

**Since aggregates must be designed with a consistency focus, it implies that the user interface should concentrate each request to execute a single command on just one aggregate instance.** 

If user requests try to accomplish too much, it will force the application to modify multiple instances at once.

**Therefore, aggregates are chiefly about consistency boundaries and not driven by a desire to design object graphs.**

### Rule: Design Small Aggregates

![](image_03.png)

If we are going to design small **aggregates**, what does **small** mean? 

The extreme would be an **aggregate** with only its globally unique identity and one additional attribute, which is not what's being recommended (unless that is truly what one specific **aggregate** requires). Rather, limit the **aggregate** to just the **root entity** and a minimal number of attributes and/or **value**-typed properties.4 The correct minimum is the ones necessary, and no more.

**Which ones are necessary?** The simple answer is: **those that must be consistent with others**, even if domain experts don't specify them as rules.

For example, `Product` has `name` and `description` attributes.  We can't imagine `name` and `description` being inconsistent, modeled in separate **aggregates**. 

When you change the `name` you probably also change the `description`. If you change one and not the other, it's probably because you are fixing a spelling error or making the `description` more fitting to the `name`.

Even though domain experts will probably not think of this as an explicit business rule, it is an implicit one.

What if you think you should model a contained part as an **entity**? 

First ask whether that part must itself change over time, or whether it can be completely replaced when change is necessary. 

 **If instances can be completely replaced, it points to the use of a value object rather than an entity.**

 **At times entity parts are necessary.**

 Favoring **value** types as **aggregate** parts doesn't mean the **aggregate** is immutable since the root entity itself mutates when one of its **value**-typed properties is replaced.

 There are important advantages to limiting internal parts to **values**. Depending on your persistence mechanism, **values** can be serialized with the **root entity**, whereas **entities** usually require separately tracked storage.

 **a high percentage of aggregates can be limited to a single entity, the root.**

 The [DDD] discussion of **aggregates** gives an example where multiple **entities** makes sense. 
 
 A purchase order is assigned a maximum allowable total, and the sum of all line items must not surpass the total.  The rule becomes tricky to enforce when multiple users simultaneously add line items. Any one addition is not permitted to exceed the limit, but concurrent additions by multiple users could collectively do so.  most of the time the invariants of business models are simpler to manage than that example. Recognizing this helps us to model **aggregates** with as few properties as possible.

 Smaller **aggregates** not only perform and scale better, they are also biased toward transactional success, meaning that conflicts preventing a commit are rare.

 Your domain will not often have true invariant constraints that force you into large composition design situations. When you occasionally encounter a true consistency rule, then add another few **entities**, or possibly a collection, as necessary, but continue to push yourself to keep the overall size as small as possible

 A common issue that arises is a particular use case that calls for
the modification of multiple aggregate instances. In such a
case we must determine whether the specified large user
goal is spread across multiple persistence transactions, or if
it occurs within just one. If it is the latter, it pays to be
skeptical. No matter how well it is written, such a use case
may not accurately reflect the true aggregates of our
model.

### Making Aggregates Work Together

![](image_04)

this has a few implications:

1. Both the referencing **aggregate** (`BacklogItem`) and the referenced **aggregate** (`Product`) must not be modified in the same transaction. Only one or the other may be modified in a single transaction.

2. If you are modifying multiple instances in a single transaction, it may be a strong indication that your consistency boundaries are wrong. If so, it is possibly a missed modeling opportunity; a concept of your **ubiquitous languag**e has not yet been discovered although it is waving its hands and shouting at you.

3. If you are attempting to apply point #2, and doing so influences a large cluster **aggregate** with all the previously stated caveats, it may be an indication that you need to use eventual consistency instead of atomic consistency.


If you don't hold any reference, you can't modify another **aggregate**. So the temptation to modify multiple **aggregates** in the same transaction could be squelched by avoiding the situation in the first place.

But that is overly limiting since domain models always require some associative connections. What might we do to facilitate necessary associations, protect from transaction misuse or inordinate failure, and allow the model to perform and scale?

![](image_05.png)


**Rule: Reference Other Aggregates By Identity**

Reference by identity doesn't completely prevent navigation through the model. Some will use a **repository** from inside an **aggregate** for look up. This technique is called **disconnected domain model**, and it's actually a form of lazy loading.

There's a different recommended approach, however: Use a **repository** or **domain service** to look up dependent objects ahead of invoking the **aggregate** behavior. A client **application service** may control this, then dispatch to the **aggregate**:

```java
public class ProductBacklogItemService ... {
...
    @Transactional
    public void assignTeamMemberToTask(
        String aTenantId,
        String aBacklogItemId,
        String aTaskId,
        String aTeamMemberId) {
        BacklogItem backlogItem =
            backlogItemRepository.backlogItemOfId(
                new TenantId(aTenantId),
                new BacklogItemId(aBacklogItemId));
        Team ofTeam =
            teamRepository.teamOfId(
                backlogItem.tenantId(),
                backlogItem.teamId());

        backlogItem.assignTeamMemberToTask(
                new TeamMemberId(aTeamMemberId),
                ofTeam,
                new TaskId(aTaskId));
    }
    ...
}
```

Having an **application service** resolve dependencies frees the **aggregate** from relying on either a **repository** or a **domain service**. Again, referencing multiple **aggregates** in one request does not give license to cause modification on two or more of them.

Limiting a model to using reference only by identity could make it more difficult to serve clients that assemble and render **user interface** views. You may have to use multiple **repositories** in a single use case to populate views. If query overhead causes performance issues, it may be worth considering the use of **CQRS** [Dahan, Fowler, Young]. Or you may need to strike a balance between inferred and direct object reference.

#### Scalability and Distribution

Since aggregates don't use direct references to other ag-
gregates, but reference by identity, their persistent state can
be moved around to reach large scale. Almost-infinite
scalability is achieved by allowing for continuous reparti-
tioning of aggregate data storage, as explained by
Amazon.com's Pat [Helland] in his position paper, Life
Beyond Distributed Transactions: an Apostate's Opinion.
What we call aggregate he calls entity. But what he de-
scribes is still aggregate by any other name; a unit of com-
position that has transactional consistency. Some NoSql
persistence mechanisms support the Amazon-inspired dis-
tributed storage. These provide much of what [Helland]
refers to as the lower, scale-aware layer. When employing a
distributed store, or even when using a SQL database with
similar motivations, reference by identity plays an import-
ant role.

Distribution extends beyond storage. Since there are always
multiple bounded contexts at play in a given core domain
initiative, reference by identity allows distributed domain
models to have associations from afar. When an event-driv-
en approach is in use, message-based domain events con-
taining aggregate identities are sent around the enterprise.
Message subscribers in foreign bounded contexts use the
identities to carry out operations in their own domain mod-
els. Reference by identity forms remote associations or
partners. Distributed operations are managed by what
[Helland] calls two-party activities; but in publish-
subscribe [POSA1, GoF] terms it's multi-party (two or
more). Transactions across distributed systems are not
atomic. The various systems bring multiple aggregates into
a consistent state eventually.


**Rule: Use Eventual Consistency Outside the Boundary**

There is a frequently overlooked statement found in the
[DDD] **aggregate** pattern definition. It bears heavily on
what we must do to achieve model consistency when mul-
tiple **aggregates** must be affected by a single client request.

Thus, if executing a command on one **aggregate** instance
requires that additional business rules execute on one or
more other **aggregates**, use eventual consistency. Accept-
ing that all **aggregate** instances in a large-scale, high-traffic
enterprise are never completely consistent helps us accept
that eventual consistency also makes sense in the smaller
scale where just a few instances are involved.

There is a practical way to support eventual consistency in a DDD model. An **aggregate** command method publishes a **domain event** that is in time delivered to one or more asynchronous subscribers:

```java
public class BacklogItem extends ConcurrencySafeEntity {
...
    public void commitTo(Sprint aSprint) {
    ...
    DomainEventPublisher
        .instance()
            .publish(new BacklogItemCommitted(
                this.tenantId(),
                this.backlogItemId(),
                this.sprintId()));
    }
    ...
}
```


