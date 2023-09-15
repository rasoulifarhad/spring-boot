see  https://www.sivalabs.in/spring-boot-rest-api-best-practices-part-1/

### Test

```sh
curl --location 'http://localhost:8080/api/bookmarks' \
   --header 'Content-Type: application/json' \
   --data '{
       "title": "googleeeeeeeeeeeeeeeeeeee",
       "url": "https://google.com"
  }'
```


```sh
curl -v --location --request PUT 'http://localhost:8080/api/bookmarks/{id}' \
   --header 'Content-Type: application/json' \
   --data '{
       "title": "googleeeeeeeeeeeeeeeeeeee- updaated",
       "url": "https://google.com"
   }'
```

```sh
curl --location 'http://localhost:8080/api/bookmarks/1'
```

```sh
curl --location --request DELETE 'http://localhost:8080/api/bookmarks/1'
```

```sh
curl --location --request DELETE 'http://localhost:8080/api/bookmarks/99999'
```


### Different approaches to handling exceptions

- Handling exceptions in the controller handler method
- Using Controller level @ExceptionHandler
- GlobalExceptionHandler using @RestControllerAdvice
    - Spring’s ProblemDetails for HTTP APIs (RFC 7807).
    - Using 3rd party libraries
        - [Error Handling Spring Boot Starter](https://github.com/wimdeblauwe/error-handling-spring-boot-starter) by Wim Deblauwe
        - [problem-spring-web](https://github.com/zalando/problem-spring-web) by Zalando

