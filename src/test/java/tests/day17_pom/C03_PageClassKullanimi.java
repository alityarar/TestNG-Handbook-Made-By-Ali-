package tests.day17_pom;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {

    @Test
    public void test1() {
        Faker faker = new Faker();
        //facebook anasayfasina gidin
        //kullanici mail kutusuna rastgele bir isim yazdirin
        //kullanici sifre kutusuna rastgele bir password yazdirin
        //login butonuna basin
        //giris yapilamadigini test edin

        Driver.getDriver().get("https://www.facebook.com");
        FacebookPage facebookpage=new FacebookPage();
        facebookpage.kullaniciGirisYeri.sendKeys(faker.internet().emailAddress());
        facebookpage.sifreGirisi.sendKeys(faker.internet().password());
        facebookpage.girisYapTusu.click();

        Assert.assertTrue(facebookpage.girilemediYaziElementi.isDisplayed());

        Driver.getDriver().close();
    }
}
