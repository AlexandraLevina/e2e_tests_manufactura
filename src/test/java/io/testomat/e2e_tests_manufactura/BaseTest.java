package io.testomat.e2e_tests_manufactura;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import io.testomat.e2e_tests_manufactura.common.Application;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    protected static Dotenv env = Dotenv.load();
    protected static String userName = env.get("USER_NAME");
    protected static String password = env.get("PASSWORD");
    protected String targetProjectName = "PLY";

    protected static Application app = new Application();
    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }

    @BeforeAll
    static void openTestomatAndLogin() {
        app.signInPage.open();
        app.signInPage.loginUser(userName, password);
        app.projectsPage.signInSuccess();
    }
}
