package stepDef.MotorRequest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static stepDef.TestBase.driver;
import static stepDef.TestBase.prop;

public class MotorRequestStepdefs {
    WebDriver driver1;
    @When("^Click on New Motor Request$")
    public void clickOnNewMotorRequest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='toggle-link']")).click();
        WebElement childElement1 = driver.findElement(By.xpath("//span[contains(text(),'Request Offline Quote')]"));
//       WebElement childElement1 = driver.findElement(By.xpath("//li[@id='id-offlinereq']"));
        Thread.sleep(5000L);
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement1);
        jse2.executeScript("arguments[0].click();", childElement1);
        childElement1.click();
        Thread.sleep(5000L);
        driver.findElement(By.xpath("//a[contains(text(),'New Motor Request')]")).click();
//        WebElement childElement = driver.findElement(By.xpath("//a[contains(text(),'New Motor Request')]"));
//        childElement.click();

    }

    @Then("^Click on Vehicle details,Registration Date, Registration NO, \"([^\"]*)\"$")
    public void clickOnVehicleDetailsRegistrationDateRegistrationNO(String registraNum) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("registraNum"))).sendKeys(registraNum);
        Thread.sleep(2000L);
        WebElement regidate = driver.findElement(By.xpath(prop.getProperty("regisDate")));
        regidate.sendKeys("2022-12-20");
        regidate.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(prop.getProperty("vehiType"))).click();

        WebElement childElement3= driver.findElement(By.xpath(prop.getProperty("polType")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement3);
        jse2.executeScript("arguments[0].click();", childElement3);
//        childElement3.click();
//        driver.findElement(By.xpath(prop.getProperty("insurer"))).click();
////        driver.findElement(By.xpath(prop.getProperty("insList"))).click();
//        WebElement insurer = driver.findElement(By.xpath(prop.getProperty("insList")));
//        Select insurerdropdown = new Select(insurer);
//        insurerdropdown.selectByVisibleText("Reliance General Insurance");
    }

    @Then("^Choose Insurers$")
    public void chooseInsurers() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']//input[@class='select2-search__field']"));
        dropdown.sendKeys("ICICI Lombard");
        dropdown.sendKeys(Keys.ENTER);
        /* WebElement dropdown = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']//input[@class='select2-search__field']"));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByVisibleText("(//li[@class='select2-results__option'])[1]");*/

        // Locate the dropdown input field and click it to open the dropdown
//        WebElement dropdown = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']//input[@class='select2-search__field']"));
//        dropdown.click();
//        // Wait for the dropdown options to become visible (use WebDriverWait if necessary)
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[@class='select2-results__option'])[1]")));
//        // Click the desired option
//        option.click();



//        WebDriverWait wait= new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[@class='select2-results__option'])[1]")));
//        WebElement SearchText =driver.findElement(By.xpath("(//li[@class='select2-results__option'])[1]"));
//        SearchText.click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[conatins(text(),'ICICI Lombard')]")));
//        WebElement search = driver.findElement(By.xpath("//span[conatins(text(),'ICICI Lombard')]"));
//        search.click();
//        WebElement searchInput = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']//input[@class='select2-search__field']"));
//        searchInput.sendKeys("ICICI Lombard");
//        searchInput.sendKeys(Keys.ENTER);

//        Thread.sleep(200);


//        driver.findElement(By.xpath(prop.getProperty("insurer"))).click();
//
//        WebElement mfgdate =  driver.findElement(By.xpath(prop.getProperty("insList")));
//        mfgdate.sendKeys("Reliance General Insurance");
//        mfgdate.sendKeys(Keys.ENTER);
//        WebElement insur = driver.findElement(By.xpath(prop.getProperty("insList")));
//        Select insurerdropdown = new Select(insur);
//        insurerdropdown.selectByVisibleText("Reliance General Insurance");

    }

       @Then("^IDV value, customer-email, Mobile no\\. and Pan number \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void idvValueCustomerEmailMobileNoAndPanNumber(String idvValue, String custemail, String mobileNo, String panNo) throws Throwable {
        driver.findElement(By.xpath(prop.getProperty("idvValue"))).sendKeys(idvValue);
        driver.findElement(By.xpath(prop.getProperty("custemail"))).sendKeys(custemail);
        driver.findElement(By.xpath(prop.getProperty("mobileNo"))).sendKeys(mobileNo);
        driver.findElement(By.xpath(prop.getProperty("panNo"))).sendKeys(panNo);
    }

    @Then("^choose DOB$")
    public void chooseDOB() {
        WebElement dateOB = driver.findElement(By.xpath(prop.getProperty("dateOfBirth")));
        dateOB.sendKeys("2000-12-20");
        dateOB.sendKeys(Keys.ENTER);
    }

    @Then("^upload RC \"([^\"]*)\"$")
    public void uploadRC(String rc) throws Throwable {
        WebElement l = driver.findElement(By.xpath(prop.getProperty("rc")));
        // file path passed with sendkeys()
        l.sendKeys(rc);
    }
    @Then("^Choose Add-ons$")
    public void chooseAddOns() {
        WebElement addons = driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered']//input[@class='select2-search__field'])[2]"));
        addons.sendKeys("Zero Dep");
        addons.sendKeys(Keys.ENTER);

    }

    @Then("^Click on Request Quote button$")
    public void clickOnRequestQuoteButton() {
       WebElement ReqQuote= driver.findElement(By.xpath(prop.getProperty("reqQuoteButton")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", ReqQuote);
        jse2.executeScript("arguments[0].click();", ReqQuote);
    }

    @Then("^Fetch the Request Id$")
    public void fetchTheRequestId() {
        WebElement reqID = driver.findElement(By.xpath(prop.getProperty("requestID")));
        String sentence = reqID.getText();
        // Split the sentence into words using whitespace as the delimiter
        String[] words = sentence.split("\\s+");
        // Extract the last word from the array
        String endWord = words[words.length - 1];
        // Display the last word
        System.out.println("Last Word: " + endWord);
    }

    @Then("^Open the Admin panel$")
    public void openTheAdminPanel() {
//        System.setProperty("webdriver.chrome.driver", "D:\\Cucumber_automation\\Test\\chromedriver.exe");
        ChromeDriver driver1 = new ChromeDriver();
        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver1.get("https://polbkqa.policybazaar.com/login");
        driver1.manage().window().maximize();
        driver1.findElement(By.xpath("//input[@id='login_field']")).sendKeys("Dev4");
        driver1.findElement(By.xpath("//input[@id='password']")).sendKeys("123456@");
        WebElement childElement=driver1.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
//        driver1.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        JavascriptExecutor jse1 = (JavascriptExecutor) driver1;
        jse1.executeScript("arguments[0].scrollIntoView()", childElement);
        jse1.executeScript("arguments[0].click();", childElement);
    }

    @Then("^Open the Offline Request through admin$")
    public void openTheOfflineRequestThroughAdmin() {
        WebElement childElement = driver.findElement(By.xpath(prop.getProperty("offlineReq")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver1;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
    }
}


