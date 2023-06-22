package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HealthJourneyDef extends TestBase {

    String parent;


    public HealthJourneyDef() throws IOException {
    }





    @Then("^Clicks on the send otp button in login page$")
    public void clicksOnTheSendOtpButtonInLoginPage() {
        driver.findElement(By.xpath("//button[@id='send-otp-id']")).click();

    }

    @Then("^enter the generated otp numbers$")
    public void enterTheGeneratedOtpNumbers() {
        if (prop.getProperty("env").equalsIgnoreCase("prod")) {
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox1']"))).sendKeys(prop.getProperty("OTP1"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox2']"))).sendKeys(prop.getProperty("OTP2"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox3']"))).sendKeys(prop.getProperty("OTP3"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox4']"))).sendKeys(prop.getProperty("OTP4"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox5']"))).sendKeys(prop.getProperty("OTP5"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox6']"))).sendKeys(prop.getProperty("OTP6"));
        }else{
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox1']"))).sendKeys(prop.getProperty("QaOTP1"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox2']"))).sendKeys(prop.getProperty("QaOTP2"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox3']"))).sendKeys(prop.getProperty("QaOTP3"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox4']"))).sendKeys(prop.getProperty("QaOTP4"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox5']"))).sendKeys(prop.getProperty("QaOTP5"));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox6']"))).sendKeys(prop.getProperty("QaOTP6"));
        }
    }

    @Then("^Click on verify otp buttons$")
    public void clickOnVerifyOtpButtons() throws IOException, InterruptedException {
        String expectedTitle = "PBPartners | Dashboard";
        driver.findElement(By.xpath(prop.getProperty("VerifyOTPbutton"))).click();
//        Assert.assertEquals(driver.getTitle(), expectedTitle);
//        Thread.sleep(1000l);
//        Robot robot;
//         try {
//        robot = new Robot();
//         org.openqa.selenium.Dimension i = driver.manage().window().getSize();
//         System.out.println("Dimension x and y :"+i.getWidth()+" "+i.getHeight());
//         int x = (i.getWidth()/4)+100;
//         int y = (i.getHeight()/10)+500;
//         robot.mouseMove(x,y);
//         robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//         robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        System.out.println("Browse button clicked");
//         System.out.println("Removed the handle by clicking on (500,500)");
//             } catch (AWTException e) {
//        // TODO Auto-generated catch block
//         e.printStackTrace();
//    }


    }

    @Given("^Click on the Health button$")
    public void clickOnTheHealthButton() throws IOException, InterruptedException {
        Thread.sleep(2500);

        WebElement childElement = driver.findElement(By.xpath("//div[@class='col-lg-2 col-md-4 col-sm-4 item']//p[contains(text(),'Health')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
//        childElement.click();
//        driver.findElement(By.xpath("//em[contains(text(),'Female')]")).click();

////        driver.findElement(By.xpath("//div[@class='col-lg-2 col-md-4 col-sm-4']//small[contains(text(),'Health')]")).click();
//        String parent = driver.getWindowHandle();
//        String expectedTitle = "PBPartners | Dashboard";
//        for (String child : driver.getWindowHandles()) {
//            if (!parent.contentEquals(child)) {
//                driver.switchTo().window(child);
//                break;
//            }
    }


    @When("^Enter the Partner Code$")
    public void enterThePartnerCode() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        if (prop.getProperty("env").equalsIgnoreCase("prod")) {
            driver.findElement(By.xpath("//input[@id='user']")).sendKeys(prop.getProperty("IPCodeProd"));
        }else{
            driver.findElement(By.xpath("//input[@id='user']")).sendKeys(prop.getProperty("IPCodeQA"));
        }
    }

    @Then("^Enter the details Health landing page$")
    public void enterTheDetailsHealthLandingPage() throws InterruptedException {
        WebElement icon = driver.findElement(By.xpath("//em[contains(text(),'Female')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", icon);
        jse2.executeScript("arguments[0].click();", icon);
//        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//em[contains(text(),'Female')]"))).click();
//         driver.findElement(By.xpath("//em[contains(text(),'Female')]")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("fullname"))).sendKeys("Automation Script");
        //  driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("Neha gupta");
        driver.findElement(By.xpath("//input[@id='pmobile']")).sendKeys("8976789876");
        driver.findElement(By.xpath("//input[@id='continuecta1']")).click();
    }

    @Then("^Verify the title of Health journey landing page$")
    public void verifyTheTitleOfHealthJourneyLandingPage() {
        String parent = driver.getWindowHandle();
        String expectedTitle = "PBPartners | Sell Now";
        for (String child : driver.getWindowHandles()) {
            if (!parent.contentEquals(child)) {
                driver.switchTo().window(child);
                break;
            }

            Assert.assertEquals(expectedTitle, driver.getTitle());
        }
    }

    @Then("^select combination and age$")
    public void selectCombinationAndAge() {
        driver.findElement(By.xpath("//i[@class='gender self']")).click();
        WebElement age = driver.findElement(By.xpath("//select[@id='eldestMemberAge']"));
        Select dropdownAge = new Select(age);
        dropdownAge.selectByValue("26");
        driver.findElement(By.xpath("//input[@id='continuecta2']")).click();

    }

    @Then("^Enter the State$")
    public void enterTheState() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Delhi')]")).click();
        Thread.sleep(3000l);
    }

    @Then("^Choose Existing illness$")
    public void chooseExistingIllness() {
        driver.findElement(By.xpath("//input[@id='ped_last']")).click();
    }

    @Then("^choose quote from the list$")
    public void chooseQuoteFromTheList() {
        List<WebElement> button = driver.findElements(By.xpath("//div[@id='ProceedToProduct']"));
        button.get(0).click();

    }

    @Then("^click on proceed to proposal$")
    public void clickOnProceedToProposal() throws InterruptedException {

        Thread.sleep(10000L);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button']"))).click();
        // WebElement input = driver.findElement(By.xpath("//button[@type='button']"));
//casting a driver instance into JavascriptExecutor instance
        //JavascriptExecutor js = (JavascriptExecutor) driver;
//set the dropdown value to 'Sam Winchester' using javascript
        //js.executeScript("arguments[0].click();", button);
//           for(int i=0; i<=2;i++) {
//               try {
//                   WebElement element = driver.findElement(By.xpath("//button[@type='button']"));
////                   element.click();
////                JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//////                jse2.executeScript("arguments[0].scrollIntoView()", element);
////                jse2.executeScript("arguments[0].click();", element);
//                new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='button']"))).click();
//                   break;
//               } catch (Exception e) {
//                   System.out.println(e.getMessage());
//               }
//           }
    }

    @Then("^Fill Proposal form$")
    public void fillProposalForm() throws InterruptedException {
//       System.out.println(icon.size());
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'PAN Card')]"))).sendKeys("NXAPS9876S");
        Thread.sleep(5000l);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("pan"))).sendKeys("NXAPS9876S");
        //  driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("Neha gupta");
        driver.findElement(By.xpath("//input[@id='addressLine1']")).sendKeys("Delhi Delhi");
        driver.findElement(By.xpath("//input[@id='addressLine2']")).sendKeys("New Delhi");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nehagupta@pbpartners.com");
        driver.findElement(By.xpath("//input[@id='emergencyMobile']")).sendKeys("9090908765");
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO MEMBER SECTION')]")).click();
    }

    @Then("^fill member details$")
    public void fillMemberDetails() throws InterruptedException {
        Thread.sleep(5000l);
        driver.findElement(By.name("dob")).sendKeys("02-12-1999");
        List<WebElement> occupation = driver.findElements(By.xpath("//div[@class='field']//select"));
        Select occuption = new Select(occupation.get(0));
        occuption.selectByValue("1");

        Select heightdropdown = new Select(occupation.get(1));
        heightdropdown.selectByValue("60");

        Select inchesdropdown = new Select(occupation.get(2));
        inchesdropdown.selectByValue("3");

//        List<WebElement> weightkg = driver.findElements(By.xpath("//input[@label='Weight (KG)']"));
//        Select weight = new Select(occupation.get());
//        weight.selectByValue("58");

        driver.findElement(By.xpath("//input[@label='Weight (KG)']")).sendKeys("58");
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO MEDICAL QUESTIONS')]")).click();


    }

    @Then("^choose medical questions$")
    public void chooseMedicalQuestions() {
        List<WebElement> notapplicable = driver.findElements(By.xpath("//div[contains(text(),'Not Applicable')]"));
        System.out.println(notapplicable.size());
        notapplicable.get(0).click();
        notapplicable.get(1).click();
        notapplicable.get(2).click();
        notapplicable.get(3).click();
        notapplicable.get(4).click();
        notapplicable.get(5).click();
        notapplicable.get(6).click();
        WebElement eduQualification = driver.findElement(By.xpath("//div[@class='field']//select"));
        Select eduDropdown = new Select(eduQualification);
        eduDropdown.selectByValue("POSTGRADUATE");
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE TO NOMINEE SECTION')]")).click();


    }

    @Then("^fill the nominee section$")
    public void fillTheNomineeSection() {

        for (int i = 0; i <= 2; i++) {
            try {
                WebElement relationship = driver.findElement(By.xpath("//div[@class='field']//select"));
                Select relationshipDropdown = new Select(relationship);
                relationshipDropdown.selectByValue("98");

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']"))).sendKeys("Mother Name");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='dob']"))).sendKeys("05/01/1970");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='primaryButtonStyle btn']"))).click();
        WebElement element = driver.findElement(By.xpath("//button[@class='primaryButtonStyle btn']"));
//        element.click();
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().build().perform();
//    driver.findElement(By.xpath("//button[@class='primaryButtonStyle btn']")).click();
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", element);
        jse2.executeScript("arguments[0].click();", element);


    }

    @Then("^Accept declaration pop-up$")
    public void acceptDeclarationPopUp() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//input[@id='declarationInput']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE')]")).click();
        Thread.sleep(10000L);

//        get the full name of this page
//        close the tab
//        switch to parent window
//        Click on lead tab
        List<WebElement> fullName = driver.findElements(By.xpath("//p[@class='colValue']"));

        String actualFullName = fullName.get(0).getText();
        System.out.println("actualFullName is" + actualFullName);

        Thread.sleep(5000L);


    }


    @Then("^click on proceed to payment button$")
    public void clickOnProceedToPaymentButton() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//button[@class='btn']"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", element);
        jse2.executeScript("arguments[0].click();", element);
    }

    @Then("^get full name details$")
    public void getFullNameDetails() {

    }

    @Then("^click on Lead navigation$")
    public void clickOnLeadNavigation() {
        WebElement element = driver.findElement(By.xpath("//a//span[contains(text(),'Lead')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", element);
        jse2.executeScript("arguments[0].click();", element);
        test();
        List<WebElement> fullName = driver.findElements(By.xpath("//h2[@class='insurer-name']"));
        for (int i = 0; i < fullName.size(); i++) {
            if (fullName.get(i).getText().contains("Neha Gupta")) {
                driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
                break;
            }
        }

    }

//    @Then("^click on Request Offline Quote navigation$")
//    public void clickOnRequestOfflineQuoteNavigation() throws InterruptedException {
//
//        driver.findElement(By.xpath("//a[@data-bs-toggle='collapse']")).click();
//        WebElement childElement = driver.findElement(By.xpath("//li[@data-sidenav='raise-mapping-request']"));
//        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
//        jse2.executeScript("arguments[0].click();", childElement);
//        childElement.click();
//        List<WebElement> productName = driver.findElements(By.xpath("//select[@id='product_id']"));
//        Select details = new Select(productName.get(0));
//        details.selectByValue("186");
//        driver.findElement(By.xpath("//input[@id='cust_name']")).sendKeys("Neha gupta");
//        driver.findElement(By.xpath("//input[@id='reg_num']")).sendKeys("RJ09CM8899");
//        WebElement insurer = driver.findElement(By.xpath("//select[@id='insurer_id']"));
//        Select insurerdropdown = new Select(insurer);
//        insurerdropdown.selectByValue("4");
//        driver.findElement(By.xpath("//input[@id='policy_number']")).sendKeys("tax4544044");
//        driver.findElement(By.xpath("//input[@id='premium']")).sendKeys("5000");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        // identify element
//        WebElement l=driver.findElement(By.xpath("//input[@id='file1']"));
//        // file path passed with sendkeys()
//        l.sendKeys("C:\\Users\\NehaGupta\\Desktop\\Backup folder\\Download data\\43400916.pdf");
//        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
//
//    }


    @When("^Enter the Partner Code \"([^\"]*)\"$")
    public void enterThePartnerCode(String arg0) throws Throwable {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(arg0);

    }

    @Then("^enter the generated otp numbers \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheGeneratedOtpNumbers(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox1']"))).sendKeys(arg0);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox2']"))).sendKeys(arg1);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox3']"))).sendKeys(arg2);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox4']"))).sendKeys(arg3);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox5']"))).sendKeys(arg4);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox6']"))).sendKeys(arg5);

    }

    @Then("^Enter the details Health landing page \"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailsHealthLandingPage(String arg0, String arg1) throws Throwable {
        driver.findElement(By.xpath("//em[contains(text(),'Female')]")).click();
//       System.out.println(icon.size());
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("fullname"))).sendKeys(arg0);
        //  driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("Neha gupta");
        driver.findElement(By.xpath("//input[@id='pmobile']")).sendKeys(arg1);
        driver.findElement(By.xpath("//input[@id='continuecta1']")).click();

    }

    @When("^Click on Sell now module$")
    public void clickOnSellNowModule() throws InterruptedException {
        Thread.sleep(350);
        driver.findElement(By.xpath("//li[@id='id-sellnow']")).click();
//        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
//        jse2.executeScript("arguments[0].scrollIntoView()", sellNow);
//        jse2.executeScript("arguments[0].click();", sellNow);
//        WebElement childElement = driver.findElement(By.xpath("//li[@id='id-sellnow']//a//span[@class='name']"));
    }

    //    Investment request
    @Given("^Click on the the New Offline investment Request$")
    public void clickOnTheTheNewOfflineInvestmentRequest() {
        driver.findElement(By.xpath(prop.getProperty("ClickOnRequestOfflineQuote"))).click();

    }

    @Then("^Click on the New Investment Request$")
    public void clickOnTheNewInvestmentRequest() {
        driver.findElement(By.xpath(prop.getProperty("ClickOnNewInvestmentOfflineRequest"))).click();
    }


    @When("^Select the Payment Frequency \"([^\"]*)\", \"([^\"]*)\"$")
    public void selectThePaymentFrequency(String paymentFrequency, String custOccupation) throws Throwable {
        Select frequency = new Select(driver.findElement(By.xpath(prop.getProperty("paymentFrequency"))));
        frequency.selectByValue(paymentFrequency);
        Select occuption = new Select(driver.findElement(By.xpath(prop.getProperty("custOccupation"))));
        occuption.selectByValue(custOccupation);
    }

    @When("^Enter the pincode \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void enterThePincode(String pincode, String DOB, String dateOBooking, String annualIncome) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("pincode"))).sendKeys(pincode);
        driver.findElement(By.xpath(prop.getProperty("DOB"))).sendKeys(DOB);
        driver.findElement(By.xpath(prop.getProperty("dateOBooking"))).sendKeys(dateOBooking);
        driver.findElement(By.xpath(prop.getProperty("annualIncome"))).sendKeys(annualIncome);
    }

    @When("^Enter the paymentpayingterm \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void enterThePaymentpayingterm(String PPT, String policyTerm, String sumAssured) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("PPT"))).sendKeys(PPT);
        driver.findElement(By.xpath(prop.getProperty("policyTerm"))).sendKeys(policyTerm);
        driver.findElement(By.xpath(prop.getProperty("sumAssured"))).sendKeys(sumAssured);
    }

    @When("^Enter the premium \"([^\"]*)\"$")
    public void enterThePremium(String premium) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("premium"))).sendKeys(premium);
    }

    @When("^Select gender$")
    public void selectGender() {
        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@name='gender']"));
        radioButton.get(Integer.parseInt(prop.getProperty("gender"))).click();
