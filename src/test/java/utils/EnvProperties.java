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
    public static final String API_URL = PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiUrl");
    public static final String API_TOKEN = PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiToken");
    public static final String API_URI = PropertiesReader.getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiUri");






}
