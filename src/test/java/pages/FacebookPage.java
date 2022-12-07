package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//input[@data-testid='royal_email']")
    public WebElement kullaniciGirisYeri;

    @FindBy (xpath = "//input[@type='password']")
    public WebElement sifreGirisi;

    @FindBy(xpath = "//button[@data-testid='royal_login_button']")
    public WebElement girisYapTusu;

    @FindBy(className = "_9ay7")
    public WebElement girilemediYaziElementi;

}
