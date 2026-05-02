package com.example.myapplication.screens;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import com.example.myapplication.elements.ButtonUiA2;

public class UsersScreen extends BaseScreenUiA2 {

    public ButtonUiA2 createUserBtn =  new ButtonUiA2(By.res("com.example.apppolygon", "buttonCreateUser"));
    public ButtonUiA2 carMenuBtn = new ButtonUiA2(By.res("com.example.apppolygon", "carMenu"));
    public ButtonUiA2 housesMenuBtn = new ButtonUiA2(By.res("com.example.apppolygon", "housesMenu"));
    public ButtonUiA2 threePointsBtn;
    public UsersScreen() {
        threePointsBtn = new ButtonUiA2(By.desc("Ещё"));
    }
    public ButtonUiA2 getThreePointsBtn() {
        return threePointsBtn;
    }
}
