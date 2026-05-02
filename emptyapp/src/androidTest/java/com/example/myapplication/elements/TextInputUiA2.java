package com.example.myapplication.elements;

import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;
import com.example.myapplication.Device;

import static org.junit.Assert.assertNotNull;

public class TextInputUiA2 extends ElementsContainerWrapper {
    public TextInputUiA2(BySelector self) {
        super(self);
    }

    /**
     * Type text into input
     * @param text will type
     */
    public void type(String text) {
        UiObject2 element = Device.getDevice().wait(Until.findObject(self), DEFAULT_TIMEOUT_MS);
        assertNotNull(
                "No input by selector: " + self,
                element
        );
        element.setText(text);
    }
}
