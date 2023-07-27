package stepDef.healthStepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDef.TestBase;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        driver.findElement(By.xpath(prop.getProperty("Noneofthese"))).click();
        Thread.sleep(5000L);
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
        driver.findElement(By.xpath(prop.getProperty("coverammountbutton"))).click();

    }

    @And("^Select the  (\\d+) crore suminsurred$")
    public void selectTheCroreSuminsurred(int arg0) {
        driver.findElement(By.xpath(prop.getProperty("1crCoverAmountButton"))).click();

    }

    @And("^Click on the Apply button of cover amount drop down$")
    public void clickOnTheApplyButtonOfCoverAmountDropDown() {
        driver.findElement(By.xpath(prop.getProperty("Applybutton"))).click();
    }

    @And("^click on premium button of niva Max Saver$")
    public void clickOnPremiumButtonOfNivaMaxSaver() throws InterruptedException {
        validateNivaMaxSaverPremiumButtonText();
        Thread.sleep(3000L);
    }
    public void validateNivaMaxSaverPremiumButtonText(){
        WebElement nivaMaxSaver = null;
        try {
            nivaMaxSaver = driver.findElement(By.xpath(prop.getProperty("NivaMaxSaver")));
            String queryNivaMaxSaver = "use HealthDB Select top 1 Premium from Hi.Health_Rates nolock where Plan_Id=12114 and SumInsured=10000000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=40 and Term = 1";
            ResultSet res1 = stmt.executeQuery(queryNivaMaxSaver);
            while (res1.next()) {
                System.out.println("premium value from DB " + res1.getString(1));
                String nivaMaxSavertext;
                nivaMaxSavertext = nivaMaxSaver.getText();
                String MaxSaversymbol1 = nivaMaxSavertext.replaceAll("₹", "");
                String MaxSaversymbol2 = MaxSaversymbol1.replaceAll("/year", "");
                String MaxSaverfinalsymbol = MaxSaversymbol2.replaceAll(",", "");
                System.out.println("premium value from nivaMaxSaver UI = " + MaxSaverfinalsymbol);
                String expectedbuttontext = res1.getString(1);
                junit.framework.Assert.assertEquals(expectedbuttontext, MaxSaverfinalsymbol);
                WebElement niva = driver.findElement(By.xpath(prop.getProperty("NivaMaxSaver")));
                niva.click();
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @And("^click on proceed to the proposal page$")
    public void clickOnProceedToTheProposalPage() throws InterruptedException {
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
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@id='pan']")).sendKeys(panCard);
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
}
