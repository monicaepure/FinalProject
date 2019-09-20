package Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class InitializeTests {
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);
    public WebDriver driver;

    private Config cfg = new Config();

    public Config getCfg() {
        return cfg;
    }

    @BeforeMethod
    public void startBrowser() {
        LOGGER.info("Starting browser");
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().deleteAllCookies();
        driver.get(cfg.getProperty("baseURL"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void quit() {
        driver.close();
        driver.quit();
    }
}
