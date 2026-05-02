package com.example.myapplication.elements;


import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;
import com.example.myapplication.Device;

import static org.junit.Assert.assertNotNull;

/**
 * Custom element to represent buttons
 */
public class ButtonUiA2 extends ElementsContainerWrapper {
    public ButtonUiA2(BySelector self) {
        super(self);
    }

    /**
     * Click on the button
     */
    public void click() {
        UiObject2 element = Device.getDevice().wait(Until.findObject(self), DEFAULT_TIMEOUT_MS);
        assertNotNull(
                "Не найдена кнопка по селектору: " + self,
                element
        );
        element.click();
    }
}
