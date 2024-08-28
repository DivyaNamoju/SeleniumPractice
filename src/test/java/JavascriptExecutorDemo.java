import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://testautomationpractice.blogspot.com/");
        String title = driver.getTitle();
        System.out.println("title of the website : " + title);

        // send keys to name field
        // driver.findElement(By.id("name")).sendKeys("TestAutomation");

        // using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement emailText = driver.findElement(By.id("email"));
        js.executeScript("arguments[0].setAttribute('value','practice');",emailText );


        driver.quit();
    }
}
