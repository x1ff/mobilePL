package org.example.robots;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.example.screens.UsersScreen;

public class UserScreenRobot implements Robotic {
    UsersScreen usersScreen = Selenide.page(UsersScreen.class);

    @Step("Проверить, что открыт экран")
    @Override
    public UserScreenRobot assertVisibleElements() {
        usersScreen.assertVisibleElements();
        return this;
    }
}
