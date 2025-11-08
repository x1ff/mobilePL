package com.example.myapplication.robots;

import io.qameta.allure.Step;

public class UserScreenRobot implements Robotic {
    @Step("Проверить, что открыт экран")
    @Override
    public UserScreenRobot assertVisibleElements() {
        // usersScreen.assertVisibleElements();
        return this;
    }
}
