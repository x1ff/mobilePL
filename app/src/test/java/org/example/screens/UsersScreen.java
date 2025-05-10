package org.example.screens;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import static com.codeborne.selenide.Condition.visible;
public class UsersScreen extends BaseScreen {
    @AndroidFindBy(id = "com.example.apppolygon:id/buttonCreateUser")
    public SelenideAppiumElement createUserBtn;

    @AndroidFindBy(id = "com.example.apppolygon:id/carMenu")
    public SelenideAppiumElement carMenuBtn;
    @AndroidFindBy(id = "com.example.apppolygon:id/housesMenu")
    public SelenideAppiumElement housesMenuBtn;

    @Override
    public void assertVisibleElements() {
        createUserBtn.shouldBe(visible);
        carMenuBtn.shouldBe(visible);
        housesMenuBtn.shouldBe(visible);
    }
}
