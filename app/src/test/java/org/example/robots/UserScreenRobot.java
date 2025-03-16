package org.example.robots;

import com.codeborne.selenide.Selenide;
import org.example.screens.UsersScreen;

public class UserScreenRobot extends BaseScreenRobot {
    UsersScreen screen = Selenide.page(UsersScreen.class);

    @Override
    public UserScreenRobot checkScreen() {
        screen.checkScreenElements();
        return this;
    }
}
