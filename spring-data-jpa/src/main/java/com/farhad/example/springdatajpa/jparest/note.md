- top level service:

```
$ curl http://localhost:8080
```

- how to see the people records :

```
$ curl http://localhost:8080/people
```

- create new person

```
$ curl -i -H "Content-Type:application/json" -d '{"firstName": "Farhad", "lastName": "Rasouli"}' http://localhost:8080/people
```

- All people:

```
$ curl http://localhost:8080/people
```

- individual person
  
```
$ curl http://localhost:8080/people/1
```

- find all the custom queries
  
```
$ curl http://localhost:8080/people/search
```


- findByLastName query:

```
$ curl http://localhost:8080/people/search/findByLastName?name=Baggins
```

- issue PUT, PATCH, and DELETE REST calls to replace, update, or delete existing persons 
  
```
$ curl -X PUT -H "Content-Type:application/json" -d '{"firstName": "Bilbo", "lastName": "Baggins"}' http://localhost:8080/people/1

$ curl http://localhost:8080/people/1
```


```
$ curl -X PATCH -H "Content-Type:application/json" -d '{"firstName": "Bilbo Jr."}' http://localhost:8080/people/1

$ curl http://localhost:8080/people/1
```

> PUT replaces an entire record. Fields not supplied are replaced with null. You can use PATCH to update a subset of items.  


- delete person

```
$ curl -X DELETE http://localhost:8080/people/1

$ curl http://localhost:8080/people
```