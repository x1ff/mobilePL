package com.example.myapplication;

import android.app.UiAutomation;
import android.os.ParcelFileDescriptor;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScreenRecordRule extends TestWatcher {

    private final Shell shell = new Shell();
    private List<Integer> screenRecordProcessIds = Collections.emptyList();

    @Override
    protected void starting(Description description) {
        String fileName = "record_" + description.getMethodName() + ".mp4";

        shell.executeCommand(
                "screenrecord /sdcard/" + fileName,
                false
        );

        screenRecordProcessIds = shell.findProcessIds("screenrecord");
    }

    @Override
    protected void finished(Description description) {
        try {
            Thread.sleep(5000);

            for (Integer pid : screenRecordProcessIds) {
                shell.executeCommand(
                        "kill -SIGINT " + pid,
                        false
                );
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Screen record stopping was interrupted", e);
        }
    }
    private static class Shell {

        private final UiAutomation uiAutomation =
                InstrumentationRegistry.getInstrumentation().getUiAutomation();

        public String executeCommand(String cmd, boolean awaitOutput) {
            ParcelFileDescriptor parcelFileDescriptor =
                    uiAutomation.executeShellCommand(cmd);

            if (!awaitOutput) {
                return "";
            }

            try (InputStream inputStream =
                         new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor)) {

                return readToString(inputStream);

            } catch (IOException e) {
                throw new RuntimeException("Failed to execute shell command: " + cmd, e);
            }
        }

        public List<Integer> findProcessIds(String processName) {
            String output = executeCommand(
                    "pidof " + processName,
                    true
            ).trim();

            if (output.isEmpty()) {
                return Collections.emptyList();
            }

            String[] parts = output.split("\\s+");
            List<Integer> processIds = new ArrayList<>();

            for (String part : parts) {
                if (!part.isEmpty()) {
                    processIds.add(Integer.parseInt(part));
                }
            }

            return processIds;
        }

        private String readToString(InputStream inputStream) throws IOException {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            byte[] data = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(data)) != -1) {
                buffer.write(data, 0, bytesRead);
            }

            return buffer.toString(Charset.defaultCharset().name());
        }
    }
}
