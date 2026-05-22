package com.example.myapplication.tests;

import com.example.myapplication.Config;
import com.example.myapplication.modals.InfoAlertModal;
import com.example.myapplication.robots.InfoAlertModalRobot;
import com.example.myapplication.robots.LoginScreenRobot;
import com.example.myapplication.robots.UserScreenRobot;
import com.example.myapplication.screens.LoginScreen;
import com.example.myapplication.screens.UsersScreen;
import io.qameta.allure.kotlin.TmsLink;
import io.qameta.allure.kotlin.junit4.DisplayName;
import io.qameta.allure.kotlin.junit4.Tag;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTest extends BaseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginTest.class.getName());

    @Test
    @DisplayName("Users. Пользователь \"user\". Авторизация с валидными значениями")
    @TmsLink("2336")
    @Tag("#2336")
    public void userLoginTest() {
        LOGGER.info("loginTest test start");
        final String EXPECTED_TEXT = "Успешная авторизация!";
        LoginScreen loginScreen = new LoginScreen();
        new LoginScreenRobot(loginScreen)
                .typeUserName(Config.getUserLogin())
                .typePassword(Config.getUserPass())
                .clickToLoginBtn();
        InfoAlertModal infoAlertModal = new InfoAlertModal();
        new InfoAlertModalRobot(infoAlertModal)
                .checkMsgText(EXPECTED_TEXT)
                .clickOkBtn();
        LOGGER.info("loginTest end");
    }

    @Test
    @DisplayName("Users. Пользователь \"user\". Авторизация с невалидным email")
    @TmsLink("2388")
    @Tag("#2388")
    public void userlogOutTest() {
        LOGGER.info("Prep state by userLoginTest");
        LoginScreen loginScreen = new LoginScreen();
        new LoginScreenRobot(loginScreen)
                .typeUserName(Config.getUserLogin())
                .typePassword(Config.getUserPass())
                .clickToLoginBtn();
        InfoAlertModal infoAlertModal = new InfoAlertModal();
        new InfoAlertModalRobot(infoAlertModal)
                .clickOkBtn();
        LOGGER.info("logOut test start");
        UsersScreen usersScreen = new UsersScreen();
        new UserScreenRobot(usersScreen)
                .threePointsBtnClick();
        LOGGER.info("logOut end");
    }

    @Test
    public void failTest() {
        LOGGER.info("failTest test start");
        final String EXPECTED_TEXT = "Успешная авторизация!";
        LoginScreen loginScreen = new LoginScreen();
        new LoginScreenRobot(loginScreen)
                .typeUserName("inri inri")
                .typePassword("abracadabra")
                .clickToLoginBtn();
        InfoAlertModal infoAlertModal = new InfoAlertModal();
        new InfoAlertModalRobot(infoAlertModal)
                .checkMsgText(EXPECTED_TEXT)
                .clickOkBtn();
        LOGGER.info("failTest end");
    }
}
