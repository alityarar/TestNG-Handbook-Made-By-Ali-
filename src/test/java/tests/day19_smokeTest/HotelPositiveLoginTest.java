package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelPositiveLoginTest {
    @Test
    public void positiveTest() {
        HotelPage hotelPage = new HotelPage();
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        hotelPage.logOn.click();
        hotelPage.userName.sendKeys(ConfigReader.getProperty("hotelUser"));
        hotelPage.password.sendKeys(ConfigReader.getProperty("hotelPass"));
        hotelPage.lastlogin.click();
        Assert.assertTrue(hotelPage.menuYonetim.isDisplayed());


    }
}
