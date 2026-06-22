package com.example.myapplication.robots;

import com.example.myapplication.screens.UsersScreen;
import io.qameta.allure.kotlin.Allure;

public class UserScreenRobot implements Robotic {
    UsersScreen usersScreen;

    public UserScreenRobot(UsersScreen screen) {
        this.usersScreen = screen;
    }

    public UserScreenRobot threePointsBtnClick() {
        Allure.step("Кликнуть на 3 точки", s -> {
            usersScreen.getThreePointsBtn().click();
            return null;
        });
        return this;
    }

    @Override
    public UserScreenRobot assertVisibleElements() {
        usersScreen.getThreePointsBtn().assertVisible();
        return this;
    }
}
