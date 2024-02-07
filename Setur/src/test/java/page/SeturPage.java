package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SeturPage extends ATestPage {

    private WebDriver driver;

    public SeturPage(WebDriver driver) {
        super(driver);
    }


    //Kullanılan Web Elementlerin tanımı ve yolu
    @FindBy(xpath = "//*[@id='responsive-image-1689835577900100']")
    public WebElement wheelCampain;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/a")
    public WebElement backHomePage;

    @FindBy(id = "CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")
    public WebElement cookies;


    @FindBy(className = "sc-5391ca11-0")
    public WebElement divContainer;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div[2]/div[2]/input")
    public WebElement cityName;

    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[1]/div/div[2]/div/div/ul/div[1]/div/div/span/strong")
    public WebElement cityButton;


    @FindBy(xpath = "//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div/div/div/div[2]/div[2]")
    public WebElement dateButton;

    @FindBy(xpath =" //*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/button[2]")
    public WebElement dateForwardButton;

    @FindBy(xpath ="//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/table/tbody/tr[1]/td[1]/span")
    public WebElement startDateButton;

    @FindBy(xpath ="//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[3]/div/table/tbody/tr[1]/td[7]/span")
    public WebElement endDateButton;


    @FindBy(xpath ="//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[2]/div[3]/div/div/div[1]")
    public WebElement personButton;

    @FindBy(css  ="button[data-testid='increment-button']")
    public WebElement incrementButton;


    @FindBy(css  ="span[data-testid='count-label']")
    public WebElement personNumberArea;

    @FindBy(xpath  ="//*[@id=\"__next\"]/div[3]/div[3]/div[1]/div[2]/div/div/div/div[3]/button")
    public WebElement searchButton;

    @FindBy(xpath  ="//*[@id=\"__next\"]/div[3]/div[3]/div/div[1]/div[1]/div[2]/div/div[1]")
    public WebElement otherElementsButton;

    @FindBy(css ="div[data-testid='checkbox']")
    public List<WebElement> checkboxes ;

    @FindBy(xpath  ="//*[@id=\"__next\"]/div[3]/div[3]/div/div[1]/div[2]/div[7]/div[1]/span[2]")
    public WebElement hotelNumber;











}