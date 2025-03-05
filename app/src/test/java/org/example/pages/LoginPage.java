package org.example.pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class LoginPage extends BasePage {

    @AndroidFindBy(id = "com.example.apppolygon:id/username")
    private SelenideAppiumElement userNameInput;
    @AndroidFindBy(id = "com.example.apppolygon:id/password")
    private SelenideAppiumElement passwordInput;
    @AndroidFindBy(id = "com.example.apppolygon:id/login")
    private SelenideAppiumElement loginBtn;

    public LoginPage() {

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
}
