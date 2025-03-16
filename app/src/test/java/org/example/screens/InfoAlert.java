package org.example.screens;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static com.codeborne.selenide.Condition.visible;

public class InfoAlert extends BaseScreen {
    @AndroidFindBy(id = "android:id/message")
    private SelenideAppiumElement msgText;

    @AndroidFindBy(id = "android:id/button1")
    private SelenideAppiumElement okBtn;

    public SelenideAppiumElement getMsgText() {
        return msgText;
    }

    public SelenideAppiumElement getOkBtn() {
        return okBtn;
    }

    @Override
    public void checkScreenElements() {
        msgText.shouldBe(visible);
        okBtn.shouldBe(visible);
    }
}
