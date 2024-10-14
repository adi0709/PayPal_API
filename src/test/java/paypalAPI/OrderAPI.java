package paypalAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Orders;
import pojo.PurchaseUnit;
import base.BaseTest;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;


public class OrderAPI extends BaseTest {

    static String access_token;
    public static String intent = "CAPTURE";

    public static String getAuthKey() {
        access_token =
                given()
                        .auth().preemptive()
                        .basic(clientId, secretKey)
                        .param("grant_type", "client_credentials")
                        .log().all()
                        .post(config.getProperty("getAuthTokenEndpoint"))
                        .jsonPath()
                        .get("access_token").toString();

        return access_token;
    }

    public static Response createOrder(String currency_code, String amount) {

        ArrayList<PurchaseUnit> list = new ArrayList<PurchaseUnit>();
        list.add(new PurchaseUnit(currency_code, amount));
        Orders order = new Orders(intent, list);

        return given()
                .contentType(ContentType.JSON)
                .auth().oauth2(getAuthKey())
                .body(order)
                .log().all()
                .post(config.getProperty("createOrderEndpoint"));
    }

    public static Response getOrder(String orderId) {

        return given()
                .contentType(ContentType.JSON)
                .auth().oauth2(getAuthKey())
                .log().all()
                .get(config.getProperty("getOrdersEndpoint") + orderId);
    }

}
