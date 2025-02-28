package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URL;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class.getName());
    public static AndroidDriver driver = null;

    @BeforeAll
    public static void setUp() throws IOException {
        LOGGER.info("Before test block start");
        String apkDir = System.getenv("APK_DIR");
        LOGGER.info("apk Dir: {}", apkDir);
        boolean isLoad = Config.loadConfig("application.properties");
        if (isLoad) {
            Config.logConfig();
        } else {
            LOGGER.info("Конфиг не загружен");
        }

        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(Config.getUdid())
                .setApp(apkDir);
        driver = new AndroidDriver(new URL(Config.getAppiumUrl()), options);
    }

    @AfterAll
    public static void clean() {
        driver.quit();
    }
}
