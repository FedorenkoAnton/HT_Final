package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    PreCartPage preCartPage;
    CartPage cartPage;
    PageFactoryManager pageFactoryManager;
    CartPopUp cartPopUp;
    ChangeCountryPopUp changeCountryPopUp;
    SignInPage signInPage;
    ShippingAndPayment shippingAndPayment;
    SelectPaymentMethod selectPaymentMethod;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} of the site")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks visibility of search field")
    public void userChecksVisibilityOfSearchField() {
        homePage.isSearchFieldDisplayed();
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String query) {
        homePage.inputQueryToSearchField(query);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User clicks on first product on the search page")
    public void userClicksOnFirstProductOnTheSearchPage() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.waitPageToComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickResultIphoneSearch();
    }

    @And("User clicks on add to cart button")
    public void userClicksOnAddToCartButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitPageToComplete(DEFAULT_TIMEOUT);
        productPage.clickAddToCartButton();
    }

    @And("User clicks on cart button")
    public void userClicksOnCartButton() {
        preCartPage = pageFactoryManager.getPreCartPage();
        preCartPage.clickCartIconAtTopRight();
    }

    @Then("User checks that the Cart has aimed product {string}")
    public void userChecksThatTheCartHasAimedProductProduct(final String searchAim) {
        cartPage = pageFactoryManager.getCartPage();
        assertEquals(searchAim, cartPage.getAimedProductInCart());
    }

    @And("User clicks up to")
    public void userClicksUpTo$() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.clickUpTo100$();
        searchResultsPage.waitPageToComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that list of products contains smartphones under {int}")
    public void userChecksThatListOfProductsContainsSmartphonesUnderPrice(final int price) {
        searchResultsPage.getSmartphoneUpTo100$Results()
                .forEach(p -> assertTrue(p < price));
    }

    @And("User checks visibility of All menu")
    public void userChecksVisibilityOfCatalog() {
        homePage.isCatalogVisible();
    }

    @And("User clicks on All menu")
    public void userClicksOnAllMenu() {
        homePage.clickCatalogSlideMenu();
    }

    @And("User clicks on Electronics")
    public void userClicksOnElectronics() {
        homePage.clickElectronicsSubMenu();
    }

    @And("User clicks on Cameras&Photo")
    public void userClicksOnCamerasPhoto() {
        homePage.clickCameraPhotoSubmenu();
    }

    @And("User clicks on Digital Cameras")
    public void userClcksOnDigitalCameras() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.waitPageToComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickDigitalCameraFilter();
    }

    @And("User clicks on Blackmagic  Design Pocket Cinema")
    public void userClicksOnBlackmagicDesignPocketCinema() {
        searchResultsPage.waitPageToComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickCameraBlackmagic();
    }

    @And("User clicks on Add to Cart")
    public void userClicksOnAddToCart() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToCartButton();
        cartPopUp = pageFactoryManager.getCartPopUp();
        cartPopUp.waitForVisibilityOfElement(DEFAULT_TIMEOUT, cartPopUp.getCloseWindow());
        if (cartPopUp.getCloseWindow() != null) { // cart popUp appears not everytime
            cartPopUp.clickCloseWindow();
        }
    }

    @And("User clicks Cart button")
    public void userClicksCartButton() {
        preCartPage = pageFactoryManager.getPreCartPage();
        preCartPage.waitForVisibilityOfElement(DEFAULT_TIMEOUT, preCartPage.getCartIconAtTopRight());
        preCartPage.clickCartIconAtTopRight();
    }

    @When("User increase amount of products in cart")
    public void userIncreaseAmountOfProductsInCart() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getQuantityDropDown());
        cartPage.clickQuantityDropDown();
        cartPage.clickNumberOfChosenProduct();
    }

    @Then("User check that total price is {double}")
    public void userCheckThatTotalPriceIs(final double totalPrice) {
        assertEquals(cartPage.getActualTotalPrice(), totalPrice, 0.0);
    }

    @When("User clicks on delete")
    public void userClicksOnDelete() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitForVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getDeleteButton());
        cartPage.clickDeleteButton();
        cartPage.waitPageToComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that cart has {int} of goods")
    public void userChecksThatCartHasAmountOfGoods(final int amountInCart) {
        assertEquals(cartPage.getAmountGoodsInCartDisplayedAtTopRight(), amountInCart);
    }

    @And("User checks visibility of Delivery to")
    public void userChecksVisibilityOfChangeDeliveryCountryDropdown() {
        homePage.isDeliveryToVisible();
    }

    @And("User clicks on Delivery to")
    public void userClicksOnChangeDeliveryCountryDropdown() {
        homePage.clickDeliveryTo();
    }

    @And("User clicks on chose country dropdown")
    public void userClicksOnChoseCountryDropdown() {
        changeCountryPopUp = pageFactoryManager.getChangeCountryPopUp();
        changeCountryPopUp.waitForVisibilityOfElement(DEFAULT_TIMEOUT, changeCountryPopUp.getCountryDropdown());
        changeCountryPopUp.clickOnCountryDropdown();
    }

    @When("User clicks on Delivery Country Uzbekistan")
    public void userClicksOnDeliveryCountryUzbekistan() {
        changeCountryPopUp.waitForVisibilityOfElement(DEFAULT_TIMEOUT, changeCountryPopUp.getOptionUzbekistan());
        changeCountryPopUp.clickOptionUzbekistan();
    }

    @And("clicks on Done button")
    public void clicksOnDoneButton() {
        changeCountryPopUp.waitForVisibilityOfElement(DEFAULT_TIMEOUT, changeCountryPopUp.getDoneButton());
        changeCountryPopUp.clickOnDoneButton();
    }

    @Then("Delivery Country changed to {string}")
    public void deliveryCountryChangedToUzbekistan(final String countryName) {
        driver.navigate().refresh(); //the only way to get country name stably after changing
        assertEquals(countryName, homePage.getDeliveryToCountryName());
    }

    @And("User clicks on sign in")
    public void userClicksOnSignIn() {
        homePage.waitForVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInDropdown());
        homePage.clickOnSignInMenu();
    }

    @And("User input valid {string}")
    public void userInputValidEmail(final String email) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.inputEmail(email);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //to avoid captcha while signing in
    }

    @And("clicks Continue button")
    public void clicksContinueButton() {
        signInPage.clickContinueButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //to avoid captcha while signing in
    }

    @When("User clicks on Sign-in button")
    public void userClicksOnSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("User signed-in on the site and get {string}")
    public void userSignedInOnTheSiteAndGetMessage(final String expectedMessage) {
        homePage.waitPageToComplete(DEFAULT_TIMEOUT);
        assertEquals(expectedMessage, homePage.getWelcomeMessageText());
    }

    @And("User input invalid  email {string}")
    public void userInputInvalidEmail(final String invalidEmail) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.inputEmail(invalidEmail);
    }

    @When("User clicks on Continue button")
    public void userClicksOnContinueButton() {
        signInPage.clickSignInButton();
    }

    @Then("User get validation message {string}")
    public void userGetValidationMessageThereWasAProblem(final String message) {
        assertEquals(message, signInPage.getValidationMessageHeaderText());
    }


    @And("User clicks on Buy Now button")
    public void userClicksOnBuyNowButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickOnBuyNowButton();
    }

    @And("User clicks on Proceed to checkout button")
    public void userClicksOnProceedToCheckoutButton() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.clickProceedToCheckOutButton();
    }

    @When("User clicks Use this address")
    public void userClicksUseThisAddress() {
        shippingAndPayment = pageFactoryManager.getShippingAndPayment();
        shippingAndPayment.clickContinueWithThisAddressButton();
    }

    @Then("User checks that he on the page {string}")
    public void userChecksThatHeOnThePageSelectPaymentMethod(final String pageHeader) {
        selectPaymentMethod = pageFactoryManager.getSelectPaymentMethod();
        assertEquals(pageHeader, selectPaymentMethod.getTextSelectPaymentMethodHeader());
    }

    @And("User checks visibility of product in cart")
    public void userChecksVisibilityOfProductInCart() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitPageToComplete(DEFAULT_TIMEOUT);
        cartPage.isActiveItemInCartVisible();
    }


    @Then("User checks that {string} is visible")
    public void userChecksThatCustomersWhoBoughtItemsInYourCartAlsoBoughtIsVisible(final String text) {
        assertEquals(text, cartPage.getTextAlsoBuyItemsCarousel());
    }


}
