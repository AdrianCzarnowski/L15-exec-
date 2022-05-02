package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.base.BasePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class QuickViewPage extends BasePage {

    private static Logger log = LoggerFactory.getLogger("QuickViewPage.class");
    public QuickViewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#bigpic")
    private WebElement bigImg;
    @FindBy(xpath = "//ul[@id='thumbs_list_frame']//img[@alt='Blouse']")
    private List<WebElement> smallImgList;
    @FindBy(css = "iframe")
    private WebElement iframe;


    public QuickViewPage displayedBigImage_isTheSame_asSmallImage() {
       switchToIframe(iframe);
        for (int i = 0; i < smallImgList.size(); i++) {
            hover(smallImgList.get(i));
            String smallImgSrc = smallImgList.get(i).getAttribute("src").replace("cart", "large");
            String bigImgSrc = bigImg.getAttribute("src");
            log.info(smallImgSrc);
            log.info(bigImgSrc);
            assertThat(smallImgSrc).isEqualTo(bigImgSrc);
            log.info("Picture is displayed well");
        }
        return this;
    }
}



