package stepDef;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestBase;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class HealthCJStepdefs extends TestBase {
    Select dropdownAge;
    @Before
    public void initialization() throws IOException {
        setUp();
    }

//    @After
//    public void tearDown() {
//        closeBrowser();
//    }
    @When("^Click on Sell now modules$")
    public void clickOnSellNowModules() throws InterruptedException {
        Thread.sleep(350);
        driver.findElement(By.xpath(prop.getProperty("sellnowbutton"))).click();
    }
    @Given("^Click on the Health buttons$")
    public void clickOnTheHealthButtons() throws IOException, InterruptedException {
        Thread.sleep(1500);

        WebElement childElement = driver.findElement(By.xpath("//div[@class='col-lg-2 col-md-4 col-sm-4 item']//p[contains(text(),'Health')]"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
    }

    @And("^Enter the detail in Health landing page \"([^\"]*)\",\"([^\"]*)\"$")
    public void enterTheDetailInHealthLandingPage(String FullName, String MobileNo) throws Throwable {
        String parent = driver.getWindowHandle();

        for (String child : driver.getWindowHandles()) {
            if (!parent.contentEquals(child)) {
                driver.switchTo().window(child);
                break;
            }
       }
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Femaleimage")))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("CustomerFullName")))).sendKeys(FullName);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("CustomerMobileNumber")))).sendKeys(MobileNo);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("ContinueButton1")))).click();


    }

    @Then("^user should be able to navigate to member detail$")
    public void userShouldBeAbleToNavigateToMemberDetail() {
        String actualTitle=driver.getTitle();
        String expectedTitle="PolicyBazaar Health Insurance: Get a 5 Lac health plan @Rs. 373/Month";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("Actual title is "+actualTitle);
    }



    @And("^user should enter the mandatory fields on member screen \"([^\"]*)\"$")
    public void userShouldEnterTheMandatoryFieldsOnMemberScreen(String eldestmemberage) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
            new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("2Adult")))).click();

            WebElement age = driver.findElement(By.xpath(prop.getProperty("eldestmemberagexpath")));
            dropdownAge = new Select(age);
            dropdownAge.selectByValue(eldestmemberage);
            driver.findElement(By.xpath(prop.getProperty("ContinueButton2"))).click();

    }

    @And("^select City \"([^\"]*)\"$")
    public void selectCity(String city) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       WebElement selectCity = driver.findElement(By.xpath(prop.getProperty("selectcity")));
       selectCity.sendKeys(city);
       selectCity.sendKeys(Keys.ENTER);
       driver.findElement(By.xpath(prop.getProperty("continueofselectcity"))).click();
    }

    @And("^select existing illness and click on View Plan$")
    public void selectExistingIllnessAndClickOnViewPlan() {
        driver.findElement(By.xpath(prop.getProperty("Noneofthese"))).click();
        //driver.findElement(By.xpath(prop.getProperty("viewplanbutton"))).click();
    }

    @And("^click on proceed to payment button of NivaBupa$")
    public void clickOnProceedToPaymentButtonOfNivaBupa() {
       List<WebElement> niva= driver.findElements(By.xpath(prop.getProperty("NivaReAssure")));
       for(int i=0;i<niva.size();i++){
         String reAssure =  driver.findElement(By.xpath("//*[contains(text(),'Health ReAssure')]")).getText();

         List<WebElement> proceedButton=driver.findElements(By.xpath("//div[@id='ProceedToProduct']"));
         for(int j=0;j<proceedButton.size();j++) {
           String buttontext= proceedButton.get(j).getText();
             if (reAssure.equalsIgnoreCase("Health ReAssure") && buttontext.contains("/year")) {
                 System.out.println("reassure value is "+ reAssure);
                 System.out.println("button text is"+ buttontext);
                 proceedButton.get(j+1).click();

         }


         }
       }
    }

//    @Then("^validate the error msg$")
//    public void validateTheErrorMsg() {
//      String actualerrormsgofFullName=driver.findElement(By.xpath("//div[contains(text(),'Required')]")).getText();
//        String actualerrormsgofMobileNo=driver.findElement(By.xpath("//div[contains(text(),'Required')]")).getText();
//      String expectederrormsg="Required";
//        System.out.println("Actual errormsgfullname is "+actualerrormsgofFullName);
//        System.out.println("Actual errormsgmobileno is "+actualerrormsgofMobileNo);
//        Assert.assertEquals(actualerrormsgofFullName,expectederrormsg);
//        Assert.assertEquals(actualerrormsgofMobileNo,expectederrormsg);
    }

