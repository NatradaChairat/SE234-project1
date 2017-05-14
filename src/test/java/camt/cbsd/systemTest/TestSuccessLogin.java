package camt.cbsd.systemTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
public class TestSuccessLogin {
    @Test
    public void  testLoginOnFF() throws InterruptedException {
         WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://localhost:4200";
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Course list".equals(driver.findElement(By.linkText("Course list")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Course list", driver.findElement(By.linkText("Course list")).getText());
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("List".equals(driver.findElement(By.linkText("List")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("List", driver.findElement(By.linkText("List")).getText());
        assertEquals("Add", driver.findElement(By.linkText("Add")).getText());
        assertEquals("View", driver.findElement(By.linkText("View")).getText());
        assertEquals("Add Course", driver.findElement(By.linkText("Add Course")).getText());

    }

    @Test
    public void testLoginOnChrome() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        String baseUrl = "http://localhost:4200";

        driver2.get(baseUrl + "/login");
        driver2.findElement(By.id("username")).sendKeys("admin");
        driver2.findElement(By.id("password")).sendKeys("admin");
        driver2.findElement(By.cssSelector("button.btn.btn-primary")).click();

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Course list".equals(driver2.findElement(By.linkText("Course list")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Course list", driver2.findElement(By.linkText("Course list")).getText());
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("List".equals(driver2.findElement(By.linkText("List")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("List", driver2.findElement(By.linkText("List")).getText());
        assertEquals("Add", driver2.findElement(By.linkText("Add")).getText());
        assertEquals("View", driver2.findElement(By.linkText("View")).getText());
        assertEquals("Add Course", driver2.findElement(By.linkText("Add Course")).getText());


    }
}
