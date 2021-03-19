package com.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium-java-3.141.59\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.edureka.co");
			
			
			searchCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchCourse() {
		driver.findElement(By.className("open_search_overlay")).click();
		driver.findElement(By.id("search-input")).sendKeys("Java");
			
		WebElement searchbox = driver.findElement(By.id("search-input"));
		searchbox.sendKeys(Keys.ENTER);

		driver.findElement(By.cssSelector("div.dropdown:nth-child(3) > button:nth-child(1)")).click();
		
		
		driver.findElement(By.cssSelector(".trainingandbatchtype > div:nth-child(2) > div:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > label:nth-child(2)")).click();
		
		driver.findElement(By.cssSelector(".trainingandbatchtype > div:nth-child(3) > a:nth-child(1)")).click();

	//	driver.close();
		

			
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirstScript firstScript = new FirstScript();
		firstScript.invokeBrowser();

	}

}
