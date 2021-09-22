package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShippingAndPayment extends BasePage {

    public ShippingAndPayment(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href, '/gp/buy/addressselect/handlers/continue.html/ref=ox_shipaddress_s')]")
    private WebElement continueWithThisAddressButton;

    public void clickContinueWithThisAddressButton() {
        continueWithThisAddressButton.click();
    }

}
