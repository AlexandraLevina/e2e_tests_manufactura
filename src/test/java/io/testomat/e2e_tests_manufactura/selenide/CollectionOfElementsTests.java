package io.testomat.e2e_tests_manufactura.selenide;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;

public class CollectionOfElementsTests extends BaseTest {

    @Test
    @DisplayName("find all products experiments")
    void findAllProductsExperiments() {
        var labelCountOfTests = $$("ul li p")
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(0));

        $$(Selectors.byText("0 tests")).shouldHave(CollectionCondition.size(28));
        $$(Selectors.byText("1 tests")).shouldHave(CollectionCondition.size(1));

        labelCountOfTests.filter(Condition.text("0 tests")).shouldHave(CollectionCondition.size(28));
        labelCountOfTests.filter(Condition.text("1 tests")).shouldHave(CollectionCondition.size(1));

        $$(".inline-flex.items-center").shouldHave(CollectionCondition.sizeGreaterThanOrEqual(30));
        $$(Selectors.byText("+43")).shouldHave(CollectionCondition.size(3));

    }

    @Test
    @DisplayName("clipboard")
    void clipboard() {
        Selenide.clipboard().setText("nbb");
        Selenide.clipboard().shouldHave(ClipboardConditions.content("nbb"));
    }

    @Test
    @DisplayName("find projects with followers more than 30")
    void checkAllProjectsAreClassical() {
        $$(".common-badge.common-badge-project-default")
                .forEach(element -> {
                    element.shouldHave(Condition.text("Classical"));
                });
    }

}
