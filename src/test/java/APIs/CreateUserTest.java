package APIs;

import helper.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateUserTest {
    private static int userId; // static field to share userId across tests
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"Reem\", \"job\": \"Developer\" }";

        // Send POST request to create a user
        String response = RestAssured.given()
                .baseUri(baseURI)
                .basePath("/api/users")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract().asString();


        // Use JsonPath to parse the response and extract the userId
        JsonPath jsonPath = new JsonPath(response);
        userId = jsonPath.getInt("id");  // Extract the "id" field as an integer
        System.out.println(jsonPath.prettify());
        // Validate the response
        Assert.assertTrue(response.contains("Reem"));
        Assert.assertTrue(response.contains("Developer"));
        Assert.assertTrue(userId > 0, "User ID should be greater than 0");
        Assert.assertNotNull(userId, "User ID should not be null");
    }


    public static int getUserId() {
        return userId; // Getter to access userId in other tests
    }



}
