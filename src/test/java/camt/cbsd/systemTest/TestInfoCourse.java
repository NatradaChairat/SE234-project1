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
public class TestInfoCourse {
    @Test
    public void testInfoCourse() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://localhost:4200";
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Enroll Course 3".equals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Enroll Course 3", driver.findElement(By.cssSelector("button.btn.btn-primary")).getText());
        assertEquals("1", driver.findElement(By.cssSelector("td")).getText());
        assertEquals("953331", driver.findElement(By.xpath("//td[2]")).getText());
        assertEquals("CBSD", driver.findElement(By.xpath("//td[3]")).getText());
        assertEquals("2", driver.findElement(By.xpath("//tr[2]/td")).getText());
        assertEquals("953323", driver.findElement(By.xpath("//tr[2]/td[2]")).getText());
        assertEquals("Software Construction", driver.findElement(By.xpath("//tr[2]/td[3]")).getText());
        assertEquals("3", driver.findElement(By.xpath("//tr[3]/td")).getText());
        assertEquals("953499", driver.findElement(By.xpath("//tr[3]/td[2]")).getText());
        assertEquals("Software Project", driver.findElement(By.xpath("//tr[3]/td[3]")).getText());


    }
}
