package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalCars {
    public BlueRentalCars(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[@href='/login']" )
    public WebElement loginButton;

    @FindBy (xpath = "//input[@name='email']" )
    public WebElement userEnter;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passEnter;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement lastLogin;

    @FindBy (xpath = "//button[@id='dropdown-basic-button']")
    public WebElement dropDown;

    @FindBy(xpath = "(//a[@href='/'])[3]")
    public WebElement homeButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div[2]/div/div/div/div/nav/ol/li[1]/a")
    public WebElement homehome;

}
