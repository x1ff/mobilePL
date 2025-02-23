package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class.getName());
    AndroidDriver driver = null;

    @Before
    public void setUp() throws IOException {
        LOGGER.info("Before test block start");
        String apkDir = System.getenv("APK_DIR");
        LOGGER.info("apk Dir: {}", apkDir);
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(Config.getConfig().getUdid())
                .setApp(apkDir);

        try {
            driver = new AndroidDriver(
                    new URL(Config.getConfig().getAppiumUrl()), options
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
