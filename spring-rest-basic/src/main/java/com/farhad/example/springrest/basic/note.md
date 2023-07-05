
See https://spring.io/guides/tutorials/rest/

See https://github.com/spring-projects/spring-hateoas-examples

See https://datatracker.ietf.org/doc/html/rfc7807


```
$ curl -v -X POST localhost:8080/v2/customers -H 'Content-Type:application/json' -d '{"name": "Amir Amiri"}'

Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /v2/customers HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 22
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
< Location: http://localhost:8080/v2/customers/7
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 00:00:14 GMT
< 
{
  "firstName" : "Amir",
  "lastName" : "Amiri",
  "name" : "Amir Amiri",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/v2/customers/7"
    },
    "customers" : {
      "href" : "http://localhost:8080/v2/customers"
    }
  }
* Connection #0 to host localhost left intact
}
```


```
$ curl -v -X POST localhost:8080/v2/customers -H 'Content-Type:application/json' -d '{"firstName": "Amir2", "lastName": "Amiri2"}'

Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> POST /v2/customers HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 44
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
< Location: http://localhost:8080/v2/customers/8
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 00:01:54 GMT
< 
{
  "firstName" : "Amir2",
  "lastName" : "Amiri2",
  "name" : "Amir2 Amiri2",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/v2/customers/8"
    },
    "customers" : {
      "href" : "http://localhost:8080/v2/customers"
    }
  }
* Connection #0 to host localhost left intact
}
```

```
$ curl -v -X PUT localhost:8080/v2/customers/8 -H 'Content-Type:application/json' -d '{"name": "Amir3 Amiri3"}'

*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> PUT /v2/customers/8 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 24
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
< Location: http://localhost:8080/v2/customers/8
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 00:13:18 GMT
< 
{
  "firstName" : "Amir3",
  "lastName" : "Amiri3",
  "name" : "Amir3 Amiri3",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/v2/customers/8"
    },
    "customers" : {
      "href" : "http://localhost:8080/v2/customers"
    }
  }
* Connection #0 to host localhost left intact
}
```


```
$ curl -v http://localhost:8080/v2/customers/8

*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /v2/customers/8 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 00:14:26 GMT
< 
{
  "firstName" : "Amir3",
  "lastName" : "Amiri3",
  "name" : "Amir3 Amiri3",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/v2/customers/8"
    },
    "customers" : {
      "href" : "http://localhost:8080/v2/customers"
    }
  }
* Connection #0 to host localhost left intact
}
```


```
$ curl -v -X PUT localhost:8080/v2/customers/8 -H 'Content-Type:application/json' -d '{"firstName": "Amir4", "lastName": "Amiri4"}'

*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> PUT /v2/customers/8 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> Content-Type:application/json
> Content-Length: 44
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 201 
< Location: http://localhost:8080/v2/customers/8
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 00:14:54 GMT
< 
{
  "firstName" : "Amir4",
  "lastName" : "Amiri4",
  "name" : "Amir4 Amiri4",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/v2/customers/8"
    },
    "customers" : {
      "href" : "http://localhost:8080/v2/customers"
    }
  }
* Connection #0 to host localhost left intact
}
```

```
$ curl -v http://localhost:8080/v2/customers/8

*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /v2/customers/8 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 00:15:13 GMT
< 
{
  "firstName" : "Amir4",
  "lastName" : "Amiri4",
  "name" : "Amir4 Amiri4",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/v2/customers/8"
    },
    "customers" : {
      "href" : "http://localhost:8080/v2/customers"
    }
  }
* Connection #0 to host localhost left intact
}
```

```
$ curl -v -X DELETE http://localhost:8080/v2/customers/1

*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> DELETE /v2/customers/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 204 
< Date: Wed, 05 Jul 2023 00:18:46 GMT
< 
* Connection #0 to host localhost left intact
```

```
$ curl -v http://localhost:8080/v2/customers/1 | json_pp

*   Trying 127.0.0.1:8080...
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /v2/customers/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 500 
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 00:20:11 GMT
< Connection: close
< 
{ [126 bytes data]
100   120    0   120    0     0   7859      0 --:--:-- --:--:-- --:--:--  8000
* Closing connection 0
{
   "error" : "Internal Server Error",
   "path" : "/v2/customers/1",
   "status" : 500,
   "timestamp" : "2023-07-05T00:20:11.528+00:00"
}
```


```
$ curl -v http://localhost:8080/v2/orders

*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /v2/orders HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 03:46:17 GMT
< 
{
  "_embedded" : {
    "orders" : [ {
      "description" : "Mediocre Paper Computer",
      "status" : "IN_PROGRESS",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/v2/orders/1"
        },
        "orders" : {
          "href" : "http://localhost:8080/v2/orders"
        },
        "cancel" : {
          "href" : "http://localhost:8080/v2/orders/1/cancel"
        },
        "complete" : {
          "href" : "http://localhost:8080/v2/orders/1/complete"
        }
      }
    }, {
      "description" : "Rustic Copper Chair",
      "status" : "COMPLETED",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/v2/orders/2"
        },
        "orders" : {
          "href" : "http://localhost:8080/v2/orders"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/v2/orders"
    }
  }
* Connection #0 to host localhost left intact
}
```


```
$ curl -v -X DELETE http://localhost:8080/v2/orders/1/cancel

*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> DELETE /v2/orders/1/cancel HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 200 
< Content-Type: application/hal+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 03:49:41 GMT
< 
{
  "description" : "Intelligent Linen Keyboard",
  "status" : "CANCELED",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/v2/orders/1"
    },
    "orders" : {
      "href" : "http://localhost:8080/v2/orders"
    }
  }
* Connection #0 to host localhost left intact
}
```

```
$ curl -v -X DELETE http://localhost:8080/v2/orders/1/cancel

*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> DELETE /v2/orders/1/cancel HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 405 
< Content-Type: application/problem+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 03:51:41 GMT
< 
* Connection #0 to host localhost left intact
{"title":"Method not allowed","detail":"You can not cancel an order that is in the CANCELED status."}
```


```
$ curl -v -X PUT http://localhost:8080/v2/orders/1/complete

*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> PUT /v2/orders/1/complete HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.81.0
> Accept: */*
> 
* Mark bundle as not supporting multiuse
< HTTP/1.1 405 
< Content-Type: application/problem+json
< Transfer-Encoding: chunked
< Date: Wed, 05 Jul 2023 03:53:49 GMT
< 
* Connection #0 to host localhost left intact
{"title":"Method not allowed","detail":"You can not complete an order that is in CANCELED status"}
```
