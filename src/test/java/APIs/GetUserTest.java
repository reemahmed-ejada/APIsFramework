package APIs;

import helper.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetUserTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    @Test
    public void testGetUser() {
         String userId = "2"; // Replace with the actual user ID from the create step
        //int userId = CreateUserTest.getUserId(); // Get userId from CreateUserTest

        // Send GET request to retrieve the user
        String response = RestAssured.given()
                .baseUri(baseURI)
                .basePath("/api/users/{id}")
                .pathParam("id", userId)
                .when()
                .get()
                .then()
                .extract().asString();


        JsonPath jsonPath = new JsonPath(response);
        System.out.println(jsonPath.prettify());


        Assert.assertTrue(response.contains("Reem"), "User name should be Reem");
    }
}
