package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")
    private WebElement emailInputField;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement signInButton;

    @FindBy(xpath = "//h4[@class='a-alert-heading']")
    private WebElement validationMessageHeader;

    public void inputEmail(String text) {
        emailInputField.sendKeys(text);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void inputPassword(String text) {
        passwordInputField.sendKeys(text);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getValidationMessageHeaderText() {
        return validationMessageHeader.getText().trim();
    }
}
