package org.example.robots;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.example.screens.LoginScreen;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
public class LoginScreenRobot extends BaseScreenRobot{

    LoginScreen loginScreen = Selenide.page(LoginScreen.class);

    @Step("Ввести имя пользователя")
    public LoginScreenRobot typeUserName(String name) {
        loginScreen.getUserNameInput().shouldBe(visible).sendKeys(name);
        return this;
    }
    @Step("Ввести пароль")
    public LoginScreenRobot typePassword(String password) {
        loginScreen.getPasswordInput().shouldBe(visible).sendKeys(password);
        return this;
    }
    @Step("Кликаем на кнопку логин")
    public void clickToLoginBtn() {
        loginScreen.getLoginBtn().shouldBe(visible).click(tap());
    }
    @Step("Получить текст у кнопки логин")
    public String getLoginBtnText() {
        return loginScreen.getLoginBtn().shouldBe(visible).getText();
    }
    @Step("Проверить наличие элементов")
    @Override
    public LoginScreenRobot checkScreen() {
        loginScreen.checkScreenElements();
        return this;
    }
}
