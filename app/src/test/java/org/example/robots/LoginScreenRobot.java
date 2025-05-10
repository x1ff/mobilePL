package org.example.robots;

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
    public LoginScreenRobot typeUserName(String name) {
        loginScreen.getUserNameInput().type(name);
        return this;
    }
    public LoginScreenRobot typePassword(String password) {
        loginScreen.getPasswordInput().type(password);
        return this;
    }

    public void clickToLoginBtn() {
        loginScreen.getLoginBtn().click();
    }

    @Override
    public LoginScreenRobot assertVisibleElements() {
        loginScreen.assertVisibleElements();
        return this;
    }
}
