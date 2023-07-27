package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TaskPage extends DashboardPage{

    private static final SelenideElement taskSummary = $("#task-summary");

    private static final SelenideElement closeTaskOption = $x("//*[contains(text(),'Close this task')]");
    private static final SelenideElement confirmationModal = $("#modal-box");

    private static final SelenideElement confirmButton = $("#modal-confirm-button");

    private static final SelenideElement taskStatus = $("section div li span");
    private static final SelenideElement commentsButton = $x("//*[contains(text(),'Comments')]");
    private static final SelenideElement commentsSection = $("#comments");
    private static final SelenideElement commentTextArea = $x("//textarea[@name='comment']");
    private static final SelenideElement saveCommentButton = $x("//button[@type='submit']");
    private static final SelenideElement commentContent = $(".comment-content");

    @Step("Verifying the task page is opened")
    public TaskPage assertTaskSummaryDisplayed(){
        taskSummary.shouldBe(Condition.visible);
        return this;
    }

    @Step("Closing the task and verifying the status is closed")
    public TaskPage closeTask(){
        closeTaskOption.shouldBe(Condition.visible).click();
        confirmationModal.shouldBe(Condition.visible);
        confirmButton.shouldBe(Condition.visible).click();
        taskStatus.shouldHave(Condition.text("closed"));
        return this;
    }

    @Step("Adding new comment to a task")
    public TaskPage addComment(String comment){
        commentsButton.shouldBe(Condition.visible).click();
        commentsSection.shouldBe(Condition.visible);
        commentTextArea.shouldBe(Condition.interactable).setValue(comment);
        saveCommentButton.click();
        return this;
    }

    @Step("Verifying the comment added to the task is visible")
    public TaskPage assertCommentVisible(String comment){
        commentContent.shouldBe(Condition.visible).shouldHave(Condition.text(comment));
        return this;
    }


}
