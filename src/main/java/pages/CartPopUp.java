package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPopUp extends BasePage{
    public CartPopUp(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='a-link-normal close-button']")
    private WebElement closeWindow;

    public void clickCloseWindow() {
        closeWindow.click();
    }

    public WebElement getCloseWindow() {
        return closeWindow;
    }
}
