package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReader {
    @Test
    public void test01() {

        //facebook anasayfasina gidin
        //kullanici mail kutusuna rastgele bir isim yazdirin
        //kullanici sifre kutusuna rastgele bir password yazdirin
        //login butonuna basin
        //giris yapilamadigini test edin

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        FacebookPage facebookpage=new FacebookPage();
        facebookpage.kullaniciGirisYeri.sendKeys(ConfigReader.getProperty("fbWrongUsername"));
        facebookpage.sifreGirisi.sendKeys(ConfigReader.getProperty("fbWrongPass"));
        facebookpage.girisYapTusu.click();

        Assert.assertTrue(facebookpage.girilemediYaziElementi.isDisplayed());

        Driver.closeDriver();
    }
}
