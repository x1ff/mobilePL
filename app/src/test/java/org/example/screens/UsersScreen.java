package org.example.screens;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import static com.codeborne.selenide.Condition.visible;
public class UsersScreen extends BaseScreen {
    @AndroidFindBy(id = "com.example.apppolygon:id/buttonCreateUser")
    private SelenideAppiumElement createUserBtn;

    @AndroidFindBy(id = "com.example.apppolygon:id/carMenu")
    private SelenideAppiumElement carMenuBtn;
    @AndroidFindBy(id = "com.example.apppolygon:id/housesMenu")
    private SelenideAppiumElement housesMenuBtn;

    @Override
    public void checkScreenElements() {
        createUserBtn.shouldBe(visible);
        carMenuBtn.shouldBe(visible);
        housesMenuBtn.shouldBe(visible);
    }
}
