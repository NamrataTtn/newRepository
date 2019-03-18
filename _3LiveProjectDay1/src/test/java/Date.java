import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Date extends Variables{




    @Test(priority = 3)
    public void Book_With_Date_Issue() throws IOException {

//        driver=setDriver();
//        properties=setProperties();
            Login_with_valid_credentials();
        String type = properties.getProperty("FlightType");
        type = type.replace(" ", "").toLowerCase();
        driver.findElement(By.xpath("//input[@value='" + type + "']")).click();

        WebElement passCount = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passenger = new Select(passCount);
        passenger.selectByVisibleText(properties.getProperty("Passengers"));

        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select departingCity = new Select(fromPort);
        departingCity.selectByVisibleText(properties.getProperty("DepartingCity"));

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select onMonth = new Select(fromMonth);
        onMonth.selectByVisibleText(properties.getProperty("OnMonth"));

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select onDay = new Select(fromDay);
        onDay.selectByVisibleText(properties.getProperty("OnDate"));

        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select arrivalCity = new Select(toPort);
        arrivalCity.selectByVisibleText(properties.getProperty("ArrivalCity"));

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select returnMonth = new Select(toMonth);
        returnMonth.selectByVisibleText(properties.getProperty("ReturnMonth"));

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select returnDate = new Select(toDay);
        returnDate.selectByVisibleText(properties.getProperty("ReturnDate"));

        driver.findElement(By.xpath("//input[@value='" + properties.getProperty("Class") + "']")).click();

        driver.findElement(By.xpath("//input[@name='findFlights']")).click();
        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();

        driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys(properties.getProperty("FirstName"));
        driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys(properties.getProperty("LastName"));
        //meal
        WebElement meal = driver.findElement(By.xpath("//select[@name='pass.0.meal']"));
        Select mealPrefer = new Select(meal);
        mealPrefer.selectByVisibleText(properties.getProperty("Meal"));

        //cardtype
        WebElement creditCard = driver.findElement(By.xpath("//select[@name='creditCard']"));
        Select card = new Select(creditCard);
        card.selectByVisibleText(properties.getProperty("Card"));

        driver.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys(properties.getProperty("CreditNumber"));
        //expiry
        WebElement expiryDate = driver.findElement(By.xpath("//select[@name='cc_exp_dt_mn']"));
        Select expiryD = new Select(expiryDate);
        expiryD.selectByVisibleText(properties.getProperty("ExpiryDate"));

        WebElement expiryYear = driver.findElement(By.xpath("//select[@name='cc_exp_dt_yr']"));
        Select expiryY = new Select(expiryYear);
        expiryY.selectByVisibleText(properties.getProperty("ExpiryYear"));

        driver.findElement(By.xpath("//input[@name='cc_frst_name']")).sendKeys(properties.getProperty("FirstName"));
        driver.findElement(By.xpath("//input[@name='cc_last_name']")).sendKeys(properties.getProperty("LastName"));
        driver.findElement(By.xpath("//input[@name='billAddress1']")).sendKeys(properties.getProperty("Address"));
        driver.findElement(By.xpath("//input[@name='billCity']")).sendKeys(properties.getProperty("City"));
        driver.findElement(By.xpath("//input[@name='billState']")).sendKeys(properties.getProperty("State"));
        driver.findElement(By.xpath("//input[@name='billZip']")).sendKeys(properties.getProperty("PostalCode"));
//        driver.findElement(By.xpath("")).sendKeys(properties.getProperty(""));

//        WebElement billCountry = driver.findElement(By.xpath("//select[@name='billCountry']"));
//        Select country = new Select(billCountry);
//        country.selectByVisibleText(properties.getProperty("Country").toUpperCase());

        driver.findElement(By.xpath("//input[@name='buyFlights']")).click();

        String actualText = driver.findElement(By.xpath("//b")).getText();
        String expectedText = "Your itinerary has been booked!";
        System.out.println();
        Assert.assertNotEquals(actualText, expectedText);

    }

}
