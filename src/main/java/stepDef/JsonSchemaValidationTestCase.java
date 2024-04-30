package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.given;

// Validate the json schema of the response
public class JsonSchemaValidationTestCase
{
    @Test
    @Given("When user submits input schema")
    public void Submit_Input_jsonSchema() {

        InputStream getBookingJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("response.json");

        assert getBookingJsonSchema != null;
        given()
                    .contentType(ContentType.JSON)
                    .baseUri("http://open.er-api.com/v6/latest/USD")
                    .when()
                .get();
    }
    @Test
    @When("User submits the request")
    public void Submit_jsonSchema_request() {

        InputStream getBookingJsonSchema = getClass().getClassLoader()
                .getResourceAsStream("response.json");

        assert getBookingJsonSchema != null;
        given()
                .contentType(ContentType.JSON)
                .baseUri("http://open.er-api.com/v6/latest/USD")
                .when()
                .get()
                .then()
                .statusCode(200);
        System.out.println("Validated response successfully");
    }

    @Test
    @Then("Validate the response schema matches with the input schema")
    public void validate_jsonSchema_response() {

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
        System.out.println("Validated the json schema of the response successfully");
    }

}
