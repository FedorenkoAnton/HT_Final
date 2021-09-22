package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='field-keywords']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='hm-icon-label']")
    private WebElement catalogSlideMenu;

    @FindBy(xpath = "//a[@data-menu-id='5']")
    private WebElement electronicsSubMenu;

    @FindBy(xpath = "//a[text()='Camera & Photo']")
    private WebElement cameraPhotoSubmenu;

    @FindBy(xpath = "//span[@class='a-declarative nav-progressive-attribute']")
    private WebElement deliverToMenu;

    @FindBy(xpath = "//span[@class='nav-line-2 nav-progressive-content']")
    private WebElement deliveryToCountry;

    @FindBy(xpath = "//span[text()='Hello, Sign in']")
    private WebElement signInDropdown;

    @FindBy(xpath = "//span[text()='Hello, Anton']")
    private WebElement welcomeMessage;

    public void inputQueryToSearchField(String text) {
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void isSearchFieldDisplayed() {
        searchField.isDisplayed();
    }

    public void isCatalogVisible() {
        catalogSlideMenu.isDisplayed();
    }

    public void clickCatalogSlideMenu() {
        catalogSlideMenu.click();
    }

    public void clickElectronicsSubMenu() {
        electronicsSubMenu.click();
    }

    public void clickCameraPhotoSubmenu() {
        cameraPhotoSubmenu.click();
    }

    public void isDeliveryToVisible() {
        deliverToMenu.isDisplayed();
    }

    public void clickDeliveryTo() {
        deliverToMenu.click();
    }

    public String getDeliveryToCountryName() {
        return deliveryToCountry.getText().trim();
    }

    public WebElement getCountryDeliveryTo() {
        return deliveryToCountry;
    }

    public void clickOnSignInMenu() {
        signInDropdown.click();
    }

    public String getWelcomeMessageText() {
        return welcomeMessage.getText();
    }

    public WebElement getSignInDropdown() {
        return signInDropdown;
    }
}
