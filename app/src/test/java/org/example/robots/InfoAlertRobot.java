package org.example.robots;

import com.codeborne.selenide.Selenide;
import org.example.screens.InfoAlert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class InfoAlertRobot {
    InfoAlert alert = Selenide.page(InfoAlert.class);

    public InfoAlertRobot checkMsgText(String expectedMsg) {
        alert.getMsgText().shouldBe(visible).shouldHave(text(expectedMsg));
        return this;
    }

    public InfoAlertRobot clickOkBtn() {
        alert.getOkBtn().shouldBe(visible).click(tap());
        return this;
    }

    public InfoAlertRobot checkDisappear() {
        alert.getOkBtn().should(disappear);
        alert.getMsgText().should(disappear);
        return this;
    }
}
