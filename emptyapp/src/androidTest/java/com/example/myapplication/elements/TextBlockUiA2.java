package com.example.myapplication.elements;

import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;
import com.example.myapplication.Device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TextBlockUiA2 extends ElementsContainerWrapper {
    public TextBlockUiA2(BySelector self) {
        super(self);
    }

    /**
     * Check the text block by the expected test
     * @param expectedText
     */
    public void assertText(String expectedText) {
        UiObject2 element = Device.getDevice().wait(Until.findObject(self), DEFAULT_TIMEOUT_MS);
        assertNotNull(
                "No text block by selector: " + self,
                element
        );
        assertEquals(expectedText, element.getText());
    }
}
