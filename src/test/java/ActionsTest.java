import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest {

    @Test
    public void actionTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        Actions actions = new Actions(driver);
//         actions.contextClick().perform();
//         actions.contextClick(driver.findElement(By.id("myFile"))).perform();

        WebElement button = driver.findElement(By.id("bottom"));
        actions.doubleClick(button).perform();

        WebElement heading = driver.findElement(By.tagName("h1"));

        actions.moveToElement(heading).perform();
    }
}
