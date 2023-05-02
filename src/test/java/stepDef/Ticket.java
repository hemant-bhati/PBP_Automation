//package stepDef;
//
//
//import cucumber.annotation.After;
//import cucumber.annotation.Before;
//import cucumber.annotation.en.Then;
//import cucumber.annotation.en.When;
//import junit.framework.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import utils.TestBase;
//import utils.Utility;
//
//import java.awt.*;
//import java.awt.event.InputEvent;
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//
//public class Ticket extends TestBase {
//
//    WebDriverWait webDriverWait;
//    Utility util = new Utility();
//    String parent;
//
//
//    @When("^Enter the mobile Numb$")
//    public void enterthemobilenumb() throws IOException {
//
//        driver.findElement(By.xpath(util.getMobilrNumber())).sendKeys(util.getEnterMobileNumber());
//
//    }
//
//    @Then("^Click on the send OTP button in Login Page$")
//    public void clickOnTheSendOTPButtonInLoginPage() {
//        driver.findElement(By.xpath("//button[@id='send-otp-id']")).click();
//
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
//
//    }
//
//    @Then("^Click on verify OTP button$")
//    public void clickOnVerifyOtpButton() throws IOException {
//        String expectedTitle = "PBPartners | Dashboard";
//        driver.findElement(By.xpath(util.verifyOTPButton())).click();
//        Assert.assertEquals(driver.getTitle(), expectedTitle);
//
//
//    }
//}