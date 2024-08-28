import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TakeScreenShotDemo {
    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://lichess.org/learn");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("title of the website : " + title);

        String userDir = System.getProperty("user.dir");
        System.out.println("User's current working directory " + userDir);

        // Taking screenshot using TakeScreenshot interface
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(userDir+"\\screenshots\\fullpage.png");
        srcFile.renameTo(targetFile);

        // Take screenshot of section of screen
        WebElement headerEle = driver.findElement(By.className("categ_stages"));
        File srcFile1 = headerEle.getScreenshotAs(OutputType.FILE);
        File targetFile1 = new File(userDir+"\\screenshots\\elementImg.png");
        srcFile1.renameTo(targetFile1);

        // Screenshot of a specific element
        WebElement categoryEle = driver.findElement(By.xpath("//div[@class='learn__side-home']"));
        File srcFile2 = categoryEle.getScreenshotAs(OutputType.FILE);
        File targetFile2 = new File(userDir+"\\screenshots\\chessPieces.png");
        srcFile2.renameTo(targetFile2);

    }
}
