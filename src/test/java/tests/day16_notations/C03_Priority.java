package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class C03_Priority extends TestBase {

    /*
    TestNG methodlari isim sirasina gore calisir
    eger isim siralamasi disinda bir siralama ile calismasini
    isterseniz o zaman test methodlarina oncelik taniyabiliriz

    priority kucukten buyuge dogru calisir
    eger bir test methoduna priority degeri atanmissa
    default olarak priority=0 kabul edilir

     */

    @Test (priority = 3)
    public void test01() {

        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());


    }

    @Test
    public void test02() {
        driver.get("https://www.facebook.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test (groups = "grup1")
    public void test03() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }

}
