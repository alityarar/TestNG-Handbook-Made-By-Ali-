package tests.day19_smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class HotelAddUserTest {
    @Test
    public void addUser() {
        HotelPage hotelPage = new HotelPage();
       // Select bdSelect=new Select(hotelPage.birthDate);
        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        hotelPage.logOn.click();
        hotelPage.userName.sendKeys(ConfigReader.getProperty("hotelUser"));
        hotelPage.password.sendKeys(ConfigReader.getProperty("hotelPass"));
        hotelPage.lastlogin.click();
        hotelPage.addUser.click();
        //hotelPage.userEnter.sendKeys(ConfigReader.getProperty("hotelUsr"));
        actions.click(hotelPage.userEnter).sendKeys(ConfigReader.getProperty("hotelUsr"))

                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hotelPsr"))
        .sendKeys(Keys.TAB)
        .sendKeys(ConfigReader.getProperty("hotelEmail"))
        .sendKeys(Keys.TAB)
        .sendKeys(ConfigReader.getProperty("hotelFullName"))
        .sendKeys(Keys.TAB)
        .sendKeys(ConfigReader.getProperty("hotelPhone"))
        .sendKeys(Keys.TAB)
        .sendKeys(ConfigReader.getProperty("hotelSocial"))
        .sendKeys(Keys.TAB)
        .sendKeys(ConfigReader.getProperty("hotelDriving"))
        .sendKeys(Keys.TAB).perform();
        Select select=new Select(hotelPage.country);
        select.selectByVisibleText(ConfigReader.getProperty("hotelCountry"));
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hotelAdress"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hotelBD"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hotelSector"))
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("hotelRole"))
                .sendKeys(Keys.TAB).perform();

        Select roleslct= new Select(Driver.getDriver().findElement(By.id("IDRole")));
        roleslct.selectByVisibleText(ConfigReader.getProperty("hotelRole"));
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();



        Driver.closeDriver();
    }
}
