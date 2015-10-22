package be.ua.iw.ei.se;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Kevin on 20/10/2015.
 */
public class SeleniumTestProb {

    @Test
    public void startWebDriver() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.navigate().to("http://146.175.138.153/");
        Assert.assertTrue("body should start with this is a TEST" ,        //asserTrue proberen met Title
                driver.getTitle().startsWith("IDT"));

        driver.close();
        driver.quit();

    }
}
