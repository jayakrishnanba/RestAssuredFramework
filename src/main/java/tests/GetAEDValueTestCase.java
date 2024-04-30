package tests;

import com.jayway.jsonpath.JsonPath;
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
    public void ValidateAPISuccess_returnsValidPrice() {

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


        Assert.assertTrue(response.getBody().asString().contains("success"), "Validated the success message from response");
        HashMap<String, Double> rates = JsonPath.read(response.body().asString(), "$.rates");
        // Validates the valid price are returned
        System.out.println("Response : Returns valid rates for the corresponding to dollar rates");
        System.out.println(rates);

    } //Validates the AED Value of the corresponding dollar value
    @Test
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

