
import Pages.PetTypesPage;
import Pages.Header;
import Utils.InitializeTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

public class PetTypesTests extends InitializeTests {

    private Header header;
    private PetTypesPage petTypesPage;


    @BeforeMethod
    public void beforeMethod() throws FileNotFoundException, MalformedURLException {
        startBrowser();
        header = new Header(driver);
        petTypesPage = new PetTypesPage(driver);
    }

    @Test
    public void checkTableHeader() {
        header.clickOnPettypesButton();
        LOGGER.info("Verifying that the pet types table header has a column named \"Name\"");
        Assert.assertTrue(petTypesPage.petTableHeaderContains("Name"));

    }

    @Test
    public void checkTableTitle() {
        header.clickOnPettypesButton();
        LOGGER.info("Verifying that the pet types table title is \"Pet Types\"");
        Assert.assertTrue(petTypesPage.petVetTableTitle().equals("Pet Types"));
    }

    @Test
    public void addAPet() throws InterruptedException {
        header.clickOnPettypesButton();
        LOGGER.info("Adding a new pet type");
        String petType = petTypesPage.petType;
        petTypesPage.clikcOnAddAPet();
        petTypesPage.typePetType();
        petTypesPage.clickOnSubmit();
        LOGGER.info("Verifying that the pet types is added");
        Assert.assertTrue(petTypesPage.verifyPetTableContains(petType));
    }

    @Test
    public void deleteAPet() throws InterruptedException {
        header.clickOnPettypesButton();
        LOGGER.info("Deleting a pet type");
        String petType = petTypesPage.petType;
        petTypesPage.clikcOnAddAPet();
        petTypesPage.typePetType();
        petTypesPage.clickOnSubmit();
        petTypesPage.deleteAPetType(petType);
        LOGGER.info("Verifying that the pet types is indeed deleted");
        Assert.assertFalse(petTypesPage.verifyPetTableContains(petType));
    }
}
