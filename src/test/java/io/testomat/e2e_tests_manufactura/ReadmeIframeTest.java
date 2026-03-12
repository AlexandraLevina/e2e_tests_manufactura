package io.testomat.e2e_tests_manufactura;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


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
                .editFirstLineInEditor(testText)
                .clickOnUpdate()
                .checkAlert()
                .clickOnCancel()
                .openReadmeText()
                .checkUpdatingTextIsNotAdded(testText);
    }
}
