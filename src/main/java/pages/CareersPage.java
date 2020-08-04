package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class CareersPage extends BasePage {

    @FindBy(css = ".s-careers-title")
    private List<WebElement> jobsList;

    @Override
    String currentPagePath() {
        return "/job";
    }

    public int getJobsCount() {
        return jobsList.size();
    }

    public boolean isManualQAEngineerPositionExists() {
        return jobsList
                .stream()
                .anyMatch(job -> job.getText().contains("Manual QA Engineer"));
    }

    public boolean isQAAutomationEngineerPositionExists() {
        return jobsList
                .stream()
                .anyMatch(job -> job.getText().contains("QA Automation Engineer"));
    }

    public void clickOnQaAutomationPosition() {
        jobsList
                .stream()
                .filter(job -> job.getText().contains("QA Automation Engineer"))
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .click();
    }
}
