package unit;

import browserFactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    public void click(By by){
        WebElement cl = driver.findElement(by);
        cl.click();
    }

    public void inputdata(By by,String keys){
        WebElement inp = driver.findElement(by);
        inp.sendKeys(keys);
    }


}
