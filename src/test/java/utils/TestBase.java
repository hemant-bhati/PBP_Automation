package utils;


import jdk.jfr.events.FileReadEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
   public FileReader reader = new FileReader("application.properties");
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


    public TestBase() throws IOException {
    prop.load(reader);
        try{
// Database connection
            String dbClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(dbClass).newInstance();
// Get connection to DB
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
// Statement object to send the SQL statement to the Database
            stmt = con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

}
