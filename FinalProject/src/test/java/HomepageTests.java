import Pages.Homepage;
import Utils.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomepageTests {
    WebDriver driver;
    private String baseURL = "http://bhdtest.endava.com/petclinic/";
    Homepage homepage;

    @BeforeTest
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homepage = new Homepage(driver);

    }

    @Test
    public void firstPageTest(){
        Assert.assertTrue(homepage.isLogoDisplayed());
        Assert.assertTrue(homepage.getTitleName().equalsIgnoreCase("Welcome to Petclinic"));
    }

    @AfterTest
    public void afterMethod(){
        driver.close();
        driver.quit();
    }
}
