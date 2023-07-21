package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        Configuration.browser = "chrome";
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
