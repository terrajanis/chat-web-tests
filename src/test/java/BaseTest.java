import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.refresh;


public class BaseTest {

    protected Properties properties = new Properties();

    {
        try {
            properties.load(new FileInputStream("src/test/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected final String BASE_URL = properties.getProperty("baseUrl");
    protected final String EMAIL = System.getProperty("email");
    protected final String PASSWORD = System.getProperty("password");

    @BeforeSuite
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
        Configuration.pageLoadStrategy ="normal";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    protected void openMainPage(String url){
        open(url);
        clearBrowserCookies();
        clearBrowserLocalStorage();
        refresh();
        sleep(2000);
    }
}

