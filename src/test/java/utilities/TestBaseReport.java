package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestBaseReport {
    protected static ExtentReports extentReports; //extent report a ilk atamayi yapar
    protected static ExtentTest extentTest;//test pass veya failed gibi bilgileri kaydeder
    protected static ExtentHtmlReporter extentHtmlReporter;//Html raportu duzenler

    //test islemine balsamadan hemen once (test methodundan once degil
    //tum islemden once)
    @BeforeTest(alwaysRun = true) //alwaysRun:her zaman calistir
    public void setUpTest(){
        extentReports=new ExtentReports();//raporlamayi baslatir
        //rapor olustuktan sonra raporunuz nereye eklensin istiyorsaniz
        //buraya yaziyorsunuz
        String date= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath=System.getProperty("user.dir")+"/target/Report/report"+date+".html";
        //olusturmak istedigimiz raporu (html formatinda) baslatiyoruz
        //filePath ile dosya yolunu ayarliyoruz
        extentHtmlReporter=new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        //istediginiz bilgileri buraya ekleyebiliyorsunuz

        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser",ConfigReader.getProperty("browser"));
        extentReports.setSystemInfo("Automation Engineer","Ali");
        extentHtmlReporter.config().setDocumentTitle("TestReport");
        extentHtmlReporter.config().setReportName("TestNG Reports");
    }

    //Her test methodundan sonra eger test varsa, ekran goruntusu
    //alip rapora ekliyor

    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {
    if (result.getStatus()==ITestResult.FAILURE){//eger test fail olursa
        String screenShotLocation=ReUsableMethods.getScreenShot(result.getName());
        extentTest.fail(result.getName());
        extentTest.addScreenCaptureFromPath(screenShotLocation);
        extentTest.fail(result.getThrowable());
    }else if (result.getStatus()==ITestResult.SKIP){//eger test calistirilmadan gecilme
        extentTest.skip("Test Case is Skipped: "+result.getName());//ignore olanlar
    }
    Driver.closeDriver();
    }

    //Raporlandirmayi sonlandirmak icin
    @AfterTest(alwaysRun = true)
    public void tearDownTest(){extentReports.flush();}

}
