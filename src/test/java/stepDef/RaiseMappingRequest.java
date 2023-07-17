package stepDef;


import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RaiseMappingRequest extends TestBase {
    String parent;


    public RaiseMappingRequest() throws IOException, InterruptedException {
    }
    @When("^click on Request Offline Quote navigations \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void clickOnRequestOfflineQuoteNavigations(String prodID, String custName, String regisNum, String polNum, String preMium, String docUpload) throws Throwable {
        driver.findElement(By.xpath("(//a[@data-bs-toggle='collapse'])[1]")).click();
        WebElement childElement = driver.findElement(By.xpath("//li[@data-sidenav='raise-mapping-request']"));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
       // JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement);
        jse2.executeScript("arguments[0].click();", childElement);
        childElement.click();
//        Actions action = new Actions(driver);
//        WebElement childElement = driver.findElement(By.xpath("//li[@data-sidenav='raise-mapping-request']"));
//        action.moveToElement(childElement).click().perform();

        List<WebElement> productName = driver.findElements(By.xpath(prop.getProperty("prodID")));
        Select details = new Select(productName.get(0));
        details.selectByValue(prodID);
        driver.findElement(By.xpath(prop.getProperty("custName"))).sendKeys(custName);
        driver.findElement(By.xpath(prop.getProperty("regisNum"))).sendKeys(regisNum);
        WebElement insurer = driver.findElement(By.xpath(prop.getProperty("insID")));
        Select insurerdropdown = new Select(insurer);
        insurerdropdown.selectByValue("1");
        driver.findElement(By.xpath(prop.getProperty("polNum"))).sendKeys(polNum);
        driver.findElement(By.xpath(prop.getProperty("preMium"))).sendKeys(preMium);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // identify element
        WebElement l = driver.findElement(By.xpath(prop.getProperty("docUpload")));
        // file path passed with sendkeys()
        l.sendKeys(docUpload);
        WebElement submitButton = driver.findElement(By.xpath(prop.getProperty("subBut")));
        //JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", submitButton);
        jse2.executeScript("arguments[0].click();", submitButton);
        Thread.sleep(70000l);

    }
    @Then("^Open the Admin Panel \"([^\"]*)\", \"([^\"]*)\"$")
    public void openTheAdminPanel(String prePolNum, String netPremium) throws Throwable {
        WebElement sentenceElement = driver.findElement(By.xpath("//div[@class='alert alert-success alert-important']"));
        // Get the text from the element
        String sentence = sentenceElement.getText();
        // Split the sentence into words using whitespace as the delimiter
        String[] words = sentence.split("\\s+");
        // Extract the last word from the array
        String lastWord = words[words.length - 1];
        // Display the last word
        System.out.println("Last Word: " + lastWord);
//        String ID = driver.findElement(By.xpath("//div[@class='alert alert-success alert-important']")).getText();
        System.setProperty("webdriver.chrome.driver", "D:\\Cucumber_automation\\Test\\chromedriver.exe");
        WebDriver driver1 = new ChromeDriver();
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
//        driver1.findElement(By.xpath(prop.getProperty("adminTickets"))).click();
//        new WebDriverWait(driver1, 20).until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("adminTickets")))).click();
        JavascriptExecutor jse2 = (JavascriptExecutor) driver1;
        jse2.executeScript("arguments[0].scrollIntoView()", childElement1);
        jse2.executeScript("arguments[0].click();", childElement1);
        driver1.findElement(By.xpath(prop.getProperty("viewTickets"))).click();
        driver1.findElement(By.xpath(prop.getProperty("globalSearch"))).sendKeys(lastWord);
        driver1.findElement(By.xpath(prop.getProperty("ticketEditButton"))).click();
        WebElement childElement4=driver1.findElement(By.xpath(prop.getProperty("verifyButtonAdmin")));
        JavascriptExecutor jse3 = (JavascriptExecutor) driver1;
        jse3.executeScript("arguments[0].scrollIntoView()", childElement4);
        jse3.executeScript("arguments[0].click();", childElement4);
        List<WebElement> busiType = driver1.findElements(By.xpath(prop.getProperty("businessTypeVerify")));
        Select businessType = new Select(busiType.get(0));
        businessType.selectByValue("2");
        List<WebElement> stp = driver1.findElements(By.xpath(prop.getProperty("stpNstp")));
        Select stpNstp = new Select(stp.get(0));
        stpNstp.selectByValue("1");
        List<WebElement> planVal = driver1.findElements(By.xpath(prop.getProperty("planId")));
        Select planId = new Select(planVal.get(0));
        planId.selectByValue("3139");
        driver1.findElement(By.xpath(prop.getProperty("prePolNum"))).sendKeys(prePolNum);
       List<WebElement> fuelT = driver1.findElements(By.xpath(prop.getProperty("fuelType")));
       Select fuelTy = new Select(fuelT.get(0));
        fuelTy.selectByValue("2");
      List<WebElement> mode= driver1.findElements(By.xpath(prop.getProperty("model")));
      Select carModel = new Select(mode.get(0));
        carModel.selectByVisibleText("CARNIVAL");
        driver1.findElement(By.xpath(prop.getProperty("netPremium"))).sendKeys(netPremium);
        WebElement submitButt= driver1.findElement(By.xpath(prop.getProperty("updateButton")));
        jse2.executeScript("arguments[0].scrollIntoView()", submitButt);
        jse2.executeScript("arguments[0].click();", submitButt);
//       List<WebElement> term = driver1.findElements(By.xpath(prop.getProperty("polTerm")));
//       Select termpol= new Select(mode.get(0));
//        termpol.selectByValue("1");
    }
}
