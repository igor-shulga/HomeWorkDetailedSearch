package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PersonalCoachPage {
    private WebDriver driver;
    private By personalPageHeader = By.className("greenHeader");
    private By personalPageDescription = By.className("text");

    public PersonalCoachPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public boolean showsName(String coachName) {
        return driver.findElement(personalPageHeader).getText().contains(coachName);
    }


    public boolean showsSpecialisation(String coachName) {
        return driver.findElement(personalPageDescription).getText().contains(coachName);
    }


}