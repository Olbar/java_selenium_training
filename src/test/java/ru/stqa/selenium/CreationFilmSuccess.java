package ru.stqa.selenium;


import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreationFilmSuccess extends TestNgTestBase {

 
  @Test
  public void testCreationFilmSuccess() throws Exception {
	driver.get(baseUrl + "/php4dvd/");
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.name("submit")).click();
	WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.movie_cover")));
	int count1= driver.findElement(By.cssSelector("div#results")).findElements(By.tagName("a")).size();
	System.out.println("count1"+- count1);
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.name("imdbid")).clear();
    driver.findElement(By.name("imdbid")).sendKeys("1");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("film222");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2015");
    driver.findElement(By.id("submit")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[alt=\"Edit\"]")));
    driver.findElement(By.linkText("Home")).click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.movie_cover")));
    int count2= driver.findElement(By.cssSelector("div#results")).findElements(By.tagName("a")).size();
    System.out.println("count2"+ -count2);
    int res=count2-count1;
    System.out.println("res"+ -res);
    assertEquals(res,1);
    driver.quit();
   

	
}

 
}
