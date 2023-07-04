package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;

public class BaseTest {

    @BeforeMethod
    public void setUp(){
        Configuration.browser = "chrome";
    }

    @AfterMethod
    public void cleanUp(){
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
