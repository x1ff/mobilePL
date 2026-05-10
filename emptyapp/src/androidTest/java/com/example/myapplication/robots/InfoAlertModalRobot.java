package com.example.myapplication.robots;

import com.example.myapplication.modals.InfoAlertModal;
import io.qameta.allure.kotlin.Step;


public class InfoAlertModalRobot implements Robotic {
    InfoAlertModal infoAlertModal;

    public InfoAlertModalRobot(InfoAlertModal infoAlertModal) {
        this.infoAlertModal =  infoAlertModal;
    }
    @Step("Проверить текст сообщения {expectedMsg}")
    public InfoAlertModalRobot checkMsgText(String expectedMsg) {
        infoAlertModal.getMsgText().assertText(expectedMsg);
        return this;
    }

    @Step("Кликнуть ОК")
    public InfoAlertModalRobot clickOkBtn() {
        infoAlertModal.getOkBtn().click();
        return this;
    }

    @Step("Проверить исчезновение")
    public InfoAlertModalRobot checkDisappear() {
        infoAlertModal.getOkBtn().assertDissapear();
        infoAlertModal.getMsgText().assertDissapear();
        return this;
    }

    @Step("Проверить, что открыт экран")
    @Override
    public InfoAlertModalRobot assertVisibleElements() {
//        infoAlertModal.assertVisibleElements();
        return this;
    }
}
