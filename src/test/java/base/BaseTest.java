package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public static Properties config = new Properties();
    public static FileInputStream fis;
    public static Response response;
    public static String orderId;
    public static String clientId;
    public static String secretKey;

    public static void init() throws IOException {

        fis = new FileInputStream("./src/test/resources/properties/config.properties");
        try {
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        RestAssured.baseURI = config.getProperty("baseURI");
        clientId = config.getProperty("clientId");
        secretKey = config.getProperty("secretKey");

    }
}
