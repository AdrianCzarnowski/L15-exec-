package pages.base;


import configuration.helpers.listener.WebListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Random;


public class BasePage {
    protected static Random random = new Random();
    private static Logger log = LoggerFactory.getLogger("BasePage.class");
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("waitTime"))));
        actions = new Actions(driver);
        js = ((JavascriptExecutor) driver);
        PageFactory.initElements(driver, this);
    }


    public void highLightenerMethod(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: lightgreen; border: 5px solid red;')", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highLightenerMethod(element);
        element.click();
    }


    public void hover(WebElement element) {
        EventFiringMouse eventFiringMouse = new EventFiringMouse(driver, (WebDriverEventListener) new WebListener());
        Locatable object = (Locatable) element;
        Coordinates coordinates = object.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
    }
    public void switchToIframe(WebElement element){
        highLightenerMethod(element);
        driver.switchTo().frame(element);
    }
}
