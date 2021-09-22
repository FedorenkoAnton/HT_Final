package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='submit.add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//input[@id='buy-now-button']")
    private WebElement buyNowButton;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnBuyNowButton() {
        buyNowButton.click();
    }
}
