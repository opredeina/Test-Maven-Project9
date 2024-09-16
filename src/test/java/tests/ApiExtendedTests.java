package tests;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import models.LoginBodyModel;
import models.LoginResponseModel;
import org.junit.jupiter.api.Test;

public class ApiExtendedTests {

  @Test
  void successfulModelLoginTest() {

    LoginBodyModel authData = new LoginBodyModel();
    authData.setEmail("eve.holt@reqres.in");
    authData.setPassword("cityslicka");

    LoginResponseModel response = given()
           .body(authData)
           .contentType(JSON)
           .log().uri()

        .when()
           .post("https://reqres.in/api/login")

        .then()
           .log().status()
           .log().body()
           .statusCode(200)
           .extract().as(LoginResponseModel.class);

    assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

  }

}