//        int size = radioButton.size();
//        for(int i = 0; i < size; i++) {
//            String val = radioButton.get(i);
//        }
//        WebElement gender = driver.findElement(By.name("gender"));
//        boolean gensel = gender.isSelected();
//        if(!gensel){
//            gender.click();
//        if (!gensel && gender.getText().contains("Male")) {
//            gender.click();
//        } else if (!gensel && gender.getText().contains("Female")) {
//            gender.click();
//        }
    }

    @When("^Select business type$")
    public void selectBusinessType() {
        WebElement businessType = driver.findElement(By.xpath(prop.getProperty("businessType")));
//        element.click();
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;

        jse2.executeScript("arguments[0].scrollIntoView()", businessType);
        jse2.executeScript("arguments[0].click();", businessType);

    }

    @Given("^Click on the Request Offline Quote$")
    public void clickOnTheRequestOfflineQuote() {
        driver.findElement(By.xpath(prop.getProperty("ClickOnRequestOfflineQuote"))).click();
    }

    @Then("^Click on the New Other Request$")
    public void clickOnTheNewOtherRequest() {
        WebElement childElement = driver.findElement(By.xpath(prop.getProperty("newOtherRequest")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
        childElement.click();
//        driver.findElement(By.xpath(prop.getProperty("newOtherRequest"))).click();
    }


    @When("^choose Policy Type$")
    public void choosePolicyType() {
    }

    @When("^Enter the customer name \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheCustomerName(String customerName, String customerEmail, String customerMobileNo) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("customerName"))).sendKeys(customerName);
        driver.findElement(By.xpath(prop.getProperty("customerEmail"))).sendKeys(customerEmail);
        driver.findElement(By.xpath(prop.getProperty("customerMobileNo"))).sendKeys(customerMobileNo);
    }

    @When("^Select gender \"([^\"]*)\"$")
    public void selectGender(String gender) throws Throwable {
//        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@name='gender']"));
//        radioButton.get(Integer.parseInt(prop.getProperty("gender"))).click();

        List<WebElement> genderSelected = driver.findElements(By.name("gender"));
        int size = genderSelected.size();
        for (int i = 0; i < size; i++) {
            String value = genderSelected.get(i).getAttribute("value");
            if (value.equals(gender)) {
                genderSelected.get(i).click();
                break;
            }

        }

//        boolean gensel = genderSelected.isSelected();
//        String text = genderSelected.getText();
//        System.out.println(text);
//        if (!gensel && genderSelected.getText().contains(gender)) {
//            genderSelected.click();
//
//        }
    }
    // Term Offline Request
    @Given("^Click on the the New Offline Term Request$")
    public void clickOnTheTheNewOfflineTermRequest() {
        driver.findElement(By.xpath(prop.getProperty("ClickOnRequestOfflineQuote"))).click();
    }

    @Then("^Click on the New Term Request$")
    public void clickOnTheNewTermRequest() {
        driver.findElement(By.xpath(prop.getProperty("clickOnNewTermOfflineRequest"))).click();
    }

    @When("^Enter mobile number \"([^\"]*)\"$")
    public void enterMobileNumber(String enterMobileNumber) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("enterMobileNumber"))).sendKeys(enterMobileNumber);
    }

    @When("^Enter pincode \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void enterPincode(String pincode, String DOB, String dateOBooking, String annualIncome) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("pincode"))).sendKeys(pincode);
        driver.findElement(By.xpath(prop.getProperty("DOB"))).sendKeys(DOB);
        driver.findElement(By.xpath(prop.getProperty("dateOBooking"))).sendKeys(dateOBooking);
        driver.findElement(By.xpath(prop.getProperty("annualIncome"))).sendKeys(annualIncome);
    }

    @When("^Enter paymentpayingterm \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void enterPaymentpayingterm(String PPT, String policyTerm, String sumAssured) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("PPT"))).sendKeys(PPT);
        driver.findElement(By.xpath(prop.getProperty("policyTerm"))).sendKeys(policyTerm);
        driver.findElement(By.xpath(prop.getProperty("sumAssured"))).sendKeys(sumAssured);

    }

    @When("^Enter premium \"([^\"]*)\"$")
    public void enterPremium(String premium) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("premium"))).sendKeys(premium);

    }

    @When("^Select  Payment Frequency \"([^\"]*)\", \"([^\"]*)\"$")
    public void selectPaymentFrequency(String paymentFrequency, String custOccupation) throws Throwable {
        Select frequency = new Select(driver.findElement(By.xpath(prop.getProperty("paymentFrequency"))));
        frequency.selectByValue(paymentFrequency);
        Select occuption = new Select(driver.findElement(By.xpath(prop.getProperty("custOccupation"))));
        occuption.selectByValue(custOccupation);
    }

    @When("^Select the gender$")
    public void selectTheGender() {
        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@name='gender']"));
        radioButton.get(Integer.parseInt(prop.getProperty("gender"))).click();
    }

    @When("^Select policy type \"([^\"]*)\"$")
    public void selectPolicyType(int policyType) throws Throwable {
        List<WebElement> policyType1 = driver.findElements(By.xpath(prop.getProperty("policyType")));
        policyType1.get(policyType);
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", policyType1.get(policyType));
        jse2.executeScript("arguments[0].click();", policyType1.get(policyType));


    }
