# Spring Boot API with JWT Authentication

This is a Spring Boot application that demonstrates JWT authentication for users and interacts with a MySQL database based on incoming JSON payloads.


## Stack

- Java 18
- MySQL database
- Postman (for testing)
- Spring Boot 2.7.0
- jjwt 0.11.5
- RestAssured 4.5.0

### API Endpoints

The application will be accessible at http://localhost:8080.

#### 1. Add User
 - Endpoint: /user/add
 - Method: POST
 - Payload Example:
```json
{
  "username": "your_username",
  "password": "your_password"
}
```

#### 2. Authenticate User
 - Endpoint: /user/authenticate
 - Method: POST
 - Payload Example:
```json
{
  "username": "your_username",
  "password": "your_password"
}
```

#### 3. Add Products
 - Endpoint: /products/add
 - Method: POST
 - Payload Example:
```json
{
  "table": "products",
  "records": [
    {
      "entryDate": "03-01-2023",
      "itemCode": "11111",
      "itemName": "Test Inventory 1",
      "itemQuantity": "20",
      "status": "Paid"
    },
    {
      "entryDate": "03-01-2023",
      "itemCode": "11112",
      "itemName": "Test Inventory 2",
      "itemQuantity": "25",
      "status": "Paid"
    }
  ]
}
```

#### 4. Get All Products
  - Endpoint: /products/all
  - Method: GET

Note: Authentication is required for endpoints 3 and 4. Use the JWT token obtained from the authentication endpoint.

## Running Tests

The project includes integration tests for the endpoints mentioned above.



