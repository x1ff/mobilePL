package org.example.provider;

import androidx.annotation.NonNull;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.Config;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverAppProvider implements WebDriverProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(AndroidDriverAppProvider.class.getName());
    @Override
    @NonNull
    public WebDriver createDriver(Capabilities capabilities) {
        try {
            // Config.loadConfig("application-local.properties");
            Config.loadConfig("application.properties");
            LOGGER.info("Конфигуцрация загружена!");
        } catch (IllegalStateException | IOException e) {
            LOGGER.error("Конфигурация не загружена");
        }
        Config.logConfig();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setUdid(Config.getUdid());
        options.setApp(Config.getApkDir());
        try {
            return new AndroidDriver(new URL(Config.getAppiumUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
