package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequestTestCase
{

    @Test
    public void getAllBookings() {

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

    }

}