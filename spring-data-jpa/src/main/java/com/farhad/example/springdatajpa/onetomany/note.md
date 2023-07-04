```
$ curl -X POST localhost:8080/libraries -H 'Content-type:application/json' -d '{"name": "library 01"}'
```

```
$ curl -X PUT localhost:8080/libraries/3 -H 'Content-type:application/json' -d '{"name": "updated library 01"}'
```

```
$ curl -X DELETE localhost:8080/libraries/3
```

```
$ curl localhost:8080/libraries/3
```

