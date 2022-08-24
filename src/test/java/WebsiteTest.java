import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTest extends TestBase {

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