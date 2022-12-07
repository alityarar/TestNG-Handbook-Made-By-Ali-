package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.List;

public class C07_SoftAssert extends TestBase {

    @Test
    public void test01() {
        /*
        "https://zero.webappsecurity.com/" adresine gidin
        sign in butonuna basin
        login kutusuna username yazin
        pass kutusuna password yazin
        sign in tusuna basin
        online banking menusu icinde pay bills sayfasina gidin
        puchase foreign currency tusuna basin
        currency drop down menusunden eurozone u secin
        soft assert kullanarak eurozone secildigini test edin
        soft assert kullanarak dropdown listesinin su secenekleri oldugunu
        test edin
         */



        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();


        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        driver.findElement(By.xpath("//input[@name='submit']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("(//div['Online Banking'])[12]")).click();

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();

        WebElement secim =driver.findElement(By.xpath("//select[@id='pc_currency']"));

        Select select=new Select(secim);

        select.selectByVisibleText("Eurozone (euro)");


        SoftAssert softAssert=new SoftAssert();

        String secilenOption=select.getFirstSelectedOption().getText();
        String expectedOption="Eurozone (Euro)";

        softAssert.assertEquals(secilenOption,expectedOption,"Secilen option uygun degil");

        List<WebElement>optionlist=select.getOptions();

    }
}
