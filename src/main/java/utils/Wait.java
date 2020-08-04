package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@UtilityClass
public class Wait {
    private final WebDriver driver = DriverFactory.getDriver();
    private final int SHORT_WAIT = 5;

    public void waitUntilElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, SHORT_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, SHORT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
