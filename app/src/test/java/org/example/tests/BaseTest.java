package org.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.appium.SelenideAppium;
import org.example.Config;
import org.example.provider.AndroidDriverAppProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class.getName());

    @BeforeAll
    public static void setUp() {
        LOGGER.info("Before test block start");
        Configuration.browser = AndroidDriverAppProvider.class.getName();
        SelenideAppium.launchApp();
    }

    @AfterAll
    public static void clean() {

    }

    @BeforeEach
    public void runApp() {

        LOGGER.info("SelenideAppium.launchApp() was done");
    }

    @AfterEach
    public void cleanEach() {
        String appId = Config.getAppId();
        SelenideAppium.terminateApp(appId);
        Map<String, Object> params = new HashMap<>();
        params.put("packageName", appId);
        params.put("appId", appId);
        JavascriptExecutor jsDriver = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        jsDriver.executeScript("mobile: clearApp", params);
        SelenideAppium.relaunchApp(appId);
    }
}
