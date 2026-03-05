package io.testomat.e2e_tests_manufactura;

import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_manufactura.utils.StringParsers;
import io.testomat.e2e_tests_manufactura.web.pages.NewProjectPage;
import io.testomat.e2e_tests_manufactura.web.pages.ProjectPage;
import io.testomat.e2e_tests_manufactura.web.pages.ProjectsPage;
import io.testomat.e2e_tests_manufactura.web.pages.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProjectPageTests extends BaseTest {

    private static final ProjectsPage projectsPage = new ProjectsPage();
    private static final SignInPage signInPage = new SignInPage();
    private static final NewProjectPage newProjectPage = new NewProjectPage();
    static String userName = env.get("USER_NAME");
    static String password = env.get("PASSWORD");
    private final ProjectPage projectPage = new ProjectPage();
    String targetProjectName = "PLY";

    @BeforeAll
    static void openTestomatAndLogin() {
        signInPage.open();
        signInPage.loginUser(userName, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    void openProjectPage() {
        projectsPage.open();
        projectsPage.isLoaded();
    }

    @Test
    public void authorizedUserCanFindProjectAndOpenProjectTest() {
        projectsPage.searchForProject(targetProjectName);
        projectsPage.selectProject(targetProjectName);
        projectPage.isLoaded(targetProjectName);
    }

    @Test
    public void checkCountOfTestsAndSignedUsersTest() {
        projectsPage.searchForProject(targetProjectName);
        SelenideElement targetProject = projectsPage.countOfProjectsShouldBeEqualsTo(1).first();
        projectsPage.countOfTestsShouldBeEqualsTo(targetProject, 0);
        projectsPage.countOfSignedUsersGraterThan(targetProject, 31);
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
        projectsPage.searchForProject(targetProjectName);
        projectsPage.checkProjectBadget();
    }

    @Test
    public void checkEnterprisePlan() {
        projectsPage.checkEnterprisePlan();
    }

    @Test
    public void createNewProject() {
        projectsPage.createNewProject();
        newProjectPage.open();
        newProjectPage.isLoaded();
    }

}
