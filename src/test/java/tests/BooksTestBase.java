package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.BeforeAll;

public class BooksTestBase {

  @BeforeAll
  static void setUp() {

    RestAssured.baseURI = "https://demoqa.com/";
    RestAssured.basePath = "/BookStore/";
    RestAssured.requestSpecification = new RequestSpecBuilder()
        .log(LogDetail.ALL)
        .build();
    RestAssured.responseSpecification = new ResponseSpecBuilder()
        .log(LogDetail.BODY)
        .build();

  }

}
