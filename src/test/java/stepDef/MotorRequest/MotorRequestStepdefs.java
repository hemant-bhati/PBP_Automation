package stepDef.MotorRequest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static stepDef.TestBase.driver;
import static stepDef.TestBase.prop;

public class MotorRequestStepdefs {
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
        WebElement childElement = driver.findElement(By.xpath("//a[contains(text(),'New Motor Request')]"));
        childElement.click();

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
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"insurer_list\"]/span/span[1]/span"));

        Select select = new Select(dropdown);
        select.selectByVisibleText("//*[@id=\"select2-Insurers-result-bd3s-2\"]");


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
        driver.findElement(By.xpath(prop.getProperty("addons"))).click();
        WebElement searchInput = driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[2]"));
//        searchInput.sendKeys("Daily Allowance");
        searchInput.click();
        WebDriverWait wait= new WebDriverWait(driver,10);
        WebElement SearchText =driver.findElement(By.xpath("(//li[@class='select2-results__option'])[5]"));
        SearchText.click();

    }
}


