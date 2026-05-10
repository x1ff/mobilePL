package com.example.myapplication;

import android.os.Bundle;
import io.qameta.allure.android.runners.AllureAndroidJUnitRunner;

import java.io.File;

public class AllureTestRunner extends AllureAndroidJUnitRunner {

    private static final String ALLURE_JUNIT4_LISTENER = "io.qameta.allure.android.listeners.AllureAndroidRunListener";

    @Override
    public void onCreate(Bundle arguments) {
        Bundle args = arguments == null ? new Bundle() : new Bundle(arguments);

        String currentListener = args.getString("listener");

        if (currentListener == null || currentListener.trim().isEmpty()) {
            args.putString("listener", ALLURE_JUNIT4_LISTENER);
        } else if (!containsListener(currentListener, ALLURE_JUNIT4_LISTENER)) {
            args.putString("listener", currentListener + "," + ALLURE_JUNIT4_LISTENER);
        }

        super.onCreate(args);
    }

    @Override
    public void onStart() {
        File baseDir = getTargetContext().getExternalFilesDir(null);

        if (baseDir == null) {
            baseDir = getTargetContext().getFilesDir();
        }

        File allureResultsDir = new File(baseDir, "allure-results");

        if (!allureResultsDir.exists()) {
            allureResultsDir.mkdirs();
        }

        System.setProperty("allure.results.directory", allureResultsDir.getAbsolutePath());

        super.onStart();
    }

    private boolean containsListener(String listeners, String expectedListener) {
        String[] listenerArray = listeners.split(",");

        for (String listener : listenerArray) {
            if (expectedListener.equals(listener.trim())) {
                return true;
            }
        }

        return false;
    }
}

