import Pages.Owners.AddOwnerPage;
import Pages.Owners.AllOwnersPage;
import Pages.Header;


import Pages.Owners.OwnerInformationPage;
import Pages.Owners.OwnersPet;
import Utils.DatabaseConnection;
import Utils.InitializeTests;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;


public class OwnersPageTests extends InitializeTests {

    private Header header;
    private AddOwnerPage addOwnerPage;
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;
    private OwnersPet ownersPet;
    private DatabaseConnection databaseConnection;

    @BeforeMethod(groups = {"params", "regression"})
    public void beforeClass() throws FileNotFoundException, MalformedURLException {
        //startBrowser();
        header = new Header(driver);
        addOwnerPage = new AddOwnerPage(driver);
        allOwnersPage = new AllOwnersPage(driver);
        ownerInformationPage = new OwnerInformationPage(driver);
        ownersPet = new OwnersPet(driver);
        databaseConnection = new DatabaseConnection();
    }

    @Test(groups = {("regression")})
    public void addNewOwner() {
        header.clickOnAddNewOwner();
        addOwnerPage.typeFirstName();
        addOwnerPage.typeLastName();
        addOwnerPage.typeAddress();
        addOwnerPage.typeCity();
        addOwnerPage.typeTelephone();
        addOwnerPage.clickOnSubmit();
        header.clickOnAllOwnersButton();
        LOGGER.info("Verifying that the new owner " + addOwnerPage.firstName + " " + addOwnerPage.lastName + "has been added");
        Assert.assertTrue(allOwnersPage.ownersTableContains(addOwnerPage.firstName + " " + addOwnerPage.lastName));
    }

    @Test(groups = {"params"})
    @Parameters({"firstName", "lastName", "address", "city", "telephone"})
    public void addNewOwnerParams(String firstName, String lastName, String address, String city, String telephone) {
        header.clickOnAddNewOwner();
        addOwnerPage.typeFirstName(firstName);
        addOwnerPage.typeLastName(lastName);
        addOwnerPage.typeAddress(address);
        addOwnerPage.typeCity(city);
        addOwnerPage.typeTelephone(telephone);
        addOwnerPage.clickOnSubmit();
        header.clickOnAllOwnersButton();
        LOGGER.info("Verifying that the new owner " + firstName + " " + lastName + "has been added");
        Assert.assertTrue(allOwnersPage.ownersTableContains(firstName + " " + lastName));
    }

    @Test(groups = {("regression")})
    public void checkTableHeader() {
        header.clickOnAllOwnersButton();
        LOGGER.info("Verifying that the owners table header has a column named \"Name\"");
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("Name"));
        LOGGER.info("Verifying that the owners table header has a column named \"Address\"");
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("Address"));
        LOGGER.info("Verifying that the owners table header has a column named \"City\"");
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("City"));
        LOGGER.info("Verifying that the owners table header has a column named \"Telephone\"");
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("Telephone"));
        LOGGER.info("Verifying that the owners table header has a column named \"Pets\"");
        Assert.assertTrue(allOwnersPage.ownersTableHeaderContains("Pets"));
    }

    @Test
    public void checkTableTitle() {
        header.clickOnAllOwnersButton();
        LOGGER.info("Verifying that the owners table title is \"Owners\"");
        Assert.assertEquals(allOwnersPage.getOwnersTableTitle(), "Owners");
    }

//    @Test(groups = {"params"})
//    @Parameters({"petName","birthDate","type"})
//    public void addPetToOwner(String petName,String birthDate,String type){
//        header.clickOnAddNewOwner();
//        addOwnerPage.typeFirstName();
//        addOwnerPage.typeLastName();
//        addOwnerPage.typeAddress();
//        addOwnerPage.typeCity();
//        addOwnerPage.typeTelephone();
//        addOwnerPage.clickOnSubmit();
//        String ownerName = addOwnerPage.firstName + " "  + addOwnerPage.lastName;
//        allOwnersPage.clickOnOwner(ownerName);
//        ownerInformationPage.clickOnAddNewPetButton();
//        ownersPet.typeName(petName);
//        ownersPet.typeBirthDate(birthDate);
//        ownersPet.typePetType(type);
//        ownersPet.clickOnSubmit();
//        header.clickOnAllOwnersButton();
//        A
//    }

    @Test(groups = {("regression")})
    public void verifyDB() throws SQLException {
        header.clickOnAddNewOwner();
        addOwnerPage.typeFirstName();
        addOwnerPage.typeLastName();
        addOwnerPage.typeAddress();
        addOwnerPage.typeCity();
        addOwnerPage.typeTelephone();
        addOwnerPage.clickOnSubmit();
        String sqlStatement = "select * from owners";
        LOGGER.info("Verifying that the new owner " + addOwnerPage.firstName + " " + addOwnerPage.lastName + "has been added");
        List<String> names = databaseConnection.connectToDB(getCfg().getProperty("dbURL"), getCfg().getProperty("dbUser"), getCfg().getProperty("dbPass"), sqlStatement);
        boolean booly = false;
        for (String name : names) {
            if (name.equalsIgnoreCase(addOwnerPage.firstName + " " + addOwnerPage.lastName))
                booly = true;
        }
        Assert.assertTrue(booly);
    }
}
