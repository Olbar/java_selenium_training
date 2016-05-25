package ru.stqa.selenium;


import org.testng.annotations.*;
import static org.testng.Assert.*;


import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFilmNotFound extends TestNgTestBase {
  

 

  @Test
  public void testSearchFilmNotFound() throws Exception {
	driver.get(baseUrl + "/php4dvd/");
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys("admin");
	driver.findElement(By.name("submit")).click();
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.movie_cover")));
	driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#imdbsearch")));
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("ertretretretersdfdsfdsfds");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.content")));
    int count1=driver.findElement(By.cssSelector("div.content > div")).findElements(By.tagName("tr")).size();
    assertEquals(count1,0);
    System.out.println("Найдено фильмов -"+ count1+"шт");
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("abfdgfddfgfdgdf");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.content")));
    int count2=driver.findElement(By.cssSelector("div.content > div")).findElements(By.tagName("tr")).size();
    assertEquals(count2,0);
    System.out.println("Найдено фильмов -"+ count2+"шт");
    driver.quit();
  }
}
