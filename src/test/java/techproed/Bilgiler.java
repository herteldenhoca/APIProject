package techproed;

public class Bilgiler {
/*
PATCH için
https://jsonplaceholder.typicode.com/todos
https://restful-booker.herokuapp.com/booking
http://dummy.restapiexample.com/api/v1
Put için
http://dummy.restapiexample.com/api/v1/update
http://dummy.restapiexample.com/api/v1/create
http://api.openweathermap.org
get put patch delete den body e ihtiyacı olmayanlar get and delete
Path and Query Paramaters
https://www.amazon.com.tr/s?k=java+kitap&__mk_tr_TR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1NQZ2ZYT6F50F&sprefix
     Base Url            path
                       parameter
                       k=java+kitap&__mk_tr_TR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=1NQZ2ZYT6F50F&sprefix
                        Query Parameter
                        Multiple query Parameter
 Amazon un içerisinde birçok modül var.
 All categories, search, login
 Path param kullanınca kaynağı sınırlandırıyoruz, belirli bir modül üzerinde çalışmış oluyoruz
 Query param searchi le ilgili detay veriyoruz
 Biriyle kaynağı sınırlandırıyoruz,diğeriyle spesifik bir ürün belirlemiş oluyoruz
 Path param da key value structure yok ama query param da key value ilişkisi var.
 JsonPath:
 How to navigate in jsonpath
 jsonpath evaluator
 {
    "store": {       json data nın ismi
        "book": [    list içerisinde birden çok json data var
            {
                "category": "reference",
                "author": "Nigel Rees",
                "title": "Sayings of the Century",
                "price": 8.95
            },
            {
                "category": "fiction",
                "author": "Evelyn Waugh",
                "title": "Sword of Honour",
                "price": 12.99
            },
            {
                "category": "fiction",
                "author": "Herman Melville",
                "title": "Moby Dick",
                "isbn": "0-553-21311-3",
                "price": 8.99
            },
            {
                "category": "fiction",
                "author": "J. R. R. Tolkien",
                "title": "The Lord of the Rings",
                "isbn": "0-395-19395-8",
                "price": 22.99
            }
        ],
        "bicycle": {              json
            "color": "red",
            "price": 19.95
        }
    },
    "expensive": 10
}

                        store,          expensive
                  list      book         10
                   1 json   bcycle

     $ all data  like * in SQL

     $.store
     $.expensive
     store.book[0]
     author of last book
     -1
     First 3 books
     https://jsonpath.herokuapp.com/
         /*
       Given: Baslangıc icin gereklilikleri ifade eder.
       When: Kullanicinin aksiyonunu ifade eder.
       Then: Ciktilari ifade eder-- Assert ler genelde burada yapilir
       And: Herhangi iki coklu adim arasinda kullanilabilir.
        Positive Scenario
     When I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
     Then
     HTTP Status code should be 200
     And  Content type should be Json
     And  Status Line should be HTTP/1.1 200 OK
    */
    /*
    @Test
public void get01(){
    // 1) URL 'i olustur
    String url = "https://restful-booker.herokuapp.com/booking/3";
    // 2) Beklenen data'yi (ckiti) olustur-- Daha sonra
    // 3) REquest'i gonder (Postman'daki Send butonu gibi)
    // Response ozel bir class
    Response response = given().
            accept("application/json"). // Gelen response 'un sadece Json formatinda olmasini istiyorum
            when().
            get(url);
    response.prettyPrint();
    // 4) Gelen sonuc (response) ile test case'deki beklenen sonucu karsilastir. (status code, response body ect.)
    response.then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).
            statusLine("HTTP/1.1 200 OK");
    //  Konsolda content-type, status code, status line, etc. nasıl gorebilirim?
    System.out.println(response.getContentType());
    System.out.println(response.getStatusLine());
    System.out.println(response.getStatusCode());
    // Konsolda headers ın içindekileri nasıl görebilirim?
    System.out.println(response.getHeaders());
    System.out.println(response.getTime());
}

     */
    /*
        Negative Scenario
     When I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/101
     Then
     HTTP Status code should be 404
     And  Status Line should be HTTP/1.1 404 Not Found
    */
   /* @Test
    public void get01(){
        // 1. URL i olustur
        String url =   "https://restful-booker.herokuapp.com/booking/101";
        // Request i gonder
        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);
        response.prettyPrint();
        System.out.println(response.contentType());
        // Assertion lari yap
        response.
                then().
                assertThat().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");
    }
}
    /*
                                         When I send a GET request to REST API URL
                                         https://restful-booker.herokuapp.com/booking/1001
                                         Then HTTP Status Code should be 404
                                         HTTP Status code should be 404
                                         And  Status Line should be HTTP/1.1 404 Not Found
                                         And response body contains "Not Found"
                                         And response body does not contain "TechProEd"
                                        */
  /*  @Test
    public void get01(){
        // Url i olustur
        String url = "https://restful-booker.herokuapp.com/booking/1001";
        Response response = given().
                accept(ContentType.JSON).
                when().
                get(url);
        response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");
        Assert.assertEquals(404,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 404 Not Found",response.getStatusLine());
        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("TechProEd"));
    }
 */
}
