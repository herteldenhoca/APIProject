package techproed;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {
     /*
	 Positive Scenario:
	 when() Bir GET Request asagida verilen Endpoint'e yollanir
	        https://restful-booker.herokuapp.com/booking
	 and()  Accept Type'i "application/json" dir.
	 then() status code 200'dur
	 and()  content type  "application/json" dir.
	*/

        /*
         Negative Scenario:
         when() Bir GET Request asagida verilen Endpoint'e yollanir
                https://restful-booker.herokuapp.com/booking/1001
         and()  Accept Type'i "application/json" dir.
         then() status code 404'dur.
         */


    @Test
    public void get01(){
        //Url i olusturmak
        String url ="https://restful-booker.herokuapp.com/booking";
        //datayi olusturmak
        //Request i gonder
        Response response =given().accept(ContentType.JSON).when().get(url);
        response.prettyPrint();
//Status code u consolde gormek icin
        System.out.println("Status code"+response.getStatusCode());
        response.then().assertThat().statusCode(200);
        Assert.assertEquals(200,response.getStatusCode());
        //status line 1 gormek icin
        System.out.println("Status line"+response.getStatusLine());
//Content Type
        System.out.println("Content type"+response.getContentType());//application json
        response.then().assertThat().contentType(ContentType.JSON);
        System.out.println("Header"+response.getHeader("Content-Type"));

//headerstaki tum verileri gormek icin
        System.out.println(response.getHeaders());
        // Headers tan belirli bir veri alalım
        System.out.println("Date "+ response.getHeader("Date"));

/*
    Negative Scenario:
    when() Bir GET Request asagida verilen Endpoint'e yollanir
           https://restful-booker.herokuapp.com/booking/1001
    and()  Accept Type'i "application/json" dir.
    then() status code 404'dur.
    */
      }

    @Test
    public void get02(){
        //1. url i olustur
        String url = " https://restful-booker.herokuapp.com/booking/1001";

//Request olustur
        Response response =given().
                accept(ContentType.JSON).when().get(url);
        response.prettyPrint();
        System.out.println(response.getHeaders());
        response.then().assertThat().statusCode(404);
        Assert.assertEquals(404, response.getStatusCode());

    }
    /*
    Negative Scenario:
    when() Bir GET Request asagida verilen Endpoint'e yollanir
           https://restful-booker.herokuapp.com/booking/1001
    then() status code 404'dur
    and()  Response body'de "Not Found" var
    and()  Response body'de "API" yok
    */
    @Test
    public void get03(){
        // Url i olustur
        String url = "https://restful-booker.herokuapp.com/booking/1001";
        // Request olustur
        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(404);

        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("API"));


    }
}
