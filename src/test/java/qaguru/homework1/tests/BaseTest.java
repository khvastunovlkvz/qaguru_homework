package qaguru.homework1.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import qaguru.homework1.pages.RegistrationPage;


public class BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 4000;
        Configuration.pageLoadStrategy = "none";
        Configuration.browserPosition = "0x0";
        Configuration.holdBrowserOpen = false;
    }

    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
    }
}