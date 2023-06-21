package stepDef;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.ResultSet;

public class Dashboard extends TestBase {
    @Then("^Validate Support Tickets tab under My Actionables$")
    public void validateSupportTicketsTabUnderMyActionables() {
        String spticket =driver.findElement(By.xpath("//h5[contains(text(),'Support Tickets')]")).getText();
        if(spticket.contains("Support Tickets")){
            driver.findElement(By.xpath(prop.getProperty("supportTickets"))).click();
        }
        driver.navigate().back();
        try {
            String query = "use POSPDB EXEC [stats].[GetProductWiseBusinessStats_v1] @AffiliateCode='IP9022', @FromDate='2023-05-01', @ToDate='2023-05-09', @businessCheckOn=1";
// Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
// Print the result untill all the records are printed
// res.next() returns true if there is any next record else returns false
            int counter = 0;
            while (res.next()) {
                System.out.print(" " + res.getString(1));
                System.out.print(" " + res.getString(2));
                System.out.print(" " + res.getString(3));
                System.out.println(" " + res.getString(4));
                System.out.print(" " + res.getString(5));
                System.out.print(" " + res.getString(6));
                System.out.println(" " + res.getString(7));
                counter += res.getInt(3);
                System.out.println(counter);
                WebElement totalPol = driver.findElement(By.xpath("//div[@class='details']//h6"));
                String totalPol1 = totalPol.getText();
                String polCount=  res.getString(1);
                   //     Assert.assertEquals("Total Policies\r\n"+ polCount,totalPol1);
                //Assert.assertEquals(res.getString(1),1234);
            }
//            List<WebElement> leadId = driver.findElements(By.xpath("//span[@class='leadid']"));
//            for(WebElement e:leadId){
//              String leadValue=  res.getString(1);
//                Assert.assertEquals(leadValue,e.getText());
////                Assert.assertEquals(res.getString(1),1234); ---to get values through UI
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Then("^Validate Offline Request tab under My Actionables$")
    public void validateOfflineRequestTabUnderMyActionables() {
        driver.findElement(By.xpath(prop.getProperty("OfflineRequest"))).click();
        driver.navigate().back();
    }
    @Then("^Validate Leads tab under My Actionables$")
    public void validateLeadsTabUnderMyActionables() {
        driver.findElement(By.xpath(prop.getProperty("leads"))).click();
        driver.navigate().back();
    }
    @Then("^Click on continue button through leads$")
    public void clickOnContinueButtonThroughLeads() {
        driver.findElement(By.xpath(prop.getProperty("continueLeadButton"))).click();
        driver.navigate().back();
    }
}
