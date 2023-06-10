package testSuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unit.Utility;

public class RegisterTest extends Utility {
    String url = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(url);

    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        click(By.xpath("//a[contains(text(),\"Register\")]"));   //click on Register link

        WebElement welcome = driver.findElement(By.xpath("//h1"));
        String actualmessage = welcome.getText();
        String expectedmessage = "Signing up is easy!";
        Assert.assertEquals("Verifying SigningMessage", expectedmessage, actualmessage);
        System.out.println(actualmessage);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        click(By.xpath("//a[contains(text(),\"Register\")]"));

        inputdata(By.xpath("//input[@id='customer.firstName']"), "Meet");   //FisrtName

        inputdata(By.xpath("//input[@id='customer.lastName']"), "Patel");  //LastName

        inputdata(By.xpath("//input[@id='customer.address.street']"), "387510");//Address

        inputdata(By.xpath("//input[@id='customer.address.city']"), "Harrow");   //City

        inputdata(By.xpath("//input[@id='customer.address.state']"), "London");  //State

        inputdata(By.xpath("//input[@id='customer.address.zipCode']"), "38751"); //Zipcode

        inputdata(By.xpath("//input[@id='customer.phoneNumber']"), "0742323232");//Phone Number

        inputdata(By.xpath("//input[@id='customer.ssn']"), "07272727772");//SSN

        inputdata(By.xpath("//input[@id='customer.username']"), "meet123");   //username

        inputdata(By.xpath("//input[@id='customer.password']"), "meet123");  //Password

        inputdata(By.xpath("//input[@id='repeatedPassword']"), "meet123");//conformPassword

        click(By.xpath("//input[@value='Register']"));

        WebElement welcome = driver.findElement(By.xpath("//div[@id='rightPanel']/p"));
        String actualmessage = welcome.getText();
        String expectedmessage = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals("Verifying Desktop Message", expectedmessage, actualmessage);
        System.out.println(actualmessage);


    }
    @After
    public void close(){
        //closeBrowser();
    }
}
