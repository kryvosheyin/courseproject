package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectForm extends DashboardPage{

    private final static SelenideElement projectForm = $("#project-creation-form");
    private final static SelenideElement projectName = $("#form-name");
    private final static SelenideElement projectIdentifier = $("#form-identifier");
    private final static SelenideElement submitNewProjectButton = $x("//button[@type='submit']");


    public DashboardPage submitProjectForm(String name, String identifier){
        projectForm.shouldBe(Condition.visible);
        projectName.shouldBe(Condition.visible).sendKeys(name);
        projectIdentifier.shouldBe(Condition.visible).sendKeys(identifier);
        submitNewProjectButton.click();
        return this;
    }


}
