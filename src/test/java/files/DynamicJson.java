package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static files.Payload.deleteBookPayload;
import static io.restassured.RestAssured.*;


public class DynamicJson {
    String bookID = "";

    @Test(dataProvider = "BooksData", priority = 0)
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String addbookResponse =
                given()
                        .header("Content-Type", "application/json")
                        .body(Payload.AddBookPayload(isbn, aisle))
                .when()
                        .post("/Library/Addbook.php")
                .then()
                        .log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = ReusableMethods.rawToJson(addbookResponse);
        System.out.println("Book id is : " + js.getString("ID"));


    }

    @Test
    public void getBook() {
        RestAssured.baseURI = "http://216.10.245.166";
        String getbook =
                given()
//            .log()
//            .all()
//            .queryParam("AuthorName","")
                        .queryParam("ID", "fsds3344234")
                        .when()
                        .get("/Library/GetBook.php")
                        .then()
//            .log()
//            .all()
                        .assertThat().statusCode(200).extract().response().asString();

        JsonPath js = ReusableMethods.rawToJson(getbook);
        bookID = js.get("[" + 0 + "].isbn").toString();
        System.out.println("Response Size : " + js.getString("size()"));
        ; //27459 at 4:08
        System.out.println(js.get("[" + 0 + "].isbn").toString()); //Prints first response
    }

    @Test
    public void deleteBook() {

    }

    @DataProvider(name="BooksData")
    public Object[][] getData() {
        return new Object[][]{
                {"arar","3132"},
                {"dfgef","4234"},
                {"ffeag","2355"}
        };
    }


//    @Parameters({"a", "b"})

    @Test(dataProvider="BooksData")
    public void callDeletebookAPI(String isbn, String aisle) {
        String bookID = isbn + aisle;

        System.out.println("Concated id " + bookID);
        RestAssured.baseURI = "http://216.10.245.166";
        given()
//            .log()
//            .all()
//            .queryParam("AuthorName","")
                .body(deleteBookPayload(bookID))
                .when()
                .post("/Library/DeleteBook.php")
                .then()
                .log()
                .all().toString();
    }
}
