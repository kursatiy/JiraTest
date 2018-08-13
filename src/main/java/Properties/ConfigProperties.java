package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {


    Properties prop = new Properties();
    InputStream input = null;

    public String DataFromPropertiesFile(String loginOrPasswordOrJiraUrl) {


        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            try {
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (
                IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop.getProperty(loginOrPasswordOrJiraUrl);
    }


}
