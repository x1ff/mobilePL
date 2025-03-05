package org.example.screens;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class InfoAlert {
    @AndroidFindBy(id = "android:id/message")
    private SelenideAppiumElement msgText;

    @AndroidFindBy(id = "android:id/button1")
    private SelenideAppiumElement okBtn;

    public String getMsgText() {
        return  $(msgText).shouldBe(visible).getText();
    }

    public void clickOkBtn() {
        $(okBtn).shouldBe(visible).click(tap());
    }
}
