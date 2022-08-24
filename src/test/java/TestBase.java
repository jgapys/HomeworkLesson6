import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.logging.Level;

import static org.assertj.core.api.Assertions.assertThat;

public class TestBase {
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
}