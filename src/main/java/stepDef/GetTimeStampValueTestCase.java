package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetTimeStampValueTestCase {
    @Test
    @When("User enters the input request")
    public void Submit_InputRequest() {

        Response response =
                RestAssured
                        .given()
                        .contentType(ContentType.JSON)
                        .baseUri("http://open.er-api.com/v6/latest/USD")
                        .when()
                        .get()
                        .then()
                        .extract()
                        .response();
        System.out.println("The response is returned successfully");
    }
    @Test
    @Then("Validate the timestamp response is not less than 3 seconds")
    public void Validate_TimeStampResponse() {

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

        System.out.println("The response is returned in "+ response.getTimeIn(TimeUnit.SECONDS)+"\t\tseconds");
        Assert.assertFalse(response.getTimeIn(TimeUnit.SECONDS)<3,"Timestamp less than 3 seconds");

    }

}
