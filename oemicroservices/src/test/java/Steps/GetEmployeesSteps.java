package Steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class GetEmployeesSteps {

    @LocalServerPort
    String port;

    ResponseEntity<String> lastResponse;

    @Given("^user hits the GET {string} endpoint$")
    public void userHitsTheGETEndpoint(String endpoint) {
        lastResponse = new RestTemplate().exchange("http://localhost:" + port + endpoint, HttpMethod.GET, null,
                String.class);

    }

    @Then("^user should be able to complete list of the EMPLOYEES$")
    public void userShouldBeAbleToCompleteListOfTheEMPLOYEES() {
        assertThat("Status code is "+)

    }

}
