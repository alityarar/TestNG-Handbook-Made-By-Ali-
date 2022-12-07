package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {


    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri={{"firuze@nehaber.com","54678"},
                {"muratbilmemne@bihaber.com","4687431"},
                {"ilyas@hollanda.com","44564562"}};


        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullaniciListesi")
    public void test01(String usermail,String password) {
        BlueRentalCars blueRentalCars=new BlueRentalCars();
        Driver.getDriver().get(ConfigReader.getProperty("rentUrl"));
        blueRentalCars.loginButton.click();

        blueRentalCars.userEnter.sendKeys(usermail);
        blueRentalCars.passEnter.sendKeys(password);

        blueRentalCars.lastLogin.click();


        Assert.assertTrue(blueRentalCars.loginButton.isDisplayed());


        Driver.closeDriver();

    }
}
