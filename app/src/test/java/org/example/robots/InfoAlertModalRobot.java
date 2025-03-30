package org.example.robots;

import com.codeborne.selenide.Selenide;
import org.example.modals.InfoAlertModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class InfoAlertModalRobot implements Robotic {
    InfoAlertModal infoAlertModal = Selenide.page(InfoAlertModal.class);

    public InfoAlertModalRobot checkMsgText(String expectedMsg) {
        infoAlertModal.getMsgText().shouldBe(visible).shouldHave(text(expectedMsg));
        return this;
    }

    public InfoAlertModalRobot clickOkBtn() {
        infoAlertModal.getOkBtn().shouldBe(visible).click(tap());
        return this;
    }

    public InfoAlertModalRobot checkDisappear() {
        infoAlertModal.getOkBtn().should(disappear);
        infoAlertModal.getMsgText().should(disappear);
        return this;
    }

    @Override
    public InfoAlertModalRobot checkScreen() {
        infoAlertModal.checkScreenElements();
        return this;
    }
}
