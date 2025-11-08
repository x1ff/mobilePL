package com.example.myapplication.elements;

import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiDevice;
import com.example.myapplication.devices.Device1;

import static org.junit.Assert.assertEquals;
public class TextBlockUiA2 extends ElementsContainerWrapper {

    public TextBlockUiA2(BySelector self) {
        super(self);
    }

    public void assertText(String expectedText) {
        assertEquals(expectedText, Device1.getDevice().findObject(self).getText());
    }

}
