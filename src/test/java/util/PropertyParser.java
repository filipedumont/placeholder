package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ffranca on 6/11/15.
 */
public class PropertyParser {

    private static final Logger logger = Logger.getLogger(PropertyParser.class.getName());

    private Properties prop;
    private InputStream input;

    public PropertyParser(){
        String env = System.getProperty("env");
        prop = new Properties();

        try {
            if ("staging".equals(env)) {
                input = new FileInputStream("src/test/java/config/staging.properties");
            }
            prop.load(input);
        }catch(IOException e){
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public String getPropertyValue(String key){
        return prop.getProperty(key);
    }

}
