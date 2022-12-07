package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {
    @DataProvider
    public static Object[][] AranacakKelimeler() {

        Object[][] arananKelimeArray= {{"Nutella"}, {"java"}, {"cigdem"},{"Netherlands"}};

        return arananKelimeArray;
    }

    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella icin arama yapalim
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella icerdigini test edin
        String expectedKelime="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        Driver.closeDriver();
    }

    @Test (dataProvider = "AranacakKelimeler")
    //arayacagimiz kelimeleri bir liste gibi tutup
    //bana yollayacak bir veri saglayicisi olusturacagiz
    public void test02(String arananKelime) {
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella,java,cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(arananKelime+ Keys.ENTER);
        String expectedKelime=arananKelime;
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        Driver.closeDriver();

        //sonuclarin aradigimiz kelime icerdigini test edelim
        //sayfayi kapatalim



    }
}
