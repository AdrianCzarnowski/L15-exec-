package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class BlousesPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("BlousesPage.class");
    public BlousesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = " div > a.product_img_link")
    private WebElement picture;
    @FindBy(css = " div > a.quick-view")
    private WebElement quickViewBtn;


    public BlousesPage navigateToPicture() {
        hover(picture);
        return this;
    }

    public BlousesPage clickQuickView() {
        log.info(driver.getTitle() + " section selected");
        clickOnElement(quickViewBtn);
        return this;
    }
}
