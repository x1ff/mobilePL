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

    private String udid;
    private String appiumUrl;


    private Config() throws IOException {
        boolean isLoad = this.loadConfig("application.properties");
        if(isLoad) {
            logConfig();
        } else {
            LOGGER.info("Конфиг не загружен");
        }
    }

    public static Config getConfig() throws IOException {
        if(Config.instance == null) {
            Config.instance = new Config();
        }
        return instance;
    }

    private boolean loadConfig(String fileName) throws IOException {
        Properties prop = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        File configFile = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        try {
            prop.load(new FileInputStream(configFile));

            this.udid = prop.getProperty("udid");
            this.appiumUrl = prop.getProperty("appiumUrl");

        } catch (IOException e) {
            LOGGER.error("Ошибка при загрузке конфига " + e.getMessage());
            return false;
        }
        return true;
    }

    private void logConfig() {
        LOGGER.info("udid: " + udid);
        LOGGER.info("appiumUrl: " + appiumUrl);
    }

    public String getUdid() {
        return udid;
    }

    public String getAppiumUrl() {
        return appiumUrl;
    }
}
