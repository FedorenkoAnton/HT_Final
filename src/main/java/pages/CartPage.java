package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    private List<WebElement> productsInCart;

    @FindBy(xpath = "//span[@class='a-button a-button-dropdown quantity']")
    private WebElement quantityDropDown;

    @FindBy(xpath = "//a[text()='3']")
    private WebElement numberOfChosenProduct;

    @FindBy(xpath = "//span[contains(@class,'a-size-medium a-color-base sc-price sc-white-space-nowrap ')]")
    private WebElement priceOfProduct;

    @FindBy(xpath = "//span[@class='a-dropdown-prompt']")
    private WebElement actualAmount;

    @FindBy(xpath = "//input[@data-action='delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[@class='nav-cart-count nav-progressive-attribute nav-progressive-content nav-cart-0']")
    private WebElement amountGoodsInCartDisplayedAtTopRight;

    @FindBy(xpath = "//div[@data-name='Active Cart']")
    private WebElement activeItemsInCart;

    @FindBy(xpath = "//h2[@class='a-carousel-heading']")
    private WebElement alsoBuyItemsCarousel;

    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    private WebElement proceedToCheckOutButton;

    public String getAimedProductInCart() {
        return productsInCart.get(0).getText();
    }

    public void clickQuantityDropDown() {
        quantityDropDown.click();
    }

    public void clickNumberOfChosenProduct() {
        numberOfChosenProduct.click();
    }

    public WebElement getQuantityDropDown() {
        return quantityDropDown;
    }

    public double getActualTotalPrice() {
        double actualProductPrice = Double
                .parseDouble(priceOfProduct.getText()
                        .replaceAll("[^0-9|.]", ""));

        double actualAmountOfProduct = Integer.parseInt(actualAmount.getText().replaceAll("[^0-9]", ""));

        return actualProductPrice * actualAmountOfProduct;
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public int getAmountGoodsInCartDisplayedAtTopRight() {
        return Integer.parseInt(amountGoodsInCartDisplayedAtTopRight.getText());
    }

    public void isActiveItemInCartVisible() {
        activeItemsInCart.isDisplayed();
    }

    public String getTextAlsoBuyItemsCarousel() {
        return alsoBuyItemsCarousel.getText().trim();
    }

    public void clickProceedToCheckOutButton() {
        proceedToCheckOutButton.click();
    }
}
