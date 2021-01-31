package techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class GetRequest03 {
      	/*
	 Positive Scenario:
	 When Asagidaki Endpoint'e bir GET request yolladim
	 https://restful-booker.herokuapp.com/booking/7
     And Accept type “application/json” dir
     Then
     HTTP Status Code 200
     And Response format "application/json"
     And firstname "Eric"
     And lastname "Brown"
     And checkin date "2016-05-20"
     And checkout date "2020-12-18"
	*/
    @Test
    public void  get01(){
        String url = "https://restful-booker.herokuapp.com/booking/7";
        Response response=given().accept("application/json").when().get(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);//yukarda aslinda And Response format "application/json" yaziyor
        // ama biz ContentType.JSON kullanicaz


        response.then().
                assertThat().body("firstname", Matchers.equalTo("Mark")).
                body("lastname",Matchers.equalTo("Jones")).
                body("totalprice",Matchers.equalTo(975)).
                body("depositpaid",Matchers.equalTo(true)).
                body("bookingdates.checkin",Matchers.equalTo("2019-12-04")).
                body("bookingdates.checkout",Matchers.equalTo("2020-10-26"));
               // body("additionalneeds",Matchers.equalTo("Breakfast"));

        //2. yol yukarda cok ortak sey kullandik
        response.then().assertThat().body("firstname",Matchers.equalTo("Jim"),
                "lastname",Matchers.equalTo("Jones"),
                "totalprice",Matchers.equalTo(932),"depositpaid",Matchers.equalTo(true),
                "bookingdates.checkin",Matchers.equalTo("2019-12-04"),
                "bookingdates.checkout",Matchers.equalTo("2020-10-26"));

         //3. yol

        response.then().assertThat().body("firstname",equalTo("Jim"),
                "lastname",equalTo("Jones"),
                "totalprice",equalTo(932),"depositpaid",equalTo(true),
                "bookingdates.checkin",equalTo("2019-12-04"),
                "bookingdates.checkout",equalTo("2020-10-26"));

    }
}
