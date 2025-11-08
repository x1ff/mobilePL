package com.example.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.Until;
import com.example.myapplication.devices.Device1;
import com.example.myapplication.modals.InfoAlertModal;
import com.example.myapplication.robots.InfoAlertModalRobot;
import com.example.myapplication.robots.LoginScreenRobot;
import com.example.myapplication.screens.LoginScreen;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleInstrumentedTest.class.getName());
    private static final String APP_POLYGON_PACKAGE = "com.example.apppolygon";
    private static final int LAUNCH_TIMEOUT = 5000;

    @Before
    public void startMainActivityFromHomeScreen() throws Exception {
        // Initialize UiDevice instance
        Device1.initDevice1();

        // Start from the home screen
        Device1.getDevice().pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        System.out.println("LauncherPackageName " + launcherPackage);
        assertThat(launcherPackage, notNullValue());
        Device1.getDevice().wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the blueprint app
        Context context = getApplicationContext();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setPackage(APP_POLYGON_PACKAGE);
        intent.setComponent(new ComponentName(APP_POLYGON_PACKAGE, APP_POLYGON_PACKAGE + ".MainActivity"));

        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        UiObject2 appPolygon = Device1.getDevice().findObject(By.desc ("AppPolygon"));
        assertTrue(appPolygon.clickAndWait(Until.newWindow(), 3000));
    }

    /**
     * After Each
     * @throws IOException
     */
    @After
    public void clearApp() throws IOException {
        Device1.getDevice().executeShellCommand(String.format(
                "pm clear %s",
                APP_POLYGON_PACKAGE
        ));
    }

    @Test
    public void loginTest() {
        LOGGER.info("loginTest test start");
        final String EXPECTED_TEXT = "Успешная авторизация!";
        LoginScreen loginScreen = new LoginScreen();
        new LoginScreenRobot(loginScreen)
                .typeUserName("user@pflb.ru")
                .typePassword("user")
                .clickToLoginBtn();
        InfoAlertModal infoAlertModal = new InfoAlertModal();
        new InfoAlertModalRobot(infoAlertModal)
                .checkMsgText(EXPECTED_TEXT)
                .clickOkBtn();
        LOGGER.info("loginTest end");
    }

    @Test
    public void failTest() {
        LOGGER.info("failTest test start");
        final String EXPECTED_TEXT = "Успешная авторизация!";
        LoginScreen loginScreen = new LoginScreen();
        new LoginScreenRobot(loginScreen)
                .typeUserName("inri inri")
                .typePassword("abracadabra")
                .clickToLoginBtn();
        InfoAlertModal infoAlertModal = new InfoAlertModal();
        new InfoAlertModalRobot(infoAlertModal)
                .checkMsgText(EXPECTED_TEXT)
                .clickOkBtn();
        LOGGER.info("failTest end");
    }

    /**
     * Checks whether the given package is installed on the device or emulator.
     * Throws exception if it isn't found.
     */
    private void checkAppInstallation(String packageName) throws Exception {
        Context context = getApplicationContext();
        PackageManager pm = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setPackage(packageName);
        List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.GET_ACTIVITIES);
        System.out.println("list: " + list);
        if (list.isEmpty()) {
            throw new IllegalStateException("The app with package '" + packageName + "' is not installed.");
        }
    }

    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = getApplicationContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}