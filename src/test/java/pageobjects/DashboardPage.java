package pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage extends BasePage {

    private final static SelenideElement pageHeader = $(".page-header");

    public SelenideElement getPageHeader() {
        return pageHeader;
    }


}
