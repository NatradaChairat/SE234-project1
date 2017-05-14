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
public class TestUrl {

    @Test
    public void testLink() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://localhost:4200";
        driver.get(baseUrl + "/lp");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("The resource you have asked is not in the server".equals(driver.findElement(By.cssSelector("h2")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
        assertEquals("The resource you have asked is not in the server", driver.findElement(By.cssSelector("h2")).getText());

    }
}
