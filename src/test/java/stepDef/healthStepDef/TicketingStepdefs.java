package stepDef.healthStepDef;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDef.TestBase;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class TicketingStepdefs extends TestBase {

    WebDriver driver1;

    @When("^Click on Reports$")
    public void clickOnReports() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='toggle-link']")).click();
        WebElement childElement1 = driver.findElement(By.xpath("//span[contains(text(),'Reports')]"));
        Thread.sleep(5000L);
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement1);
        jse2.executeScript("arguments[0].click();", childElement1);
        childElement1.click();
        Thread.sleep(5000L);

    }

    @Then("^click on Bookings$")
    public void clickOnBookings() {
        WebElement childElement = driver.findElement(By.xpath("//a[contains(text(),'Bookings')]"));
        childElement.click();
    }

    @Then("^Click on product filter & choose CAR$")
    public void clickOnProductFilterChooseCAR() {
        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.xpath(prop.getProperty("proDrop")));
        dropdownElement.click();
        WebElement optionCheckbox = driver.findElement(By.xpath(prop.getProperty("dropValue")));
        optionCheckbox.click();
    }

//    @Then("^Click on Raise Ticket icon$")
//    public void clickOnRaiseTicketIcon() {
//      WebElement  driver.findElement(By.xpath(prop.getProperty("raiseTicket")));
//    }

    @When("^Click on Tickets$")
    public void clickOnTickets() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='toggle-link']")).click();
        WebElement childElement1 = driver.findElement(By.xpath("//span[contains(text(),'Tickets')]"));
        Thread.sleep(5000L);
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement1);
        jse2.executeScript("arguments[0].click();", childElement1);
        childElement1.click();
        Thread.sleep(5000L);

    }

    @Then("^Click on New Tickets$")
    public void clickOnNewTickets() {
        WebElement childElement = driver.findElement(By.xpath("//a[contains(text(),'New Ticket')]"));
        childElement.click();
    }


    @Then("^Click on Raise Tech issue$")
    public void clickOnRaiseTechIssue() throws InterruptedException {
        WebElement childElement = driver.findElement(By.xpath(prop.getProperty("raiseTech")));
        childElement.click();
        Thread.sleep(3000L);
    }

    @Then("^Raise Mobile number change$")
    public void raiseMobileNumberChange() {
        WebElement childElement = driver.findElement(By.xpath(prop.getProperty("mobileNumberChange")));
        childElement.click();
    }

    @Then("^Mention change mobile number and Reason$")
    public void mentionChangeMobileNumberAndReason() {
        driver.findElement(By.xpath(prop.getProperty("mobileNo"))).click();
    }

    @Then("^Click on submit button$")
    public void clickOnSubmitButton() {
        WebElement childElement = driver.findElement(By.xpath(prop.getProperty("proceed")));
        childElement.click();
    }

    @Then("^Check for the validation message$")
    public void checkForTheValidationMessage() {
        WebElement childElement = driver.findElement(By.xpath(prop.getProperty("proceed")));
        childElement.click();
    }

    @Then("^Mention change mobile number and Reason \"([^\"]*)\",\"([^\"]*)\"$")
    public void mentionChangeMobileNumberAndReason(String mobileNo2, String remarks) throws Throwable {
        Random mobilenum = new Random();
        long nummobile = mobilenum.nextInt(1000);
        driver.findElement(By.xpath(prop.getProperty("mobileNo2"))).sendKeys(mobileNo2+String.valueOf(nummobile));
        driver.findElement(By.xpath(prop.getProperty("remarks"))).sendKeys(remarks);
    }

    @Then("^Copy the ticket ID$")
    public void copyTheTicketID() throws InterruptedException {
        Thread.sleep(3000L);
        WebElement e = driver.findElement(By.xpath(prop.getProperty("ticketId")));
        String ticketId = e.getText();
        System.out.println(ticketId);
//        Assert.assertEquals(ticketId, "PB");
    }

    @Then("^Open the BMS portal$")
    public void openTheBMSPortal() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "D:\\Cucumber_automation\\Test\\chromedriver.exe");
        ChromeDriver driver1 = new ChromeDriver();
        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver1.get("https://bmsv2test.policybazaar.com");
        driver1.manage().window().maximize();
        driver1.findElement(By.xpath("//input[@name='employeeId']")).sendKeys("Nehagupta");
        driver1.findElement(By.xpath("//input[@name='password']")).sendKeys("pbindia@321!");
        WebElement childElement=driver1.findElement(By.xpath(prop.getProperty("submitButton")));
//        driver1.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        JavascriptExecutor jse4 = (JavascriptExecutor) driver1;
        jse4.executeScript("arguments[0].scrollIntoView()", childElement);
        jse4.executeScript("arguments[0].click();", childElement);

    }

    @Then("^Click on logout button from BMS$")
    public void clickOnLogoutButtonFromBMS() throws InterruptedException {
        Thread.sleep(10000L);
        WebElement element1 = driver1.findElement(By.xpath(prop.getProperty("logout")));
        System.out.println(element1);
        element1.click();

    }
}
