import Pages.Veterinarians.AddVeterinariansPage;
import Pages.Veterinarians.AllVeterinariansPage;
import Pages.Veterinarians.EditVeterinarianPage;
import Pages.Header;
import Utils.DatabaseConnection;
import Utils.InitializeTests;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;


public class VeterinariansTests extends InitializeTests {

    private Header header;
    private AddVeterinariansPage addVeterinariansPage;
    private AllVeterinariansPage allVeterinariansPage;
    private EditVeterinarianPage editVeterinarianPage;
    private DatabaseConnection databaseConnection;

    @BeforeMethod(groups = {("sanity")})
    public void beforeMethod() throws FileNotFoundException, MalformedURLException {

        //startBrowser();
        header = new Header(driver);
        addVeterinariansPage = new AddVeterinariansPage(driver);
        allVeterinariansPage = new AllVeterinariansPage(driver);
        editVeterinarianPage = new EditVeterinarianPage(driver);
        databaseConnection = new DatabaseConnection();

    }

    @Test(groups = {("sanity")})
    public void addVeterinarian() {
        header.clickOnAddAVet();
        addVeterinariansPage.addVet();
        String vetName = addVeterinariansPage.firstName + " " + addVeterinariansPage.lastName;
        System.out.println("Verifying that the new veterinarian " + vetName + " has been added");
        Assert.assertTrue(allVeterinariansPage.vetTableContains(vetName));
    }

    @Test
    public void checkTableHeader() {
        header.clickOnAllVet();
        System.out.println("Verifying that the veterinarians table header has a column named \"Name\"");
        Assert.assertTrue(allVeterinariansPage.vetTableHeaderContains("Name"));
        System.out.println("Verifying that the veterinarians table header has a column named \"Specialties\"");
        Assert.assertTrue(allVeterinariansPage.vetTableHeaderContains("Specialties"));
    }

    @Test
    public void checkTableTitle() {
        header.clickOnAllVet();
        System.out.println("Verifying that the owners table title is \"Veterinarians\"");
        Assert.assertTrue(allVeterinariansPage.getVetTableTitle().equals("Veterinarians"));
    }

    @Test(groups = {("sanity")})
    public void deleteVeterinarian() throws InterruptedException {
        header.clickOnAddAVet();
        addVeterinariansPage.addVet();
        String vetName = addVeterinariansPage.firstName + " " + addVeterinariansPage.lastName;
        allVeterinariansPage.deleteVet(vetName);
        System.out.println("Verifying that the new veterinarian has been deleted " + vetName);
        Assert.assertFalse(allVeterinariansPage.vetTableContains(vetName));
    }

    @Test(groups = {("sanity")})
    public void editVeterinarian() throws InterruptedException {
        header.clickOnAddAVet();
        addVeterinariansPage.addVet();
        String vetName = addVeterinariansPage.firstName + " " + addVeterinariansPage.lastName;
        String newFirstName = "Aladin";
        allVeterinariansPage.editVet(vetName);
        editVeterinarianPage.editFirstName(newFirstName);
        LOGGER.info("Verifying that the new veterinarian has been edited: " + newFirstName + " " + addVeterinariansPage.lastName);
        //System.out.println("Verifying that the new veterinarian has been edited " + newFirstName + " " + addVeterinariansPage.lastName);
        Assert.assertTrue(allVeterinariansPage.vetTableContains(newFirstName + " " + addVeterinariansPage.lastName));
    }

    @Test(groups = {("sanity")})
    public void verifyDB() throws SQLException {
        header.clickOnAddAVet();
        addVeterinariansPage.addVet();
        String vetName = addVeterinariansPage.firstName + " " + addVeterinariansPage.lastName;

        String sqlStatement = "select * from vets";
        LOGGER.info("Verifying that the new vet " + vetName + "has been added");
        List<String> names = databaseConnection.connectToDB(getCfg().getProperty("dbURL"), getCfg().getProperty("dbUser"), getCfg().getProperty("dbPass"), sqlStatement);
        boolean booly = false;
        for (String name : names) {
            if (name.equalsIgnoreCase(vetName))
                booly = true;
        }
        Assert.assertTrue(booly);
    }
}
