//package stepDef;
//
//import cucumber.annotation.Before;
//import cucumber.annotation.en.Given;
//import cucumber.annotation.en.Then;
//import cucumber.annotation.en.When;
//import cucumber.runtime.PendingException;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import stepDef.TestBase;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class TermOfflineRequestStepDef extends TestBase {
//    public TermOfflineRequestStepDef() throws IOException {
//    }
//
//    @Before
//    public void intialization(){
//        System.setProperty("webdriver.chrome.driver", "cromeDriver/Test.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(prop.getProperty("getURL"));
//    }
//    @When("^Enter the Mobile number$")
//    public void enterTheMobileNumber() {
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("IP9022");
//    }
//
//    @Then("^Click on the send OTP button$")
//    public void clickOnTheSendOTPButton() {
//        driver.findElement(By.xpath("//button[@id='send-otp-id']")).click();
//    }
//
//    @Then("^Enter the generated OTP number$")
//    public void enterTheGeneratedOTPNumber() {
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox1']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox2']"))).sendKeys("0");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox3']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox4']"))).sendKeys("0");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox5']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox6']"))).sendKeys("0");
//    }
//
//    @Then("^Click on Verify OTP button$")
//    public void clickOnVerifyOTPButton() {
//        driver.findElement(By.xpath(prop.getProperty("VerifyOTPbutton"))).click();
//    }
//
//    @Given("^Click on the the New Offline Term Request$")
//    public void clickOnTheTheNewOfflineTermRequest() {
//        driver.findElement(By.xpath(prop.getProperty("ClickOnRequestOfflineQuote"))).click();
//    }
//
//    @Then("^Click on the New Term Request$")
//    public void clickOnTheNewTermRequest() {
//        driver.findElement(By.xpath(prop.getProperty("clickOnNewTermOfflineRequest"))).click();
//    }
//
//    @When("^Enter mobile number \"([^\"]*)\"$")
//    public void enterMobileNumber(String enterMobileNumber) throws Throwable {
//        driver.findElement(By.xpath(prop.getProperty("enterMobileNumber"))).sendKeys(enterMobileNumber);
//    }
//
//    @When("^Enter the Customer name \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
//    public void enterTheCustomerName(String customerName, String customerEmail, String customerMobileNo) throws Throwable {
//        driver.findElement(By.xpath(prop.getProperty("customerName"))).sendKeys(customerName);
//        driver.findElement(By.xpath(prop.getProperty("customerEmail"))).sendKeys(customerEmail);
//        driver.findElement(By.xpath(prop.getProperty("customerMobileNo"))).sendKeys(customerMobileNo);
//    }
//
//    @When("^Enter pincode \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
//    public void enterPincode(String pincode, String DOB, String dateOBooking, String annualIncome) throws Throwable {
//        driver.findElement(By.xpath(prop.getProperty("pincode"))).sendKeys(pincode);
//        driver.findElement(By.xpath(prop.getProperty("DOB"))).sendKeys(DOB);
//        driver.findElement(By.xpath(prop.getProperty("dateOBooking"))).sendKeys(dateOBooking);
//        driver.findElement(By.xpath(prop.getProperty("annualIncome"))).sendKeys(annualIncome);
//    }
//
//    @When("^Enter paymentpayingterm \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
//    public void enterPaymentpayingterm(String PPT, String policyTerm, String sumAssured) throws Throwable {
//    driver.findElement(By.xpath(prop.getProperty("PPT"))).sendKeys(PPT);
//    driver.findElement(By.xpath(prop.getProperty("policyTerm"))).sendKeys(policyTerm);
//    driver.findElement(By.xpath(prop.getProperty("sumAssured"))).sendKeys(sumAssured);
//
//    }
//
//    @When("^Enter premium \"([^\"]*)\"$")
//    public void enterPremium(String premium) throws Throwable {
//        driver.findElement(By.xpath(prop.getProperty("premium"))).sendKeys(premium);
//
//    }
//
//    @When("^Select  Payment Frequency \"([^\"]*)\", \"([^\"]*)\"$")
//    public void selectPaymentFrequency(String paymentFrequency, String custOccupation) throws Throwable {
//        Select frequency = new Select(driver.findElement(By.xpath(prop.getProperty("paymentFrequency"))));
//        frequency.selectByValue(paymentFrequency);
//        Select occuption = new Select(driver.findElement(By.xpath(prop.getProperty("custOccupation"))));
//        occuption.selectByValue(custOccupation);
//    }
//
//    @When("^Select the gender$")
//    public void selectTheGender() {
//        List<WebElement> radioButton = driver.findElements(By.xpath("//input[@name='gender']"));
//        radioButton.get(Integer.parseInt(prop.getProperty("gender"))).click();
//    }
//}
