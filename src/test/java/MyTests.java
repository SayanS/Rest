/**
 * Created by user on 28.09.16.
 */
import com.jayway.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static com.jayway.restassured.RestAssured.get;
public class MyTests {
    private WebDriver wd;
        @org.testng.annotations.BeforeClass
        private void setUp(){
            System.setProperty("webdriver.chrome.driver", "/home/user/IdeaProjects/ChromeDriver/chromedriver");
            wd=new ChromeDriver();
            wd.get("https://qa1-mgstore.gepowerconversion.com/rmstorefront/rm/en/USD/");
        }


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

        @org.testng.annotations.AfterClass
        private void tearDown(){
            wd.close();
        }


}
