package com.example.myapplication;

import androidx.test.uiautomator.UiDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

public class Device {
    private static final Logger LOGGER = LoggerFactory.getLogger(Device.class.getName());
    private static Device instance = null;
    private static UiDevice device;
    private Device() {
    }
    public static Device getInstance() {
        if (Device.instance == null) {
            Device.instance = new Device();
        }
        return instance;
    }
    public static void initDevice() {
        device = UiDevice.getInstance(getInstrumentation());
    }

    public static UiDevice getDevice() {
        return device;
    }
}
