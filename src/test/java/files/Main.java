package files;

import groovy.json.JsonBuilder;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import static files.Payload.addPlacePayload;
//import static files.Payload.updatePlacePayload;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * Author : @partha51613
 * Email: github@partha51613.com
 *
 */

public class Main {

    @Test
    public void Test1() {


        //ADD Place API

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String jsonResponse =
                given()
                        .queryParam("key", "qaclick123")
                        .header("Content-Type", "application/json")
                        .body(addPlacePayload())
                        .when()
                        .post("maps/api/place/add/json")
                        .then()
//                .log()
//                .all()
                        .assertThat()
                        .statusCode(200)
                        .body("scope", equalTo("APP"))
                        .header("Server", equalTo("Apache/2.4.52 (Ubuntu)")).extract().response().asString();

        System.out.println("jsonResponse is: " + jsonResponse);
        JsonPath placeIDPath = new JsonPath(jsonResponse);
        String place_id = placeIDPath.getString("place_id");
        System.out.println("place ID is : : " + place_id);


        //GET PLACE API

        String getPlaceResponse =
                given()
//                .log()
//                .all()
                        .queryParam("key", "qaclick123")
                        .queryParam("place_id", place_id)
                        .when()
                        .get("/maps/api/place/get/json")
                        .then()
//                .log()
//                .all()
                        .extract().asString();
        JsonPath getAddressPath = new JsonPath(getPlaceResponse);
        System.out.println("Address is : " + getAddressPath.getString("address"));


        //UPDATE ADDRESS
        given()
                .log()
                .all()
//                .queryParam("place_id","0fe1fb4287c2749221006dcb6b921383")
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\"" + place_id + "\",\n" +
                        "\"address\":\"Mumbai\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}")
                .when()
                .put("maps/api/place/update/json")
                .then()
                .log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));


        /*
        .body("{\n" +
                "\"place_id\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\n" +
                "\"address\":\"70 Summer walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}")
        */


        //CHECK IF ADDRESS IS UPDATED

//        String getPlaceResponse =
        given()
//                .log()
//                .all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", place_id)
                .when()
                .get("/maps/api/place/get/json")
                .then()
//                .log()
//                .all()
                .body("address", equalTo("Mumbai"));
    }

    @Test
    public void getPlace(){
        //GET PLACE API
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String getPlaceResponse =
                given()
//                .log()
//                .all()
                        .queryParam("key", "qaclick123")
                        .queryParam("place_id", "c3314a7cc472fb6174fb9d159cfcab99")
                        .when()
                        .get("/maps/api/place/get/json")
                        .then()
//                .log()
//                .all()
                        .extract().asString();
        JsonPath getAddressPath = new JsonPath(getPlaceResponse);
        System.out.println("Address is : " + getAddressPath.getString("address"));

    }
}



