package stepDef;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequestTestCase
{
    @Test
    @When("user enters request")

    public void Validate_getRequest_Success_Validation() {

        Response response =
                RestAssured
                        .given()
                        .contentType(ContentType.JSON)
                        .baseUri("http://open.er-api.com/v6/latest/USD")
                        .when()
                        .get();

        System.out.println("Submitted the get request successfully");

    }
    @Test
    @Then("Validate success message in response")
    public void Validate_getRequest_Success_Validation_message() {

        Response response =
                RestAssured
                        .given()
                        .contentType(ContentType.JSON)
                        .baseUri("http://open.er-api.com/v6/latest/USD")
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .statusLine("HTTP/1.1 200 OK")

                        .extract()
                        .response();


        Assert.assertTrue(response.getBody().asString().contains("success"));
        System.out.println("Validated the response message has success message successfully");

    }


}
