import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.visible;

public class WebSteps {

    @Step("Open Github")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Search for repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").val(repository).pressEnter();
    }

    @Step("Open allure gradle repository: {repository}")
    public void openRepository(String repository) {
        $(byLinkText(repository)).click();
    }

    @Step("Open tab Issues")
    public void openIssues() {
        $(byText("Issues")).click();
    }

    @Step("Search for issues with {issue}")
    public void searchForIssue(String issue) {
        $("#js-issues-search").val(issue).pressEnter();
    }

    @Step("Check that issue {nameOfIssue} is visible")
    public void checkIssueIsVisible(String nameOfIssue) {
        $(withText(nameOfIssue)).shouldBe(visible);
    }
}
