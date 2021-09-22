package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectPaymentMethod extends BasePage{

    public SelectPaymentMethod(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[@class='a-spacing-base']")
    private WebElement selectPaymentMethodHeader;

    public String getTextSelectPaymentMethodHeader() {
        return selectPaymentMethodHeader.getText().trim();
    }
}
