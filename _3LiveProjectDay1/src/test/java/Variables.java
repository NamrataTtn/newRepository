import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Variables {
    WebDriver driver;
    Properties properties;


    @BeforeClass
    public  void setDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/assignment/_3LiveProjectDay1/driver/chromedriver");
        driver = new ChromeDriver();
        properties = new Properties();
        File f = new File("/home/ttn/assignment/_3LiveProjectDay1/testData.properties");
        FileInputStream fip = new FileInputStream(f);
        properties.load(fip);

    }


    public void Login_with_valid_credentials() throws IOException {


//        driver=setDriver();
//        properties=setProperties();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com/");


        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(properties.getProperty("UserName"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(properties.getProperty("Password"));
        driver.findElement(By.xpath("//input[@name='login']")).click();


        String actual = driver.getCurrentUrl();
        System.out.println(actual);
        String expected = "http://newtours.demoaut.com/mercuryreservation.php";
        Assert.assertTrue(actual.contains(expected));
    }


        @AfterSuite
    public void close()
        {
            driver.quit();
        }

}
