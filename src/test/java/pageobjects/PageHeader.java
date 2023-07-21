package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PageHeader extends BasePage{


    private final static SelenideElement pageHeader = $(".page-header");
    private final static SelenideElement headerCreateDropdown = $(".header-creation-menu");
    private final static SelenideElement userMenuDropdown = $(".avatar");
    private final static SelenideElement dropdownSubmenu = $(".dropdown-submenu-open");



    public SelenideElement getPageHeader() {
        return pageHeader;
    }


}
