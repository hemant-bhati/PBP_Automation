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
import java.sql.SQLException;
import java.util.List;


public class NivaHealthCompanionStepdefs extends TestBase {
    Select dropdownAge;
    String parent;
    String premiumofproposalpage;

    @When("^Click on the sell now button$")
    public void clickOnSellNowModulesIcon() throws InterruptedException {
        Thread.sleep(10000L);
        driver.findElement(By.xpath(prop.getProperty("sellnowbutton"))).click();
    }

    @When("^Click on the Health Module$")
    public void clickOnTheHealthModule() throws InterruptedException {
        Thread.sleep(1500);

        WebElement childElement = driver.findElement(By.xpath("//div[@class='col-lg-2 col-md-4 col-sm-4 item']//p[contains(text(),'Health')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
    }

    @And("^Enter the detail on Health page \"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailOnHealthPage(String FullName, String MobileNo) throws Throwable {
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

    @Then("^user should be able to navigate member detail$")
    public void userShouldBeAbleToNavigateMemberDetail() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "PolicyBazaar Health Insurance: Get a 5 Lac health plan @Rs. 373/Month";
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Actual title is " + actualTitle);
    }

    @And("^user should enter the details on the member screen \"([^\"]*)\",\"([^\"]*)\"$")
    public void userShouldEnterTheDetailsOnTheMemberScreen(String eldestmemberage, String eldestchildage) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("2Adult+1Kid")))).click();
        WebElement age1 = driver.findElement(By.xpath(prop.getProperty("eldestmemberagexpath")));
        dropdownAge = new Select(age1);
        dropdownAge.selectByValue(eldestmemberage);

        WebElement age2 = driver.findElement(By.xpath(prop.getProperty("eldestchildage")));
        dropdownAge = new Select(age2);
        dropdownAge.selectByValue(eldestchildage);

        driver.findElement(By.xpath(prop.getProperty("ContinueButton2"))).click();


    }

    @And("^User should be able to select City Name \"([^\"]*)\"$")
    public void userShouldBeAbleToSelectCityName(String city) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement selectCity = driver.findElement(By.xpath(prop.getProperty("selectcity")));
        selectCity.sendKeys(city);
        selectCity.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(prop.getProperty("continueofselectcity"))).click();
    }

    @And("^select existing illness and click on View Plan checkbox$")
    public void selectExistingIllnessAndClickOnViewPlanCheckbox() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Noneofthese"))).click();
        Thread.sleep(5000L);
    }

    @And("^Enter the spouse age through edit member on the quote page$")
    public void enterTheSpouseAgeThroughEditMemberOnTheQuotePage() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Edit Members')]")).click();
        Thread.sleep(5000L);
        Select spouseage = new Select(driver.findElement(By.xpath("(//div[@class='select_members_age']//select)[2]")));
        spouseage.selectByValue("30");
    }

    @And("^Enter ChildRelationship through the edit members$")
    public void enterChildRelationshipThroughTheEditMembers() throws InterruptedException {
        Thread.sleep(5000L);
        Select relationshipSelect = new Select(driver.findElement(By.xpath("(//div[@class='select_members_age child_dropdown']//select)[1]")));
        relationshipSelect.selectByValue("8");
        new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Apply')]"))).click();

//        driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();
    }

    @And("^click on cover ammount dorp down button$")
    public void clickOnCoverAmmountDorpDownButton() {
        driver.findElement(By.xpath(prop.getProperty("coverammountbutton"))).click();
    }

    @And("^Select the (\\d+)\\.(\\d+) lakhs suminsurred$")
    public void selectTheLakhsSuminsurred(int arg0, int arg1) {
        driver.findElement(By.xpath(prop.getProperty("10lakhcoverAmmount"))).click();
    }

    @And("^Click on Apply button$")
    public void clickOnApplyButton() {

        driver.findElement(By.xpath(prop.getProperty("Applybutton"))).click();
    }

    @And("^click on the premium button of healthcompanion of niva$")
    public void clickOnThePremiumButtonOfHealthcompanionOfNiva() throws InterruptedException {
        validateHealthCampanionPremiumButtonText();
        Thread.sleep(3000L);
    }


    public void validateHealthCampanionPremiumButtonText() {
        try {
            boolean healthCompanionFound = false;

            // Check if the "Health Companion" text is found on the page
            while (!healthCompanionFound) {
                boolean isTextPresent = (boolean) ((JavascriptExecutor) driver).executeScript(
                        "return document.body.innerText.includes('Health Companion');"
                );

                if (isTextPresent) {
                    healthCompanionFound = true;
                } else {
                    // Scroll the page down
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
                    Thread.sleep(1000); // Adjust the sleep duration as needed
                }
            }

            WebElement nivaHealthCompanion = driver.findElement(By.xpath(prop.getProperty("NivabuttonHealthCompanion")));

            // Check the value of the "env" property
            if (prop.getProperty("env").equalsIgnoreCase("qa")) {
                // Execute the query
                String queryNivaCompanion = "use HealthDB Select top 1 Premium from Hi.Health_Rates nolock where Plan_Id=319 and SumInsured=750000 and NumberOfAdults=2 and NumberOfChildren=1 and Max_AgeOfEldestMember=35 and Term = 1 and CityGroup_Id=21";
                ResultSet res1 = stmt.executeQuery(queryNivaCompanion);

                while (res1.next()) {
                    System.out.println("premium value from DB " + res1.getString(1));
                    String nivaCompaniontext = nivaHealthCompanion.getText();
                    String Companionsymbol1 = nivaCompaniontext.replaceAll("₹", "");
                    String Companionsymbol2 = Companionsymbol1.replaceAll("/year", "");
                    String Companionfinalsymbol = Companionsymbol2.replaceAll(",", "");
                    System.out.println("premium value from nivacompanion UI = " + Companionfinalsymbol);
                    String expectedbuttontext = res1.getString(1);
                    junit.framework.Assert.assertEquals(expectedbuttontext, Companionfinalsymbol);
                    nivaHealthCompanion.click();
                }
            } else {
                // Execute a different action when "env" is not "qa"
                nivaHealthCompanion.click();
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Handle element not found exception
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


        @And("^click on the proceed to proposal Page after adding rider$")
            public void clickOnTheProceedToProposalPageAfterAddingRider() throws InterruptedException {

                WebElement premiumvalue = driver.findElement(By.xpath("//div[@class='flexRow section_premium']//div//span"));
                System.out.println("*****Premium value before adding rider*****" + premiumvalue.getText());
                String beforerider = premiumvalue.getText();
                WebElement rider1 = null;
                try {
                    rider1 = driver.findElement(By.xpath("//div[@class='flexRow row sp-rider dailyAllowanceRider']//div[2]//button"));
                    rider1.click();
                } catch (Exception e) {
                    e.getMessage();
                }


                Thread.sleep(5000L);
                WebElement premiumvalue1 = driver.findElement(By.xpath("//div[@class='flexRow section_premium']//div//span"));
                System.out.println("*****Premium value after adding rider*****" + premiumvalue1.getText());
                Assert.assertNotEquals(beforerider, premiumvalue1.getText());
                driver.findElement(By.xpath(prop.getProperty("proceedtoproposal"))).click();
            }

            @And("^Enter details on proposer details screen \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
            public void enterDetailsOnProposerDetailsScreen(String panCard, String address, String contactEmail, String emergencyMobile) throws Throwable {
                // Write code here that turns the phrase above into concrete actions
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

            @And("^Enter details of the member on member details screen \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
            public void enterDetailsOfTheMemberOnMemberDetailsScreen(String dob, String occupation, String heightFeet, String heightInch, String weight, String spouseName, String spouseDOB, String spouseOccupation, String spouseHeightFeet, String spouseHeightInch, String spouseWeight) throws Throwable {
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

            }

            @And("^Enter Details of the child on the member details Screen \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
            public void enterDetailsOfTheChildOnTheMemberDetailsScreen(String childName, String childdob, String childHeightFeet, String childHeightInch, String childweight) throws Throwable {
                // Write code here that turns the phrase above into concrete actions
                driver.findElement(By.xpath("(//input[@name='name'])[3]")).sendKeys(childName);
                driver.findElement(By.xpath("(//input[@name='dob'])[3]")).sendKeys(childdob);
                WebElement childHeightFt = driver.findElement(By.xpath("(//div[@class='fieldBlockProposal select_proposal']/div/select)[7]"));
                Select dropdownchildHeightFeet = new Select(childHeightFt);
                dropdownchildHeightFeet.selectByValue(childHeightFeet);
                WebElement childHeightIn = driver.findElement(By.xpath("(//div[@class='fieldBlockProposal select_proposal']/div/select)[8]"));
                Select dropdownchildHeightInch = new Select(childHeightIn);
                dropdownchildHeightInch.selectByValue(childHeightInch);
                driver.findElement(By.xpath("(//input[@name='weight'])[3]")).sendKeys(childweight);
                driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO MEDICAL QUESTIONS')]")).click();
            }

            @And("^Enter details of medical question on medical screen$")
            public void enterDetailsOfMedicalQuestionOnMedicalScreen() throws InterruptedException {
                Thread.sleep(10000L);

                Actions action = new Actions(driver);
                WebElement childElement = driver.findElement(By.xpath("(//div[@class='optionsModule'])[4]"));
                action.moveToElement(childElement).click().perform();

                action = new Actions(driver);
                WebElement childElement1 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[8]"));
                action.moveToElement(childElement1).click().perform();

                action = new Actions(driver);
                WebElement childElement2 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[12]"));
                action.moveToElement(childElement2).click().perform();

                action = new Actions(driver);
                WebElement childElement3 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[16]"));
                action.moveToElement(childElement3).click().perform();

                action = new Actions(driver);
                WebElement childElement4 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[20]"));
                action.moveToElement(childElement4).click().perform();

                action = new Actions(driver);
                WebElement childElement5 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[24]"));
                action.moveToElement(childElement5).click().perform();

                action = new Actions(driver);
                WebElement childElement6 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[28]"));
                action.moveToElement(childElement6).click().perform();

                action = new Actions(driver);
                WebElement childElement7 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[32]"));
                action.moveToElement(childElement7).click().perform();

                action = new Actions(driver);
                WebElement childElement8 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[36]"));
                action.moveToElement(childElement8).click().perform();

                action = new Actions(driver);
                WebElement childElement9 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[40]"));
                action.moveToElement(childElement9).click().perform();

                action = new Actions(driver);
                WebElement childElement10 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[44]"));
                action.moveToElement(childElement10).click().perform();

                action = new Actions(driver);
                WebElement childElement11 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[48]"));
                action.moveToElement(childElement11).click().perform();

                action = new Actions(driver);
                WebElement childElement12 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[52]"));
                action.moveToElement(childElement12).click().perform();

                action = new Actions(driver);
                WebElement childElement13 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[56]"));
                action.moveToElement(childElement13).click().perform();

                action = new Actions(driver);
                WebElement childElement14 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[60]"));
                action.moveToElement(childElement14).click().perform();

                action = new Actions(driver);
                WebElement childElement15 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[64]"));
                action.moveToElement(childElement15).click().perform();

                action = new Actions(driver);
                WebElement childElement16 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[68]"));
                action.moveToElement(childElement16).click().perform();

                action = new Actions(driver);
                WebElement childElement17 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[72]"));
                action.moveToElement(childElement17).click().perform();

                action = new Actions(driver);
                WebElement childElement18 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[76]"));
                action.moveToElement(childElement18).click().perform();

                action = new Actions(driver);
                WebElement childElement19 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[80]"));
                action.moveToElement(childElement19).click().perform();

                action = new Actions(driver);
                WebElement childElement20 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[84]"));
                action.moveToElement(childElement20).click().perform();

                WebElement highestQualification = driver.findElement(By.xpath("(//div[@class='field']/select)[1]"));
                Select dropdownhighestQualification = new Select(highestQualification);
                dropdownhighestQualification.selectByIndex(2);
                dropdownhighestQualification.selectByValue("Graduate");

                WebElement highestQualificationSpouse = driver.findElement(By.xpath("(//div[@class='field']/select)[2]"));
                Select dropdownhighestQualificationSpouse = new Select(highestQualificationSpouse);
                dropdownhighestQualificationSpouse.selectByIndex(4);
                dropdownhighestQualificationSpouse.selectByValue("Matric");

                WebElement highestQualificationCh = driver.findElement(By.xpath("(//div[@class='field']/select)[3]"));
                Select dropdownhighestQualificationChild = new Select(highestQualificationCh);
                dropdownhighestQualificationChild.selectByIndex(5);
                dropdownhighestQualificationChild.selectByValue("Non-matric");

                action = new Actions(driver);
                WebElement childElement21 = driver.findElement(By.xpath("(//div[@class='optionsModule'])[88]"));
                action.moveToElement(childElement21).click().perform();

                driver.findElement(By.xpath("//button[@class=\"primaryButtonStyle btn\" and contains(text(), \"CONTINUE TO NOMINEE SECTION\")]")).click();
            }

            @And("^Enter details on The Nominee page$")
            public void enterDetailsOnTheNomineePage() throws InterruptedException {
                Thread.sleep(5000L);
                WebElement childElement1 = driver.findElement(By.xpath("(//div[@class='InputLabelBox'])[1]"));
                JavascriptExecutor jse4 = (JavascriptExecutor) driver;
                jse4.executeScript("arguments[0].scrollIntoView()", childElement1);
                jse4.executeScript("arguments[0].click();", childElement1);

                Actions action = new Actions(driver);
                WebElement childElement = driver.findElement(By.xpath("//button[@class='primaryButtonStyle btn']"));
                action.moveToElement(childElement).click().perform();
            }

            @And("^check Declaration popup$")
            public void checkDeclarationPopup() throws InterruptedException {

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

            @And("^move the POSP parent portal$")
            public void moveThePOSPParentPortal() {
                driver.close();
                driver.switchTo().window(parent);
            }

            @And("^click the Lead tab$")
            public void clickTheLeadTab() {
                WebElement element = driver.findElement(By.xpath("//a//span[contains(text(),'Lead')]"));
                JavascriptExecutor jse2 = (JavascriptExecutor) driver;
                jse2.executeScript("arguments[0].scrollIntoView()", element);
                jse2.executeScript("arguments[0].click();", element);
            }

            @And("^verify Lead ID from UI and DB$")
            public void verifyLeadIDFromUIAndDB() {
                try {
                    String query = "use PospDB select top(1) LeadID from dbo.LeadDetails_v1 where productID = 190 and name like '%Ankit sharma%' order by LeadID desc";
                    ResultSet res = stmt.executeQuery(query);
                    while (res.next()) {
                        System.out.println("leadId value from DB - " + res.getString(1));
                        Thread.sleep(3000L);
                        List<WebElement> leadId = driver.findElements(By.xpath(prop.getProperty("Companionleadidpage")));
                        for (WebElement e : leadId) {
                            System.out.println("Lead Id value from UI " + e.getText());
                            String leadValue = res.getString(1);
                            junit.framework.Assert.assertEquals("Lead Id - " + leadValue, e.getText());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @And("^click Continue button from Lead section$")
            public void clickContinueButtonFromLeadSection() throws InterruptedException {
                WebElement Childelement = driver.findElement(By.xpath(prop.getProperty("CompanionHowerbuttonleadpage")));
                Actions action = new Actions(driver);
                action.moveToElement(Childelement).build().perform();
                Thread.sleep(5000L);
                WebElement Childelement1 = driver.findElement(By.xpath(prop.getProperty("CompanionContinueLeadpagebutton")));
                if (Childelement1.isDisplayed()) {
                    Childelement1.click();

                }
            }

            @And("^click proceed to payment page$")
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

            @And("^navigate payment page and fill all mandatory entries$")
            public void navigatePaymentPageAndFillAllMandatoryEntries() throws InterruptedException {
                Thread.sleep(50000l);
                driver.findElement(By.xpath("(//div[@class='selectBank'])[1]")).click();
                driver.findElement(By.xpath("//button[@class=\"btn\" and @id=\"paynb\"]")).click();
                driver.findElement(By.xpath("//button[@data-val=\"S\" and @class=\"success\"]")).click();
                Thread.sleep(20000L);
                driver.navigate().refresh();
            }

        }




        //It will wait for maximum of 10sec for each object
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        //Identify the xpath of the object.
//        WebElement element = driver.findElement(By.xpath(prop.getProperty("NivabuttonHealthCompanion")));
//        //scrollIntoView will help us to scroll to the Sign-up button
//                js.executeScript("arguments[0].scrollIntoView();",element);










