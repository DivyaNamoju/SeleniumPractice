package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class TestData {
    public static String getData(String val)
    {
        Properties pr = new Properties();
        try {
            File propertiesFileName = new File(System.getProperty("user.dir")+"\\testdata\\TestData.properties");
            FileInputStream fi = new FileInputStream(propertiesFileName);
            pr.load(fi);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return pr.getProperty(val);
    }
}
