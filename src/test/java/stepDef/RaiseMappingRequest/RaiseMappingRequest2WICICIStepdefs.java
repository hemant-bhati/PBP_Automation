package stepDef.RaiseMappingRequest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDef.TestBase;

import java.sql.ResultSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static stepDef.TestBase.driver;

public class RaiseMappingRequest2WICICIStepdefs extends TestBase {
    String parent;
    WebDriver driver1;
    String lastWord;
    @When("^click on Request offline Quote left navigation$")
    public void clickOnRequestOfflineQuoteLeftNavigation() {
        driver.findElement(By.xpath("//li[@id='id-offlinereq']")).click();
    }

    @When("^click on Raise mapping request and fill mandatory fields \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void clickOnRaiseMappingRequestAndFillMandatoryFields(String prodID, String custName, String regisNum, String polNum, String premiumvalue, String docUpload) throws Throwable {
        WebElement childElement = driver.findElement(By.xpath("//li[@data-sidenav='raise-mapping-request']"));
//        Actions reqofflinequote = new Actions(driver);
//        reqofflinequote.moveToElement(childElement).build().perform();
        Thread.sleep(5000L);
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
        childElement.click();
        Thread.sleep(5000L);
        List<WebElement> productName = driver.findElements(By.xpath(prop.getProperty("prodID")));
        Select details = new Select(productName.get(0));
        details.selectByValue(prodID);
        driver.findElement(By.xpath(prop.getProperty("custName"))).sendKeys(custName);
        driver.findElement(By.xpath(prop.getProperty("regisNum"))).sendKeys(regisNum);
        WebElement insurer = driver.findElement(By.xpath(prop.getProperty("insID")));
        Select insurerdropdown = new Select(insurer);
        insurerdropdown.selectByValue("194");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        Random appno = new Random();
//        int policyno = appno.nextInt(500);
//        driver.findElement(By.xpath(prop.getProperty("polNum"))).sendKeys(polNum+String.valueOf(policyno));
        Random appno = new Random();
        String uniquePolicyNumber = polNum + System.currentTimeMillis() + "_" + appno.nextInt(500);
        driver.findElement(By.xpath(prop.getProperty("polNum"))).sendKeys(uniquePolicyNumber);
        driver.findElement(By.xpath(prop.getProperty("premium"))).sendKeys(premiumvalue);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // identify element
        WebElement l = driver.findElement(By.xpath(prop.getProperty("docUpload")));
        // file path passed with sendkeys()
        l.sendKeys(docUpload);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement submitButton = driver.findElement(By.xpath(prop.getProperty("subBut")));
        jse2.executeScript("arguments[0].scrollIntoView()", submitButton);
        jse2.executeScript("arguments[0].click();", submitButton);
        Thread.sleep(10000l);

    }

