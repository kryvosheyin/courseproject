package utils;

public class EnvVariables {
    private final static String FILE_PATH = "src/test/java/resources/";
    private final static String FILE_NAME = "variables.properties";
    public final static String USER_NAME = PropertiesReader.getPropertyValue(FILE_PATH, FILE_NAME, "validUser");
    public final static String USER_PASSWORD = PropertiesReader.getPropertyValue(FILE_PATH, FILE_NAME, "validPassword");
    public final static String INVALID_USER_NAME = PropertiesReader.getPropertyValue(FILE_PATH, FILE_NAME, "invalidUser");
    public final static String INVALID_PASSWORD = PropertiesReader.getPropertyValue(FILE_PATH, FILE_NAME, "invalidPassword");

    public final static String PROJECT_API = PropertiesReader.getPropertyValue(FILE_PATH, FILE_NAME, "projectApi");
    public final static String API_IDENTIFIER = PropertiesReader.getPropertyValue(FILE_PATH, FILE_NAME, "apiIdentifier");
}
