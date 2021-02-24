import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.gboss.io/login");

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement login = driver.findElement(By.className("MuiButton-label"));

        username.sendKeys("example@gmail.com");
        password.sendKeys("password");
        login.click();

        WebElement form = driver.findElement(By.cssSelector(".MuiBox-root.jss18.center-root.submit-root div"));
        String actualResult = form.getText();
        System.out.println("text " +actualResult);
        String expectedResult = "Username/ password không chính xác";

        if (expectedResult.equalsIgnoreCase(actualResult)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

    }
}