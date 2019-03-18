import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BookWithNoDetails extends Variables{


    @Test(priority = 2)
            public void bookingWithNoDetails() throws IOException {

//         driver=setDriver();
//         properties=setProperties();

        Login_with_valid_credentials();

            driver.findElement(By.xpath("//input[@name='findFlights']")).click();
            driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
            driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
            String current_url = driver.getCurrentUrl();
            String current_url2 = "http://newtours.demoaut.com/mercurypurchase2.php";
            Assert.assertNotEquals(current_url,current_url2);
        }
    }