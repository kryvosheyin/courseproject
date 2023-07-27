package utils;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvProperties {

    private final static String FILE_PATH = "src/test/java/resources/";
    private final static String ENV_PROPERTIES_FILE = "environment.properties";

    public static final String API_USER = PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiUser");
    public static final String API_URL = System.getProperty("api_url", PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiUrl"));
    public static final String API_TOKEN = System.getProperty("api_token", PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiToken"));
    public static final String API_URI = System.getProperty("api_uri", PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiUri"));
    public static final String DB_URL = PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "databaseURL");
    public static final String DB_USER = PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "dbUser");
    public static final String DB_PASSWORD = PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "dbPassword");
    public static final String BROWSER_NAME = System.getProperty("browser", PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "browserName"));
    public static final boolean BROWSER_HEADLESS = Boolean.parseBoolean(System.getProperty("headless", PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "browserHeadless")));







}
