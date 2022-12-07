package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {
    @Test
    public void NegativeLoginTest() {
        BlueRentalCars blueRentalCars=new BlueRentalCars();
        Driver.getDriver().get(ConfigReader.getProperty("rentUrl"));
        blueRentalCars.loginButton.click();

        blueRentalCars.userEnter.sendKeys(ConfigReader.getProperty("rentNoUser"));
        blueRentalCars.passEnter.sendKeys(ConfigReader.getProperty("rentNoPass"));

        blueRentalCars.lastLogin.click();


        Assert.assertTrue(blueRentalCars.loginButton.isDisplayed());



    }
}
