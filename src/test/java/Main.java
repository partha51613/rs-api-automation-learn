import groovy.json.JsonBuilder;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static files.Payload.addPlacePayload;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class Main {

    @Test
    public void Test1() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given()
//                .log()
//                .all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(addPlacePayload())
        .when()
                .post("maps/api/place/add/json")
        .then().
                log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).header("Server",equalTo("Apache/2.4.52 (Ubuntu)"));


    }
}



