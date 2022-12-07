package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelNegativeTest {
    @Test
    public void negativeTest() {
        HotelPage hotelPage = new HotelPage();
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        hotelPage.logOn.click();
        hotelPage.userName.sendKeys(ConfigReader.getProperty("hotelNoUser"));
        hotelPage.password.sendKeys(ConfigReader.getProperty("hotelNoPass"));
        hotelPage.lastlogin.click();
        Assert.assertTrue(hotelPage.lastlogin.isDisplayed());
    }
}
