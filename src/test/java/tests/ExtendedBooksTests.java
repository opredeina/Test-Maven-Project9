package tests;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import models.BooksBodyModel;
import models.BooksResponseModel;
import org.junit.jupiter.api.Test;

public class ExtendedBooksTests {

  @Test
  void unsuccessBooksTest() {

    BooksBodyModel authData = new BooksBodyModel();
    authData.setUserId("2");
    authData.setCollectionOfIsbns("9781449325862");

    BooksResponseModel response = given()
        .body(authData)
        .contentType(JSON)
        .log().uri()

        .when()
        .post("https://demoqa.com/BookStore/v1/Books")

        .then()
        .log().status()
        .log().body()
        .statusCode(401)
        .extract().as(BooksResponseModel.class);

    assertEquals("1200", response.getCode());
    assertEquals("User not authorized!", response.getMessage());

  }

}
