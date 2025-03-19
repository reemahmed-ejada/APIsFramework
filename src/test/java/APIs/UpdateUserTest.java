package APIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import helper.ConfigReader;

import static io.restassured.RestAssured.given;

public class UpdateUserTest {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    @Test
    public void testUpdateUser() {
       // String userId = "2"; // Replace with the actual user ID from the create step
        int userId = CreateUserTest.getUserId(); // Get userId from CreateUserTest
        String requestBody = "{ \"name\": \"Reem Updated\", \"job\": \"Senior Developer\" }";

        String response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/api/users/" + userId)
                .then()
                .statusCode(200) // Assert that the update is successful
                .extract()
                .asString();


        // Use JsonPath to parse the response and extract the userId
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(jsonPath.prettify());

        Assert.assertTrue(response.contains("Reem Updated"), "Updated name should be John Updated");
    }
}
