package stepDef;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void selectExistingIllnessAndClickOnViewPlan() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Noneofthese"))).click();

        //driver.findElement(By.xpath(prop.getProperty("viewplanbutton"))).click();
    }
    public void validatePremiumButtonText() throws SQLException {
        try {
            String query = "use HealthDB Select Premium  from Hi.Health_Rates nolock where Plan_Id=626 and SumInsured=500000 and NumberOfAdults=2 and NumberOfChildren=0 and Max_AgeOfEldestMember=35 and CityGroup_Id=204 and Term = 1";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.println("premium value from DB " + res.getString(1));
                Thread.sleep(3000L);
                WebElement niva = driver.findElement(By.xpath(prop.getProperty("Nivabutton")));
                    String reAssure = niva.getText();
                            String symbol1 = reAssure.replaceAll("₹", "");
                            String symbol2 = symbol1.replaceAll("/year", "");
                            String finalsymbol = symbol2.replaceAll(",", "");
                            System.out.println("premium value from UI = "+finalsymbol);
                            String expectedbuttontext = res.getString(1);
                            junit.framework.Assert.assertEquals(expectedbuttontext, finalsymbol);
                        }

                } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    @And("^click on premium button of NivaBupa$")
    public void clickOnpremiumButtonOfNivaBupa() throws InterruptedException, SQLException {
        validatePremiumButtonText();
        Thread.sleep(5000L);

        WebElement niva = driver.findElement(By.xpath(prop.getProperty("Nivabutton")));
        niva.click();
       }
    @And("^click on proceed to proposal page$")
    public void clickOnProceedToProposalPage() throws InterruptedException {
        WebElement premiumvalue = driver.findElement(By.xpath("//div[@class='flexRow section_premium']//div//span"));
        System.out.println("*****Premium value before adding rider*****" + premiumvalue.getText());
        String beforerider =premiumvalue.getText();
        driver.findElement(By.xpath("(//div[@class='fullWidthBtn'])[1]")).click();
        //Thread.sleep(10000L);
        WebElement premiumvalue1 = driver.findElement(By.xpath("//div[@class='flexRow section_premium']//div//span"));
        System.out.println("*****Premium value after adding rider*****" + premiumvalue1.getText());
        Assert.assertNotEquals(beforerider,premiumvalue1.getText());
        driver.findElement(By.xpath(prop.getProperty("proceedtoproposal"))).click();
    }

    @And("^Enter spouse age through edit member$")
    public void enterSpouseAgeThroughEditMember() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Edit Members')]")).click();
        Thread.sleep(5000L);
        Select spouseage = new Select(driver.findElement(By.xpath("(//div[@class='select_members_age']//select)[2]")));
        spouseage.selectByValue("30");
        driver.findElement(By.xpath("//div[contains(text(),'Apply')]")).click();
    }
}





