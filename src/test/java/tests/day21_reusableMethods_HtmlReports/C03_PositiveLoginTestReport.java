package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C03_PositiveLoginTestReport  extends TestBaseReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Positive Login","Gecerli " +
                "sifre ve username ile giris yapabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("rentUrl"));
        extentTest.info("rent anasayfaya gidildi");

        BlueRentalCars blueRentalCars = new BlueRentalCars();

        blueRentalCars.loginButton.click();
        extentTest.info("ilk login butonuna tiklandi");

        blueRentalCars.userEnter.sendKeys(ConfigReader.getProperty("rentUser"));
        extentTest.info("username girildi");
        blueRentalCars.passEnter.sendKeys(ConfigReader.getProperty("rentPass"));
        extentTest.info("password girildi");

        blueRentalCars.lastLogin.click();
        extentTest.info("login yapildi");


        Assert.assertTrue(blueRentalCars.homehome.isDisplayed());
        //normali drop olacak, sifreyi degistirmisler aw


        extentTest.pass("kullanici basarili sekilde home seysini gordu");


    }
}
