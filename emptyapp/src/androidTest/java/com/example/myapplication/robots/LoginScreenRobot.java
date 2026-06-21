package com.example.myapplication.robots;

import com.example.myapplication.screens.LoginScreen;
import io.qameta.allure.kotlin.Allure;


public class LoginScreenRobot implements Robotic {
    LoginScreen loginScreen;

    public LoginScreenRobot(LoginScreen screen) {
        this.loginScreen = screen;
    }

    /**
     * Ввести имя пользователя
     *
     * @param name
     * @return
     */
    public LoginScreenRobot typeUserName(String name) {
        Allure.step("Ввести имя пользователя " + name, s -> {
            s.parameter("name", name);
            loginScreen.getUserNameInput().type(name);
            return null;
        });
        return this;
    }

    public LoginScreenRobot typePassword(String password) {
        Allure.step("Ввести пароль", s -> {
            s.parameter("password", password);
            loginScreen.getPasswordInput().type(password);
            return null;
        });
        return this;
    }

    public void clickToLoginBtn() {
        Allure.step("Кликаем на кнопку логин", s -> {
            loginScreen.getLoginBtn().click();
            return null;
        });
    }

    public LoginScreenRobot assertLoginBtnText(String expectedText) {
        Allure.step("Проверить текст у кнопки логин", s -> {
            s.parameter("expectedText", expectedText);
            loginScreen.getLoginBtn().assertText(expectedText);
            return null;
        });
        return this;
    }

    public LoginScreenRobot checkLoginBtnText(String expectedText) {
        Allure.step("Проверить текст у кнопки логин", s -> {
            s.parameter("expectedText", expectedText);
            loginScreen.getLoginBtn().assertText(expectedText);
            return null;
        });
        return this;
    }

    @Override
    public LoginScreenRobot assertVisibleElements() {
//        loginScreen.assertVisibleElements();
        return this;
    }
}