//    DB Rule

    public void test() {
        try {
            String query = "select top(1) LeadID from dbo.LeadDetails_v1 where productID = 190 and name like '%automation%' order by LeadID desc";
// Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
// Print the result untill all the records are printed
// res.next() returns true if there is any next record else returns false
            while (res.next()) {
                System.out.println("leadId value from DB " + res.getString(1));
//                System.out.print(" " + res.getString(2));
//                System.out.print(" " + res.getString(3));
//                System.out.println(" " + res.getString(4));
                Thread.sleep(3000L);
                List<WebElement> leadId = driver.findElements(By.xpath("(//span[@class='leadid'])[1]"));

                for (WebElement e : leadId) {
                    System.out.println("Lead Id value from UI " + e.getText());
                    String leadValue = res.getString(1);
                    Assert.assertEquals("LEAD ID: " + leadValue, e.getText());
//                Assert.assertEquals(res.getString(1),1234);
                }
            }
//            List<WebElement> leadId = driver.findElements(By.xpath("//span[@class='leadid']"));
//            for(WebElement e:leadId){
//              String leadValue=  res.getString(1);
//                Assert.assertEquals(leadValue,e.getText());
////                Assert.assertEquals(res.getString(1),1234);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @When("^Select Insurer \"([^\"]*)\"$")
    public void selectInsurer(String insurerDropdown) throws Throwable {
        Select insurer = new Select(driver.findElement(By.xpath(prop.getProperty("insurerDropdown"))));
        insurer.selectByVisibleText(insurerDropdown);
    }


    @When("^Select Plan name \"([^\"]*)\"$")
    public void selectPlanName(String planName) throws Throwable {
        Select plan = new Select(driver.findElement(By.xpath(prop.getProperty("planName"))));
        plan.selectByVisibleText(planName);
    }


    @When("^Click on Request quote button$")
    public void clickOnRequestQuoteButton() {
        WebElement childElement = driver.findElement(By.xpath("//button[contains(text(),'Request Quote')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
    }

    @When("^Select number of adults \"([^\"]*)\"$")
    public void selectNumberOfAdults(String adullts) throws Throwable {
        Select noofadults = new Select(driver.findElement(By.xpath(prop.getProperty("adullts"))));
        noofadults.selectByVisibleText(adullts);

    }

    @When("^Select number of children \"([^\"]*)\"$")
    public void selectNumberOfChildren(String children) throws Throwable {
        Select noofchild = new Select(driver.findElement(By.xpath(prop.getProperty("children"))));
        noofchild.selectByVisibleText(children);
    }

    @When("^Select Eldest member age \"([^\"]*)\"$")
    public void selectEldestMemberAge(String memberage) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("memberage"))).sendKeys(memberage);
    }

    @When("^select Product type \"([^\"]*)\"$")
    public void selectProductType(String productType) throws Throwable {
        Select proType = new Select(driver.findElement(By.xpath(prop.getProperty("productType"))));
        proType.selectByVisibleText(productType);

    }

    @When("^Select Policy Type \"([^\"]*)\"$")
    public void selectPolicyType(Integer otherPolicyType) throws Throwable {
        List<WebElement> otherpol = driver.findElements(By.xpath(prop.getProperty("otherPolicyType")));
        otherpol.get(otherPolicyType);
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", otherpol.get(otherPolicyType));
        jse2.executeScript("arguments[0].click();", otherpol.get(otherPolicyType));
    }

    @When("^Enter the customer name \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void enterTheCustomerName(String insuredName, String custEmail, String custMobileNo, String customerAddress, String postcode) throws Throwable {
        Thread.sleep(5000l);
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("insuredName"))).click();
        driver.findElement(By.xpath(prop.getProperty("insuredName"))).sendKeys(insuredName);
        driver.findElement(By.xpath(prop.getProperty("custEmail"))).sendKeys(custEmail);
        driver.findElement(By.xpath(prop.getProperty("custMobileNo"))).sendKeys(custMobileNo);
        driver.findElement(By.xpath(prop.getProperty("customerAddress"))).sendKeys(customerAddress);
        driver.findElement(By.xpath(prop.getProperty("postcode"))).sendKeys(postcode);

    }

    @When("^select Sum insured and address \"([^\"]*)\", \"([^\"]*)\"$")
    public void selectSumInsuredAndAddress(String SI, String Address) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("SI"))).sendKeys(SI);
        driver.findElement(By.xpath(prop.getProperty("Address"))).sendKeys(Address);
    }

    @When("^Select Occupancies \"([^\"]*)\"$")
    public void selectOccupancies(String Occupancies) throws Throwable {
        Select occupan = new Select(driver.findElement(By.xpath(prop.getProperty("Occupancies"))));
        occupan.selectByVisibleText(Occupancies);
//        WebElement l = driver.findElement(By.xpath("//label[contains(text(),'Previous Year Policy')"));
//        // file path passed with sendkeys()
//        l.sendKeys("C:\\Users\\NehaGupta\\Desktop\\Backup folder\\Download data\\43400916.pdf");
//        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
//        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
//        jse2.executeScript("arguments[0].scrollIntoView()", submitButton);
//        jse2.executeScript("arguments[0].click();", submitButton);
        Thread.sleep(50000l);
    }

    @When("^Click on proceed button$")
    public void clickOnProceedButton() {
        WebElement childElement = driver.findElement(By.xpath("//input[@id='submit-button']"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
//        driver.findElement(By.xpath("//input[@id='submit-button']")).click();
//        policy upload = //label[contains(text(),'Previous Year Policy')]
    }

    @When("^Enter risk Description \"([^\"]*)\"$")
    public void enterRiskDescription(String riskDes) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("riskDes"))).sendKeys(riskDes);
    }

    @Then("^Click on New health Request$")
    public void clickOnNewHealthRequest() {
        driver.findElement(By.xpath(prop.getProperty("newHealthRequest"))).click();
    }

    @When("^Enter the Pin \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void enterThePin(String pincode, String DOB, String polTerm, String sumAssured, String premium) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("pincode"))).sendKeys(pincode);
        driver.findElement(By.xpath(prop.getProperty("DOB"))).sendKeys(DOB);
        driver.findElement(By.xpath(prop.getProperty("policyTerm"))).sendKeys(polTerm);
        driver.findElement(By.xpath(prop.getProperty("sumAssured"))).sendKeys(sumAssured);
        driver.findElement(By.xpath(prop.getProperty("premium"))).sendKeys(premium);
    }

    @When("^select customer Occupation \"([^\"]*)\"$")
    public void selectCustomerOccupation(String custOccupation) throws Throwable {
        Select occuption = new Select(driver.findElement(By.xpath(prop.getProperty("custOccupation"))));
        occuption.selectByValue(custOccupation);
    }

}