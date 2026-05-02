package com.example.myapplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class.getName());
    private static Config instance = null;
    private static String userLogin;
    private static String userPass;

    private Config() {
    }

    public static Config getConfig() {
        if (Config.instance == null) {
            Config.instance = new Config();
        }
        return instance;
    }
    public static void loadConfig(String fileName) throws IllegalStateException {
        // apkDir = System.getenv("APK_DIR");
        Properties prop = new Properties();
        try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(fileName)) {
            prop.load(inputStream);
            userLogin = prop.getProperty("userLogin");
            userPass = prop.getProperty("userPassword");
        } catch (IOException | RuntimeException e) {
            LOGGER.error("Ошибка при загрузке конфига {}", e.getMessage());
            throw new IllegalStateException("Ошибка при загрузке конфига");
        }
    }

    public static void logConfig() {
        LOGGER.info("userLogin: {}", userLogin);
        LOGGER.info("userPassword: {}", userPass);
    }

    public static String getUserLogin() {
        return userLogin;
    }

    public static String getUserPass() {
        return userPass;
    }
}
