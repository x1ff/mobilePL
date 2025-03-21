package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppium;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.example.provider.AndroidDriverAppProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class.getName());

    @BeforeAll
    public static void setUp() {
        LOGGER.info("Before test block start");
        Configuration.browser = AndroidDriverAppProvider.class.getName();
    }
    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
        );
    }
    @AfterAll
    public static void clean() {

    }

    @BeforeEach
    public void runApp() {
        SelenideAppium.launchApp();
        LOGGER.info("SelenideAppium.launchApp() was done");
    }

    @AfterEach
    public void cleanEach() {
        Selenide.closeWebDriver();
    }
}
