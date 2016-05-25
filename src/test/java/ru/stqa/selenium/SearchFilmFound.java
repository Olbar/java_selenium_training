package ru.stqa.selenium;


import org.testng.annotations.*;
import static org.testng.Assert.*;


import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFilmFound extends TestNgTestBase {
  

 

  @Test
  public void testSearchFilmFound() throws Exception {
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
    driver.findElement(By.id("imdbsearch")).sendKeys("a");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("table.imdbmovies")));
    int count1=driver.findElement(By.cssSelector("table.imdbmovies")).findElements(By.tagName("tr")).size();
    assertNotEquals(count1,0);
    System.out.println("Найдено фильмов"+ -count1+"шт");
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("ab");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("table.imdbmovies")));
    int count2=driver.findElement(By.cssSelector("table.imdbmovies")).findElements(By.tagName("tr")).size();
    assertNotEquals(count2,0);
    System.out.println("Найдено фильмов"+ -count2+"шт");
    driver.quit();
  }
}
