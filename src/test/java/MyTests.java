/**
 * Created by user on 28.09.16.
 */
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.containsString;


public class MyTests {
    private WebDriver wd;
      /*  @BeforeClass
        private void setUp(){
            System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver");
            wd=new ChromeDriver();
            wd.get("https://qa1-mgstore.gepowerconversion.com/rmstorefront/rm/en/USD/");
        }
      */

        @Test
        public void getRequestFindCapital() throws JSONException {

            // выполняем запрос get для доступа ко всем параметрам ответа
            Response resp = get("http://restcountries.eu/rest/v1/name/norway");

            JSONArray jsonResponse = new JSONArray(resp.asString());

            // получение параметра capital (столицы Норвегии)
            String capital = jsonResponse.getJSONObject(0).getString("capital");

            // проверка, что столицей является Осло
            AssertJUnit.assertEquals(capital, "Oslo");
        }

        @Test
        public static void getSomething() throws JSONException {

            RestTemplate restTemplate=new RestTemplate();
            CountriesModel countriesModel=new CountriesModel();
            countriesModel=restTemplate.getForObject("http://restcountries.eu/rest/v1/name/norway", CountriesModel.class);


            Response resp=get("http://restcountries.eu/rest/v1/name/norway");
            JSONArray jsonResponse=new JSONArray(resp.asString());
            Assert.assertEquals(jsonResponse.getJSONObject(0).get("capital").toString(),"Oslo");


            RestAssured.baseURI="http://restcountries.eu/rest/v1/name";
            String json = get("/no").asString();
            given().when().get("/norway").then().body(containsString("Oslo"));
            List<String> capitals = from(json).get("capital");

        }

        @AfterClass
        private void tearDown(){
            wd.close();
        }


}
