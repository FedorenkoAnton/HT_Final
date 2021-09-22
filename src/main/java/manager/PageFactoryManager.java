package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public PreCartPage getPreCartPage() {
        return new PreCartPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchResultsPage getSearchResultPage() {
        return new SearchResultsPage(driver);
    }

    public CartPopUp getCartPopUp() {
        return new CartPopUp(driver);
    }

    public ChangeCountryPopUp getChangeCountryPopUp() {
        return new ChangeCountryPopUp(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public ShippingAndPayment getShippingAndPayment() {
        return new ShippingAndPayment(driver);
    }

    public SelectPaymentMethod getSelectPaymentMethod() {
        return new SelectPaymentMethod(driver);
    }
}
