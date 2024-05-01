package stepDef;

import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

// API call is successful and returns valid price.
public class GetAEDValueTestCase {
    public HashMap<String, Double> rates;
    @Test
    @When("User enters the request parameter")
    public void ValidateAPISuccess_returnsValidPrice() {

        Response response =
                RestAssured
                        .given()
                        .contentType(ContentType.JSON)
                        .baseUri("http://open.er-api.com/v6/latest/USD")
                        .when()
                        .get();


    } //Validates the AED Value of the corresponding dollar value
    @Test
    @Then("Verify the response is returned as AED Value for dollar value")
    public void Validate_aedValue()
        {
            Response response =
                    RestAssured
                            .given()
                            .contentType(ContentType.JSON)
                            .baseUri("http://open.er-api.com/v6/latest/USD")
                            .when()
                            .get()
                            .then()
                            .assertThat()
                            // Validates the status
                            .statusCode(200)
                            .statusLine("HTTP/1.1 200 OK")

                            .extract()
                            .response();

            HashMap<String, Double> rates = JsonPath.read(response.body().asString(), "$.rates");
            if (rates.containsKey("AED")) {
                Double f = rates.get("AED");
                System.out.println("Response : Returns valid rates for AED for  the corresponding dollar rates");

                System.out.println(f);
            }

        }
    }

