//package stepDef;
//
//import cucumber.annotation.After;
//import cucumber.annotation.Before;
//import cucumber.annotation.en.Then;
//import cucumber.annotation.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import utils.TestBase;
//import java.awt.*;
//import java.awt.event.InputEvent;
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//public class OfflineRequestMapping extends TestBase {
//    public OfflineRequestMapping () throws IOException{
//
//    }
//
//    WebDriverWait webDriverWait;
//    String parent;
//
//
//    @When("^Enter the Partner code$")
//    public void enterThePartnerCode() {
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//input[@id='user']")).sendKeys("IP9022");
//    }
//
//    @Then("^Clicks on the send otp button in login Page$")
//    public void clicksOnTheSendOtpButtonInLoginPage() {
//        driver.findElement(By.xpath("//button[@id='send-otp-id']")).click();
//
//    }
//
//    @Then("^enter the generated otp Numbers$")
//    public void enterTheGeneratedOtpNumbers() {
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox1']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox2']"))).sendKeys("0");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox3']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox4']"))).sendKeys("0");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox5']"))).sendKeys("1");
//        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='codeBox6']"))).sendKeys("0");
//
//    }
//
//    @Then("^Click on verify otp Buttons$")
//    public void clickOnVerifyOtpButtons() throws IOException, InterruptedException {
//        String expectedTitle = "PBPartners | Dashboard";
//        driver.findElement(By.xpath(prop.getProperty("VerifyOTPbutton"))).click();
////        Assert.assertEquals(driver.getTitle(), expectedTitle);
//        Thread.sleep(1000l);
//        Robot robot;
//        try {
//            robot = new Robot();
//            org.openqa.selenium.Dimension i = driver.manage().window().getSize();
//            System.out.println("Dimension x and y :" + i.getWidth() + " " + i.getHeight());
//            int x = (i.getWidth() / 4) + 100;
//            int y = (i.getHeight() / 10) + 500;
//            robot.mouseMove(x, y);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            System.out.println("Browse button clicked");
//            System.out.println("Removed the handle by clicking on (500,500)");
//        } catch (AWTException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//    }
//
//    @When("^click on Request Offline Quote navigations$")
//    public void clickOnRequestOfflineQuoteNavigations() {
//        driver.findElement(By.xpath("//a[@data-bs-toggle='collapse']")).click();
//        WebElement childElement = driver.findElement(By.xpath("//li[@data-sidenav='raise-mapping-request']"));
//        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
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
//        driver.findElement(By.xpath("//input[@id='policy_number']")).sendKeys("tax452004188");
//        driver.findElement(By.xpath("//input[@id='premium']")).sendKeys("5000");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        // identify element
//        WebElement l = driver.findElement(By.xpath("//input[@id='file1']"));
//        // file path passed with sendkeys()
//        l.sendKeys("C:\\Users\\NehaGupta\\Desktop\\Backup folder\\Download data\\43400916.pdf");
//        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
//        jse2.executeScript("arguments[0].scrollIntoView()", submitButton);
//        jse2.executeScript("arguments[0].click();", submitButton);
//
//
//    }
//
//}