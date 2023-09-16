See https://www.freecodecamp.org/news/modern-clean-architecture/


Sample TODO List Application

A **todo list** is a collection of **tasks**. A **task** has a **name**, and is either **completed or not**. As a user, you can:

- Create a single todo list, and persist it
- Add a task
- Complete a task, or “uncomplete” it
- Delete a task
- List all tasks
- Filter completed/uncompleted tasks


The AggregateRoot interface is part of the [jMolecules](https://github.com/xmolecules/jmolecules) library. This library makes DDD concepts explicit in the domain code. During build, [a ByteBuddy plugin](https://github.com/xmolecules/jmolecules-integrations/tree/main/jmolecules-bytebuddy) maps the annotations to Spring Data annotations.

So we only have a single model, both for representing domain concepts, and persistence. Still, we don’t have any persistence-specific annotations in the domain code. We don’t tie ourselves to any framework.


The App's Behavior (and Use Cases)

Next, we define the behavior of the application that is visible to the end user. Any interaction of the user with the application happens as follows:

1. The user interface sends a request.
2. The backend reacts by executing a request handler. The request handler does everything necessary to fulfill the request:
	- Access the database
	- Call external services
	- Call domain entity methods
3. The request handler may return a response.

Rquest handler implement with a Java 8 functional interface.

A handler that returns a response implements the `java.util.Function` interface.

One question remains: who creates these handlers?

The answer: a class implementing the [BehaviorModel](https://github.com/bertilmuth/requirementsascode/blob/master/requirementsascodecore/src/main/java/org/requirementsascode/BehaviorModel.java) interface. The behavior model maps each request class to the request handler for this kind of request.
