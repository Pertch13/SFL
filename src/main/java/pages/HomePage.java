package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Action;
import utils.Wait;

public class HomePage extends BasePage {
    @FindBy(xpath = "//header[@id='top']//span[@class='job-count']")
    private WebElement jobCount;

    @Override
    String currentPagePath() {
        return "";
    }

    public void clickOnCareers() {
        Wait.waitUntilElementToBeClickable(jobCount);
        Action.clickOn(jobCount);
    }

    public int getJobsCount() {
        String count = jobCount.getText();
        return Integer.parseInt(count);
    }
}
