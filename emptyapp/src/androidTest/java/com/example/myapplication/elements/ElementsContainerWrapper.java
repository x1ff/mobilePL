package com.example.myapplication.elements;

import android.os.RemoteException;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiDevice;
import com.example.myapplication.devices.Device1;

import static org.junit.Assert.assertEquals;

/**
 * Abstract class for wrap BySelector and prove some common methods.
 *
 */
public abstract class ElementsContainerWrapper {
    BySelector self;

    public ElementsContainerWrapper(BySelector self)  {
        this.self = self;
    }
    public void assertText(String expectedText) {
        UiObject2 object = Device1.getDevice().findObject(self);
        assertEquals(expectedText, object.getText());
    }

    public void assertVisible() throws RemoteException {
        UiObject2 object = Device1.getDevice().findObject(self);
        Device1.getDevice().isScreenOn();
        //TODO
    }

    public void assertDissapear() {
        //TODO
    }

    public String getText() {
        return Device1.getDevice().findObject(self).getText();
    }

    public boolean isDisplayed() {
        return true; //TODO
    }

    public boolean isTextContains(String expected) {
        return Device1.getDevice().findObject(self).getText().contains(expected);
    }
}
