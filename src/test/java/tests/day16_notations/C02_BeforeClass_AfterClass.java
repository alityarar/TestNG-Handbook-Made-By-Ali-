package tests.day16_notations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_BeforeClass_AfterClass extends TestBase {



    /*
    TestNG bize daha fazla before v e after nasotyanlari sunar
    diger before/after notasyonlari tanimlayacagimiz grup,test veya
    suit'den once ve sonra calisirlar
    ileride xml dosyalari ile birlikte gorecegiz

     */

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("Before Class Method");
    }

    @AfterClass
    public void afterClassMethod() {
        System.out.println("After Class Method");
    }


    @Test (groups = "grup1")
    public void test01() {

        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());


    }

    @Test
    public void test02() {
        driver.get("https://www.facebook.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void test03() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }



}
