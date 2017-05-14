package camt.cbsd.systemTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.fail;
import static org.junit.Assert.assertEquals;

/**
 * Created by GL552J on 14/5/2560.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFailedLogin {
    @Test
    public void testLogin() throws InterruptedException{

        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://localhost:4200";
        driver.get(baseUrl + "/login");
        // ERROR: Caught exception [unknown command [forXml]]
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Login".equals(driver.findElement(By.cssSelector("h2")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Unauthorized".equals(driver.findElement(By.cssSelector("div.alert.alert-error")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Unauthorized", driver.findElement(By.cssSelector("div.alert.alert-error")).getText());
        // ERROR: Caught exception [unknown command [endForXml]]


        driver.get(baseUrl + "/login");
        // ERROR: Caught exception [unknown command [forXml]]
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Login".equals(driver.findElement(By.cssSelector("h2")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Enroll Course 3".equals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Enroll Course 3", driver.findElement(By.cssSelector("button.btn.btn-primary")).getText());
        // ERROR: Caught exception [unknown command [endForXml]]



        driver.get(baseUrl + "/login");
        // ERROR: Caught exception [unknown command [forXml]]
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Login".equals(driver.findElement(By.cssSelector("h2")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Username is required".equals(driver.findElement(By.cssSelector("span.help-block")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Username is required", driver.findElement(By.cssSelector("span.help-block")).getText());
        // ERROR: Caught exception [unknown command [endForXml]]



        driver.get(baseUrl + "/login");
        // ERROR: Caught exception [unknown command [forXml]]
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Login".equals(driver.findElement(By.cssSelector("h2")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);

        }

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Password is required".equals(driver.findElement(By.cssSelector("span.help-block")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Password is required", driver.findElement(By.cssSelector("span.help-block")).getText());
        // ERROR: Caught exception [unknown command [endForXml]]


    }
}
