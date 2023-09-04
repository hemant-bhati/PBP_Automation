package practiceProblem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SvgGraph {
    public static void main(String args[]){
        System.setProperty("webdriver.chrome.driver", "cromeDriver/Test.exe");
       WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.worldometers.info/coronavirus/country/india/");
        List<WebElement> points = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[2]//*[name()='path']"));

        for(WebElement e:points){
            Actions a = new Actions(driver);
            a.moveToElement(e).perform();
           List<WebElement> case1 = driver.findElements(By.xpath("(//*[local-name()='svg' and @class='highcharts-root'])[2]//*[name()='text' and @x='8']//*[name()='tspan']"));
           for(WebElement values:case1){
               System.out.println(values.getText());
           }

        }
//        List<WebElement> points= driver
//        (//*[local-name()='svg' and @class='highcharts-root'])[4]//*[name()='path']
    }



}
