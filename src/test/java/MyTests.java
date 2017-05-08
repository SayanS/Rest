/**
 * Created by user on 28.09.16.
 */

import RozetkaUserProfile.User;
import RozetkaUserProfile.UserProfile;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import static sun.misc.VM.getState;


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
    public static void getSomething() throws JSONException, UnsupportedEncodingException {

        RestTemplate restTemplate = new RestTemplate();
        CountriesModel[] countriesModel = restTemplate.getForObject("http://restcountries.eu/rest/v1/name/ukraine", CountriesModel[].class);
        System.out.println(countriesModel[0].getName());
        System.out.println(countriesModel[0].getCapital());
        System.out.println(countriesModel[0].getBorders());


        RestTemplate restTemplateRozetka = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "my.rozetka.com.ua");
        headers.add("Connection","keep-alive");
        headers.add("User-Agent",URLEncoder.encode("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.96 Safari/537.36","UTF-8"));
        headers.add("Content-type","application/x-www-form-urlencoded; charset=utf-8");
        headers.add("Accept",URLEncoder.encode("text/javascript, text/html, application/xml, text/xml, */*","UTF-8"));
        headers.add("X-Requested-With","XMLHttpRequest");
        headers.add("X-Rozetka-Header","true");
        headers.add("Referer","https://my.rozetka.com.ua/profile/personal-information/");
        headers.add("Accept-Encoding",URLEncoder.encode("gzip, deflate, sdch, br","UTF-8"));
        headers.add("Accept-Language",URLEncoder.encode("en-US,en;q=0.8","UTF-8"));
        headers.add("Cookie",URLEncoder.encode("language_choose=new; ab_catalog_button=new; device_type=computer; PUID=e64b2978-004c-b9a8-cea3-d1929a27fd05; __exponea_etc__=514bbd43-e91f-4a63-bd7a-b17ff4f14807; __utmz_gtm=utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __sonar=362955411573517377; __gads=ID=0ff52f81ac3e390d:T=1494239455:S=ALNI_MZPIPjrJTgGKrfOuPAkuUF1aWglAw; rg_updated=true; unpaid_invoices=1494263771; club_invitation=1494328572; ho_sid=1; sid=msuibnmqv720rbsg2fd1em9a24; uid=rB4eBlkQVD2sXEV8Cl8EAg==; mini_cart_block_state=%22maximized%22; social_popup=1; mini_waitlist_available_block_state=%22maximized%22; __utmt=1; __exponea_time2__=-0.01351165771484375; session_update_from_server=1; _dc_gtm_UA-203518-6=1; href=https%3A%2F%2Fmy.rozetka.com.ua%2Fprofile%2Fwishlists%2F; analyticsRozetkaClubStatus=Unconfirm; analyticsRozetkaClubBonuses=0; _dy_csc_ses=t; _dy_ses_load_seq=24870%3A1494245119671; _dy_c_exps=; gauid=35789756; login=tserg_2011%40mail.ru; gautype=%22Buyer%22; _ga=GA1.3.1472557353.1493302349; _gid=GA1.3.1818536756.1494245120; visitor_city=31; _dy_soct=186255.270847.1494239454*116461.161196.1494245119; __utma=28000675.1472557353.1493302349.1493302349.1494239454.2; __utmb=28000675.27.9.1494245120057; __utmc=28000675; __utmz=28000675.1493302349.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __utmv=28000675.|4=userId=35789756=1^5=VisitorCity=31=1; _dyid=3143512687426796621; _dycst=dk.l.c.ws.frv4.tos.; _dy_geo=UA.EU.UA_07.UA_07_Kharkov; _dy_df_geo=Ukraine..Kharkov; _dy_toffset=-1; _dyus_8767390=262%7C0%7C0%7C0%7C0%7C0.0.1493302350326.1494245120110.942769.0%7C127%7C19%7C4%7C117%7C13%7C0%7C0%7C0%7C0%7C0%7C0%7C13%7C0%7C1%7C0%7C0%7C0%7C13%7C1%7C0%7C0%7C0%7C0","UTF-8"));

        HttpEntity requestEntity = new HttpEntity(headers);
        ResponseEntity rssResponse = restTemplateRozetka.exchange(
                "https://my.rozetka.com.ua/s/session.json?0.8174663630110013",
                HttpMethod.GET,
                requestEntity,
                User.class);
        rssResponse.getBody();

//((User) ((ResponseEntity) rssResponse).body).subscribes



        /*Rest-Assured Example*/

        Response resp = get("http://restcountries.eu/rest/v1/name/no");
        JSONArray jsonResponse = new JSONArray(resp.asString());
        Assert.assertEquals(jsonResponse.getJSONObject(0).get("capital").toString(), "Oslo1");
        Assert.assertEquals(jsonResponse.getJSONObject(0).get("capital").toString(), "Oslo2");
        Assert.assertEquals(jsonResponse.getJSONObject(0).get("capital").toString(), "Oslo");

        RestAssured.baseURI = "http://restcountries.eu/rest/v1/name";
        String json = get("/norway").asString();
        given().when().get("/norway").then().body(containsString("Oslo1"));
        given().when().get("/norway").then().body(containsString("Oslo2"));
        given().when().get("/norway").then().body(containsString("Oslo"));

        List<String> capitals = from(json).get("capital");

    }

    @AfterClass
    private void tearDown() {
        wd.close();
    }


}
