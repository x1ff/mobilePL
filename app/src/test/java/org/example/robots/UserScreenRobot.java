package org.example.robots;

import com.codeborne.selenide.Selenide;
import org.example.screens.UsersScreen;

public class UserScreenRobot implements Robotic {
    UsersScreen usersScreen = Selenide.page(UsersScreen.class);

    @Override
    public UserScreenRobot assertVisibleElements() {
        usersScreen.assertVisibleElements();
        return this;
    }
}
