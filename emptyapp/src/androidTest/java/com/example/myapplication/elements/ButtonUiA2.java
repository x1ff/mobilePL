package com.example.myapplication.elements;


import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import com.example.myapplication.devices.Device1;

/**
 * Custom element to represent buttons
 */
public class ButtonUiA2 extends ElementsContainerWrapper {
    public ButtonUiA2(BySelector self) {
        super(self);
    }

    public void click() {
        Device1.getDevice().findObject(self).click();
    }
}
