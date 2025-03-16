package org.example.robots;

import com.codeborne.selenide.Selenide;
import org.example.screens.LoginScreen;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
public class LoginScreenRobot extends BaseScreenRobot{

    LoginScreen screen = Selenide.page(LoginScreen.class);
    public LoginScreenRobot() {

    }

    public LoginScreenRobot typeUserName(String name) {
        screen.getUserNameInput().shouldBe(visible).sendKeys(name);
        return this;
    }
    public LoginScreenRobot typePassword(String password) {
        screen.getPasswordInput().shouldBe(visible).sendKeys(password);
        return this;
    }

    public void clickToLoginBtn() {
        screen.getLoginBtn().shouldBe(visible).click(tap());
    }

    public String getLoginBtnText() {
        return screen.getLoginBtn().shouldBe(visible).getText();
    }

    @Override
    public LoginScreenRobot checkScreen() {
        screen.checkScreenElements();
        return this;
    }
}
