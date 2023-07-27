package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TaskModal extends ProjectPage{

    private static SelenideElement taskTitle = $("#form-title");
    private static SelenideElement taskDescription= $x("//textarea[@name='description']");
    private static SelenideElement submitFormButton = $x("//button[@type='submit']");



    public void submitTask(String taskName, String description){
        taskTitle.shouldBe(Condition.visible).sendKeys(taskName);
        taskDescription.shouldBe(Condition.visible).sendKeys(description);
        submitFormButton.click();
    }





}
