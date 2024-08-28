package orangehrm.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import orangehrm.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRMTest {

    WebDriver driver;
    @Test(description = "navigating to application", priority = 1)
    void openapp()
    {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://lichess.org/");
        Assert.assertEquals(driver.getTitle(), "lichess.org • Free Online Chess");
    }
    @Test(priority = 2, description = "login to the application")
    void login()
    {
        driver.findElement(By.className("signin")).click();
        driver.findElement(By.name("username")).sendKeys(BaseClass.username);
        driver.findElement(By.name("password")).sendKeys(BaseClass.password);
        driver.findElement(By.xpath("//div[@class='one-factor']//button[@type='submit'][normalize-space()='Sign in']")).click();
        String username = driver.findElement(By.id("user_tag")).getText();
        Assert.assertEquals(username,BaseClass.username);
    }
    @Test(priority = 3, description = "Logout from the application")
    void logout()
    {
        driver.findElement(By.id("user_tag")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).click();
    }
    @Test(priority = 4, description = "tear down the browser")
    void tearDown()
    {
        driver.quit();
    }
}
