package smokeTest;

import baseUrl.HerOkuAppBaseUrl;


import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;


import java.util.HashMap;
import java.util.Map;



import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static smokeTest.S1Post.bookingId;

public class S4Patch extends HerOkuAppBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/{id}
    And
          {
            "firstname": "John",
            "lastname": "Doe"
          }
    When
        Send patch request

    Then
        Status code should be 200

    And
        {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2023-01-01",
                "checkout": "2024-01-01"
            },
            "additionalneeds": "Breakfast"
        }

     */

    @Test
    public void patchTest(){
        //Set the url
        spec.pathParams("first","booking","second",S1Post.bookingId);

        //Set the expected data
        Map<String,String> expectedData = new HashMap<>();
        expectedData.put("firstname","John");
        expectedData.put("lastname","Doe");

        //Send the request and get the response
        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String,Object> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));

    }
}
