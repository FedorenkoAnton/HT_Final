package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PreCartPage extends BasePage {

    public PreCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='nav-a nav-a-2 nav-progressive-attribute']")
    private WebElement cartIconAtTopRight;

    public void clickCartIconAtTopRight() {
       cartIconAtTopRight.click();
    }

    public WebElement getCartIconAtTopRight() {
        return cartIconAtTopRight;
    }
}
