package io.testomat.e2e_tests_manufactura.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ReadmePage {

    public ReadmePage clickOnEditReadme() {
        $(Selectors.byText("Edit Readme")).click();
        Selenide.switchTo().frame($("#modal-overlays iframe[src*='ember-monaco/frame.html']"));
        return this;
    }

    public ReadmePage editFirstLineInEditor(String targetText) {
        $(".view-lines div").click();
        $("textarea").setValue(targetText);
        return this;
    }

    public ReadmePage clickOnUpdate() {
        Selenide.switchTo().defaultContent();
        $(Selectors.byText("Update")).click();
        return this;
    }

    public ReadmePage clickOnCancel() {
        Selenide.switchTo().defaultContent();
        $(Selectors.byText("Cancel")).click();
        return this;
    }

    public ReadmePage isLoaded() {
        $(".setting-header").shouldHave(Condition.text("Readme"));
        return this;
    }

    public ReadmePage openReadmeText() {
        $(".ember-view.secondary-btn.btn-text-and-icon").shouldHave(Condition.visible).click();
        return this;
    }

    public ReadmePage checkAlert() {
        $("div[data-alert].ember-notify-show").shouldBe(visible);
        return this;
    }


    public ReadmePage checkUpdatingTextIsNotAdded(String targetText) {
        Selenide.switchTo().defaultContent();
        $(".detail-view-content").shouldBe(visible)
                .shouldNotHave(text(targetText));
        return this;
    }
}
