package tests;
import static io.restassured.RestAssured.given;

import java.io.InputStream;


import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;


public class JsonSchemaValidationTestCase
{
    @Test
    public void testGetBookingJsonSchema() {

        InputStream getBookingJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("response.json");

        System.out.println(getBookingJsonSchema);


        assert getBookingJsonSchema != null;
        given()
                    .contentType(ContentType.JSON)
                    .baseUri("http://open.er-api.com/v6/latest/USD")
                    .when()
                .get()
                .then()
                .statusCode(200)
                .assertThat()
                    .body(JsonSchemaValidator.matchesJsonSchema(getBookingJsonSchema));
    }
}
