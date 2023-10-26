package stepDef.healthStepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDef.TestBase;

import java.sql.ResultSet;
import java.util.List;

public class NivaMaxSaverStepdefs extends TestBase {
    Select dropdownAge;
    String parent;
    String premiumofproposalpage;

    @When("^Click on Sell now modules icon$")
    public void clickOnSellNowModulesIcon() throws InterruptedException {
        Thread.sleep(10000L);
        driver.findElement(By.xpath(prop.getProperty("sellnowbutton"))).click();

    }

    @When("^Click on the Health buttons icon$")
    public void clickOnTheHealthButtonsIcon() throws InterruptedException {
        Thread.sleep(1500);

        WebElement childElement = driver.findElement(By.xpath("//div[@class='col-lg-2 col-md-4 col-sm-4 item']//p[contains(text(),'Health')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
    }

    @And("^Enter the detail in Health preQuotes page \"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailInHealthPreQuotesPage(String FullName, String MobileNo) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
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


    @Then("^user should be able to navigate to member detail page$")
    public void userShouldBeAbleToNavigateToMemberDetailPage() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "PolicyBazaar Health Insurance: Get a 5 Lac health plan @Rs. 373/Month";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Actual title is " + actualTitle);

    }

    @And("^user should be enter the mandatory fields on member screen \"([^\"]*)\"$")
    public void userShouldBeEnterTheMandatoryFieldsOnMemberScreen(String eldestmemberage) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Male2Adult")))).click();
        WebElement age = driver.findElement(By.xpath(prop.getProperty("eldestmemberagexpath")));
        dropdownAge = new Select(age);
        dropdownAge.selectByValue(eldestmemberage);
        driver.findElement(By.xpath(prop.getProperty("ContinueButton2"))).click();
    }

    @And("^select City name\"([^\"]*)\"$")
    public void selectCityName(String city) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement selectCity = driver.findElement(By.xpath(prop.getProperty("selectcity")));
        selectCity.sendKeys(city);
        selectCity.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(prop.getProperty("continueofselectcity"))).click();
    }


    @And("^select existing illness & click on View Plan$")
    public void selectExistingIllnessClickOnViewPlan() throws InterruptedException {
        new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Noneofthese")))).click();
//        driver.findElement(By.xpath(prop.getProperty("Noneofthese"))).click();
        Thread.sleep(3000L);
    }

    @And("^Enter spouse Age through edit member$")
    public void enterSpouseAgeThroughEditMember() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Edit Members')]")).click();
        Thread.sleep(5000L);
        Select spouseage = new Select(driver.findElement(By.xpath("(//div[@class='select_members_age']//select)[2]")));
        spouseage.selectByValue("30");
        driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();

    }

    @And("^click on the cover amount dorp down button on the quote page$")
    public void clickOnTheCoverAmountDorpDownButtonOnTheQuotePage() {
//        driver.findElement(By.xpath(prop.getProperty("coverammountbutton"))).click();
        new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated((By.xpath(prop.getProperty("coverammountbutton"))))).click();

    }

    @And("^Select the  (\\d+) crore suminsurred$")
    public void selectTheCroreSuminsurred(int arg0) {
        driver.findElement(By.xpath(prop.getProperty("1crCoverAmountButton"))).click();

    }

    @And("^Click on the Apply button of cover amount drop down$")
    public void clickOnTheApplyButtonOfCoverAmountDropDown() {
        driver.findElement(By.xpath(prop.getProperty("Applybutton"))).click();
    }
    @And("^click on the Insurer name dropdown button and select the name of the insurer$")
    public void clickOnTheInsurerNameDropdownButtonAndSelectTheNameOfTheInsurer() {
        WebElement insurerDropdownButton = driver.findElement(By.xpath(prop.getProperty("InsurerDropdownbutton")));
        insurerDropdownButton.click();

        // Use WebDriverWait to wait for the insurer element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
        By insurerElementLocator = By.xpath("//input[@id='Niva Bupa (formerly known as Max Bupa)']");
        WebElement insurerElement = wait.until(ExpectedConditions.elementToBeClickable(insurerElementLocator));

        insurerElement.click();
        driver.findElement(By.xpath(prop.getProperty("Applybutton"))).click();
    }

    @And("^click on premium button of niva Max Saver$")
    public void clickOnPremiumButtonOfNivaMaxSaver() throws InterruptedException {
        validateNivaMaxSaverPremiumButtonText();
        Thread.sleep(3000L);
    }

    public void validateNivaMaxSaverPremiumButtonText() {
        try {
            String nameToFind = "Max Saver"; // The name you want to find

            boolean MaxSaverFound = false;

            // Check if the "Max Saver" text is found on the page
            while (!MaxSaverFound) {
                boolean isTextPresent = (boolean) ((JavascriptExecutor) driver).executeScript(
                        "return document.body.innerText.includes('" + nameToFind + "');"
                );

                if (isTextPresent) {
                    MaxSaverFound = true;
                } else {
                    // Scroll the page down
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
                    Thread.sleep(1000); // Adjust the sleep duration as needed
                }
            }

            if (MaxSaverFound) {
//                WebElement nivaMaxSaver = driver.findElement(By.xpath(prop.getProperty("NivaMaxSaver")));
                // Check the value of the "env" property
                if (prop.getProperty("env").equalsIgnoreCase("qa")) {
                    WebElement  nivaMaxSaver = driver.findElement(By.xpath(prop.getProperty("NivaMaxSaver")));
                    // Execute the query
                    String queryNivaMaxSaver = "use HealthDB Select top 1 Premium from Hi.Health_Rates nolock where Plan_Id=12114 and SumInsured=10000000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=40 and Term = 1";
                    ResultSet res1 = stmt.executeQuery(queryNivaMaxSaver);

                    while (res1.next()) {
                        System.out.println("premium value from DB " + res1.getString(1));
                        String nivaMaxSavertext = nivaMaxSaver.getText();
                        String maxSaverSymbol1 = nivaMaxSavertext.replaceAll("₹", "");
                        String maxSaverSymbol2 = maxSaverSymbol1.replaceAll("/year", "");
                        String maxSaverFinalSymbol = maxSaverSymbol2.replaceAll(",", "");
                        System.out.println("premium value from nivaMaxSaver UI = " + maxSaverFinalSymbol);
                        String expectedButtonText = res1.getString(1);
                        junit.framework.Assert.assertEquals(expectedButtonText, maxSaverFinalSymbol);

                        // Click the element outside the loop
                        nivaMaxSaver.click();
                    }
                } else {
                    // Execute a different action when "env" is not "qa"
                    WebElement  nivaMaxSaverprod = driver.findElement(By.xpath(prop.getProperty("NivaMaxSaverprod")));
                    nivaMaxSaverprod.click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @And("^click on proceed to the proposal page$")
    public void clickOnProceedToTheProposalPage() throws InterruptedException {
        int maxWaitTimeInSeconds = 5;
        try {
            WebDriverWait wait = new WebDriverWait(driver, maxWaitTimeInSeconds);
            // Define the ExpectedCondition to check if the "Cover Amount" text is visible
            ExpectedCondition<Boolean> CoverAmountVisible = webDriver -> {
                try {
                    WebElement coverAmountElement = driver.findElement(By.xpath("//h3[contains(text(), 'Cover Amount')]"));
                    return coverAmountElement.isDisplayed();
                } catch (StaleElementReferenceException e) {
                    return false;
                }
            };
            // Wait for the "Cover Amount" text to be visible
            wait.until(CoverAmountVisible);
            // If it becomes visible within the specified time, continue with your code

        } catch (TimeoutException e) {
            // The "Cover Amount" text is not visible within the timeout
            // Refresh the page
            driver.navigate().refresh();
            // Continue with any additional actions you want to perform after the page refresh
        }
        WebElement premiumvalue = driver.findElement(By.xpath("//div[@class='flexRow section_premium']//div//span"));
        System.out.println("*****Premium value before adding rider*****" + premiumvalue.getText());
        String beforerider = premiumvalue.getText();
        WebElement rider1 = null;
        WebElement rider2 = null;
        try {
            rider1 = driver.findElement(By.xpath("(//div//button)[1]"));
            rider1.click();
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            rider2 = driver.findElement(By.xpath("(//div//button)[2]"));
            rider2.click();
        } catch (Exception e) {
            e.getMessage();
        }


        Thread.sleep(5000L);
        WebElement premiumvalue1 = driver.findElement(By.xpath("//div[@class='flexRow section_premium']//div//span"));
        System.out.println("*****Premium value after adding rider*****" + premiumvalue1.getText());
        premiumofproposalpage = premiumvalue1.getText();
        Assert.assertNotEquals(beforerider, premiumvalue1.getText());
        Actions action = new Actions(driver);
        WebElement childElement = driver.findElement(By.xpath("//input[@class='input-check buyBackContent']"));
        action.moveToElement(childElement).click().perform();
        driver.findElement(By.xpath(prop.getProperty("proceedtoproposal"))).click();
    }

    @And("^Enter the details on proposer details on the screen \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailsOnProposerDetailsOnTheScreen(String panCard, String address, String contactEmail, String emergencyMobile) throws Throwable {
        int maxWaitTimeInSeconds = 5;
        WebDriverWait wait = null;
        try {
            wait = new WebDriverWait(driver, maxWaitTimeInSeconds);
            ExpectedCondition<WebElement> presenceOfElementLocated = ExpectedConditions.presenceOfElementLocated(By.id("pan"));
            WebElement element = wait.until(presenceOfElementLocated);
            element.sendKeys("NXAPS8425T");
        } catch (org.openqa.selenium.TimeoutException e) {
            // Handle timeout exception
            driver.navigate().refresh();

            // Reuse the existing wait variable
            ExpectedCondition<WebElement> presenceOfElementLocated = ExpectedConditions.presenceOfElementLocated(By.id("pan"));
            WebElement element = wait.until(presenceOfElementLocated);
            element.sendKeys("NXAPS8425T");
        } catch (StaleElementReferenceException e) {
            // Handle stale element reference exception
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//input[@id='addressLine1']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(contactEmail);
        driver.findElement(By.xpath("//input[@id='emergencyMobile']")).sendKeys(emergencyMobile);
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO MEMBER SECTION')]")).click();
    }

    @And("^Enter the details on the member details screen \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailsOnTheMemberDetailsScreen(String dob, String occupation, String heightFeet, String heightInch, String weight, String spouseName, String spouseDOB, String spouseOccupation, String spouseHeightFeet, String spouseHeightInch, String spouseWeight) throws Throwable {
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

    @And("^Enter the details on the medical screen$")
    public void enterTheDetailsOnTheMedicalScreen() {
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[3]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[6]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[9]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[12]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[15]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[18]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[21]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[24]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[27]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[30]")).click();
        driver.findElement(By.xpath("(//div[@class='optionsModule'])[33]")).click();
        WebElement highestQualification = driver.findElement(By.xpath("(//div[@class='field']/select)[1]"));
        Select dropdownhighestQualification = new Select(highestQualification);
        dropdownhighestQualification.selectByIndex(2);
        //dropdownhighestQualification.selectByValue("Graduate");
        WebElement highestQualificationSpouse = driver.findElement(By.xpath("(//div[@class='field']/select)[2]"));
        Select dropdownhighestQualificationSpouse = new Select(highestQualificationSpouse);
        dropdownhighestQualificationSpouse.selectByIndex(4);
        //dropdownhighestQualificationSpouse.selectByValue("Matric");
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO NOMINEE SECTION')]")).click();
        Actions action = new Actions(driver);
        WebElement childElement = driver.findElement(By.xpath("//button[@class='btn zuno']"));
        action.moveToElement(childElement).click().perform();
    }

    @And("^Enter the details on the Nominee page$")
    public void enterTheDetailsOnTheNomineePage() throws InterruptedException {
//        Thread.sleep(5000L);
//        driver.navigate().refresh();
        WebElement childElement1 = driver.findElement(By.xpath("(//div[@class='InputLabelBox'])[1]"));
        JavascriptExecutor jse4 = (JavascriptExecutor) driver;
        jse4.executeScript("arguments[0].scrollIntoView()", childElement1);
        jse4.executeScript("arguments[0].click();", childElement1);
        Actions action = new Actions(driver);
        WebElement childElement = driver.findElement(By.xpath("//button[@class='primaryButtonStyle btn']"));
        action.moveToElement(childElement).click().perform();
    }


    @And("^Enter the Policy Expire Date for the policy port \"([^\"]*)\"$")
    public void enterThePolicyExpireDateForThePolicyPort(String PolicyExpirydate) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000L);
        driver.findElement(By.xpath("//input[@id='expiryDate']")).sendKeys(PolicyExpirydate);

    }

    @And("^Enter the Details on the Portability page \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailsOnThePortabilityPage(String PolicyNumber, String SumInsurred, String CumulativeBonus, String PEDDeclared) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000L);
        Select ReasonforProtability = new Select(driver.findElement(By.xpath("//select[@id='portabilityReason']")));
        ReasonforProtability.selectByValue("1");
        Thread.sleep(1000L);
        Actions action = new Actions(driver);
        WebElement childElement = driver.findElement(By.xpath("(//div[@class='optionsModule'])[2]"));
        action.moveToElement(childElement).click().perform();
        Select SelectInsurer = new Select(driver.findElement(By.xpath("//Select[@id='selectInsurer']")));
        SelectInsurer.selectByValue("1028");
        Thread.sleep(1000L);
        Select SelectPlan = new Select(driver.findElement(By.xpath("//Select[@id='selectPlan']")));
        SelectPlan.selectByValue("49");
        driver.findElement(By.xpath("//input[@name='policyNumber']")).sendKeys(PolicyNumber);
        Select SelectTerm = new Select(driver.findElement(By.xpath("//select[@id='selectTerm']")));
        SelectTerm.selectByValue("1");
        Select SelectPolicyType = new Select(driver.findElement(By.xpath("//select[@id='policyType']")));
        SelectPolicyType.selectByValue("1");
        action = new Actions(driver);
        WebElement childElement1 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[4]"));
        action.moveToElement(childElement1).click().perform();
        action = new Actions(driver);
        WebElement childElement2 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[6]"));
        action.moveToElement(childElement2).click().perform();
        action = new Actions(driver);
        WebElement childElement3 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[7]"));
        action.moveToElement(childElement3).click().perform();
        Select SelectNumberofYear = new Select(driver.findElement(By.xpath("//div[contains(@class, 'field')]//select[contains(@id, 'renewalYears')]")));
        SelectNumberofYear.selectByValue("1");
        driver.findElement(By.xpath("//input[@name='sumInsured']")).sendKeys(SumInsurred);
        driver.findElement(By.xpath("//input[@name='cumulativeBonus']")).sendKeys(CumulativeBonus);
        driver.findElement(By.xpath("(//input[@name='pedDeclared'])")).sendKeys(PEDDeclared);
        action = new Actions(driver);
        WebElement childElement4 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[10]"));
        action.moveToElement(childElement4).click().perform();
        action = new Actions(driver);
        WebElement childElement5 = driver.findElement(By.xpath("//input[@id='declarationInput']"));
        action.moveToElement(childElement5).click().perform();
        action = new Actions(driver);
        WebElement childElement6 = driver.findElement(By.xpath("//input[@id='declarationInput1']"));
        action.moveToElement(childElement6).click().perform();
        Thread.sleep(3000L);
        action = new Actions(driver);
        WebElement childElement7 = driver.findElement(By.xpath("//button[@class='primaryButtonStyle btn']"));
        action.moveToElement(childElement7).click().perform();

    }

    @And("^check to the Declaration popup$")
    public void checkToTheDeclarationPopup() throws InterruptedException {
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

    @And("^move to POSP parent portal$")
    public void moveToPOSPParentPortal() {
        driver.close();
        driver.switchTo().window(parent);
    }

    @And("^click on the Lead tab page$")
    public void clickOnTheLeadTabPage() {
        WebElement element = driver.findElement(By.xpath("//a//span[contains(text(),'Lead')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", element);
        jse2.executeScript("arguments[0].click();", element);
    }

    @And("^verify the to Lead ID from UI and DB$")
    public void verifyTheToLeadIDFromUIAndDB() {
        try {
            String query = "use PospDB select top(1) LeadID from dbo.LeadDetails_v1 where productID = 190 and name like '%Rahul Sharma%' order by LeadID desc";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.println("leadId value from DB " + res.getString(1));
                Thread.sleep(3000L);
                List<WebElement> leadId = driver.findElements(By.xpath(prop.getProperty("Maxsaverleadidleadpage")));
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

    @And("^click on the Continue button from Lead section$")
    public void clickOnTheContinueButtonFromLeadSection() throws InterruptedException {
        WebElement Childelement =driver.findElement(By.xpath(prop.getProperty("MaxsaverHowerbuttonleadpage")));
        Actions action = new Actions(driver);
        action.moveToElement(Childelement).build().perform();
        Thread.sleep(5000L);
       WebElement Childelement1= driver.findElement(By.xpath(prop.getProperty("MaxsaverContinueLeadpagebutton")));
       if(Childelement1.isDisplayed())
       {
           Childelement1.click();

       }


    }

    @And("^click on the proceed to payment page$")
    public void clickOnTheProceedToPaymentPage() throws InterruptedException {
        parent = driver.getWindowHandle();
        for (String child : driver.getWindowHandles()) {
            if (!parent.contentEquals(child)) {
                driver.switchTo().window(child);
                break;
            }
        }
        driver.findElement(By.xpath("//button[@class='btn']")).click();
    }


    @And("^navigate to the payment page and fill all mandatory entries$")
    public void navigateToThePaymentPageAndFillAllMandatoryEntries() throws InterruptedException {

        //new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("(//div[@class='selectBank'])[1]")))).click();
        Thread.sleep(50000l);
        driver.findElement(By.xpath("(//div[@class='selectBank'])[1]")).click();
        driver.findElement(By.xpath("//button[@class=\"btn\" and @id=\"paynb\"]")).click();
        driver.findElement(By.xpath("//button[@data-val=\"S\" and @class=\"success\"]")).click();
        Thread.sleep(20000L);
        driver.navigate().refresh();

    }

}

