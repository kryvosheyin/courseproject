package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PageHeader extends BasePage{


    private final static SelenideElement pageHeader = $(".page-header");
    private final static SelenideElement headerCreateDropdown = $(".header-creation-menu");
    private final static SelenideElement userMenuDropdown = $(".avatar");
    private final static SelenideElement dropdownSubmenu = $(".dropdown-submenu-open");

    private final static SelenideElement logoutButton = dropdownSubmenu.$(".dropdown-submenu-open .fa-sign-out");



    public SelenideElement getPageHeader() {
        return pageHeader;
    }

    public LoginPage logOut(){
        userMenuDropdown.shouldBe(Condition.visible).click();
        dropdownSubmenu.shouldBe(Condition.visible);
        logoutButton.click();
        return new LoginPage();
    }


}
