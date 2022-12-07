package tests.day19_smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

public class Deneme {
    @Test
    public void testName() {
        Driver.getDriver().get("https://www.facebook.com/");
        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().findElement(By.name("email")).sendKeys("dsfsd");
        actions.sendKeys(Keys.TAB);

    }
}
