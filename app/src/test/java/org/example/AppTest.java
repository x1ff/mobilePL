/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import io.appium.java_client.AppiumBy;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class AppTest extends BaseTest {
    @Test
    public void checkTextBtn() {
        final String EXPECTED_TEXT = "Войти";
        final String LOGIN_BTN_XPATH = "//android.widget.Button[@resource-id='com.example.apppolygon:id/login']";
        String loginBtnText = "";
        try {
            WebElement loginBtn = driver.findElement(AppiumBy.xpath(LOGIN_BTN_XPATH));
            loginBtnText = loginBtn.getText();
            driver.getPageSource();
        } finally {
            driver.quit();
        }
        assertEquals("Не найдена кнопка с текстом " + EXPECTED_TEXT, EXPECTED_TEXT, loginBtnText);
    }
}
