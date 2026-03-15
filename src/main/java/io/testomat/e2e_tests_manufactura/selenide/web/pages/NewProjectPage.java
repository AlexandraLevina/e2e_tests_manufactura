package io.testomat.e2e_tests_manufactura.selenide.web.pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage {

    public void open() {
        Selenide.open("/projects/new");
    }

    public void isLoaded() {
        $(".common-page-header-left h2").shouldHave(text("New Project"));
        $(".common-page-header-right a").shouldBe(visible).shouldHave(text("How to start?"));
        $("#classical-help-text").shouldBe(visible);
        $("#classical .font-medium").shouldBe(visible).shouldHave(text("Classical"));
        $("#classical-img").shouldHave(attribute("src", "https://app.testomat.io/images/projects/circle-tick.svg"));
        $("#project-create-btn [type=submit]").shouldBe(visible).shouldHave(value("Create"));
    }
}
