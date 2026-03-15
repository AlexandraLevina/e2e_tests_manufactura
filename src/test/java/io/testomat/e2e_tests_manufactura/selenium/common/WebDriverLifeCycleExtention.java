package io.testomat.e2e_tests_manufactura.selenium.common;

import io.testomat.e2e_tests_manufactura.selenium.web.common.WebDriverProvider;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WebDriverLifeCycleExtention implements BeforeAllCallback, AfterAllCallback {


    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        WebDriverProvider.driver();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        WebDriverProvider.quitDriver();
    }

}
