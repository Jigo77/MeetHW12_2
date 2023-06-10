package testSuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unit.Utility;

public class LoginTest extends Utility {
    String url = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void set(){
        openBrowser(url);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        inputdata(By.xpath("//input[@name='username']"),"meet123");

        inputdata(By.xpath("//input[@name='password']"),"meet123");

        click(By.xpath("//input[@value='Log In']"));

        WebElement welcome = driver.findElement(By.xpath("//h1"));
        String actualmessage = welcome.getText();
        String expectedmessage = "Accounts Overview";
        Assert.assertEquals("Verifying LoginMessage",expectedmessage,actualmessage);

        System.out.println(actualmessage);
    }

    @Test
    public void verifyTheErrorMessage(){
        inputdata(By.xpath("//input[@name='username']"),"meet12");

        inputdata(By.xpath("//input[@name='password']"),"meet12");

        click(By.xpath("//input[@value='Log In']"));

        WebElement welcome = driver.findElement(By.xpath("//div[@id='rightPanel']/p"));
        String actualmessage = welcome.getText();
        String expectedmessage = "An internal error has occurred and has been logged.";
        Assert.assertEquals("Verifying LoginMessage",expectedmessage,actualmessage);

        System.out.println(actualmessage);
    }

    @Test
    public void userShouldLogOutSuccessfully(){
        inputdata(By.xpath("//input[@name='username']"),"meet123");

        inputdata(By.xpath("//input[@name='password']"),"meet123");

        click(By.xpath("//input[@value='Log In']"));

        click(By.xpath("//div[@id='leftPanel']/ul/li[8]"));

        WebElement welcome = driver.findElement(By.xpath("//h2"));
        String actualmessage = welcome.getText();
        String expectedmessage = "Customer Login";
        Assert.assertEquals("Verifying LoginMessage",expectedmessage,actualmessage);

        System.out.println(actualmessage);
    }
    @After
    public void close(){
       // closeBrowser();
    }
}
