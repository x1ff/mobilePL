package com.example.myapplication.elements;

import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import com.example.myapplication.devices.Device1;

public class TextInputUiA2 extends ElementsContainerWrapper {
    public TextInputUiA2(BySelector self) {
        super(self);
    }

    public void type(String text) {
        Device1
                .getDevice()
                .findObject(self)
                .setText(text);
    }

}
