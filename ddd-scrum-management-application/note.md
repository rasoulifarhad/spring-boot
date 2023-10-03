See https://www.dddcommunity.org/wp-content/uploads/files/pdf_articles/Vernon_2011_1.pdf
See https://www.dddcommunity.org/wp-content/uploads/files/pdf_articles/Vernon_2011_2.pdf
See https://www.dddcommunity.org/wp-content/uploads/files/pdf_articles/Vernon_2011_3.pdf


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