    @Then("^Open Admin Panel and search ticket through view ticket section \"([^\"]*)\", \"([^\"]*)\"$")
    public void openAdminPanelAndSearchTicketThroughViewTicketSection(String prePolNum, String netPremium) throws Throwable {
        WebElement sentenceElement = driver.findElement(By.xpath("//div[@class='alert alert-success alert-important']"));
        // Get the text from the element
        String sentence = sentenceElement.getText();
        // Split the sentence into words using whitespace as the delimiter
        String[] words = sentence.split("\\s+");
        // Extract the last word from the array
        lastWord = words[words.length - 1];
        // Display the last word
        System.out.println("Last Word: " + lastWord);
//        String ID = driver.findElement(By.xpath("//div[@class='alert alert-success alert-important']")).getText();
        System.setProperty("webdriver.chrome.driver", "D:\\PBP_Automation\\chromedriver.exe");
        driver1 = new ChromeDriver();
        driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver1.get("https://polbkqa.policybazaar.com/login");
        driver1.manage().window().maximize();
        driver1.findElement(By.xpath("//input[@id='login_field']")).sendKeys("Dev4");
        driver1.findElement(By.xpath("//input[@id='password']")).sendKeys("123456@");
        WebElement childElement=driver1.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
//        driver1.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
        JavascriptExecutor jse4 = (JavascriptExecutor) driver1;
        jse4.executeScript("arguments[0].scrollIntoView()", childElement);
        jse4.executeScript("arguments[0].click();", childElement);
        WebElement childElement1 =driver1.findElement(By.xpath(prop.getProperty("adminTickets")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver1;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement1);
        jse2.executeScript("arguments[0].click();", childElement1);
    }

    @Then("^click on Edit icon of respective ticket through the grid$")
    public void clickOnEditIconOfRespectiveTicketThroughTheGrid() {
        driver1.findElement(By.xpath(prop.getProperty("viewTickets"))).click();
        driver1.findElement(By.xpath(prop.getProperty("globalSearch"))).sendKeys(lastWord);
        driver1.findElement(By.xpath(prop.getProperty("ticketEditButton"))).click();
    }

    @Then("^click on verify radio button under Add New Remarks section$")
    public void clickOnVerifyRadioButtonUnderAddNewRemarksSection() throws InterruptedException {
        WebElement childElement4=driver1.findElement(By.xpath(prop.getProperty("verifyButtonAdmin")));
        JavascriptExecutor jse3 = (JavascriptExecutor) driver1;
        jse3.executeScript("arguments[0].scrollIntoView()", childElement4);
        jse3.executeScript("arguments[0].click();", childElement4);
        Thread.sleep(2000L);
    }

    @Then("^fill all mandatory fields on policy details$")
    public void fillAllMandatoryFieldsOnPolicyDetails() throws InterruptedException {
        List<WebElement> busiType = driver1.findElements(By.xpath(prop.getProperty("businessTypeVerify")));
        Select businessType = new Select(busiType.get(0));
        businessType.selectByValue("2");
        List<WebElement> stp = driver1.findElements(By.xpath(prop.getProperty("stpNstp")));
        Select stpNstp = new Select(stp.get(0));
        stpNstp.selectByValue("2");
        List<WebElement> plan = driver1.findElements(By.xpath(prop.getProperty("plantype")));
        Select plantype = new Select(plan.get(0));
        plantype.selectByValue("1");
        Thread.sleep(1000);
        plantype.selectByValue("2");
        Thread.sleep(5000L);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement planVal = driver1.findElement(By.xpath(prop.getProperty("plannameid")));
        Select planName = new Select(planVal);
        planName.selectByValue("195");
        Thread.sleep(4000L);
        driver1.findElement(By.xpath(prop.getProperty("rmrpreviouspolicyno"))).sendKeys("ABCD12345");
        Thread.sleep(2000L);
        WebElement regdate =  driver1.findElement(By.xpath(prop.getProperty("rmrregdate")));
        regdate.sendKeys("20-05-2018");
        regdate.sendKeys(Keys.ENTER);
        WebElement mfgdate =  driver1.findElement(By.xpath(prop.getProperty("rmrmfgdate")));
        mfgdate.sendKeys("20-04-2018");
        mfgdate.sendKeys(Keys.ENTER);
        List<WebElement> subclass = driver1.findElements(By.xpath(prop.getProperty("rmrvehiclesubclass")));
        Select Vehiclesubclass = new Select(subclass.get(0));
        Vehiclesubclass.selectByValue("1");
        driver1.findElement(By.xpath(prop.getProperty("rprCC"))).sendKeys("100");
        List<WebElement> fuelT = driver1.findElements(By.xpath(prop.getProperty("rmrfuelType")));
        Select fuelTy = new Select(fuelT.get(0));
        fuelTy.selectByValue("2");
        List<WebElement> make= driver1.findElements(By.xpath(prop.getProperty("rmrmake")));
        Select carMake = new Select(make.get(0));
        carMake.selectByVisibleText("HERO HONDA");
        Thread.sleep(2000L);
        List<WebElement> model= driver1.findElements(By.xpath(prop.getProperty("rmrmodel")));
        Select carModel = new Select(model.get(0));
        carModel.selectByVisibleText("SPLENDOR");
        Thread.sleep(2000L);
        WebElement TPPremium = driver1.findElement(By.xpath(prop.getProperty("rprTPPremium")));
        TPPremium.clear();
        TPPremium.sendKeys("5000");
        WebElement  NetPremium = driver1.findElement(By.xpath(prop.getProperty("rprnetpremium")));
        NetPremium.clear();
        NetPremium.sendKeys("5000");
        Thread.sleep(2000L);
        driver1.findElement(By.xpath(prop.getProperty("rprgrosspremium"))).sendKeys("5800");
        List<WebElement> term = driver1.findElements(By.xpath(prop.getProperty("rmrpolicyterm")));
        Select policyterm = new Select(term.get(0));
        policyterm.selectByValue("1");
    }

    @Then("^click on update button$")
    public void clickOnUpdateButton() throws InterruptedException {
        WebElement submitButt= driver1.findElement(By.xpath(prop.getProperty("updateButton")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver1;
        jse2.executeScript("arguments[0].scrollIntoView()", submitButt);
        jse2.executeScript("arguments[0].click();", submitButt);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //Thread.sleep(10000L);
    }

    @Then("^verify the lead value from UI and DB$")
    public void verifyTheLeadValueFromUIAndDB() throws InterruptedException {
        //new WebDriverWait(driver1, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("rprpopupclosebutton")))).click();
        //driver1.findElement(By.xpath(prop.getProperty("rprpopupclosebutton"))).click();

       // int maxWaitTimeInSeconds = 90;
        //WebDriverWait wait = new WebDriverWait(driver1, maxWaitTimeInSeconds);
        //try {

//            WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("rprpopupclosebutton")));
//            closeButton.click();
        Thread.sleep(85000L);
        //WebElement closeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("rprpopupcancelbutton")));
        driver1.findElement(By.xpath(prop.getProperty("rprpopupclosebutton"))).click();
        //closeButton.click();
//        } catch (org.openqa.selenium.TimeoutException e) {
//            System.out.println("Close button did not appear within the timeout Refreshing the page.");
//            //driver1.navigate().refresh();
//            // Wait for the page to load after refresh (you can adjust the timeout)
//            WebDriverWait pageLoadWait = new WebDriverWait(driver1, 10);
//            pageLoadWait.until(webDriver ->
//                    ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//        }
        try {
            String query = "use PospDB select top(1) LeadID from dbo.BookingDetails_v1 where productID = 187 and PlanId = 195 order by LeadID desc";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                System.out.println("leadId value from DB " + res.getString(1));
                Thread.sleep(5000L);
                WebElement leadId = driver.findElement(By.xpath(prop.getProperty("rmrLeadIdUI")));
                //for (WebElement e : leadId) {
                    System.out.println("Lead Id value from UI " + leadId.getText());
                    String leadValue = res.getString(1);
                    junit.framework.Assert.assertEquals("LEAD ID: " + leadValue, leadId.getText());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

