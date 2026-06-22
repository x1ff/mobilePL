package com.example.myapplication.screenobjects;

import androidx.test.uiautomator.By;
import com.example.myapplication.elements.ButtonUiA2;
import com.example.myapplication.screens.BaseScreenUiA2;

public class ThreePointsMenu extends BaseScreenUiA2 {
    ButtonUiA2 exitBtn = new ButtonUiA2(By.text("Выход"));
    public ButtonUiA2 getExitBtn() {
        return exitBtn;
    }
}
