package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public static String getPropertyValue(String filePath, String fileName, String propertyKey){
        Properties properties = new Properties();
        try(InputStream input = new FileInputStream(filePath+fileName)){
            properties.load(input);

        }catch (IOException ex){
            ex.printStackTrace();
        }
        return properties.getProperty(propertyKey);
    }
}
