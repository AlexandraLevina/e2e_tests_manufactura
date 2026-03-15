package io.testomat.e2e_tests_manufactura.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_manufactura.selenide.common.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TextReportExtension.class)
public class BaseTest {

    protected static Dotenv env = Dotenv.load();
    protected static String userName = env.get("USER_NAME");
    protected static String password = env.get("PASSWORD");
    protected static Application app = new Application();

    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }

    protected String targetProjectName = "PLY";
    protected String testText = "TestText";

    @BeforeAll
    static void openTestomatAndLogin() {
        app.signInPage.open();
        app.signInPage.loginUser(userName, password);
        app.projectsPage.signInSuccess();
    }
}
