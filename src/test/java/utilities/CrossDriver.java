package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver(){ //Priv Constructor obje olusumunu engeller

    }
    static WebDriver driver;

    public static WebDriver getDriver(String browser){

        browser = (browser== null) ? ConfigReader.getProperty("browser"):browser;


        if (driver==null){

            switch (browser){
                case"chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                default:WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
            }



        }


        return driver;
    }

    public static void closeDriver(){

        if (driver!=null){
            driver.close();
            driver=null;
        }



    }
}
