import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Registration extends Variables {
    @Test
    public void validRegistration() throws IOException, InterruptedException {
//        driver=setDriver();
//        properties=setProperties();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com/mercurywelcome.php");



        WebElement Register = driver.findElement(By.xpath("//a[text()='REGISTER']"));
        Register.click();


        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(properties.getProperty("FirstName"));
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(properties.getProperty("LastName"));

        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(properties.getProperty("Phone"));
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(properties.getProperty("Email"));

        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(properties.getProperty("Address"));
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys(properties.getProperty("City"));
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys(properties.getProperty("State"));
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(properties.getProperty("PostalCode"));

        WebElement select = driver.findElement(By.xpath("//select[@name='country']"));
        Select dropDown = new Select(select);
        dropDown.selectByVisibleText(properties.getProperty("Country"));
       /* List<WebElement> options = dropDown.getOptions();
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().trim().equals(prop.getProperty("Country"))) {
                dropDown.selectByValue(options.get(i).getAttribute("value"));
            }

        }*/
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(properties.getProperty("UserName"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(properties.getProperty("Password"));
        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(properties.getProperty("Password"));

        driver.findElement(By.xpath("//input[@name='register']")).click();

        String expected= "Dear " + properties.getProperty("FirstName") + " " + properties.getProperty("LastName") + ",";
        String actual = driver.findElement(By.xpath("//tr/td/p/font/b")).getText();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
        driver.close();


    }







}











