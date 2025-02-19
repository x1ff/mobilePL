package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.Before;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    AndroidDriver driver = null;

    @Before
    public void setUp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setApp("C:\\Users\\x1ff\\IdeaProjects\\mobilePL\\apk\\app-paid-debug.apk");

        try {
            driver = new AndroidDriver(
                    // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                    new URL("http://127.0.0.1:4723/"), options
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
