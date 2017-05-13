package camt.cbsd;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Lab05ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetCourseCount(){

		/*CourseServiceImpl course = new CourseServiceImpl();
		assert(course.getCourseCount()== 3);*/
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:4200";
        
        //assertEquals("Enroll Course 3", driver.findElement(By.cssSelector("button.btn.btn-primary")).getText());
        driver.get(baseUrl + "/login");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn.btn-primary")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary")));
        assertEquals("Enroll Course 3", driver.findElement(By.cssSelector("button.btn.btn-primary")).getText());

	}


}
