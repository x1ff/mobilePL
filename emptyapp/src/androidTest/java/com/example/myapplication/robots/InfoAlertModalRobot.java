package com.example.myapplication.robots;

import com.example.myapplication.modals.InfoAlertModal;
import io.qameta.allure.kotlin.Allure;


public class InfoAlertModalRobot implements Robotic {
    InfoAlertModal infoAlertModal;

    public InfoAlertModalRobot(InfoAlertModal infoAlertModal) {
        this.infoAlertModal =  infoAlertModal;
    }

    public InfoAlertModalRobot checkMsgText(String expectedMsg) {
        Allure.step("Проверить текст сообщения " +  expectedMsg, s -> {
            s.parameter("expectedMsg", expectedMsg);
            infoAlertModal.getMsgText().assertText(expectedMsg);
            return null;
        });
        return this;
    }

    public InfoAlertModalRobot clickOkBtn() {
        Allure.step("Кликнуть ОК",s -> {
            infoAlertModal.getOkBtn().click();
            return null;
        });
        return this;
    }

    public InfoAlertModalRobot checkDisappear() {
        Allure.step("Проверить исчезновение", s -> {
            infoAlertModal.getOkBtn().assertDissapear();
            infoAlertModal.getMsgText().assertDissapear();
            return null;
        });
        return this;
    }

    @Override
    public InfoAlertModalRobot assertVisibleElements() {
//        infoAlertModal.assertVisibleElements();
        return this;
    }
}
