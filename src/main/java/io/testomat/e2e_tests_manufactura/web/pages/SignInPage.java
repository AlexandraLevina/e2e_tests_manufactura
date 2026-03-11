package io.testomat.e2e_tests_manufactura.web.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    public SignInPage open() {
        Selenide.open("/users/sign_in");
        return this;
    }

    public SignInPage loginUser(String mail, String password) {
        $("#content-desktop #user_email").setValue(mail);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $("#content-desktop #user_email").shouldBe(hidden);
        $("#content-desktop #user_password").shouldBe(hidden);
        return this;
    }

}
