package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeCountryPopUp extends BasePage{

    public ChangeCountryPopUp(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='Uzbekistan']")
    private WebElement optionUzbekistan;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    private WebElement countryDropdown;

    @FindBy(xpath = "//button[@class='a-button-text']")
    private WebElement doneButton;

    public void clickOptionUzbekistan() {
        optionUzbekistan.click();
    }

    public void clickOnCountryDropdown() {
        countryDropdown.click();
    }

    public void clickOnDoneButton() {
        doneButton.click();
    }

    public WebElement getCountryDropdown() {
        return countryDropdown;
    }

    public WebElement getOptionUzbekistan() {
        return optionUzbekistan;
    }

    public WebElement getDoneButton() {
        return doneButton;
    }
}
