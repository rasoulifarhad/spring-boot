see  https://www.sivalabs.in/spring-boot-rest-api-best-practices-part-1/

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