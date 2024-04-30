package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GetTimeStampValueTestCase {
    @Test
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
        Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS)<3,"Timestamp less than 3 seconds");

    }
}
