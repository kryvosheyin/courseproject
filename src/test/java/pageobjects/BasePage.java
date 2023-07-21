package pageobjects;

import com.codeborne.selenide.WebDriverRunner;

public class BasePage {

    public String getUrl(){
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }




}
