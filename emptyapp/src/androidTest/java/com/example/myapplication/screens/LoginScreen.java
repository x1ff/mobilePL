package com.example.myapplication.screens;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import com.example.myapplication.elements.ButtonUiA2;
import com.example.myapplication.elements.TextInputUiA2;

public class LoginScreen extends BaseScreenUiA2 {
    public TextInputUiA2 userNameInput;
    public TextInputUiA2 passwordInput;
    public ButtonUiA2 loginBtn;
    public LoginScreen() {
        userNameInput = new TextInputUiA2(By.res("com.example.apppolygon", "username"));
        passwordInput = new TextInputUiA2(By.res("com.example.apppolygon", "password"));
        loginBtn = new ButtonUiA2(By.res("com.example.apppolygon", "login"));
    }

    public TextInputUiA2 getUserNameInput() {
        return userNameInput;
    }

    public TextInputUiA2 getPasswordInput() {
        return passwordInput;
    }

    public ButtonUiA2 getLoginBtn() {
        return loginBtn;
    }

}
