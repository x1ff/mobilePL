package org.example.robots;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.example.modals.InfoAlertModal;

public class InfoAlertModalRobot implements Robotic {
    InfoAlertModal infoAlertModal = Selenide.page(InfoAlertModal.class);

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
        infoAlertModal.assertVisibleElements();
        return this;
    }
}
