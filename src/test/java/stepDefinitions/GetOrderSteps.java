package stepDefinitions;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.Assert;
import paypalAPI.OrderAPI;

import static base.BaseTest.orderId;
import static base.BaseTest.response;
import static paypalAPI.OrderAPI.intent;


public class GetOrderSteps {

    @When("the user provides the correct orderId and hit the endpoint")
    public void the_user_provides_the_correct_order_id_and_hit_the_endpoint() {
        response = OrderAPI.getOrder(orderId);
    }

    @Then("the order details are displayed")
    public void the_order_details_are_displayed() {

        JSONObject jsonObject = new JSONObject(response.asString());
        Assert.assertEquals(jsonObject.get("intent").toString(), intent);
        Assert.assertEquals(jsonObject.get("status").toString(), "CREATED");
        Assert.assertEquals(response.statusCode(), 200);
    }
}
