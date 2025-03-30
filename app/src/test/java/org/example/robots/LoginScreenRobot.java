package org.example.robots;

import com.codeborne.selenide.Selenide;
import org.example.screens.LoginScreen;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
public class LoginScreenRobot implements Robotic {

    LoginScreen loginScreen = Selenide.page(LoginScreen.class);
    public LoginScreenRobot() {

    }

    public LoginScreenRobot typeUserName(String name) {
        loginScreen.getUserNameInput().shouldBe(visible).sendKeys(name);
        return this;
    }
    public LoginScreenRobot typePassword(String password) {
        loginScreen.getPasswordInput().shouldBe(visible).sendKeys(password);
        return this;
    }

    public void clickToLoginBtn() {
        loginScreen.getLoginBtn().shouldBe(visible).click(tap());
    }

    public String getLoginBtnText() {
        return loginScreen.getLoginBtn().shouldBe(visible).getText();
    }

    @Override
    public LoginScreenRobot checkScreen() {
        loginScreen.checkScreenElements();
        return this;
    }
}
