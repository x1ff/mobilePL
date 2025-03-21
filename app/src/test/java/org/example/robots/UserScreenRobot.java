package org.example.robots;

import com.codeborne.selenide.Selenide;
import org.example.screens.UsersScreen;

public class UserScreenRobot extends BaseScreenRobot {
    UsersScreen usersScreen = Selenide.page(UsersScreen.class);

    @Override
    public UserScreenRobot checkScreen() {
        usersScreen.checkScreenElements();
        return this;
    }
}
