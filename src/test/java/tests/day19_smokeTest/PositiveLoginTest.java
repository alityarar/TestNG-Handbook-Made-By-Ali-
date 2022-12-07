package tests.day19_smokeTest;

import org.bouncycastle.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {

    @Test
    public void positiveLoginTest() {
        Driver.getDriver().get(ConfigReader.getProperty("rentUrl"));

        BlueRentalCars blueRentalCars = new BlueRentalCars();

        blueRentalCars.loginButton.click();

        blueRentalCars.userEnter.sendKeys(ConfigReader.getProperty("rentUser"));
        blueRentalCars.passEnter.sendKeys(ConfigReader.getProperty("rentPass"));

        blueRentalCars.lastLogin.click();


        Assert.assertTrue(blueRentalCars.dropDown.isDisplayed());





    }
}
