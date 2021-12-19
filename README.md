# Lambda for weather check

## Prerequisites

* Java 8 + Kotlin
* Serverless 2.69.1 or later

## Setting up project

1. Make sure you are logged into AWS or another cloud platform
2. Execute this command:
```
serverless deploy
```

## Usage

Make an HTTP POST request to the created lambda url with payload:
```json
{
  "city": "Tarnów"
}
```

Response:
```json
{
  "message": "City: Tarnów Temperature: 3.79 °C"
}
```