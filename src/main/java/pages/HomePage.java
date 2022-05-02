package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

public class HomePage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("BasePage.class");
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womanBtn;
    @FindBy(xpath = "//a[@title='Blouses']")
    private WebElement blousesBtn;



    public HomePage goToWomanSection() {
        hover(womanBtn);
        log.info(womanBtn.getText() + " section founded");
        return this;
    }

    public HomePage goToBlousesSection() {
        clickOnElement(blousesBtn);
        return this;
    }

}




