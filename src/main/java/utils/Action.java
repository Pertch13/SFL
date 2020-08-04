package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

@UtilityClass
public class Action {

    public void clickOn(WebElement element) {
        Wait.waitUntilElementToBeClickable(element);
        Assert.assertTrue(element.isDisplayed(), "Unable to locate element");
        element.click();
    }

    public void mouseMoveAndClick(WebElement element){
        Wait.waitUntilElementToBeClickable(element);
        Assert.assertTrue(element.isDisplayed(), "Unable to locate element");
        WebDriver driver = DriverFactory.getDriver();
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public void typeOnElement(WebElement element, String text){
        Wait.waitForElementVisibility(element);
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }
}
