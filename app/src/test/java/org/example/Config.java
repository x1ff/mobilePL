package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    /**
     * LOGGER is an instance of the Logger class so that we can do proper
     * logging
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class.getName());
    private static Config instance = null;
    private static String udid;
    private static String appiumUrl;
    private static String apkDir;
    private static String userLogin;
    private static String userPass;
    private static String appId;
    private Config() {
    }

    public static Config getConfig() {
        if (Config.instance == null) {
            Config.instance = new Config();
        }
        return instance;
    }

    public static void loadConfig(String fileName) throws IllegalStateException {
        apkDir = System.getenv("APK_DIR");
        Properties prop = new Properties();
        try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(fileName)) {
            prop.load(inputStream);
            udid = prop.getProperty("udid");
            appiumUrl = prop.getProperty("appiumUrl");
            userLogin = prop.getProperty("userLogin");
            userPass = prop.getProperty("userPassword");
            appId = prop.getProperty("appId");
        } catch (IOException | RuntimeException e) {
            LOGGER.error("Ошибка при загрузке конфига {}", e.getMessage());
            throw new IllegalStateException("Ошибка при загрузке конфига");
        }
    }

    public static void logConfig() {
        LOGGER.info("udid: {}", udid);
        LOGGER.info("appiumUrl: {}", appiumUrl);
        LOGGER.info("userLogin: {}", userLogin);
        LOGGER.info("userPassword: {}", userPass);
        LOGGER.info("apk Dir: {}", apkDir);
        LOGGER.info("appId: {}", appId);
    }

    public static String getUdid() {
        return udid;
    }

    public static String getAppiumUrl() {
        return appiumUrl;
    }

    public static String getUserLogin() {
        return userLogin;
    }

    public static String getUserPass() {
        return userPass;
    }

    public static String getApkDir() {
        return apkDir;
    }

    public static String getAppId() {
        return appId;
    }
}
