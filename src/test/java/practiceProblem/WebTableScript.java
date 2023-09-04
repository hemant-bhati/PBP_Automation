package practiceProblem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class WebTableScript {
    public static void main(String args[]) {
        System.setProperty("webdriver.chrome.driver", "Test/Test.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/test/web-table-element.php");
       List<WebElement> list= driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr"));
        String beforeXpath="//table[@class='dataTable']/tbody/tr[";
        String afterXpath="]";
        String xpathTd="//td[";
        String xpathTdClose="]";
        //table[@class='dataTable']/tbody/tr[1]
         for(int i=1; i<=list.size(); i++){
            String finalXpath = beforeXpath + i+afterXpath;
            for(int j=1; j<=5; j++){
                String finalTdXpath = finalXpath + xpathTd+j +xpathTdClose;
                List<WebElement> tableValue= driver.findElements(By.xpath(finalTdXpath));
                for(WebElement value:tableValue){
                    System.out.println(value.getText());
                }
            }


        }
    }
}
