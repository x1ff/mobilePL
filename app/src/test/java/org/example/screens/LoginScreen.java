package org.example.screens;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(id = "com.example.apppolygon:id/username")
    private SelenideAppiumElement userNameInput;
    @AndroidFindBy(id = "com.example.apppolygon:id/password")
    private SelenideAppiumElement passwordInput;
    @AndroidFindBy(id = "com.example.apppolygon:id/login")
    private SelenideAppiumElement loginBtn;

    public LoginScreen() {

    }
    public void typeUserName(String name) {
        $(userNameInput).shouldBe(visible).sendKeys(name);
    }
    public void typePassword(String password) {
        $(passwordInput).shouldBe(visible).sendKeys(password);
    }

    public void clickToLoginBtn() {
        $(loginBtn).shouldBe(visible).click(tap());
    }

    public String getLoginBtnText() {
        return $(loginBtn).shouldBe(visible).getText();
    }

    public UsersScreen auth(String login, String pass) {
        typeUserName(login);
        typePassword(pass);
        clickToLoginBtn();
        InfoAlert infoAlert = Selenide.page(InfoAlert.class);
        assertEquals("Успешная авторизация!", infoAlert.getMsgText());
        infoAlert.clickOkBtn();
        return Selenide.page(UsersScreen.class);
    }
}
