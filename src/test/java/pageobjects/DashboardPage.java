package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static utils.EnvVariables.USER_NAME;
import static utils.EnvVariables.USER_PASSWORD;

public class DashboardPage extends MainSectionElements {


    public void createProject(String projectName, String identifier){
        new LoginPage().logInValid(USER_NAME, USER_PASSWORD).clickCreateProject().submitProjectForm(projectName, identifier);
    }

    @Step("Verifying that main section is visible")
    public static Boolean mainSectionIsVisible(){
        return mainSection().is(Condition.visible) ? true : false;
    }

    @Step("Loging out")
    public LoginPage logOut(){
        userMenuDropdown().shouldBe(Condition.visible).click();
        dropdownSubmenu().shouldBe(Condition.visible);
        logoutButton().click();
        return new LoginPage();
    }

    @Step("Opening the form to create new project")
    public ProjectForm clickCreateProject(){
        createMenuDropDown().click();
        createProjectDropDown().shouldBe(Condition.visible).click();
        return new ProjectForm();
    }

    @Step("Verifying that project is visible on the dashboard")
    public DashboardPage assertProjectIsVisible(String projectName){
        logo.click();
        myProjectsButton().click();
        specificProject(projectName).shouldBe(Condition.visible);
        return this;
    }







}
