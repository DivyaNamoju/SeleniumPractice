import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

    public static String getData(String val)
    {
        ResourceBundle rb = ResourceBundle.getBundle("TestData");
        return rb.getString(val);
    }

    public static void main(String[] args) {
        System.out.println(ResourceBundleDemo.getData("url"));
    }
}
