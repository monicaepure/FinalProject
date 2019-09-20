package Utils;

import java.io.IOException;
import java.util.Properties;

public class Config {
    Properties prop;

    public Config() {
        prop = new Properties();
        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream("Config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        String value = this.prop.getProperty(key);
        return value;
    }

}

