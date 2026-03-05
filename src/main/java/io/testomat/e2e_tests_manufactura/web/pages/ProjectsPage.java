package io.testomat.e2e_tests_manufactura.web.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    private final SelenideElement searchInput = $("#search");

    public void open() {
        Selenide.open("");
    }

    public void isLoaded() {
        searchInput.shouldBe(visible);

    }

    public void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    public void searchForProject(String targetProjectName) {
        searchInput.setValue(targetProjectName);
    }

    public void signInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);

    }

    public ElementsCollection countOfProjectsShouldBeEqualsTo(int expectedSize) {
        return $$(" #grid ul li").filter(visible).shouldHave(CollectionCondition.size(expectedSize));
    }

    public void countOfTestsShouldBeEqualsTo(SelenideElement targetProject, int expectedCount) {
        targetProject.shouldHave(text(expectedCount + " tests"));
    }

    public void countOfSignedUsersGraterThan(SelenideElement targetProject, int expectedCountOfSignedUsers) {
        targetProject.shouldHave(text("+" + expectedCountOfSignedUsers));
    }

    public void checkProjectBadget() {
        $("[title=\"PLY\"] span").shouldBe(visible).shouldHave(text("Classical"));
    }

    public void checkEnterprisePlan() {
        $(".common-page-header-left span span").shouldBe(visible).shouldHave(text("Enterprise Plan")).hover();
    }

    public void createNewProject() {
        $("#container > div.common-page-header > div.common-page-header-right > a").shouldBe(visible).shouldHave(text("Create")).click();
    }


}
