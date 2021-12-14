import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class iframeTest {

    @Test
    public void testNewWindow(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        driver.switchTo().frame(0);
          driver.findElement(By.id("fname")).sendKeys("bartel");
        driver.switchTo().defaultContent();              // powrót do pierwotnego okna htmk
        System.out.println(driver.findElement(By.tagName("h1")));

    }

    @Test
    public void testNewWindowIframeII(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");
        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("fname")).sendKeys("bartel");
        driver.switchTo().defaultContent();              // powrót do pierwotnego okna htmk
        System.out.println(driver.findElement(By.tagName("h1")));

    }
}
