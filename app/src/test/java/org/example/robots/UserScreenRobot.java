package org.example.robots;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.example.screens.UsersScreen;

public class UserScreenRobot extends BaseScreenRobot {
    UsersScreen usersScreen = Selenide.page(UsersScreen.class);

    @Step("Проверить наличие элементов")
    @Override
    public UserScreenRobot checkScreen() {
        usersScreen.checkScreenElements();
        return this;
    }
}
