package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;
import utils.DriverFactory;

public abstract class BasePage extends LoadableComponent<BasePage> {


    static final String BASE_URL = "https://sflpro.com/";
    protected final WebDriver driver = DriverFactory.getDriver();

    BasePage() {
        PageFactory.initElements(driver, this);
    }

    @Override
    protected final void isLoaded() throws Error {
        Assert.assertTrue(driver.getCurrentUrl().contains(BASE_URL), "Failed to load Base Page URL");
    }

    @Override
    protected void load() {
        getURL();
    }

    public void getURL() {
        driver.get(BASE_URL + currentPagePath());
    }

    abstract String currentPagePath();
}
