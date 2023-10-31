package stepDef.RaiseMappingRequest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import stepDef.TestBase;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RaiseMappingRequestCVMagmaStepdefs extends TestBase {

    String parent;
    WebDriver driver1;
    String lastWord;
    @When("^click on Request offline Quote button on left navigation$")
    public void clickOnRequestOfflineQuoteButtonOnLeftNavigation() {
        driver.findElement(By.xpath("//li[@id='id-offlinereq']")).click();
    }

    @When("^click on Raise mapping request under mapping and fill mandatory fields \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void clickOnRaiseMappingRequestUnderMappingAndFillMandatoryFields(String prodID, String custName, String regisNum, String polNum, String premiumvalue, String docUpload) throws Throwable {
        WebElement childElement = driver.findElement(By.xpath("//li[@data-sidenav='raise-mapping-request']"));
//        Actions reqofflinequote = new Actions(driver);
//        reqofflinequote.moveToElement(childElement).build().perform();
        Thread.sleep(5000L);
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
        childElement.click();
        Thread.sleep(3000L);
        List<WebElement> productName = driver.findElements(By.xpath(prop.getProperty("prodID")));
        Select details = new Select(productName.get(0));
        details.selectByValue(prodID);
        List<WebElement> schoolBus = driver.findElements(By.xpath(prop.getProperty("rmrschoolBus")));
        Select schoolBusDetails = new Select(schoolBus.get(0));
        schoolBusDetails.selectByValue("0");

        driver.findElement(By.xpath(prop.getProperty("custName"))).sendKeys(custName);
        driver.findElement(By.xpath(prop.getProperty("regisNum"))).sendKeys(regisNum);
        WebElement insurer = driver.findElement(By.xpath(prop.getProperty("insID")));
        Select insurerdropdown = new Select(insurer);
        insurerdropdown.selectByValue("29");
//        Random appno = new Random();
//        int policyno = appno.nextInt(500);
//        driver.findElement(By.xpath(prop.getProperty("polNum"))).sendKeys(polNum+String.valueOf(policyno));
        Random appno = new Random();
        String uniquePolicyNumber = polNum + System.currentTimeMillis() + "_" + appno.nextInt(500);
        driver.findElement(By.xpath(prop.getProperty("polNum"))).sendKeys(uniquePolicyNumber);
        driver.findElement(By.xpath(prop.getProperty("premium"))).sendKeys(premiumvalue);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // identify element
        WebElement l = driver.findElement(By.xpath(prop.getProperty("docUpload")));
        // file path passed with sendkeys()
        l.sendKeys(docUpload);
        WebElement submitButton = driver.findElement(By.xpath(prop.getProperty("subBut")));
        jse2.executeScript("arguments[0].scrollIntoView()", submitButton);
        jse2.executeScript("arguments[0].click();", submitButton);
        Thread.sleep(10000l);

    }

    @Then("^Open the Admin Panel and search ticket through view ticket section \"([^\"]*)\", \"([^\"]*)\"$")
    public void openTheAdminPanelAndSearchTicketThroughViewTicketSection(String prePolNum, String netPremium) throws Throwable {
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
        System.setProperty("webdriver.chrome.driver", "D:\\PBP_Automation\\hb.exe");
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

    @Then("^click on Edit button of respective ticket through the grid$")
    public void clickOnEditButtonOfRespectiveTicketThroughTheGrid() {
        driver1.findElement(By.xpath(prop.getProperty("viewTickets"))).click();
        driver1.findElement(By.xpath(prop.getProperty("globalSearch"))).sendKeys(lastWord);
        driver1.findElement(By.xpath(prop.getProperty("ticketEditButton"))).click();

    }

    @Then("^click on Verify radio button under Add New Remarks section$")
    public void clickOnVerifyRadioButtonUnderAddNewRemarksSection() throws InterruptedException {
        WebElement childElement4=driver1.findElement(By.xpath(prop.getProperty("verifyButtonAdmin")));
        JavascriptExecutor jse3 = (JavascriptExecutor) driver1;
        jse3.executeScript("arguments[0].scrollIntoView()", childElement4);
        jse3.executeScript("arguments[0].click();", childElement4);
        Thread.sleep(2000L);
    }

    @Then("^fill all the mandatory fields on policy details$")
    public void fillAllTheMandatoryFieldsOnPolicyDetails() throws InterruptedException {
        List<WebElement> busiType = driver1.findElements(By.xpath(prop.getProperty("businessTypeVerify")));
        Select businessType = new Select(busiType.get(0));
        businessType.selectByValue("2");
        List<WebElement> stp = driver1.findElements(By.xpath(prop.getProperty("stpNstp")));
        Select stpNstp = new Select(stp.get(0));
        stpNstp.selectByValue("2");
        List<WebElement> carrier = driver1.findElements(By.xpath(prop.getProperty("rmrcvcarrier")));
        Select cvcarrier = new Select(carrier.get(0));
        cvcarrier.selectByValue("1");
        List<WebElement> plan = driver1.findElements(By.xpath(prop.getProperty("plantype")));
        Select plantype = new Select(plan.get(0));
        plantype.selectByValue("2");
        //Thread.sleep(2000L);
        plantype.selectByValue("1");
        Thread.sleep(5000L);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement planVal = driver1.findElement(By.xpath(prop.getProperty("plannameid")));
        Select planName = new Select(planVal);
        planName.selectByValue("5152");
        Thread.sleep(4000L);
        driver1.findElement(By.xpath(prop.getProperty("rmrpreviouspolicyno"))).sendKeys("ABCD12345");
        Thread.sleep(2000L);
        List<WebElement> NCB = driver1.findElements(By.xpath(prop.getProperty("NCBValue")));
        Select NCBValue = new Select(NCB.get(0));
        NCBValue.selectByValue("20");
        Thread.sleep(2000L);
        WebElement regdate =  driver1.findElement(By.xpath(prop.getProperty("rmrregdate")));
        regdate.sendKeys("20-05-2018");
        regdate.sendKeys(Keys.ENTER);
        WebElement mfgdate =  driver1.findElement(By.xpath(prop.getProperty("rmrmfgdate")));
        mfgdate.sendKeys("20-04-2018");
        mfgdate.sendKeys(Keys.ENTER);
        List<WebElement> classtype = driver1.findElements(By.xpath(prop.getProperty("rmrvehicleclasstype")));
        Select Vehicleclasstype = new Select(classtype.get(0));
        Vehicleclasstype.selectByValue("1");
        List<WebElement> subclass = driver1.findElements(By.xpath(prop.getProperty("rmrvehiclesubclass")));
        Select Vehiclesubclass = new Select(subclass.get(0));
        Vehiclesubclass.selectByValue("1");
        driver1.findElement(By.xpath(prop.getProperty("rprCC"))).sendKeys("1200");
        driver1.findElement(By.xpath(prop.getProperty("rmrcvgvw"))).sendKeys("200");
        Thread.sleep(2000L);
        List<WebElement> fuelT = driver1.findElements(By.xpath(prop.getProperty("rmrfuelTypeCV")));
        Select fuelTy = new Select(fuelT.get(0));
        fuelTy.selectByValue("2");
        driver1.findElement(By.xpath(prop.getProperty("rprNoofseats"))).sendKeys("5");
        List<WebElement> wheels = driver1.findElements(By.xpath(prop.getProperty("rmrnoofwheels")));
        Select Noofwheels = new Select(wheels.get(0));
        Noofwheels.selectByValue("4");
        List<WebElement> make= driver1.findElements(By.xpath(prop.getProperty("rmrmake")));
        Select carMake = new Select(make.get(0));
        carMake.selectByVisibleText("MAHINDRA");
        Thread.sleep(2000L);
        List<WebElement> model= driver1.findElements(By.xpath(prop.getProperty("rmrmodel")));
        Select carModel = new Select(model.get(0));
        carModel.selectByVisibleText("215 YUVRAJ");
        Thread.sleep(2000L);
        List<WebElement> term = driver1.findElements(By.xpath(prop.getProperty("rmrpolicyterm")));
        Select policyterm = new Select(term.get(0));
        policyterm.selectByValue("1");
        driver1.findElement(By.xpath(prop.getProperty("rprODPremium"))).sendKeys("20000");
        WebElement TPPremium = driver1.findElement(By.xpath(prop.getProperty("rprTPPremium")));
        TPPremium.clear();
        TPPremium.sendKeys("10000");
        WebElement  NetPremium = driver1.findElement(By.xpath(prop.getProperty("rprnetpremium")));
        NetPremium.clear();
        NetPremium.sendKeys("30000");
        Thread.sleep(2000L);
        driver1.findElement(By.xpath(prop.getProperty("rprsuminsured"))).sendKeys("500000");
        Thread.sleep(2000L);
        driver1.findElement(By.xpath(prop.getProperty("rprgrosspremium"))).sendKeys("35000");
        WebElement submitButt= driver1.findElement(By.xpath(prop.getProperty("updateButton")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver1;
        jse2.executeScript("arguments[0].scrollIntoView()", submitButt);
        jse2.executeScript("arguments[0].click();", submitButt);
        Thread.sleep(50000L);

    }

    @Then("^click on the update button$")
    public void clickOnTheUpdateButton() {
        WebElement submitButt = driver1.findElement(By.xpath(prop.getProperty("updateButton")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver1;
        jse2.executeScript("arguments[0].scrollIntoView()", submitButt);
        jse2.executeScript("arguments[0].click();", submitButt);
    }
}
