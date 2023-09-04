package stepDef.RaiseMappingRequest;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import stepDef.TestBase;

public class RaiseMappingRequestCVHDFCStepdefs extends TestBase {
    @When("^click on Request offline Quote button on left navigation$")
    public void clickOnRequestOfflineQuoteButtonOnLeftNavigation() {
        driver.findElement(By.xpath("//li[@id='id-offlinereq']")).click();
    }
}
