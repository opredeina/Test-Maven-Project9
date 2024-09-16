package tests;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SimpleBooksTest extends BooksTestBase {

  @Test
  @DisplayName("Example 1: Extract First Value Multiple Matches")
  void extractFirstValueWhenSeveraReturned_findTitle() {
    Response response = RestAssured.given().get("v1/Books");
    String title = response.path("books.title[0]");
    System.out.println(title);

  }

  @Test
  @DisplayName("Example 2: Extract Last Value Multiple Matches")
  void extractLastValueWhenSeveraReturned_findTitle() {
    Response response = RestAssured.given().get("v1/Books");
    String title = response.path("books.title[-1]");
    System.out.println(title);

  }

  @Test
  @DisplayName("Example 3: Extract All Values into a List")
  void extractListOfValues_findAllAuthor() {
    Response response = RestAssured.given().get("v1/Books");
    List<String> allAuthors = response.path("books.author");
    System.out.println(allAuthors);

  }

  @Test
  @DisplayName("Example 4: Extract Multiple Maps of Objects")
  void extractListOfMapsOfElements_findAllBooksData() {
    Response response = RestAssured.given().get("v1/Books");
    List<Map<String, ?>> allBooksData = response.path("books");
    System.out.println(allBooksData);

  }

  @Test
  @DisplayName("Example 5: Extract Four Value Multiple Matches")
  void extractFourtValueWhenSeveraReturned_findTitle() {
    Response response = RestAssured.given().get("v1/Books");
    String publisher = response.path("books.publisher[3]");
    System.out.println(publisher);

  }

  @Test
  @DisplayName("Example 6: Use path() on Response")
  void extractSingleValue_findPublishdate() {
    Response response = RestAssured.given().get("v1/Books");
    String publishDate = response.path("books.publish_date[2]");
    System.out.println(publishDate);

  }

}