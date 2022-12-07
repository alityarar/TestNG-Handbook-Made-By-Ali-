package tests.day21_reusableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReUsableMethods;

import java.util.Set;

public class C01_WindowHandleReusableMethods {
    @Test
    public void test01() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWH=Driver.getDriver().getWindowHandle();
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String>windowHandleSeti=Driver.getDriver().getWindowHandles();

        String ikinciSayfaWH="";
        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWH)){
                ikinciSayfaWH=each;
            }

        }
        Driver.getDriver().switchTo().window(ikinciSayfaWH);
        System.out.println(Driver.getDriver().getTitle());

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        ReUsableMethods.switchToWindow("New Window");

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
}
