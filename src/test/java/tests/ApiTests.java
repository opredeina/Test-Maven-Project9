package tests;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;

public class ApiTests {

  @Test
  void successfulLoginTest() {
    String authData = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";

    given()
           .body(authData)
           .contentType(JSON)
           .log().uri()

        .when()
           .post("https://reqres.in/api/login")

        .then()
           .log().status()
           .log().body()
           .statusCode(200)
           .body("token", is("QpwL5tke4Pnpja7X4"));
  }

  @Test
  void unsuccessfulLoginTest() {
    String authData = "{\"email\": \"peter@klaven\"}";

    given()
           .body(authData)
           .contentType(JSON)
           .log().uri()

        .when()
           .post("https://reqres.in/api/login")

        .then()
           .log().status()
           .log().body()
           .statusCode(400)
           .body("error", is("Missing password"));
  }

  @Test
  void notfoundSingleUserTest() {

    given()

        .log().uri()
        .get("https://reqres.in/api/users/23")
        .then()
        .log().status()
        .log().body()
        .statusCode(404);
  }

  @Test
  void updateUsersTest() {
    String authData = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}";

    given()
           .body(authData)
           .contentType(JSON)
           .log().uri()

        .when()
           .put("https://reqres.in/api/users/2")

        .then()
           .log().status()
           .log().body()
           .statusCode(200)
           .body("name", is("morpheus"))
           .body("job", is("zion resident"));

  }

  @Test
  void updateTwoUsersTest() {
    String authData = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}";

    given()
           .body(authData)
           .contentType(JSON)
           .log().uri()

        .when()
           .patch("https://reqres.in/api/users/2")

        .then()
           .log().status()
           .log().body()
           .statusCode(200)
           .body("name", is("morpheus"))
           .body("job", is("zion resident"));

  }

  @Test
  void deleteUserTest() {

    given()

        .log().uri()
        .delete("https://reqres.in/api/users/2")
        .then()
        .log().status()
        .log().body()
        .statusCode(204);

  }

  @Test
  void unsuccessBooksTest() {
    String authData = "{\"userId\": \"2\", \"collectionOfIsbns\": [{\"isbn\": \"9781449325862\"}]}";

    given()
        .body(authData)
        .contentType(JSON)
        .log().uri()

        .when()
        .post("https://demoqa.com/BookStore/v1/Books")

        .then()
        .log().status()
        .log().body()
        .statusCode(401)
        .body("code", is("1200"))
        .body("message", is("User not authorized!"));

  }

  @Test
  void successBooksTest() {

    given()

        .log().uri()
        .get("https://demoqa.com/BookStore/v1/Books")
        .then()
        .log().status()
        .log().body()
        .statusCode(200);

  }

  @Test
  void deleteBooksTest() {

    given()

        .log().uri()
        .delete("https://demoqa.com/BookStore/v1/Books")
        .then()
        .log().status()
        .log().body()
        .statusCode(401)
        .body("code", is("1200"))
        .body("message", is("User not authorized!"));

  }

  @Test
  void updateBooksTest() {
    String authData = "{\"code\": \"0\", \"message\": \"User not authorized!\"}";

    given()
        .body(authData)
        .contentType(JSON)
        .log().uri()

        .when()
        .put("https://demoqa.com/BookStore/v1/Books/9781449325862")

        .then()
        .log().status()
        .log().body()
        .statusCode(400)
        .body("code", is("1207"))
        .body("message", is("Request Body is Invalid!"));

  }

}
