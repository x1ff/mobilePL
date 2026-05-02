package com.example.myapplication.devices;

import androidx.test.uiautomator.UiDevice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

public class Device1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Device1.class.getName());
    private static Device1 instance = null;
    private static UiDevice device;
    private Device1() {
    }

    public static Device1 getInstance() {
        if (Device1.instance == null) {
            Device1.instance = new Device1();
        }
        return instance;
    }

    public static void initDevice1() {
        device = UiDevice.getInstance(getInstrumentation());
    }


    public static UiDevice getDevice() {
        return device;
    }
}
