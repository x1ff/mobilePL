package org.example.robots;

import io.qameta.allure.Step;
import org.example.screens.LoginScreen;

public class LoginScreenRobot implements Robotic {
    LoginScreen loginScreen;
    public LoginScreenRobot(LoginScreen screen) {
        loginScreen = screen;
    }
    public LoginScreenRobot assertLoginBtnText(String text) {
        loginScreen.getLoginBtn().assertText(text);
        return this;
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
    @Step("Получить текст у кнопки логин")
    public String getLoginBtnText() {
        return loginScreen.getLoginBtn().getText();
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
