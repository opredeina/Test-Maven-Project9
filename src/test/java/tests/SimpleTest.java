package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleTest extends TestBase{

  @Test
  @DisplayName("Example 1: Use path() on Response")
  void extractSingleValue_findFirstName() {
  Response response = RestAssured.given().get("users/2");
  String firstName = response.path("data.first_name");
  System.out.println(firstName);

}

}
