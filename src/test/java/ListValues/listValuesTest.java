package ListValues;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class listValuesTest {
    String baseURI = "https://jsonplaceholder.typicode.com";
    String endpoint = "/posts";

    @Test
    @DisplayName("When listing the values, then write to the log file with markdown format")
    public void listValues() {
        RestAssured.baseURI = baseURI;

        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract()
                .response();

        JSONArray jsonArray = new JSONArray(response.asString());

        StringBuilder markdown = new StringBuilder();
        markdown.append("| slug | status | publishedAt | updatedAt |\n");
        markdown.append("|:-----------|-----------:|------------:|-------------:|\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject post = jsonArray.getJSONObject(i);
            String slug = post.getString("title"); // Assuming "title" can be used as a slug
            String status = "published"; // Assuming all posts are "published"
            String publishedAt = LocalDateTime.now().format(formatter); // Placeholder value
            String updatedAt = LocalDateTime.now().format(formatter); // Placeholder value

            markdown.append(String.format("| %s | %s | %s | %s |\n", slug, status, publishedAt, updatedAt));
        }

        System.out.println(markdown.toString());

        try (FileWriter fileWriter = new FileWriter("posts_log.md")) {
            fileWriter.write(markdown.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
