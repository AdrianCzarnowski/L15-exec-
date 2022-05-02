import org.junit.jupiter.api.Test;

public class ImagesTest extends TestBase {

    @Test
    public void imageTest() {
        homePage
                .goToWomanSection()
                .goToBlousesSection();
        blousesPage
                .navigateToPicture()
                .clickQuickView();
        quickViewPage
                .displayedBigImage_isTheSame_asSmallImage();

    }
}
