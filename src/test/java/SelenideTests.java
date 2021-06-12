import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideTests {

    private WebSteps steps = new WebSteps();

    @Test
    public void checkIssueNameSelenide() {
        open("https://github.com/");
        $(".header-search-input").val("allure gradle").pressEnter();
        $(byLinkText("allure-framework/allure-gradle")).click();
        $(byText("Issues")).click();
        $("#js-issues-search").val("gradle 7.0 ").pressEnter();
        $(withText("Plugin not working with Gradle 7.0")).shouldBe(visible);
    }

    @Test
    public void checkIssueNameAllureSteps() {
        step("Open Github", () -> {
            open("https://github.com/");
        });

        step("Search for allure gradle plugin repository", () -> {
            $(".header-search-input").val("allure gradle").pressEnter();
        });

        step("Open allure gradle repository", () -> {
            $(byLinkText("allure-framework/allure-gradle")).click();
        });

        step("Open tab Issues", () -> {
            $(byText("Issues")).click();
        });

        step("Search for issues with gradle 7.0", () -> {
            $("#js-issues-search").val("gradle 7.0 ").pressEnter();
        });

        step("Check that issue 'Plugin not working with Gradle 7.0' is visible", () -> {
            $(withText("Plugin not working with Gradle 7.0")).shouldBe(visible);
        });
    }

    @Test
    public void checkIssueNameAllureAnnotations() {
        steps.openMainPage();
        steps.searchForRepository("allure gradle");
        steps.openRepository("allure-framework/allure-gradle");
        steps.openIssues();
        steps.searchForIssue("gradle 7.0");
        steps.checkIssueIsVisible("Plugin not working with Gradle 7.0");
    }
}
