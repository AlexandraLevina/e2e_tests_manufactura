package io.testomat.e2e_tests_manufactura;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(TextReportExtension.class)
public class ReadmeIframeTest extends BaseTest {
    @Test
    @DisplayName("Update readme text in Iframe")
    void updateReadmeTextInIframeTest() {
        app.projectsPage.isLoaded()
                .searchForProject(targetProjectName)
                .selectProject(targetProjectName);
        app.projectPage.openReadme().clickOnEdit();

        app.readmePage.isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor("TESTTEXT")
                .clickOnUpdate()
                .checkAlert()
                .clickOnCancel()
                .openReadmeText()
                .checkUpdatingTextIsNotAdded("TESTTEXT");
    }
}
