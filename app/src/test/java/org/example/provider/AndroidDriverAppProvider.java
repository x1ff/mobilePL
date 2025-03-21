package org.example.provider;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.checkerframework.checker.nullness.qual.NonNull;
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
        String apkDir = System.getenv("APK_DIR");
        LOGGER.info("apk Dir: {}", apkDir);
        boolean isLoad = false;
        try {
            isLoad = Config.loadConfig("application.properties");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        if (isLoad) {
            Config.logConfig();
        } else {
            throw new RuntimeException("Конфиг не загружен");
        }

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setUdid(Config.getUdid());
        options.setApp(apkDir);
        try {
            return new AndroidDriver(new URL(Config.getAppiumUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
