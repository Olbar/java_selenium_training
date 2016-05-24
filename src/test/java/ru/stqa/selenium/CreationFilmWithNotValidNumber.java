package ru.stqa.selenium;


import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreationFilmWithNotValidNumber extends TestNgTestBase {
 

 
  @Test
  public void testCreationFilmWithNotValidNumber() throws Exception {
	driver.get(baseUrl + "/php4dvd/");
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.name("submit")).click();
    WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[alt=\"Add movie\"]")));
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("dfd");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("dfdf");
    driver.findElement(By.id("submit")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[class=\"required digits error\"]")));
    driver.quit();
  }

  
  
}
