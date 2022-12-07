package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    @Test
    public void test01() {
        /*
        Softassertion baslangic ve bitis satirlari arasindaki
        tum assertion'lari yapip bitis satirina geldiginde bize
        buldugu tum hatalari rapor eder


        -Softassert in baslangici obje olusturmaktir
         */

        SoftAssert softAssert=new SoftAssert();





        /*
        amazon anasayfaya gidin
        title in Amazon icerdigini test edin
        arama kutusunun erisilebilir oldugunu test edin
        arama kutusuna nutella yazip aratin
        arama yapildigini test edin
        arama sonucunun Nutella icerdigini test edin
         */

        driver.get("https://www.amazon.com");

        String expectedTitle="amazon";
        String actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        softAssert.assertTrue(sonucYaziElementi.isDisplayed(),"arama yapilamadi");

        softAssert.assertTrue(sonucYaziElementi.getText().contains("Kutella"),"sonuc yazisi kutella icermiyor");


        /*
        softassert'e bitis satirini soylemek icin assertAll() kullanilir

         */
        //softAssert.assertAll();

        /*
        Softassert bu sekilde sonlandirilir ve bundan sonra class calismaz

         */
    }
}
