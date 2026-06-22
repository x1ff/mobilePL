package com.example.myapplication.robots;

import com.example.myapplication.screenobjects.ThreePointsMenu;
import io.qameta.allure.kotlin.Allure;

public class ThreePointsMenuRobot {
    ThreePointsMenu threePointsMenu;

    public ThreePointsMenuRobot(ThreePointsMenu threePointsMenu) {
        this.threePointsMenu = threePointsMenu;
    }

    public void exitBtnClick() {
        Allure.step("Кликнуть Выход", s -> {
            threePointsMenu.getExitBtn().click();
            return null;
        });
    }
}
