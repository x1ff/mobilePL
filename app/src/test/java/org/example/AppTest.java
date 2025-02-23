/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import io.appium.java_client.AppiumBy;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class AppTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class.getName());

    @Test
    public void checkTextBtn() {
        LOGGER.info("checkTextBtn test start");
        final String EXPECTED_TEXT = "Войти";
        final By LOGIN_BTN_BY = AppiumBy.id("com.example.apppolygon:id/login");
        String loginBtnText = "";
        try {
            WebElement loginBtn = driver.findElement(LOGIN_BTN_BY);
            loginBtnText = loginBtn.getText();
        } finally {
            driver.quit();
        }
        assertEquals(
                String.format("У кнопки %s неправильный текст", EXPECTED_TEXT),
                EXPECTED_TEXT,
                loginBtnText
        );
    }
}
