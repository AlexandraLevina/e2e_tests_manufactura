package io.testomat.e2e_tests_manufactura.selenide;

import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_manufactura.selenide.utils.StringParsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectPageTests extends BaseTest {


    @BeforeEach
    void openProjectPage() {
        app.projectsPage.open();
        app.projectsPage.isLoaded();
    }

    @Test
    public void authorizedUserCanFindProjectAndOpenProjectTest() {
        app.projectsPage.searchForProject(targetProjectName);
        app.projectsPage.selectProject(targetProjectName);
        app.projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void checkCountOfTestsAndSignedUsersTest() {
        app.projectsPage.searchForProject(targetProjectName);
        SelenideElement targetProject = app.projectsPage.countOfProjectsShouldBeEqualsTo(1).first();
        app.projectsPage.countOfTestsShouldBeEqualsTo(targetProject, 0);
        app.projectsPage.countOfSignedUsersGraterThan(targetProject, 31);
    }

    @Test
    public void exampleAssertDouble() {
        var text = "15.4 coverage";
        Double actualDouble = StringParsers.parseDoubleFromString(text);
        Assertions.assertTrue(15.4 >= actualDouble);
    }

    @Test
    public void exampleParseBoolean() {
        var text = "true";
        Boolean actual = Boolean.parseBoolean(text);
        Assertions.assertEquals(true, actual);
    }

    @Test
    public void checkProjectBadgetTest() {
        app.projectsPage.searchForProject(targetProjectName);
        app.projectsPage.checkProjectBadget();
    }

    @Test
    public void checkEnterprisePlan() {
        app.projectsPage.checkEnterprisePlan();
    }

    @Test
    public void createNewProject() {
        app.projectsPage.createNewProject();
        app.newProjectPage.open();
        app.newProjectPage.isLoaded();
    }

}
