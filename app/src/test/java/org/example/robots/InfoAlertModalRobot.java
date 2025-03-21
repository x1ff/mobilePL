package org.example.robots;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.example.modals.InfoAlertModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.appium.AppiumClickOptions.tap;

public class InfoAlertModalRobot extends BaseScreenRobot{
    InfoAlertModal infoAlertModal = Selenide.page(InfoAlertModal.class);

    @Step("Проверить текст сообщения")
    public InfoAlertModalRobot checkMsgText(String expectedMsg) {
        infoAlertModal.getMsgText().shouldBe(visible).shouldHave(text(expectedMsg));
        return this;
    }

    @Step("Кликнуть ОК")
    public InfoAlertModalRobot clickOkBtn() {
        infoAlertModal.getOkBtn().shouldBe(visible).click(tap());
        return this;
    }

    @Step("Проверить исчезновение")
    public InfoAlertModalRobot checkDisappear() {
        infoAlertModal.getOkBtn().should(disappear);
        infoAlertModal.getMsgText().should(disappear);
        return this;
    }

    @Step("Проверить наличие элементов")
    @Override
    public InfoAlertModalRobot checkScreen() {
        infoAlertModal.checkScreenElements();
        return this;
    }
}
