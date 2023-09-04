//package stepDef;
//
//import cucumber.annotation.en.Given;
//import cucumber.annotation.en.Then;
//import cucumber.annotation.en.When;
//import junit.framework.Assert;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import utils.Utility;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.TimeUnit;
//
//public class LoginStepDef {
//    WebDriver driver;
//    WebDriverWait webDriverWait;
//    Utility util = new Utility();
//
//    @Given("^Open the browser$")
//    public void openTheBrowser() {
//
//        System.setProperty("webdriver.chrome.driver", "Test.exe");
//        driver = new ChromeDriver();
//
//
//    }
//
//    @When("^Enter the URL$")
//    public void enterTheURL() throws IOException {
//        driver.manage().window().maximize();
//        driver.get(util.getURL());
//
//
//    }
//
//    @When("^Enter the mobile Number$")
//    public void enterthemobilenumber() throws IOException {
//
//        driver.findElement(By.xpath(util.getMobilrNumber())).sendKeys(util.getEnterMobileNumber());
//
//    }
//
//    @Then("^Click on the send otp button in login page$")
//    public void clickOnTheSendOtpButtonInLoginPage() {
//        driver.findElement(By.xpath("//button[@id='send-otp-id']")).click();
//
//    }
//
//    @Then("^enter the generated otp number$")
//    public void enterTheGeneratedOtpNumber() {
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox1']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox2']"))).sendKeys("0");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox3']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox4']"))).sendKeys("0");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox5']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox6']"))).sendKeys("0");
//
//    }
//
//    @Then("^Click on verify otp button$")
//    public void clickOnVerifyOtpButton() throws IOException {
//        String expectedTitle = "PBPartners | Dashboard";
//        driver.findElement(By.xpath(util.verifyOTPButton())).click();
//        Assert.assertEquals(driver.getTitle(), expectedTitle);
//
//
//    }
//
//    @Given("^Click on the car button$")
//    public void clickOnTheCarButton() throws IOException, InterruptedException {
//        Thread.sleep(5000);
//        driver.findElement(By.xpath(util.ClickonCarbutton())).click();
//    }
//
//    @Then("^Verify the title of Car landing page$")
//    public void verifyTheTitleOfCarLandingPage() {
//        String parent = driver.getWindowHandle();
//        String expectedTitle = "PolicyBazaar Car Insurance: Insure Your Car Today";
//        for (String child : driver.getWindowHandles()) {
//            if (!parent.contentEquals(child)) {
//                driver.switchTo().window(child);
//                break;
//            }
//        }
//        Assert.assertEquals(expectedTitle, driver.getTitle());
//
//    }
//
//    @When("^Click on proceed without Car button$")
//    public void clickOnProceedWithoutCarButton() {
//        driver.findElement(By.xpath("//div[@class='dont-know-number']")).click();
//
//
//    }
//
//    @Then("^Enter the State and Click$")
//    public void enterTheStateAndClick() {
//        driver.findElement(By.xpath("//span[@id='spn1']")).click();
//
//    }
//
//
//    @Then("^Click on DLten$")
//    public void clickOnDLten() {
//        driver.findElement(By.xpath("//span[contains(text(),'DL10')]")).click();
//            }
//
//    @Then("^Click on hondo$")
//    public void clickOnHondo() {
//        Actions action=new Actions(driver);
//        WebElement click=driver.findElement(By.xpath("//li[@class='col-sm-3 col-xs-6']//span[@class='honda']"));
//        action.click(click);
//    }
//
//    @Then("^Search the maruti in text field and enter$")
//    public void searchTheHondaInTextFieldAndEnter() throws InterruptedException {
//        Thread.sleep(500l);
//        driver.findElement(By.className("maruti")).click();
//
//    }
//
//    @Then("^select the alto car model$")
//    public void selectTheAltoCarModel() throws InterruptedException {
//        Thread.sleep(500l);
//        driver.findElement(By.xpath("//b[contains(text(),'ALTO K10')]")).click();
//    }
//
//    @Then("^Click on Car fuel Type$")
//    public void clickOnCarFuelType() throws InterruptedException {
//        Thread.sleep(500l);
//        driver.findElement(By.xpath("//b[contains(text(),'Petrol')]")).click();
//    }
//
//    @Then("^Select the Car Variant$")
//    public void selectTheCarVariant() throws InterruptedException {
//        Thread.sleep(500l);
//        driver.findElement(By.xpath("//b[contains(text(),'VXI AMT (998 cc)')]")).click();
//    }
//
//    @Then("^Select Car Registration Year$")
//    public void selectCarRegistrationYear() throws InterruptedException {
//        Thread.sleep(500l);
//        driver.findElement(By.xpath("//b[contains(text(),'2018')]")).click();
//    }
//
//    @Then("^Enter the details$")
//    public void enterTheDetails() throws InterruptedException {
//        Thread.sleep(500l);
//        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Neha");
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nehagupta@pbpartners.com");
//        driver.findElement(By.xpath("//input[@id='mobileNo']")).sendKeys("6789098765");
//        driver.findElement(By.xpath("//button[@id='btnLeadDetails']")).click();
//    }
//
//    @Then("^select date from calender when your policy expires$")
//    public void selectDateFromCalenderWhenYourPolicyExpires() throws InterruptedException {
//        Thread.sleep(5000l);
//        WebElement input = driver.findElement(By.xpath("//a[contains(text(),'29')]"));
//        input.click();
//    }
//
//    @Then("^Confirm the existing claim$")
//    public void confirmTheExistingClaim() throws InterruptedException {
//        Thread.sleep(5000l);
//        WebElement input = driver.findElement(By.xpath("//label//div[contains(text(),'Yes')]"));
//        input.click();
//    }
//
//    @Then("^Click to buy quote from the list$")
//    public void clickToBuyQuoteFromTheList() throws InterruptedException {
//        Thread.sleep(5000l);
//       List<WebElement> input = driver.findElements(By.xpath("//button[@class='buy-now-btn']"));
//        input.get(1).click();
//    }
//
//    @Then("^click on insures list and choose kotak insurer$")
//    public void clickOnInsuresListAndChooseKotakInsurer() throws InterruptedException {
//        Thread.sleep(5000l);
//        WebElement input = driver.findElement(By.xpath("//label[contains(text(),'Insurers')]"));
//        input.click();
//        driver.findElement(By.xpath("//button[contains(text(),'Clear All')]")).click();
//        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(),'Kotak General Insurance')]"));
//        checkbox.click();
//        driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
//
//    }
//
//
//
//}
//
//
//
//
