package utils;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import jdk.jfr.events.FileReadEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
   public FileReader reader;

  public  Properties prop = new Properties();
    // Connection object
    Connection con = null;
    // Statement object
    public Statement stmt;
    // Constant for Database URL
    public String DB_URL = "jdbc:sqlserver://10.81.5.54:1433;databaseName=PospDB";
    //Database Username
    public String DB_USER = "Affiliate";
    // Database Password
    public static String DB_PASSWORD = "Affiliate@546510@Us@er";


    public void setUp() throws IOException {
       // if (driver == null) {
            reader = new FileReader("application.properties");
            prop.load(reader);
            try {
// Database connection
                String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                Class.forName(dbClass).newInstance();
                Connection con;
// Get connection to DB
                if (prop.getProperty("env").equalsIgnoreCase("prod")) {
                    con = DriverManager.getConnection(prop.getProperty("DBUrlProd"), prop.getProperty("DBUserNameProd"), prop.getProperty("DBPasswordProd"));
                } else {
                    con = DriverManager.getConnection(prop.getProperty("DBUrlQA"), prop.getProperty("DBUserNameQA"), prop.getProperty("DBPasswordQA"));
                }
// Statement object to send the SQL statement to the Database
                stmt = con.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
       // }
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "Test/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
           // options.addArguments("--headless");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            if (prop.getProperty("env").equalsIgnoreCase("prod")) {
                driver.get(prop.getProperty("ProdURL"));
            } else {
                driver.get(prop.getProperty("QAURL"));
            }
            driver.manage().window().maximize();
        }
    }



//    public void closeBrowser(){
//        driver.quit();



    }



