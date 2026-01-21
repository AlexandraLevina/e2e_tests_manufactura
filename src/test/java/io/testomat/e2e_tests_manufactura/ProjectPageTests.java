package io.testomat.e2e_tests_manufactura;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.testomat.e2e_tests_manufactura.utils.StringParsers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.testomat.e2e_tests_manufactura.utils.StringParsers.parseIntegerFromString;

public class ProjectPageTests extends BaseTest {

    static String baseUrl = env.get("BASE_URL") ;
    static String userName = env.get("USER_NAME") ;
    static String password = env.get("PASSWORD") ;
    String targetProjectName = "PLY";

    @BeforeAll
    static void openTestomatAndLogin() {
        open(baseUrl);
        loginUser(userName, password);

    }

    @BeforeEach
    void openHomePage() {
        open(baseUrl);
    }

    @Test
    public void authorizedUserCanFindProjectAndOpenProjectTest() {
        searchForProject(targetProjectName);
        selectProject(targetProjectName);
        waitForProjectPageIsLoaded(targetProjectName);
    }

    @Test
    public void checkCountOfTestsAndSignedUsersTest() {
        searchForProject(targetProjectName);
        SelenideElement targetProject = countOfProjectsShouldBeEqualsTo(1).first();
        countOfTestsShouldBeEqualsTo(targetProject, 0);
        countOfSignedUsersGraterThan(targetProject, 30);
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
        searchForProject(targetProjectName);
        checkProjectBadget();
    }

    private void checkProjectBadget() {
        $("[title=\"PLY\"] span").shouldBe(visible).shouldHave(text("Classical"));
    }

    private void waitForProjectPageIsLoaded(String targetProjectName) {
        $(".first h2").shouldHave(text(targetProjectName));
        $(".first [href*='/readme']").shouldHave(text("Readme"));
    }

    private void selectProject(String targetProjectName) {
        $(byText(targetProjectName)).click();
    }

    private void searchForProject(String targetProjectName) {
        $("#search").setValue(targetProjectName);
    }

    private void countOfSignedUsersGraterThan(SelenideElement targetProject, int expectedCountOfSignedUsers) {
        String countOfSignedUsersText = targetProject.$(" .text-gray-900.font-medium").getText();
        Integer actualCountOfSignedUsers = parseIntegerFromString(countOfSignedUsersText);
        Assertions.assertTrue(actualCountOfSignedUsers > expectedCountOfSignedUsers);
    }

    private void countOfTestsShouldBeEqualsTo(SelenideElement targetProject, int expectedCount) {
        String countOfTestsText = targetProject.$(" p").getText();
        Integer actualCountOfTests = parseIntegerFromString(countOfTestsText);
        Assertions.assertEquals(expectedCount, actualCountOfTests);
    }

    private ElementsCollection countOfProjectsShouldBeEqualsTo(int expectedSize) {
        return $$(" #grid ul li").filter(visible).shouldHave(CollectionCondition.size(expectedSize));
    }

    public static void loginUser(String mail, String password) {
        $("#content-desktop #user_email").setValue(mail);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);
    }
}
