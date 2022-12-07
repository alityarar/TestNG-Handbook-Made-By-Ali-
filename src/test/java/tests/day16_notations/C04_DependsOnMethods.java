package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C04_DependsOnMethods  {

    /*
    DependsOnMethod da olay kisaca soyledir, bir testi baska bir
    testle baglariz. ilk calisacak olan test basarili olmazsa,
    diger test hic calismaz bile. Buna ignore denir.
     */

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDownn() {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

    }

    @Test (dependsOnMethods = "test02")
    public void test03() {

        System.out.println("bak bu calisti");

    }
}
