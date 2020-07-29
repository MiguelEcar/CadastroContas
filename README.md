# Account Register

## Implementation
This repository contains a Accounts Registrer application.
The information is stored in a Database.

For testing purposes, it uses H2 Database, which may be easily replaced for production uses.
If changing the Database, Flyway migrations should be adjusted.

Full documentation can be seen at `http://localhost:8080/swagger-ui.html`

## Endpoints
- [POST] `/account` include a new account a return json with ID.
- [GET] `/account/all` returns all accounts with fees calculated.
- [GET] `/account/filter?page=0&size=10` returns paged list
- [GET] `/account/filter?name=XX` returns paged list filtered by name
- [GET] `/account/filter?dateFrom=2020-01-01&dateTo=2020-08-31` returns paged list filtered by date (between)

## Endpoints

### 1: [POST] `/account`

```json
    {
        "name": "Test Account",
        "mainValue": 10.00,
        "dueDate": "2020-07-01"
    }
```

Response: `Status: 201 Created`

```json
    {
        "id":7,
        "name": "Test Account",
        "mainValue": 10.00,
        "dueDate": "2020-07-01"
    }
```

### 2: [GET] `/account/all`

Response:
```json
    [
        {
            "id": 1,
            "name": "First Account",
            "mainValue": 100.00,
            "dueDate": "2020-07-29",
            "updatedValue": 102.000000000000000000000000000000000000000000000000000000000,
            "fine": 2.00,
            "interest": 0E-57
        },
        {
            "id": 2,
            "name": "Test Account",
            "mainValue": 10.00,
            "dueDate": "2020-07-01",
            "updatedValue": 11.33999999999999996891375531049561686813831329345703125000,
            "fine": 0.50,
            "interest": 0.83999999999999996891375531049561686813831329345703125000
        },
        ...
    ]
```



## Running - Non Docker Users

First things first:
- Make sure `Java` environment variable is correctly set.
- Make sure `Maven` environment variable is correctly set.

After cloning, or download and extract the repository:

### Spring Boot API

In the root folder of Spring Boot project,

On Windows,

```ps
    .\mvnw spring-boot:run
```

On Linux,

```sh
    sudo chmod +x ./mvnw
    sudo ./mvnw spring-boot:run
```



### Application defaults

- By default the API runs on port `8080`

Other configuration may be change in the [`application.properties`](/accounts-api/src/main/resources/application.properties).
