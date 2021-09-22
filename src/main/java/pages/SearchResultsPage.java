package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Apple iPhone 11 Pro Max, 512GB, Midnight Green - Unlocked (Renewed Premium)']")
    private WebElement iPhoneSearchResult;

    @FindBy(xpath = "//span[text()='$50 to $100']")
    private WebElement upTo100$;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List <WebElement> smartphoneUpTo100$Results;

    @FindBy(xpath = "//span[text()='Digital Cameras']")
    private WebElement digitalCameraFilter;

    @FindBy(xpath = "//a[contains(@href, '/Blackmagic-Design-Pocket-Cinema')]//div[contains(@class,'a-section')]")
    private WebElement cameraBlackmagic;

    public void clickResultIphoneSearch() {
        iPhoneSearchResult.click();
    }

    public void clickUpTo100$() {
        upTo100$.click();
    }

    public List<Integer> getSmartphoneUpTo100$Results() {
        return smartphoneUpTo100$Results.stream()
                .map(p -> p.getText().replaceAll("[^0-9]", "").trim())
                .filter(p -> !p.equals(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void clickDigitalCameraFilter() {
        digitalCameraFilter.click();
    }

    public void clickCameraBlackmagic() {
        cameraBlackmagic.click();
    }
}
