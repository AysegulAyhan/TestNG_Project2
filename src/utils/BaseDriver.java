package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class BaseDriver {
    protected WebDriver driver;
    protected Actions builder;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    public  PageObject page;


    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    protected void setup(@Optional("chrome") String browser) {
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium dependency\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Selenium dependency\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().deleteAllCookies();
        page=new PageObject(driver);
        builder = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys("aysegul@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#SubmitLogin")).click();

    }

    @AfterClass(alwaysRun = true)
    protected void closeDriver() {
//        driver.quit();
    }
}
