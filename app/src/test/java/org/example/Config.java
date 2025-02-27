package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
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


    private Config() {
    }

    public static Config getConfig() throws IOException {
        if (Config.instance == null) {
            Config.instance = new Config();
        }
        return instance;
    }

    public static boolean loadConfig(String fileName) throws IOException {
        Properties prop = new Properties();
        ClassLoader classLoader = Config.class.getClassLoader();
        File configFile = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        try (FileInputStream fileInputStream = new FileInputStream(configFile)) {
            prop.load(fileInputStream);
            udid = prop.getProperty("udid");
            appiumUrl = prop.getProperty("appiumUrl");
        } catch (IOException e) {
            LOGGER.error("Ошибка при загрузке конфига {}", e.getMessage());
            throw new IllegalStateException("Ошибка при загрузке конфига");
        }
        return true;
    }

    public static void logConfig() {
        LOGGER.info("udid: " + udid);
        LOGGER.info("appiumUrl: " + appiumUrl);
    }

    public static String getUdid() {
        return udid;
    }

    public static String getAppiumUrl() {
        return appiumUrl;
    }
}
