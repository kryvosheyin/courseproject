package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainSectionElements extends PageHeader{

    public SelenideElement mainSection(){
        return $("#main");
    }

    public SelenideElement pageHeader(){
        return $(".page-header");
    }

    public SelenideElement createMenuDropDown() {
        return $(".header-creation-menu");
    }

    public SelenideElement createProjectDropDown() {
        return $(".dropdown-submenu-open .js-modal-medium");
    }

    public SelenideElement userMenuDropdown(){
        return $(".avatar");
    }

    public SelenideElement dropdownSubmenu(){
        return $(".dropdown-submenu-open");
    }

    public SelenideElement logoutButton(){
        return dropdownSubmenu().$(".dropdown-submenu-open .fa-sign-out");
    }

    public SelenideElement logo = $(".logo");

    public SelenideElement overviewButton(){
        return $x("//a[contains(text(),'Overview')]");
    }

    public SelenideElement myProjectsButton(){
        return $x("//a[contains(text(),'My projects')]");
    }

    public SelenideElement myTasksButton(){
        return $x("//a[contains(text(),'My tasks')]");
    }

    public SelenideElement mySubtasksButton(){
        return $x("//a[contains(text(),'My subtasks')]");
    }

    public SelenideElement specificProject(String projectName){
        return $x("//a[contains(text(),'"+projectName+"')]");
    }





}
