package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PageHeader extends BasePage{


    private final static SelenideElement pageHeader = $(".page-header");
    private final static SelenideElement createMenuDropDown = $(".header-creation-menu");
    private final static SelenideElement createProjectDropDown = $(".dropdown-submenu-open .js-modal-medium");

    private final static SelenideElement userMenuDropdown = $(".avatar");
    private final static SelenideElement dropdownSubmenu = $(".dropdown-submenu-open");

    private final static SelenideElement logoutButton = dropdownSubmenu.$(".dropdown-submenu-open .fa-sign-out");



    public SelenideElement getPageHeader() {
        return pageHeader;
    }






}
