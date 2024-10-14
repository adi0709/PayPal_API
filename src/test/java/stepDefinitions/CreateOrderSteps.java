package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.Assert;
import paypalAPI.OrderAPI;
import java.io.IOException;
import static base.BaseTest.response;

public class CreateOrderSteps {

    @Before
    public void setUp() throws IOException {
        BaseTest.init();
    }

    @Given("the use has the correct access token")
    public void the_use_has_the_correct_access_token() {
        OrderAPI.getAuthKey();
    }
    @When("the user hits the correct endpoint and provide the currencyCode as {string} and the amount as {string}")
    public void the_user_hits_the_correct_endpoint_and_provide_the_currency_code_as_and_the_amount_as(String currency_code, String amount) {

        response = OrderAPI.createOrder(currency_code, amount);
    }
    @Then("the order is created")
    public void the_order_is_created() {

        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 201);
        JSONObject jsonObject = new JSONObject(response.asString());
        Assert.assertTrue(jsonObject.has("id"));
        Assert.assertEquals(jsonObject.get("status").toString(),"CREATED");
        BaseTest.orderId = response.jsonPath().get("id").toString();
    }
}
