package ru.stqa.selenium;


import org.testng.annotations.*;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteFirstFilm extends TestNgTestBase {


  @Test
  public void testDeleteFirstFilm() throws Exception {
    driver.get(baseUrl + "/php4dvd/");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.name("submit")).click();
    driver.get(baseUrl + "/php4dvd/?go=movie&id=40");
    WebDriverWait wait=new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.movie_cover")));
	int count1= driver.findElement(By.cssSelector("div#results")).findElements(By.tagName("a")).size();
	System.out.println("count1"+- count1);
	driver.findElement((By.cssSelector("div.movie_cover"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[alt=\"Remove\"]")));
    driver.findElement(By.cssSelector("img[alt=\"Remove\"]")).click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.movie_cover")));
	int count2= driver.findElement(By.cssSelector("div#results")).findElements(By.tagName("a")).size();
	System.out.println("count2"+- count2);
	int res=count1-count2;
    System.out.println("res"+- res);
    assertEquals(res,1);
    driver.quit();
  



  }
  
}
