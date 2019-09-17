import Pages.Owners.AddOwnerPage;
import Pages.Owners.AllOwnersPage;
import Utils.Header;
import Utils.NewUser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OwnersPageTests {
    WebDriver driver;
    private String baseURL = "http://bhdtest.endava.com/petclinic/";

    Header header;
    AddOwnerPage addOwnerPage;
    NewUser newUser;
    AllOwnersPage allOwnersPage;

    @BeforeTest
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        header = new Header(driver);
        addOwnerPage = new AddOwnerPage(driver);
        newUser = new NewUser();
        allOwnersPage = new AllOwnersPage(driver);
    }

    @Test
    public void addNewOwner() {
        header.clickOnAddNewOwner();
        addOwnerPage.addOwner();
        header.clickOnAllOwnersButton();
        System.out.println("Verifying that the new owner has been added");
        Assert.assertTrue(allOwnersPage.ownersTableContains(addOwnerPage.firstName + " "  + addOwnerPage.lastName));
    }

    @Test
    public void checkTableHeader(){
        header.clickOnAllOwnersButton();
        System.out.println("Verifying that the owners table header has a column names \"Name\"");
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("Name"));
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("Address"));
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("City"));
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("Telephone"));
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("Pets"));
    }

    @Test
    public void checkTableTitle() {
        header.clickOnAllOwnersButton();
        System.out.println("Verifying that the owners table title is \"Owners\"");
        Assert.assertTrue(allOwnersPage.getOwnersTableTitle().equalsIgnoreCase("owners"));
    }

    @AfterTest
    public void afterMethod(){
        driver.close();
        driver.quit();
    }
}
