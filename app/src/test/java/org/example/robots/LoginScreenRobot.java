package org.example.robots;

import io.qameta.allure.Step;
import org.example.screens.LoginScreen;

public class LoginScreenRobot implements Robotic {
    LoginScreen loginScreen;
    public LoginScreenRobot(LoginScreen screen) {
        loginScreen = screen;
    }

    /**
     * Ввести имя пользователя
     * @param name
     * @return
     */
    @Step("Ввести имя пользователя {name}")
    public LoginScreenRobot typeUserName(String name) {
        loginScreen.getUserNameInput().type(name);
        return this;
    }
    @Step("Ввести пароль")
    public LoginScreenRobot typePassword(String password) {
        loginScreen.getPasswordInput().type(password);
        return this;
    }
    @Step("Кликаем на кнопку логин")
    public void clickToLoginBtn() {
        loginScreen.getLoginBtn().click();
    }
    @Step("Проверить текст у кнопки логин")
    public LoginScreenRobot assertLoginBtnText(String expectedText) {
        loginScreen.getLoginBtn().assertText(expectedText);
        return this;
    }

    @Step("Проверить текст у кнопки логин")
    public LoginScreenRobot checkLoginBtnText(String expected) {
        loginScreen.getLoginBtn().assertText(expected);
        return this;
    }
    @Step("Проверить, что открыт экран")
    @Override
    public LoginScreenRobot assertVisibleElements() {
        loginScreen.assertVisibleElements();
        return this;
    }
}
