package org.example.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.elements.Button;
import org.example.elements.TextInput;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(id = "com.example.apppolygon:id/username")
    public TextInput userNameInput;
    @AndroidFindBy(id = "com.example.apppolygon:id/password")
    public TextInput passwordInput;
    @AndroidFindBy(id = "com.example.apppolygon:id/login")
    public Button loginBtn;

    public TextInput getUserNameInput() {
        return userNameInput;
    }

    public TextInput getPasswordInput() {
        return passwordInput;
    }

    public Button getLoginBtn() {
        return loginBtn;
    }

    @Override
    public void assertVisibleElements() {
        userNameInput.assertVisible();
        passwordInput.assertVisible();
        loginBtn.assertVisible();
    }
}
