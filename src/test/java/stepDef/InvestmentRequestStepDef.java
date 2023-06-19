//package stepDef;
//
//import cucumber.annotation.Before;
//import cucumber.annotation.en.Given;
//import cucumber.annotation.en.Then;
//import cucumber.annotation.en.When;
//import cucumber.runtime.PendingException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import stepDef.TestBase;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//
//public class InvestmentRequestStepDef extends TestBase {
//    public InvestmentRequestStepDef() throws IOException {
//    }
//
//    @Before
//    public void intialization() {
//        System.setProperty("webdriver.chrome.driver", "cromeDriver/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(prop.getProperty("getURL"));
//    }
//
//    @When("^Enter the mobile Numb$")
//    public void enterTheMobileNumb() {
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("IP9022");
//    }
//
//    @Then("^Click on the send OTP button in Login Page$")
//    public void clickOnTheSendOTPButtonInLoginPage() {
//        driver.findElement(By.xpath("//button[@id='send-otp-id']")).click();
//    }
//
//    @Then("^enter the generated OTP number$")
//    public void enterTheGeneratedOTPNumber() {
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox1']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox2']"))).sendKeys("0");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox3']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox4']"))).sendKeys("0");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox5']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox6']"))).sendKeys("0");
//    }
//
//    @Then("^Click on verify OTP button$")
//    public void clickOnVerifyOTPButton() {
//
//        driver.findElement(By.xpath(prop.getProperty("VerifyOTPbutton"))).click();
//    }
//
////    @Given("^Click on the the New Offline investment Request$")
////    public void clickOnTheTheNewOfflineInvestmentRequest() {
////        driver.findElement(By.xpath(prop.getProperty("ClickOnRequestOfflineQuote"))).click();
////
////    }
////
////    @Then("^Click on the New Investment Request$")
////    public void clickOnTheNewInvestmentRequest() {
////        driver.findElement(By.xpath(prop.getProperty("ClickOnNewInvestmentOfflineRequest"))).click();
////    }
////
////    @When("^Enter the customer name \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
////    public void enterTheCustomerName(String customerName, String customerEmail, String customerMobileNo) throws Throwable {
////        driver.findElement(By.xpath(prop.getProperty("customerName"))).sendKeys(customerName);
////        driver.findElement(By.xpath(prop.getProperty("customerEmail"))).sendKeys(customerEmail);
////        driver.findElement(By.xpath(prop.getProperty("customerMobileNo"))).sendKeys(customerMobileNo);
////    }
////
////    @When("^Select the Payment Frequency \"([^\"]*)\", \"([^\"]*)\"$")
////    public void selectThePaymentFrequency(String paymentFrequency, String custOccupation) throws Throwable {
////        Select frequency = new Select(driver.findElement(By.xpath(prop.getProperty("paymentFrequency"))));
////        frequency.selectByValue(paymentFrequency);
////        Select occuption = new Select(driver.findElement(By.xpath(prop.getProperty("custOccupation"))));
////        occuption.selectByValue(custOccupation);
////    }
////
////    @When("^Enter the pincode \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
////    public void enterThePincode(String pincode, String DOB, String dateOBooking, String annualIncome) throws Throwable {
////        driver.findElement(By.xpath(prop.getProperty("pincode"))).sendKeys(pincode);
////        driver.findElement(By.xpath(prop.getProperty("DOB"))).sendKeys(DOB);
////        driver.findElement(By.xpath(prop.getProperty("dateOBooking"))).sendKeys(dateOBooking);
////        driver.findElement(By.xpath(prop.getProperty("annualIncome"))).sendKeys(annualIncome);
////    }
////
////    @When("^Enter the paymentpayingterm \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
////    public void enterThePaymentpayingterm(String PPT, String policyTerm, String sumAssured) throws Throwable {
////        driver.findElement(By.xpath(prop.getProperty("PPT"))).sendKeys(PPT);
////        driver.findElement(By.xpath(prop.getProperty("policyTerm"))).sendKeys(policyTerm);
////        driver.findElement(By.xpath(prop.getProperty("sumAssured"))).sendKeys(sumAssured);
////    }
////
////    @When("^Enter the premium \"([^\"]*)\"$")
////    public void enterThePremium(String premium) throws Throwable {
////        driver.findElement(By.xpath(prop.getProperty("premium"))).sendKeys(premium);
////    }
////
////    @When("^Select gender$")
////    public void selectGender() {
////        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@name='gender']"));
////        radioButton.get(Integer.parseInt(prop.getProperty("gender"))).click();
//////        int size = radioButton.size();
//////        for(int i = 0; i < size; i++) {
//////            String val = radioButton.get(i);
//////        }
//////        WebElement gender = driver.findElement(By.name("gender"));
//////        boolean gensel = gender.isSelected();
//////        if(!gensel){
//////            gender.click();
//////        if (!gensel && gender.getText().contains("Male")) {
//////            gender.click();
//////        } else if (!gensel && gender.getText().contains("Female")) {
//////            gender.click();
//////        }
////    }
////
////    @When("^Select business type$")
////    public void selectBusinessType() {
////       WebElement businessType= driver.findElement(By.xpath(prop.getProperty("businessType")));
//////        element.click();
////        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
////
////        jse2.executeScript("arguments[0].scrollIntoView()", businessType);
////                jse2.executeScript("arguments[0].click();", businessType);
////
////    }
////
////    @Given("^Click on the Request Offline Quote$")
////    public void clickOnTheRequestOfflineQuote() {
////        driver.findElement(By.xpath(prop.getProperty("ClickOnRequestOfflineQuote"))).click();
////    }
////
////    @Then("^Click on the New Other Request$")
////    public void clickOnTheNewOtherRequest() {
////        driver.findElement(By.xpath(prop.getProperty("newOtherRequest"))).click();
////    }
////
////    @When("^select Product type$")
////    public void selectProductType() {
////        Select proType= new Select(driver.findElement(By.xpath(prop.getProperty("productType"))));
////        proType.selectByValue("");
////    }
////
////    @When("^choose Policy Type$")
////    public void choosePolicyType() {
////    }
////
////    @When("^Enter the customer name \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
////    public void enterTheCustomerName(String arg0, String arg1, String arg2, String arg3, String arg4) throws Throwable {
////        // Write code here that turns the phrase above into concrete actions
////        throw new PendingException();
////    }
////
////    @When("^Select gender \"([^\"]*)\"$")
////    public void selectGender(String gender) throws Throwable {
//////        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@name='gender']"));
//////        radioButton.get(Integer.parseInt(prop.getProperty("gender"))).click();
////
////        List<WebElement> genderSelected = driver.findElements(By.name("gender"));
////        int size= genderSelected.size();
////        for(int i=0; i<size; i++){
////            String value = genderSelected.get(i).getAttribute("value");
////            if(value.equals(gender)){
////                genderSelected.get(i).click();
////                break;
////            }
////        }
////
//////        boolean gensel = genderSelected.isSelected();
//////        String text = genderSelected.getText();
//////        System.out.println(text);
//////        if (!gensel && genderSelected.getText().contains(gender)) {
//////            genderSelected.click();
//////
//////        }
////    }
////
////    @When("^Select policy type$")
////    public void selectPolicyType() {
////
////    }
//}
