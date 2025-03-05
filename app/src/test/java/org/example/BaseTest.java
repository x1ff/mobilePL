package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import org.example.provider.AndroidDriverAppProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class.getName());

    @BeforeAll
    public static void setUp() {
        LOGGER.info("Before test block start");
        Configuration.browser = AndroidDriverAppProvider.class.getName();
        SelenideAppium.launchApp();
        LOGGER.info("SelenideAppium.launchApp() was done");
    }

    @AfterAll
    public static void clean() {
        WebDriverRunner.getWebDriver().quit();
    }
}
