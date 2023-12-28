package dev.max;

import dev.max.dto.ProductRequest;
import dev.max.dto.Role;
import dev.max.dto.User;
import dev.max.dto.Product;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTests {

    @LocalServerPort
    private int port;

    private String username;
    private String password;
    private final Set<Role> roles = new HashSet<>();

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
        username = "testName";
        password = "password";
        roles.add(new Role(1L, "ROLE_USER"));
    }

    @Test
    public void testUserApi() {

        User user = new User(username, password, roles);

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/user/add")
                .then()
                .statusCode(200);

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/user/authenticate")
                .then()
                .statusCode(200)
                .body("accessToken", notNullValue());

    }

    @Test
    public void testProductApi() {
        String jwtToken = obtainJwtToken();

        Product product = new Product(1L, "22-02-2022", 11111, "Product", 10, "Paid");

        ProductRequest productRequest = new ProductRequest("products", List.of(product));

        given()
                .header("Authorization", "Bearer " + jwtToken)
                .contentType(ContentType.JSON)
                .body(productRequest)
                .when()
                .post("/products/add")
                .then()
                .statusCode(200);

        given()
                .header("Authorization", "Bearer " + jwtToken)
                .when()
                .get("/products/all")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }

    // Helper method to obtain JWT token
    private String obtainJwtToken() {
        User user = new User(username, password, roles);
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/user/authenticate")
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");
    }

}

