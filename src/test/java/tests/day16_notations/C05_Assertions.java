package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assertions extends TestBase {

    @Test
    public void test01() {
        /*
        amazon anasayfaya gidin
        title in Amazon icerdigini test edin
        arama kutusunun erisilebilir oldugunu test edin
        arama kutusuna nutella yazip aratin
        arama yapildigini test edin
        arama sonucunun Nutella icerdigini test edin
         */

        driver.get("https://www.amazon.com");

        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));



    }
}
