import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.logging.Level;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTest {
    WebDriver driver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @ParameterizedTest
    @EnumSource(value = WebsiteTitleProvider.class, names = {"SII"})
    @DisplayName("Checking title for sii.pl")
    @Tag("sii")
    @Tag("regression")
    void checkTitleForSii(WebsiteTitleProvider title) {
        driver.get("https:www.sii.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.toString());
    }

    @ParameterizedTest
    @EnumSource(value = WebsiteTitleProvider.class, names = {"ONET"})
    @DisplayName("Checking title for onet.pl")
    @Tag("onet")
    @Tag("regression")
    void checkTitleForOnet(WebsiteTitleProvider title) {
        driver.get("https:www.onet.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.toString());
    }

    @ParameterizedTest
    @EnumSource(value = WebsiteTitleProvider.class, names = {"KOTUSZKOWO"})
    @DisplayName("Checking title for kotuszkowo.pl")
    @Tag("kotuszkowo")
    @Tag("regression")
    void checkTitleForKotuszkowo(WebsiteTitleProvider title) {
        driver.get("http:www.kotuszkowo.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.toString());
    }

    @ParameterizedTest
    @EnumSource(value = WebsiteTitleProvider.class, names = {"FILMWEB"})
    @DisplayName("Checking title for filmweb.pl")
    @Tag("filmweb")
    @Tag("regression")
    void checkTitleForFilmweb(WebsiteTitleProvider title) {
        driver.get("https:www.filmweb.pl");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.toString());
    }

    @ParameterizedTest
    @EnumSource(value = WebsiteTitleProvider.class, names = {"SELENIUM"})
    @DisplayName("Checking title for selenium.dev")
    @Tag("selenium")
    @Tag("regression")
    void checkTitleForSiiPortal(WebsiteTitleProvider title) {
        driver.get("https:www.selenium.dev/documentation/en/webdriver/");
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(title.toString());
    }
}