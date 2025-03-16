package org.example.robots;

import com.codeborne.selenide.Selenide;
import org.example.screens.UsersScreen;

public class UserScreenRobot {
    UsersScreen screen = Selenide.page(UsersScreen.class);

    public UserScreenRobot checkScreen() {
        screen.checkScreenElements();
        return this;
    }
}
