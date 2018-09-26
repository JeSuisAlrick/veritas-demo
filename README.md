# Veritas Demo

## Prerequisites
- MySQL Server 5.5+
- Maven 3.5+
- Postman or any other HTTP client app

## Setting up demo
Create mysql schema and user details:

```
Schema: vertis_demo
Username: vertisuser
Password: xKEMr$zL4X4m6cZ-
```

## Launch the Service
1) Clone or download project from here: [https://github.com/JeSuisAlrick/vertis-demo](https://github.com/JeSuisAlrick/vertis-demo)
2) Run `mvn spring-boot:run`

## Testing
1) Launch Postman
2) Click Authorization tab and select "Basic Auth" as Type
3) Set HTTP method to `GET`
4) Enter the following URL as the endpoint `http://localhost:8080/api/person/3/time-sheets`
5) Enter the following credentials:
```
Username: thomas-jo
Password: MyPl@!nP@ssw0rd
```
6) Send request

Results should look something like the following:
```
[
    {
        "id": 1,
        "title": "RQ-11526",
        "client": {
            "id": 1,
            "name": "Viva Ltd",
            "manager": {
                "id": 1,
                "firstName": "Thomas",
                "middleName": "Jones",
                "lastName": "Finkle",
                "username": "thomas-jo",
                "address": {
                    "streetNumber": "21A",
                    "streetName": "Fairfax Ave",
                    "city": "Kingston",
                    "postalCode": "KGN19",
                    "countryCode": "JM"
                },
                "position": {
                    "id": 1,
                    "name": "Manager"
                }
            }
        },
        "owner": {
            "id": 3,
            "firstName": "Roger",
            "middleName": "Jones",
            "lastName": "Finkle",
            "username": "roger-jo",
            "address": {
                "streetNumber": "21A",
                "streetName": "Fairfax Ave",
                "city": "Kingston",
                "postalCode": "KGN19",
                "countryCode": "JM"
            },
            "position": {
                "id": 2,
                "name": "Employee"
            }
        },
        "entries": [
            {
                "id": 1,
                "periodDate": "2018-03-23",
                "periodStart": "12:30:00",
                "periodEnd": "10:30:00",
                "comment": "I did something awesome!",
                "timeSheet": {
                    "id": 1,
                    "title": "RQ-11526",
                    "client": {
                        "id": 1,
                        "name": "Viva Ltd",
                        "manager": {
                            "id": 1,
                            "firstName": "Thomas",
                            "middleName": "Jones",
                            "lastName": "Finkle",
                            "username": "thomas-jo",
                            "address": {
                                "streetNumber": "21A",
                                "streetName": "Fairfax Ave",
                                "city": "Kingston",
                                "postalCode": "KGN19",
                                "countryCode": "JM"
                            },
                            "position": {
                                "id": 1,
                                "name": "Manager"
                            }
                        }
                    },
                    "owner": {
                        "id": 3,
                        "firstName": "Roger",
                        "middleName": "Jones",
                        "lastName": "Finkle",
                        "username": "roger-jo",
                        "address": {
                            "streetNumber": "21A",
                            "streetName": "Fairfax Ave",
                            "city": "Kingston",
                            "postalCode": "KGN19",
                            "countryCode": "JM"
                        },
                        "position": {
                            "id": 2,
                            "name": "Employee"
                        }
                    }
                }
            },
            {
                "id": 2,
                "periodDate": "2018-03-23",
                "periodStart": "15:30:00",
                "periodEnd": "13:30:00",
                "comment": "I did something else awesome!",
                "timeSheet": {
                    "id": 1,
                    "title": "RQ-11526",
                    "client": {
                        "id": 1,
                        "name": "Viva Ltd",
                        "manager": {
                            "id": 1,
                            "firstName": "Thomas",
                            "middleName": "Jones",
                            "lastName": "Finkle",
                            "username": "thomas-jo",
                            "address": {
                                "streetNumber": "21A",
                                "streetName": "Fairfax Ave",
                                "city": "Kingston",
                                "postalCode": "KGN19",
                                "countryCode": "JM"
                            },
                            "position": {
                                "id": 1,
                                "name": "Manager"
                            }
                        }
                    },
                    "owner": {
                        "id": 3,
                        "firstName": "Roger",
                        "middleName": "Jones",
                        "lastName": "Finkle",
                        "username": "roger-jo",
                        "address": {
                            "streetNumber": "21A",
                            "streetName": "Fairfax Ave",
                            "city": "Kingston",
                            "postalCode": "KGN19",
                            "countryCode": "JM"
                        },
                        "position": {
                            "id": 2,
                            "name": "Employee"
                        }
                    }
                }
            }
        ]
    }
]
```
