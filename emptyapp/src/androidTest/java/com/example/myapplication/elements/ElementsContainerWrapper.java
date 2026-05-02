package com.example.myapplication.elements;

import android.os.RemoteException;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiObject2;
import com.example.myapplication.Device;

import static org.junit.Assert.assertEquals;

/**
 * Abstract class for wrap BySelector and prove some common methods.
 *
 */
public abstract class ElementsContainerWrapper {
    BySelector self;
    protected static final long DEFAULT_TIMEOUT_MS = 5_000;
    public ElementsContainerWrapper(BySelector self)  {
        this.self = self;
    }
    public void assertText(String expectedText) {
        UiObject2 object = Device.getDevice().findObject(self);
        assertEquals(expectedText, object.getText());
    }

    public void assertVisible() throws RemoteException {
        UiObject2 object = Device.getDevice().findObject(self);
        Device.getDevice().isScreenOn();
        //TODO
    }

    public void assertDissapear() {
        //TODO
    }

    public String getText() {
        return Device.getDevice().findObject(self).getText();
    }

    public boolean isDisplayed() {
        return true; //TODO
    }

    public boolean isTextContains(String expected) {
        return Device.getDevice().findObject(self).getText().contains(expected);
    }
}
