package org.example.screens;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class InfoAlert {
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
}
