package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CareersPage;
import pages.FormPage;
import pages.HomePage;

@Listeners(utils.Listeners.class)
public class CareersTest extends BaseTest {
    final String FIRST_NAME = "First Name";
    final String LAST_NAME = "Last Name";
    final String EMAIL = "random@mail.ru";
    final String CV = System.getProperty("user.dir") + "\\src\\main\\resources\\cv.txt";
    HomePage homePage;

    @BeforeMethod
    public void setDriver() {
        homePage = new HomePage();
    }

    @Test
    public void submitApplicationTest() {
        CareersPage careersPage = new CareersPage();

        homePage.getURL();
        int careersIndicator = homePage.getJobsCount();

        homePage.clickOnCareers();
        int careersCountFromPage = careersPage.getJobsCount();

        Assert.assertFalse(careersPage.isManualQAEngineerPositionExists(), "Manual QA Engineer Position Exists");
        Assert.assertEquals(careersIndicator, careersCountFromPage, "Careers count indicator is showing wrong number");
        Assert.assertTrue(careersPage.isQAAutomationEngineerPositionExists(), "There is no vacancy for Automation QA Engineer!");

        homePage.clickOnCareers();
        careersPage.clickOnQaAutomationPosition();

        FormPage formPage = new FormPage();
        formPage.typeFirstName(FIRST_NAME);
        formPage.typeLastNAme(LAST_NAME);
        formPage.typeEmail(EMAIL);
        formPage.uploadCV(CV);
        formPage.clickSubmitBtn();

        Assert.assertTrue(formPage.isLoaderAppearsAfterSubmission(), "Loader is not displayed");
    }
}
