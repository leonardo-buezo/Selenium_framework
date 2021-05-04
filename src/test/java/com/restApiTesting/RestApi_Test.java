package com.restApiTesting;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

public class RestApi_Test {
    public static String url = "https://credapi.credify.tech/api/brportorch/v2/login";
    RequestSpecification request = RestAssured.given();
    private static Gson gson = new Gson();

    /**
     *
     * Api test with Rest Assured that validates a POST method for the login endpoint of credify.tech
     * Author: Leonardo Buezo
     * Date: 08/05/2020
     *
     */
    @Test
    public void getResults() throws Exception {
        request
                .contentType("application/json")
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", "34c16f53-38c4-461a-bd14-11fa748d2654")
                .body("{\"username\":\"coding.challenge.login@upgrade.com\"," + "\"password\":\"On$3XcgsW#9q\"}");
        Response response = request.post(url);

        int statusCode = response.getStatusCode();
        Assert.assertNotEquals(HttpStatus.SC_UNAUTHORIZED, statusCode);
        Assert.assertEquals(HttpStatus.SC_OK, statusCode);
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals( "Correct Success code was returned",200, statusCode);

        RegisteredUsers borrower = gson.fromJson(response.body().asString(), RegisteredUsers.class);
        for(LoansInReview loans : borrower.getLoansInReview()) {
            Assert.assertNotNull(loans.getId());
            Assert.assertNotNull(loans.getUuid());
            Assert.assertTrue("Invalid productType...", loans.getProductType().equals( "PERSONAL_LOAN"));
            Assert.assertEquals("BORROWER_FUNNEL_V2", loans.getSourceSystem());
        }
    }
}
