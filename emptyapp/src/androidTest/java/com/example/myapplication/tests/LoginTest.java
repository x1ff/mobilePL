package com.example.myapplication.tests;

import com.example.myapplication.Config;
import com.example.myapplication.modals.InfoAlertModal;
import com.example.myapplication.robots.InfoAlertModalRobot;
import com.example.myapplication.robots.LoginScreenRobot;
import com.example.myapplication.robots.ThreePointsMenuRobot;
import com.example.myapplication.robots.UserScreenRobot;
import com.example.myapplication.screenobjects.ThreePointsMenu;
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
        final String EXPECTED_TEXT = "Успешная авторизация!";
        login(Config.getUserLogin(), Config.getUserPass());
        InfoAlertModal infoAlertModal = new InfoAlertModal();
        new InfoAlertModalRobot(infoAlertModal)
                .checkMsgText(EXPECTED_TEXT)
                .clickOkBtn();
    }

    @Test
    @DisplayName("Users. Пользователь \"admin\". Авторизация с валидными значениями")
    @TmsLink("2383")
    @Tag("#2383")
    public void adminLoginTest() {
        final String EXPECTED_TEXT = "Успешная авторизация!";
        login(Config.getAdminLogin(), Config.getAdminPass());
        InfoAlertModal infoAlertModal = new InfoAlertModal();
        new InfoAlertModalRobot(infoAlertModal)
                .checkMsgText(EXPECTED_TEXT)
                .clickOkBtn();
    }

    @Test
    @DisplayName("Users. Пользователь \"user\". Logout")
    @TmsLink("2389")
    @Tag("#2389")
    public void userlogOutTest() {
        LOGGER.info("Prep state by userLoginTest");
        login(Config.getUserLogin(), Config.getUserPass());
        LOGGER.info("logOut test start");
        UsersScreen usersScreen = new UsersScreen();
        new UserScreenRobot(usersScreen)
                .threePointsBtnClick();
        ThreePointsMenu threePointsMenu = new ThreePointsMenu();
        new ThreePointsMenuRobot(threePointsMenu)
                .exitBtnClick();
        LoginScreen loginScreen = new LoginScreen();
        new LoginScreenRobot(loginScreen)
                .assertVisibleElements();
        LOGGER.info("logOut end");
    }

    @Test
    @DisplayName("Users. Пользователь \"user\". Авторизация с невалидным email")
    @TmsLink("2388")
    @Tag("#2388")
    public void userloginNoValidEmailTest() {
        String NO_VALID_EMAIL = "name..surname@mail.ru";
        login(NO_VALID_EMAIL, Config.getUserPass());
        // TODO: update tests if apps will be contain noValidEmail msg. Assert msg
    }

    @Test
    @DisplayName("Users. Пользователь \"user\". Авторизация с невалидным паролем")
    @TmsLink("2387")
    @Tag("#2387")
    public void userloginNoValidPassTest() {
        String NO_VALID_PASS = "'"; //too small for exemple =)
        login(Config.getUserLogin(), NO_VALID_PASS);
        // TODO: update tests if apps will be contain noValidPass msg. Assert msg
    }

    @Test
    @Tag("fail")
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

    /**
     * Method to perform a successful authorization
     * @param userName
     * @param password
     */
    private void login(String userName, String password) {
        LoginScreen loginScreen = new LoginScreen();
        new LoginScreenRobot(loginScreen)
                .typeUserName(userName)
                .typePassword(password)
                .clickToLoginBtn();
    }
}
