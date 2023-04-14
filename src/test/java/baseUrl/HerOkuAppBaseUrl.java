package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static util.AuthenticationHerOkuApp.generateToken;


public class HerOkuAppBaseUrl {
    protected RequestSpecification spec;

    @Before//This method will run before each @Test methods.
    public void setUp() {

        spec = new RequestSpecBuilder().
                addHeader("Cookie","token="+generateToken()).
                setContentType(ContentType.JSON).
                setBaseUri("https://restful-booker.herokuapp.com").
                build();

    }
}