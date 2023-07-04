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

### With address

```
$ curl http://localhost:8080

{
  "_links" : {
    "addresses" : {
      "href" : "http://localhost:8080/addresses{?page,size,sort}",
      "templated" : true
    },
    "people" : {
      "href" : "http://localhost:8080/people{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
}
```

- how to see the people records :

```
$ curl http://localhost:8080/people

{
  "_embedded" : {
    "people" : [ {
      "firstName" : "Farhad",
      "lastName" : "Rasouli",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/people/1"
        },
        "person" : {
          "href" : "http://localhost:8080/people/1"
        },
        "address" : {
          "href" : "http://localhost:8080/people/1/address"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/people"
    },
    "search" : {
      "href" : "http://localhost:8080/people/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
}
```


```
curl -i -H "Content-Type:application/json" -d '{"firstName": "Farhad", "lastName": "Rasouli"}' http://localhost:8080/people

{
  "firstName" : "Farhad",
  "lastName" : "Rasouli",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people/1"
    },
    "person" : {
      "href" : "http://localhost:8080/people/1"
    },
    "address" : {
      "href" : "http://localhost:8080/people/1/personAddress"
    }
  }
}
```

- All people:

```
$ curl http://localhost:8080/people

{
  "_embedded" : {
    "people" : [ {
      "firstName" : "Farhad",
      "lastName" : "Rasouli",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/people/1"
        },
        "person" : {
          "href" : "http://localhost:8080/people/1"
        },
        "address" : {
          "href" : "http://localhost:8080/people/1/personAddress"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/people"
    },
    "search" : {
      "href" : "http://localhost:8080/people/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
}
```

- individual person
  
```
$ curl http://localhost:8080/people/1

{
  "firstName" : "Farhad",
  "lastName" : "Rasouli",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people/1"
    },
    "person" : {
      "href" : "http://localhost:8080/people/1"
    },
    "address" : {
      "href" : "http://localhost:8080/people/1/personAddress"
    }
  }
}
```

- create address 

```
curl -i -H "Content-Type:application/json" -d '{"country": "Iran", "city": "Tehran", "street": "tehran"}' http://localhost:8080/addresses

{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/addresses/1"
    },
    "address" : {
      "href" : "http://localhost:8080/addresses/1"
    },
    "person" : {
      "href" : "http://localhost:8080/addresses/1/person"
    }
  }
}
```

- all address

```
curl http://localhost:8080/addresses

{
  "_embedded" : {
    "addresses" : [ {
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/addresses/1"
        },
        "address" : {
          "href" : "http://localhost:8080/addresses/1"
        },
        "person" : {
          "href" : "http://localhost:8080/addresses/1/person"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/addresses"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/addresses"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
}
```

- individual address

```
curl http://localhost:8080/addresses/1

{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/addresses/1"
    },
    "address" : {
      "href" : "http://localhost:8080/addresses/1"
    },
    "person" : {
      "href" : "http://localhost:8080/addresses/1/person"
    }
  }
}
```

- Creating the Associations

```
$ curl -i -X PUT -d "http://localhost:8080/addresses/1" -H "Content-Type:text/uri-list" http://localhost:8080/people/1/personAddress

HTTP/1.1 204 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Date: Tue, 04 Jul 2023 20:02:53 GMT

```

- check Associations
  
```
$ curl -i -X GET http://localhost:8080/addresses/1/person

TTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Location: http://localhost:8080/people/1
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 04 Jul 2023 20:05:01 GMT

{
  "firstName" : "Farhad",
  "lastName" : "Rasouli",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/people/1"
    },
    "person" : {
      "href" : "http://localhost:8080/people/1"
    },
    "address" : {
      "href" : "http://localhost:8080/people/1/personAddress"
    }
  }
}
```

```
$ curl -i -X GET http://localhost:8080/people/1/personAddress

HTTP/1.1 200 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Content-Location: http://localhost:8080/addresses/1
Content-Type: application/hal+json
Transfer-Encoding: chunked
Date: Tue, 04 Jul 2023 20:06:03 GMT

{
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/addresses/1"
    },
    "address" : {
      "href" : "http://localhost:8080/addresses/1"
    },
    "person" : {
      "href" : "http://localhost:8080/addresses/1/person"
    }
  }
}
```

- remove an association

```
$ curl -i -X DELETE http://localhost:8080/people/1/personAddress

HTTP/1.1 204 
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
Date: Tue, 04 Jul 2023 20:08:18 GMT

```

See https://www.baeldung.com/spring-data-rest-relationships

See https://spring.io/guides/tutorials/react-and-spring-data-rest/