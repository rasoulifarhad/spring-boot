> Example students marking the courses they like.

<br/>

> A student can like many courses, and many students can like the same course

<br/>

| Student |>------ Likes -------<| Course |

> As we know, in RDBMSs we can create relationships with foreign keys. 

<br/>

> Since both sides should be able to reference the other, ***we need to create a separate table to hold the foreign keys***:

| student |--------< course_like >---------| course |

> Such a table is called a ***join table***. In a join table, the combination of the foreign keys will be its composite primary key.

<br/>

> Modeling a many-to-many relationship with POJOs is easy. We should ***include a Collection in both classes***, which contains the elements of the others.

<br/>

> Also, we should configure the relationship type. So, ***we mark the collections with @ManyToMany*** annotations

<br/>

> Additionally, we have to configure how to model the relationship in the RDBMS.

<br/>

> The owner side is where we configure the relationship. (We'll use the Student class.)

>> ***We can do this with the @JoinTable annotation in the Student class.*** We provide the name of the join table (`course_like`) as well as the foreign keys with the `@JoinColumn` annotations. The `joinColumn` attribute will connect to the ***owner side*** of the relationship, and the `inverseJoinColumn` to the other side.

<br/>

```java
@ManyToMany
@JoinTable(
  name = "course_like", 
  joinColumns = @JoinColumn(name = "student_id"), 
  inverseJoinColumns = @JoinColumn(name = "course_id"))
Set<Course> likedCourses;
```

> ***On the target side, we only have to provide the name of the field, which maps the relationship.*** Therefore, we set the mappedBy attribute of the @ManyToMany annotation in the Course class.

<br/>

```java
@ManyToMany(mappedBy = "likedCourses")
Set<Student> likes;
```
> Keep in mind that since a many-to-many relationship doesn't have an owner side in the database, we could configure the join table in the Course class and reference it from the Student class.


> With JPA, when your Many-to-Many relationship between two entities with additional information, we need to create a new Java class