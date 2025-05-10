package org.example.modals;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.screens.BaseScreen;
import org.example.elements.Button;
import org.example.elements.TextBlock;

public class InfoAlertModal extends BaseScreen {
    @AndroidFindBy(id = "android:id/message")
    private TextBlock msgText;

    @AndroidFindBy(id = "android:id/button1")
    private Button okBtn;

    public TextBlock getMsgText() {
        return msgText;
    }

    public Button getOkBtn() {
        return okBtn;
    }

    @Override
    public void assertVisibleElements() {
        msgText.assertVisible();
        okBtn.assertVisible();
    }
}
