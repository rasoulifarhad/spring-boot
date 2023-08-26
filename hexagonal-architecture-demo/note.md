See [Hexagonal Architecture using Spring Boot](https://www.javainuse.com/spring/boot_hex)


See https://www.baeldung.com/maven-download-sources-javadoc

```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"username":"xyz","password":"xyz"}' \
  http://localhost:8080/5/withdraw/1000 | json_pp

curl -H "Content-Type: application/json" \
  -X POST \
  -d '{"username":"xyz","password":"xyz"}' \
  http://localhost:8080/5/withdraw/1000 | json_pp
```

```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"username":"xyz","password":"xyz"}' \
  http://localhost:8080/5/deposit/500 | json_pp

curl -H "Content-Type: application/json" \
  -X POST \
  -d '{"username":"xyz","password":"xyz"}' \
  http://localhost:8080/5/deposit/500 | json_pp
```