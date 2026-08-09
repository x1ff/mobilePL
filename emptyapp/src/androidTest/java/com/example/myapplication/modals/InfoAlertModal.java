package com.example.myapplication.modals;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import com.example.myapplication.elements.ButtonUiA2;
import com.example.myapplication.elements.TextBlockUiA2;
import com.example.myapplication.elements.TextInputUiA2;
import com.example.myapplication.screens.BaseScreenUiA2;


public class InfoAlertModal extends BaseScreenUiA2 {
    private TextBlockUiA2 msgText;
    private ButtonUiA2 okBtn;
    public InfoAlertModal() {
        msgText = new TextBlockUiA2(By.res("android", "message"));
        okBtn = new ButtonUiA2(By.res("android", "button1"));
    }


    public TextBlockUiA2 getMsgText() {
        return msgText;
    }

    public ButtonUiA2 getOkBtn() {
        return okBtn;
    }

}
