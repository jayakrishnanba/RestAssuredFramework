package tests;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class GetAEDValueTestCase {
    @Test
    public void getAEDConversionRates() {

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
        HashMap<String, Double> rates = JsonPath.read(response.body().asString(), "$.rates");
        System.out.println(rates);


            if(rates.containsKey("AED"))
            {
               Double f = rates.get("AED");
               System.out.println(f);
            }


    }
}
