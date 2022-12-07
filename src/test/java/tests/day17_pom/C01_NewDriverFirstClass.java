package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_NewDriverFirstClass {
    @Test (groups = "grup1")
    public void test1() {
        Driver.getDriver().get("https://www.amazon.com");

        /*
        Onceden kucuk harflerle driver yazdigimiz her yere artik
        buyuk olarak Driver.getDriver() kullanarak baslayacagiz
         */

        Driver.getDriver().get("https://www.facebook.com");

        //Driver.closeDriver();
    }
}
