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


So, where are all the controllers?

Well, there aren’t any that you have to create. At least if you only handle POST requests. (For the handling of GET requests, see the Q&A later.)

The spring-behavior-web library is part of the Modern Clean Architecture libraries. We define a single endpoint for requests. We specify the URL of that endpoint in the application.properties:

behavior.endpoint = /todolist

 If that property exists, spring-behavior-web sets up a controller for the endpoint in the background. That controller receives POST requests.

We don’t need to write Spring specific code to add new behavior. And we don’t need to add or change a controller.

Here’s what happens when the endpoint receives a POST request:

1. spring-behavior-web deserializes the request,
2. spring-behavior-web passes the request to a behavior configured by the behavior model,
3. the behavior passes the request to the appropriate request handler (if there is one),
4. spring-behavior-web serializes the response and passes it back to the endpoint (if there is one).

By default, spring-behavior-web wraps every call to a request handler in a transaction.

How to send POST requests

Once we start the Spring Boot application, we can send POST requests to the endpoint.

We include a @type property in the JSON content so that spring-behavior-web can determine the right request class during deserialization.

For example, this is a valid curl command of the To Do List application. It sends a FindOrCreateListRequest to the endpoint.

```sh
curl -H "Content-Type: application/json" -X POST -d '{"@type": "FindOrCreateListRequest"}' http://localhost:8080/todolist
```

… I want the web layer to evolve separately from the behavior?

Reasons why this may make sense include:

    the granularity of web requests is different from behavior model requests
    the web layer needs special processing of the requests

Remove the behavior.endpoint property in application.properties to turn off auto-configuration of the Controller in the background.

Follow the strategy described for GET requests for the other kinds of requests you need as well.

… I want to use a different framework than Spring?

To move away from Spring, remove the dependency to the spring-behavior-web library in your build script. All your behavior models with stay intact.

Create an instance of a behavior on your own:

Behavior behavior = StatelessBehavior.of(behaviorModel);

After that, you can call its reactTo(…) method.


See [ Modern Clean Architecture ](https://github.com/bertilmuth/modern-clean-architecture/)
See [Requirements as code](https://github.com/bertilmuth/requirementsascode)

See [jmolecules](https://github.com/xmolecules/jmolecules)
See [jmolecules-spring-data-jpa](https://github.com/xmolecules/jmolecules-examples/tree/main/jmolecules-spring-data-jpa)

