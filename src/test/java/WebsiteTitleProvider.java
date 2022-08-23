public enum WebsiteTitleProvider {
    SII("Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska"),
    ONET("Onet – Jesteś na bieżąco"),
    KOTUSZKOWO("Kotuszkowo- blog o kotach"),
    FILMWEB("Filmweb - filmy takie jak Ty!"),
    SELENIUM("WebDriver | Selenium");
    private final String websiteTitle;

    WebsiteTitleProvider(String websiteTitle) {
        this.websiteTitle = websiteTitle;
    }

    public String getWebsiteTitle() {
        return websiteTitle;
    }

    @Override
    public String toString() {
        return this.getWebsiteTitle();
    }
}