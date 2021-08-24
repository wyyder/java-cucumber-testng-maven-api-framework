package steps;

import conf.Conf;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICrudTestSteps {

    protected Conf conf;

    static Response response;
    static RequestSpecification request;

    public APICrudTestSteps() {
        System.out.println("API Crud Test Steps Constructor");
    }


    @Before
    public void initialize() {
        conf = new Conf();
        System.out.println("Initialized Conf");
    }

    @Given("initialize Rest API")
    public void initialize_rest_api() {
        RestAssured.baseURI = conf.URI;
        request = RestAssured.given();
        String path = "/oauth1";
        RestAssured.given().header("Authorization", "OAuth oauth_consumer_key=\"RKCGzna7bv9YD57c\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1472121255\",oauth_nonce=\"e5VR16\",oauth_version=\"1.0\",oauth_signature=\"Or%2F2PqPg21wp967CASJtoo%2BF5Kk%3D\"").get(path).then().log().all();
    }

    @When("i make {string} request to path {string}")
    public void i_make_request_to_path(String http_method, String path) {
        response = request.when().get(path);
    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be(int status_code) {
        response.then().assertThat().statusCode(status_code);
    }

    @And("response should includes the following")
    public void response_should_includes_the_following() {
        System.out.println("Done !");
    }
}
