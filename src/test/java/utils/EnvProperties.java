package utils;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvProperties {

    private final static String FILE_PATH = "src/test/java/resources/";
    private final static String ENV_PROPERTIES_FILE = "environment.properties";

    public static final String API_USER = getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiUser");
    public static final String API_URL = getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiUrl");
    public static final String API_TOKEN = getPropertyValue(FILE_PATH, ENV_PROPERTIES_FILE, "apiToken");


    private static String getPropertyValue(String filePath, String fileName, String propertyKey){
        Properties properties = new Properties();
        try(InputStream input = new FileInputStream(filePath+fileName)){
            properties.load(input);

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return properties.getProperty(propertyKey);
    }



}
