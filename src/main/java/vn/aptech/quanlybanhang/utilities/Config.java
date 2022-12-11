
package vn.aptech.quanlybanhang.utilities;

import java.io.IOException;
import java.util.Properties;


public class Config {

    private static Config instance;
    private final Properties prop;

    public static Config getInstance() throws IOException {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    private Config() throws IOException {
        FileUtils fileUtils = new FileUtils();
        this.prop = new Properties();
        this.prop.load(fileUtils.getInputStreamFromResource("config.properties"));
    }

    public Properties getProp() {
        return prop;
    }

    public static String get(String name) {
        return instance.getProp().getProperty(name);
    }

}
