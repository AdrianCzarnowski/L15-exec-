import configuration.config.App;
import configuration.factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.BlousesPage;
import pages.HomePage;
import pages.QuickViewPage;


public class TestBase {
    public static HomePage homePage;
    public static BlousesPage blousesPage;
    public static QuickViewPage quickViewPage;
    private static App app;
    private static DriverFactory driverFactory = new DriverFactory();
    protected WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        app = new App();
    }

    @BeforeEach
    void beforeEach() {
        driver = driverFactory.getDriver(app.setBrowserFromYaml());
        homePage = new HomePage(driver);
        blousesPage = new BlousesPage(driver);
        quickViewPage = new QuickViewPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}


