import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage() throws InterruptedException {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.switchTo().frame(0);
        WebElement agreeButton = driver.findElement(By.xpath("//span[contains(test(),'Zgadzam')]"));
        agreeButton.click();
        driver.switchTo().defaultContent();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//a[contains(@href, 'selenium.dev)]//span'"));

        Assert.assertTrue(result.isDisplayed());
    }

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                String chromePath = ("C:\\Users\\konrad.kolodziej\\OneDrive - IPF Digital AS\\Documents\\chromedriver\\chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", chromePath);
                return new ChromeDriver();
            case "firefox":
                String firefoxPath = ("C:\\Users\\konrad.kolodziej\\OneDrive - IPF Digital AS\\Documents\\geckodriver-v0.30.0-win64\\geckodriver.exe");
                System.setProperty("webdriver.chrome.driver", firefoxPath);
                return new FirefoxDriver();
            default:
                throw  new InvalidArgumentException("Invalid browser name");
        }

    }
}
