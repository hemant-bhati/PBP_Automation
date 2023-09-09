package stepDef.healthStepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDef.TestBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NivaGenericStepdefs extends TestBase {
    Select dropdownAge;
    String parent;
    String premiumofproposalpage;

    @When("^Click on sell now button$")
    public void clickOnSellNowButton() throws InterruptedException {
        Thread.sleep(10000L);
        driver.findElement(By.xpath(prop.getProperty("sellnowbutton"))).click();
    }

    @When("^Click on Health Module$")
    public void clickOnHealthModule() throws InterruptedException {
        Thread.sleep(1500);

        WebElement childElement = driver.findElement(By.xpath("//div[@class='col-lg-2 col-md-4 col-sm-4 item']//p[contains(text(),'Health')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
    }

    @And("^Enter detail on Health page \"([^\"]*)\",\"([^\"]*)\"$")
    public void enterDetailOnHealthPage(String FullName, String MobileNo) throws Throwable {
        parent = driver.getWindowHandle();
        for (String child : driver.getWindowHandles()) {
            if (!parent.contentEquals(child)) {
                driver.switchTo().window(child);
                break;
            }
        }
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Maleimage")))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("CustomerFullName")))).sendKeys(FullName);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("CustomerMobileNumber")))).sendKeys(MobileNo);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("ContinueButton1")))).click();
    }

    @Then("^user should be able to navigate to the member detail$")
    public void userShouldBeAbleToNavigateToTheMemberDetail() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "PolicyBazaar Health Insurance: Get a 5 Lac health plan @Rs. 373/Month";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Actual title is " + actualTitle);
    }

    @And("^user should enter the details on member screen \"([^\"]*)\"$")
    public void userShouldEnterTheDetailsOnMemberScreen(String eldestmemberage) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("2Adult")))).click();
        WebElement age = driver.findElement(By.xpath(prop.getProperty("eldestmemberagexpath")));
        dropdownAge = new Select(age);
        dropdownAge.selectByValue(eldestmemberage);
        driver.findElement(By.xpath(prop.getProperty("ContinueButton2"))).click();
    }

    @And("^User should be able to select the City Name \"([^\"]*)\"$")
    public void userShouldBeAbleToSelectTheCityName(String city) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement selectCity = driver.findElement(By.xpath(prop.getProperty("selectcity")));
        selectCity.sendKeys(city);
        selectCity.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(prop.getProperty("continueofselectcity"))).click();
    }

    @And("^select existing illness and click on the View Plan checkbox$")
    public void selectExistingIllnessAndClickOnTheViewPlanCheckbox() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Noneofthese"))).click();
        Thread.sleep(5000L);
    }

    @And("^Enter  the spouse age through edit member on the quote page$")
    public void enterTheSpouseAgeThroughEditMemberOnTheQuotePage() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Edit Members')]")).click();
        Thread.sleep(5000L);
        Select spouseage = new Select(driver.findElement(By.xpath("(//div[@class='select_members_age']//select)[2]")));
        spouseage.selectByValue("30");
        driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();
        Thread.sleep(5000L);
    }

    @And("^click on the cover ammount dorp down button$")
    public void clickOnTheCoverAmmountDorpDownButton() {
        driver.findElement(By.xpath(prop.getProperty("coverammountbutton"))).click();
    }

    @And("^Select the (\\d+)cr suminsurred$")
    public void selectTheCrSuminsurred(int arg0) {
        driver.findElement(By.xpath(prop.getProperty("1crCoverAmountButton"))).click();
    }

    @And("^Click on the Apply button$")
    public void clickOnTheApplyButton() {
        driver.findElement(By.xpath(prop.getProperty("Applybutton"))).click();
    }

    @And("^click on premium button of niva plan \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void clickOnPremiumButtonOfNivaPlan(String PlanName, String PlanId, String SumInsured) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        //driver.navigate().refresh();
        driver.findElement(By.xpath(prop.getProperty("Nivamoreplan"))).click();
        validatePremiumButtonText(PlanName, PlanId, SumInsured);
        Thread.sleep(3000L);
    }

    public void validatePremiumButtonText(String PlanName, String PlanId, String SumInsured) throws SQLException, InterruptedException {
        Thread.sleep(5000L);
        // driver.navigate().refresh();
        WebElement nivaHealthPlan = null;


        try {
            nivaHealthPlan = driver.findElement(By.xpath(prop.getProperty("Nivabutton" + PlanName)));
            String queryHealthPlus = "use HealthDB Select top 1 Premium  from Hi.Health_Rates nolock where Plan_Id=" + PlanId + "and SumInsured=" + SumInsured + " and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and Term = 1";
            ResultSet res = stmt.executeQuery(queryHealthPlus);
            while (res.next()) {
                System.out.println("premium value from DB " + res.getString(1));
                Thread.sleep(3000L);
                String nivaHealthPlantext;
                nivaHealthPlantext = nivaHealthPlan.getText();
                String nivaHealthPlansymbol1 = nivaHealthPlantext.replaceAll("₹", "");
                String nivaHealthPlansymbol2 = nivaHealthPlansymbol1.replaceAll("/year", "");
                String nivaHealthPlanfinalsymbol = nivaHealthPlansymbol2.replaceAll(",", "");
                System.out.println("premium value from " + PlanName + " UI = " + nivaHealthPlanfinalsymbol);
                String expectedbuttontext = res.getString(1);
                junit.framework.Assert.assertEquals(expectedbuttontext, nivaHealthPlanfinalsymbol);
                WebElement niva = driver.findElement(By.xpath(prop.getProperty("Nivabutton" + PlanName)));
                niva.click();
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }

    }

    @And("^click on proceed to proposal Page after adding rider$")
    public void clickOnProceedToProposalPageAfterAddingRider() throws InterruptedException {
        WebElement premiumvalue = driver.findElement(By.xpath("//div[@class='flexRow section_premium']//div//span"));
        System.out.println("*****Premium value before adding rider*****" + premiumvalue.getText());
        String beforerider = premiumvalue.getText();
        WebElement rider1 = null;
        WebElement rider2 = null;
        try {
            rider1 = driver.findElement(By.xpath("(//div[@class='fullWidthBtn'])[1]"));
            rider1.click();
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            rider2 = driver.findElement(By.xpath("(//div//button)[1]"));
            rider2.click();
        } catch (Exception e) {
            e.getMessage();
        }
        Thread.sleep(5000L);
        WebElement premiumvalue1 = driver.findElement(By.xpath("//div[@class='flexRow section_premium']//div//span"));
        System.out.println("*****Premium value after adding rider*****" + premiumvalue1.getText());
        premiumofproposalpage = premiumvalue1.getText();
        Assert.assertNotEquals(beforerider, premiumvalue1.getText());
        driver.findElement(By.xpath(prop.getProperty("proceedtoproposal"))).click();
    }

    @And("^Enter details on the proposer details screen \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enterDetailsOnTheProposerDetailsScreen(String panCard, String address, String contactEmail, String emergencyMobile) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@id='pan']")).sendKeys(panCard);
        driver.findElement(By.xpath("//input[@id='addressLine1']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(contactEmail);
        driver.findElement(By.xpath("//input[@id='emergencyMobile']")).sendKeys(emergencyMobile);
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO MEMBER SECTION')]")).click();
    }

    @And("^Enter the Details on member details screen \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailsOnMemberDetailsScreen(String dob, String occupation, String heightFeet, String heightInch, String weight, String spouseName, String spouseDOB, String spouseOccupation, String spouseHeightFeet, String spouseHeightInch, String spouseWeight) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(dob);
        WebElement occupationselectelement = driver.findElement(By.xpath("(//div[@class='fieldBlockProposal select_proposal']/div/select)[1]"));
        Select dropdownoccupation = new Select(occupationselectelement);
        dropdownoccupation.selectByValue(occupation);
        WebElement HeightFeet = driver.findElement(By.xpath("(//div[@class='fieldBlockProposal select_proposal']/div/select)[2]"));
        Select dropdownHeightFeet = new Select(HeightFeet);
        dropdownHeightFeet.selectByValue(heightFeet);
        WebElement HeightInch = driver.findElement(By.xpath("(//div[@class='fieldBlockProposal select_proposal']/div/select)[3]"));
        Select dropdownHeightInch = new Select(HeightInch);
        dropdownHeightInch.selectByValue(heightInch);
        driver.findElement(By.xpath("//input[@name='weight']")).sendKeys(weight);
        driver.findElement(By.xpath("(//input[@name='name'])[2]")).sendKeys(spouseName);
        driver.findElement(By.xpath("(//input[@name='dob'])[2]")).sendKeys(spouseDOB);
        WebElement spouseoccupationselectelement = driver.findElement(By.xpath("(//div[@class='fieldBlockProposal select_proposal']/div/select)[4]"));
        Select dropdownspouseoccupation = new Select(spouseoccupationselectelement);
        dropdownspouseoccupation.selectByValue(spouseOccupation);
        WebElement spouseHeightFt = driver.findElement(By.xpath("(//div[@class='fieldBlockProposal select_proposal']/div/select)[5]"));
        Select dropdownspouseHeightFeet = new Select(spouseHeightFt);
        dropdownspouseHeightFeet.selectByValue(spouseHeightFeet);
        WebElement spouseHeightIn = driver.findElement(By.xpath("(//div[@class='fieldBlockProposal select_proposal']/div/select)[6]"));
        Select dropdownspouseHeightInch = new Select(spouseHeightIn);
        dropdownspouseHeightInch.selectByValue(heightInch);
        driver.findElement(By.xpath("(//input[@name='weight'])[2]")).sendKeys(weight);
        Thread.sleep(3000L);
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO MEDICAL QUESTIONS')]")).click();


    }

    @And("^Enter the Details on medical screen$")
    public void enterTheDetailsOnMedicalScreen() {
        int questionIndex = 1;
        boolean questionsExist = true;

        while (questionsExist) {
            String questionXPath = "(//div[@class='optionsModule'])[" + (questionIndex * 3) + "]";

            try {
                driver.findElement(By.xpath(questionXPath)).click();
                questionIndex++;
            } catch (NoSuchElementException e) {
                // No more questions found, exit the loop
                questionsExist = false;
            }
        }

        // Handle the highest qualification dropdown
        selectDropdownByIndex(driver, "(//div[@class='field']/select)[1]", 2);
        selectDropdownByIndex(driver, "(//div[@class='field']/select)[2]", 4);

        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO NOMINEE SECTION')]")).click();
    }

    // Helper method to select dropdown by index
    private void selectDropdownByIndex(WebDriver driver, String xpath, int index) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    @And("^Enter details on Nominee page$")
    public void enterDetailsOnNomineePage() throws InterruptedException {
        Thread.sleep(5000L);

        WebElement childElement1 = driver.findElement(By.xpath("(//div[@class='InputLabelBox'])[1]"));
        JavascriptExecutor jse4 = (JavascriptExecutor) driver;
        jse4.executeScript("arguments[0].scrollIntoView()", childElement1);
        jse4.executeScript("arguments[0].click();", childElement1);

        driver.findElement(By.xpath("//button[contains(text(),'REVIEW & PAY')]")).click();

    }

    @And("^Check the Declaration popup$")
    public void checkTheDeclarationPopup() throws InterruptedException {
        Thread.sleep(2000L);
        Actions action = new Actions(driver);
        WebElement childElement = driver.findElement(By.xpath("//input[@id='declarationInput' and @type='checkbox' and @class='checkbox_filter']"));
        action.moveToElement(childElement).click().perform();

        action = new Actions(driver);
        WebElement childElement1 = driver.findElement(By.xpath("//button[@class='btn zuno']"));
        action.moveToElement(childElement1).click().perform();

        Thread.sleep(50000L);
        String premiumonpaymentsummarypage = driver.findElement(By.xpath("//div[@class='summaryTotalBlock__amount']")).getText();
        System.out.println("***" + premiumonpaymentsummarypage + "****");
    }

    @And("^Move the POSP parent portal$")
    public void moveThePOSPParentPortal() {
        driver.close();
        driver.switchTo().window(parent);
    }

    @And("^Click the Lead tab$")
    public void clickTheLeadTab() {
        WebElement element = driver.findElement(By.xpath("//a//span[contains(text(),'Lead')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", element);
        jse2.executeScript("arguments[0].click();", element);
    }

    @And("^Verify Lead ID from UI and DB$")
    public void verifyLeadIDFromUIAndDB() {
        try {
            String query = "use PospDB select top(1) LeadID from dbo.LeadDetails_v1 where productID = 190 and name like '%Test Automation%' order by LeadID desc";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.println("leadId value from DB " + res.getString(1));
                Thread.sleep(3000L);
                List<WebElement> leadId = driver.findElements(By.xpath(prop.getProperty("HealthPulseEnhancedleadidleadpage")));
                for (WebElement e : leadId) {
                    System.out.println("Lead Id value from UI " + e.getText());
                    String leadValue = res.getString(1);
                    junit.framework.Assert.assertEquals("Lead ID - " + leadValue, e.getText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^Click Continue button from Lead section$")
    public void clickContinueButtonFromLeadSection() throws InterruptedException {
        WebElement Childelement = driver.findElement(By.xpath(prop.getProperty("HealthPulseEnhancedHowerbuttonleadpage")));
        Actions action = new Actions(driver);
        action.moveToElement(Childelement).build().perform();
        Thread.sleep(5000L);
        WebElement Childelement1 = driver.findElement(By.xpath(prop.getProperty("HealthPulseEnhancedContinueLeadpagebutton")));
        if (Childelement1.isDisplayed()) {
            Childelement1.click();

        }
    }

    @And("^Click proceed to payment page$")
    public void clickProceedToPaymentPage() {
        parent = driver.getWindowHandle();
        for (String child : driver.getWindowHandles()) {
            if (!parent.contentEquals(child)) {
                driver.switchTo().window(child);
                break;
            }
        }
        driver.findElement(By.xpath("//button[@class='btn']")).click();
    }


    @And("^Navigate payment page and fill all mandatory entries$")
    public void navigatePaymentPageAndFillAllMandatoryEntries() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@class='selectBank'])[1]")).click();
        driver.findElement(By.xpath("//button[@class=\"btn\" and @id=\"paynb\"]")).click();
        driver.findElement(By.xpath("//button[@data-val=\"S\" and @class=\"success\"]")).click();
        Thread.sleep(10000L);
        driver.navigate().refresh();
    }
}




