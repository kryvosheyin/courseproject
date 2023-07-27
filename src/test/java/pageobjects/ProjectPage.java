package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage extends MainSectionElements {

    private static SelenideElement projectConfigurationButton = $x("//a[@title='Configure this project']");

    private static SelenideElement addTask = $(".board-add-icon");

    private static SelenideElement createTaskModal = $("#modal-box");

    private static SelenideElement specificTask(String taskName){
        return $x("//a[contains(text(),'"+taskName+"')]");
    }


    public ProjectPage addNewTask(String task, String description){
        addTask.click();
        new TaskModal().submitTask(task, description);
        specificTask(task).shouldBe(Condition.visible);
        return this;
    }

    public ProjectPage assertTaskIsVisible(String task){
        specificTask(task).shouldBe(Condition.visible);
        return this;
    }

    public TaskPage accessTaskPage(String task){
        specificTask(task).shouldBe(Condition.visible).click();
        return new TaskPage();
    }

    public static Boolean taskExists(String task){
        return specificTask(task).exists() ? true : false;
    }
}
