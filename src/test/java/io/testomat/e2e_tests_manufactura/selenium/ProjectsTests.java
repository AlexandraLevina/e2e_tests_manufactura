package io.testomat.e2e_tests_manufactura.selenium;

import io.testomat.e2e_tests_manufactura.selenium.common.LoginTestomat;
import io.testomat.e2e_tests_manufactura.selenium.common.WebDriverLifeCycleExtention;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_manufactura.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_manufactura.selenium.web.common.Elements.findByText;

@ExtendWith({WebDriverLifeCycleExtention.class, LoginTestomat.class})
public class ProjectsTests {

    @Test
    @DisplayName("Project possible to find by name")
    public void projectPossibleToFindByName() {

        find("#container .common-flash-success").waitFor().visibility();

        //search project
        String targetProjectName = "PLY";
        find("input[placeholder='Search Project']").sendKeys(targetProjectName);

        //select project
        findByText("PLY").click();

        //wait for project is loaded
        find("h2").waitFor().containsText(targetProjectName);
    }

}
