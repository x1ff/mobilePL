package org.example.robots;

import com.codeborne.selenide.Selenide;
import org.example.modals.InfoAlertModal;

public class InfoAlertModalRobot implements Robotic {
    InfoAlertModal infoAlertModal = Selenide.page(InfoAlertModal.class);

    public InfoAlertModalRobot checkMsgText(String expectedMsg) {
        infoAlertModal.getMsgText().assertText(expectedMsg);
        return this;
    }

    public InfoAlertModalRobot clickOkBtn() {
        infoAlertModal.getOkBtn().click();
        return this;
    }

    public InfoAlertModalRobot checkDisappear() {
        infoAlertModal.getOkBtn().assertDissapear();
        infoAlertModal.getMsgText().assertDissapear();
        return this;
    }

    @Override
    public InfoAlertModalRobot assertVisibleElements() {
        infoAlertModal.assertVisibleElements();
        return this;
    }
}
