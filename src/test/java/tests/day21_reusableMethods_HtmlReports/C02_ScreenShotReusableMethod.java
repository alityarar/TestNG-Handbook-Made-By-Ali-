package tests.day21_reusableMethods_HtmlReports;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReUsableMethods;

import java.io.IOException;

public class C02_ScreenShotReusableMethod {
    @Test
    public void test01() throws IOException {

        //amazon sayfasina gidip foto cekelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReUsableMethods.getScreenShot("amazon");
        Driver.closeDriver();
    }
}
