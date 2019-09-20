import Pages.Homepage;
import Utils.InitializeTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;


public class HomepageTests extends InitializeTests {

    private Homepage homepage;

    @BeforeClass
    public void beforeMethod() throws FileNotFoundException, MalformedURLException {

        homepage = new Homepage(driver);
    }

    @Test
    public void firstPageTest() {
        LOGGER.info("Verifying that the homepage has the logo and the title displayed");

        Assert.assertTrue(homepage.getTitleName().equalsIgnoreCase("Welcome to Petclinic"));
        Assert.assertTrue(homepage.isLogoDisplayed());

    }

}
