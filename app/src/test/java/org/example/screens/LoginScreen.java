package org.example.screens;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(id = "com.example.apppolygon:id/username")
    private SelenideAppiumElement userNameInput;
    @AndroidFindBy(id = "com.example.apppolygon:id/password")
    private SelenideAppiumElement passwordInput;
    @AndroidFindBy(id = "com.example.apppolygon:id/login")
    private SelenideAppiumElement loginBtn;


    public SelenideAppiumElement getUserNameInput() {
        return userNameInput;
    }

    public SelenideAppiumElement getPasswordInput() {
        return passwordInput;
    }

    public SelenideAppiumElement getLoginBtn() {
        return loginBtn;
    }

    @Override
    public void checkScreenElements() {
        userNameInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        loginBtn.shouldBe(visible);
    }


}
