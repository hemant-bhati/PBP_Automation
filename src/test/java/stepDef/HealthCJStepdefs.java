package stepDef;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class HealthCJStepdefs extends TestBase {
    Select dropdownAge;
    String parent;

    @When("^Click on Sell now modules$")
    public void clickOnSellNowModules() throws InterruptedException {
        Thread.sleep(10000L);
        driver.findElement(By.xpath(prop.getProperty("sellnowbutton"))).click();
    }

    @Given("^Click on the Health buttons$")
    public void clickOnTheHealthButtons() throws IOException, InterruptedException {
        Thread.sleep(1500);

        WebElement childElement = driver.findElement(By.xpath("//div[@class='col-lg-2 col-md-4 col-sm-4 item']//p[contains(text(),'Health')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
    }

    @And("^Enter the detail in Health landing page \"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailInHealthLandingPage(String FullName, String MobileNo) throws Throwable {
         parent = driver.getWindowHandle();
        for (String child : driver.getWindowHandles()) {
            if (!parent.contentEquals(child)) {
                driver.switchTo().window(child);
                break;
            }
        }
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Femaleimage")))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("CustomerFullName")))).sendKeys(FullName);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("CustomerMobileNumber")))).sendKeys(MobileNo);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("ContinueButton1")))).click();
    }

    @Then("^user should be able to navigate to member detail$")
    public void userShouldBeAbleToNavigateToMemberDetail() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "PolicyBazaar Health Insurance: Get a 5 Lac health plan @Rs. 373/Month";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Actual title is " + actualTitle);
    }

    @And("^user should enter the mandatory fields on member screen \"([^\"]*)\"$")
    public void userShouldEnterTheMandatoryFieldsOnMemberScreen(String eldestmemberage) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("2Adult")))).click();
        WebElement age = driver.findElement(By.xpath(prop.getProperty("eldestmemberagexpath")));
        dropdownAge = new Select(age);
        dropdownAge.selectByValue(eldestmemberage);
        driver.findElement(By.xpath(prop.getProperty("ContinueButton2"))).click();

    }

    @And("^select City \"([^\"]*)\"$")
    public void selectCity(String city) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement selectCity = driver.findElement(By.xpath(prop.getProperty("selectcity")));
        selectCity.sendKeys(city);
        selectCity.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(prop.getProperty("continueofselectcity"))).click();
    }

    @And("^select existing illness and click on View Plan$")
    public void selectExistingIllnessAndClickOnViewPlan() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Noneofthese"))).click();

        //driver.findElement(By.xpath(prop.getProperty("viewplanbutton"))).click();
    }

    public void validatePremiumButtonText() throws SQLException, InterruptedException {
        Thread.sleep(3000L);
        WebElement nivaHealthPlusEnhance = null;
        WebElement NivaHealthCompanion = null;
        WebElement NivaReasure2PlatinumPlus = null;
        WebElement NivaReasure2TitaniumPlus = null;
        WebElement NivaGoActive = null;
        WebElement NivaReasure2BronzePlus = null;
        WebElement NivaArogyaSanjeevani = null;
        WebElement nivaReAsure = null;
        try {
            nivaHealthPlusEnhance = driver.findElement(By.xpath(prop.getProperty("NivabuttonHealthPlusEnhance")));
            String queryHealthPlus = "use HealthDB Select Premium  from Hi.Health_Rates nolock where Plan_Id=574 and SumInsured=300000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and Term = 1";
            ResultSet res = stmt.executeQuery(queryHealthPlus);
            while (res.next()) {
                System.out.println("premium value from DB " + res.getString(1));
                Thread.sleep(3000L);
                String nivaHealthPlusEnhancetext;
                nivaHealthPlusEnhancetext = nivaHealthPlusEnhance.getText();
                String nivaHealthPlussymbol1 = nivaHealthPlusEnhancetext.replaceAll("₹", "");
                String nivaHealthPlussymbol2 = nivaHealthPlussymbol1.replaceAll("/year", "");
                String nivaHealthPlusfinalsymbol = nivaHealthPlussymbol2.replaceAll(",", "");
                System.out.println("premium value from HealthPlusEnhance UI = " + nivaHealthPlusfinalsymbol);
                String expectedbuttontext = res.getString(1);
                junit.framework.Assert.assertEquals(expectedbuttontext, nivaHealthPlusfinalsymbol);
                WebElement niva = driver.findElement(By.xpath(prop.getProperty("NivabuttonHealthPlusEnhance")));
                niva.click();
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
//        try {
//            nivaReAsure = driver.findElement(By.xpath(prop.getProperty("NivabuttonReasure")));
//            String queryNivaReasure = "use HealthDB Select Premium  from Hi.Health_Rates nolock where Plan_Id=626 and SumInsured=500000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and Term = 1";
//            ResultSet res1 = stmt.executeQuery(queryNivaReasure);
//            while (res1.next()) {
//                System.out.println("premium value from DB " + res1.getString(1));
//                String nivaReAsuretext;
//                nivaReAsuretext = nivaReAsure.getText();
//                String reasuresymbol1 = nivaReAsuretext.replaceAll("₹", "");
//                String reasuresymbol2 = reasuresymbol1.replaceAll("/year", "");
//                String reasurefinalsymbol = reasuresymbol2.replaceAll(",", "");
//                System.out.println("premium value from nivareasure UI = " + reasurefinalsymbol);
//                String expectedbuttontext = res1.getString(1);
//                junit.framework.Assert.assertEquals(expectedbuttontext, reasurefinalsymbol);
//                WebElement niva = driver.findElement(By.xpath(prop.getProperty("NivabuttonReasure")));
//                niva.click();
//            }
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//        }
//        try {
//            NivaHealthCompanion = driver.findElement(By.xpath(prop.getProperty("NivabuttonHealthCompanion")));
//            String queryNivaCompanion = "use HealthDB Select Premium  from Hi.Health_Rates nolock where Plan_Id=319 and SumInsured=500000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and Term = 1";
//            ResultSet res1 = stmt.executeQuery(queryNivaCompanion);
//            while (res1.next()) {
//                System.out.println("premium value from DB " + res1.getString(1));
//                String nivaCompaniontext;
//                nivaCompaniontext = NivaHealthCompanion.getText();
//                String Companionsymbol1 = nivaCompaniontext.replaceAll("₹", "");
//                String Companionsymbol2 = Companionsymbol1.replaceAll("/year", "");
//                String Companionfinalsymbol = Companionsymbol2.replaceAll(",", "");
//                System.out.println("premium value from nivareasure UI = " + Companionfinalsymbol);
//                String expectedbuttontext = res1.getString(1);
//                junit.framework.Assert.assertEquals(expectedbuttontext, Companionfinalsymbol);
//                WebElement niva = driver.findElement(By.xpath(prop.getProperty("NivabuttonHealthCompanion")));
//                niva.click();
//            }
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//        }
//        try {
//            NivaReasure2PlatinumPlus = driver.findElement(By.xpath(prop.getProperty("NivabuttonReasure2PlatinumPlus")));
//            String queryReasure2PlatinumPlus = "use HealthDB Select Premium  from Hi.Health_Rates nolock where Plan_Id=44426 and SumInsured=500000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and Term = 1";
//            ResultSet res1 = stmt.executeQuery(queryReasure2PlatinumPlus);
//            while (res1.next()) {
//                System.out.println("premium value from DB " + res1.getString(1));
//                String nivaReasure2PlatinumPlustext;
//                nivaReasure2PlatinumPlustext = NivaReasure2PlatinumPlus.getText();
//                String nivaReasure2PlatinumPlussymbol1 = nivaReasure2PlatinumPlustext.replaceAll("₹", "");
//                String nivaReasure2PlatinumPlussymbol2 = nivaReasure2PlatinumPlussymbol1.replaceAll("/year", "");
//                String nivaReasure2PlatinumPlusfinalsymbol = nivaReasure2PlatinumPlussymbol2.replaceAll(",", "");
//                System.out.println("premium value from nivareasure UI = " + nivaReasure2PlatinumPlusfinalsymbol);
//                String expectedbuttontext = res1.getString(1);
//                junit.framework.Assert.assertEquals(expectedbuttontext, nivaReasure2PlatinumPlusfinalsymbol);
//                WebElement niva = driver.findElement(By.xpath(prop.getProperty("NivabuttonReasure2PlatinumPlus")));
//                niva.click();
//            }
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//        }
//        try {
//            NivaReasure2TitaniumPlus = driver.findElement(By.xpath(prop.getProperty("NivabuttonReasure2TitaniumPlus")));
//            String queryReasure2TitaniumPlus = "use HealthDB Select Premium  from Hi.Health_Rates nolock where Plan_Id=45523 and SumInsured=500000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and Term = 1";
//            ResultSet res1 = stmt.executeQuery(queryReasure2TitaniumPlus);
//            while (res1.next()) {
//                System.out.println("premium value from DB " + res1.getString(1));
//                String Reasure2TitaniumPlustext;
//                Reasure2TitaniumPlustext = NivaReasure2TitaniumPlus.getText();
//                String Reasure2TitaniumPlussymbol1 = Reasure2TitaniumPlustext.replaceAll("₹", "");
//                String Reasure2TitaniumPlussymbol2 = Reasure2TitaniumPlussymbol1.replaceAll("/year", "");
//                String Reasure2TitaniumPlusfinalsymbol = Reasure2TitaniumPlussymbol2.replaceAll(",", "");
//                System.out.println("premium value from nivareasure UI = " + Reasure2TitaniumPlusfinalsymbol);
//                String expectedbuttontext = res1.getString(1);
//                junit.framework.Assert.assertEquals(expectedbuttontext, Reasure2TitaniumPlusfinalsymbol);
//                WebElement niva = driver.findElement(By.xpath(prop.getProperty("NivabuttonReasure2TitaniumPlus")));
//                niva.click();
//            }
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//        }
//        try {
//            NivaGoActive = driver.findElement(By.xpath(prop.getProperty("NivabuttonGoActive")));
//            String queryGoActive = "use HealthDB Select Premium  from Hi.Health_Rates nolock where Plan_Id=447 and SumInsured=500000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and Term = 1";
//            ResultSet res1 = stmt.executeQuery(queryGoActive);
//            while (res1.next()) {
//                System.out.println("premium value from DB " + res1.getString(1));
//                String GoActivetext;
//                GoActivetext = NivaGoActive.getText();
//                String NivaGoActivesymbol1 = GoActivetext.replaceAll("₹", "");
//                String NivaGoActivesymbol2 = NivaGoActivesymbol1.replaceAll("/year", "");
//                String NivaGoActivefinalsymbol = NivaGoActivesymbol2.replaceAll(",", "");
//                System.out.println("premium value from nivareasure UI = " + NivaGoActivefinalsymbol);
//                String expectedbuttontext = res1.getString(1);
//                junit.framework.Assert.assertEquals(expectedbuttontext, NivaGoActivefinalsymbol);
//                WebElement niva = driver.findElement(By.xpath(prop.getProperty("NivabuttonGoActive")));
//                niva.click();
//            }
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//        }
//        try {
//            NivaReasure2BronzePlus = driver.findElement(By.xpath(prop.getProperty("NivabuttonReasure2BronzePlus")));
//            String queryReasure2BronzePlus = "use HealthDB Select Premium  from Hi.Health_Rates nolock where Plan_Id=46547 and SumInsured=500000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and Term = 1";
//            ResultSet res1 = stmt.executeQuery(queryReasure2BronzePlus);
//            while (res1.next()) {
//                System.out.println("premium value from DB " + res1.getString(1));
//                String Reasure2BronzePlustext;
//                Reasure2BronzePlustext = NivaReasure2BronzePlus.getText();
//                String NivaReasure2BronzePlussymbol1 = Reasure2BronzePlustext.replaceAll("₹", "");
//                String NivaReasure2BronzePlussymbol2 = NivaReasure2BronzePlussymbol1.replaceAll("/year", "");
//                String NivaReasure2BronzePlusfinalsymbol = NivaReasure2BronzePlussymbol2.replaceAll(",", "");
//                System.out.println("premium value from nivareasure UI = " + NivaReasure2BronzePlusfinalsymbol);
//                String expectedbuttontext = res1.getString(1);
//                junit.framework.Assert.assertEquals(expectedbuttontext, NivaReasure2BronzePlusfinalsymbol);
//                WebElement niva = driver.findElement(By.xpath(prop.getProperty("NivabuttonReasure2BronzePlus")));
//                niva.click();
//            }
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//        }
//        try {
//            NivaArogyaSanjeevani = driver.findElement(By.xpath(prop.getProperty("NivabuttonArogyaSanjeevani")));
//            String queryArogyaSanjeevani = "use HealthDB Select Premium  from Hi.Health_Rates nolock where Plan_Id=592 and SumInsured=500000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and Term = 1";
//            ResultSet res1 = stmt.executeQuery(queryArogyaSanjeevani);
//            while (res1.next()) {
//                System.out.println("premium value from DB " + res1.getString(1));
//                String ArogyaSanjeevanitext;
//                ArogyaSanjeevanitext = NivaArogyaSanjeevani.getText();
//                String NivaArogyaSanjeevanisymbol1 = ArogyaSanjeevanitext.replaceAll("₹", "");
//                String NivaArogyaSanjeevanisymbol2 = NivaArogyaSanjeevanisymbol1.replaceAll("/year", "");
//                String NivaArogyaSanjeevanifinalsymbol = NivaArogyaSanjeevanisymbol2.replaceAll(",", "");
//                System.out.println("premium value from nivareasure UI = " + NivaArogyaSanjeevanifinalsymbol);
//                String expectedbuttontext = res1.getString(1);
//                junit.framework.Assert.assertEquals(expectedbuttontext, NivaArogyaSanjeevanifinalsymbol);
//                WebElement niva = driver.findElement(By.xpath(prop.getProperty("NivabuttonArogyaSanjeevani")));
//                niva.click();
//            }
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//        }
    }
    @And("^click on premium button of NivaBupa$")
    public void clickOnpremiumButtonOfNivaBupa() throws InterruptedException, SQLException {
        validatePremiumButtonText();
        Thread.sleep(3000L);
    }
    @And("^click on proceed to proposal page$")
    public void clickOnProceedToProposalPage() throws InterruptedException {
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
        Assert.assertNotEquals(beforerider, premiumvalue1.getText());
        driver.findElement(By.xpath(prop.getProperty("proceedtoproposal"))).click();
    }

    @And("^Enter spouse age through edit member$")
    public void enterSpouseAgeThroughEditMember() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Edit Members')]")).click();
        Thread.sleep(5000L);
        Select spouseage = new Select(driver.findElement(By.xpath("(//div[@class='select_members_age']//select)[2]")));
        spouseage.selectByValue("30");
        driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();
    }

    @And("^Enter the details on proposer details screen \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailsOnProposerDetailsScreen(String panCard, String address, String contactEmail, String emergencyMobile) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@id='pan']")).sendKeys(panCard);
        driver.findElement(By.xpath("//input[@id='addressLine1']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(contactEmail);
        driver.findElement(By.xpath("//input[@id='emergencyMobile']")).sendKeys(emergencyMobile);
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO MEMBER SECTION')]")).click();

    }

    @And("^Enter the details on member details screen \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
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

    @And("^Enter the details on medical screen$")
    public void enterTheDetailsOnMedicalScreen() {
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
    }

    @And("^Enter the details on Nominee page$")
    public void enterTheDetailsOnNomineePage() throws InterruptedException {
        Thread.sleep(5000L);
        driver.navigate().refresh();
        WebElement childElement1 = driver.findElement(By.xpath("(//div[@class='InputLabelBox'])[1]"));
        JavascriptExecutor jse4 = (JavascriptExecutor) driver;
        jse4.executeScript("arguments[0].scrollIntoView()", childElement1);
        jse4.executeScript("arguments[0].click();", childElement1);

        driver.findElement(By.xpath("//button[contains(text(),'REVIEW & PAY')]")).click();
    }
    @And("^check the Declaration popup$")
    public void checkTheDeclarationPopup() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='declarationInput']")).click();
        driver.findElement(By.xpath("//button[@class='btn zuno']")).click();
        Thread.sleep(10000L);
    }
    @And("^move to the POSP parent portal$")
    public void moveToThePOSPParentPortal() {
        driver.close();
        driver.switchTo().window(parent);
    }
    @And("^click on the Lead tab$")
    public void clickOnTheLeadTab() {
        WebElement element = driver.findElement(By.xpath("//a//span[contains(text(),'Lead')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", element);
        jse2.executeScript("arguments[0].click();", element);
    }
    @And("^verify the Lead ID from UI and DB$")
    public void verifyTheLeadIDFromUIAndDB() {
        try {
            String query = "use PospDB select top(1) LeadID from dbo.LeadDetails_v1 where productID = 190 and name like '%Test Automation%' order by LeadID desc";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.println("leadId value from DB " + res.getString(1));
                Thread.sleep(3000L);
                List<WebElement> leadId = driver.findElements(By.xpath("(//span[@class='leadid'])[1]"));
                for (WebElement e : leadId) {
                    System.out.println("Lead Id value from UI " + e.getText());
                    String leadValue = res.getString(1);
                    junit.framework.Assert.assertEquals("LEAD ID: " + leadValue, e.getText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @And("^click on Continue button from Lead section$")
    public void clickOnContinueButtonFromLeadSection() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(),'Continue ')])[1]")).click();
        Thread.sleep(5000L);
    }
    @And("^click on proceed to payment page$")
    public void clickOnProceedToPaymentPage() {
        parent = driver.getWindowHandle();
        for (String child : driver.getWindowHandles()) {
            if (!parent.contentEquals(child)) {
                driver.switchTo().window(child);
                break;
            }
        }

//        driver.navigate().refresh();
//        WebElement childElement1 = driver.findElement(By.xpath("//button[@class='btn']"));
//        JavascriptExecutor jse4 = (JavascriptExecutor) driver;
//        jse4.executeScript("arguments[0].scrollIntoView()", childElement1);
//        jse4.executeScript("arguments[0].click();", childElement1);
        driver.findElement(By.xpath("//button[@class='btn']")).click();
       // new WebDriverWait(driver, 30).until(ExpectedConditions.pre(By.xpath("//button[@class='btn']"))).click();
    }
}






