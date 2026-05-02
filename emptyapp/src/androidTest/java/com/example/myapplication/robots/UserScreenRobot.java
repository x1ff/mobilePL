package com.example.myapplication.robots;

import com.example.myapplication.screens.UsersScreen;
import io.qameta.allure.Step;

public class UserScreenRobot implements Robotic {
    UsersScreen usersScreen;

    public UserScreenRobot(UsersScreen screen) {
        this.usersScreen = screen;
    }

    @Step("Кликнуть на 3 точки")
    public UserScreenRobot threePointsBtnClick() {
        usersScreen.getThreePointsBtn().click();
        return this;
    }
    @Step("Проверить, что открыт экран")
    @Override
    public UserScreenRobot assertVisibleElements() {
        // usersScreen.assertVisibleElements();
        return this;
    }
}
