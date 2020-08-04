package pages;

import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Action;
import utils.Robot;
import utils.Wait;

public class FormPage extends BasePage {
    @FindBy(xpath = "//div[@id='6174']//input[@name='Firstname']")
    private WebElement firstNameField;
    @FindBy(xpath = "//div[@id='6174']//input[@name='Lastname']")
    private WebElement lastNameField;
    @FindBy(xpath = "//div[@id='6174']//input[@name='E-mailaddress']")
    private WebElement emailAddressField;
    @FindBy(xpath = "//div[@id='6174']//input[@type='file']")
    private WebElement chooseFileBtn;
    @FindBy(xpath = "//div[@id='6174']//input[@value='Submit']")
    private WebElement submitBtn;
    @FindBy(xpath = "//span[@class='ajax-loader is-active']")
    private WebElement loader;

    @Override
    String currentPagePath() {
        return "";
    }


    public void typeFirstName(String firstName) {
        Action.scrollToElement(firstNameField);
        Action.typeOnElement(firstNameField, firstName);
    }

    public void typeLastNAme(String lastName) {
        Action.scrollToElement(lastNameField);
        Action.typeOnElement(lastNameField, lastName);
    }

    public void typeEmail(String email) {
        Action.scrollToElement(emailAddressField);
        Action.typeOnElement(emailAddressField, email);
    }

    public void clickSubmitBtn() {
        Action.scrollToElement(submitBtn);
        Action.clickOn(submitBtn);
    }

    @SneakyThrows
    public void uploadCV(String cv) {
        Action.mouseMoveAndClick(chooseFileBtn);
        Robot.typeText(cv);
        Robot.pressEnter();
    }

    public boolean isLoaderAppearsAfterSubmission(){
        Wait.waitForElementVisibility(loader);
        return loader.isDisplayed();
    }
}
