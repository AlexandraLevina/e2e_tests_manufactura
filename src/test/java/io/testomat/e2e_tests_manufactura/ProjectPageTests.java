package io.testomat.e2e_tests_manufactura;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTests {

    @Test
    public void authorizedUserCanFindProjectAndOpenProjectTest() {
        open("https://app.testomat.io/");
        //login user
        $("#content-desktop #user_email").setValue("alexandra.levina87@gmail.com");
        $("#content-desktop #user_password").setValue("g5WdJ8!mLV6DkjZ");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success").shouldBe(visible);

        //search project
        $("#search").setValue("PLY");

        //select project
        $(byText("PLY")).click();

        //wait for project is loaded
        $("h2").shouldHave(text("PLY"));

    }
}
