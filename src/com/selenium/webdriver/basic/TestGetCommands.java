package com.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.seleniumhq.jetty9.server.ResourceService.WelcomeFactory;

public class TestGetCommands {

	WebDriver driver;
	private static final String regex = "^(.+)@(.+)$";

	public void invokeBrowser() {

		try {
			System.setProperty("webdriver.chrome.driver", "D:\\selenium-java-3.141.59\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getCommands() {

		try {
			driver.get("http://www.amazon.com.au");
			String titleOfPage = driver.getTitle();
			System.out.println("Title of the Page is :" + titleOfPage);
			System.out.println("Your URL is "+driver.getCurrentUrl());
			driver.findElement(By.linkText("Today's Deals")).click();
			String currentURL = driver.getCurrentUrl();
			System.out.println("Now the current URL is : "+currentURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			driver.close();
		}

	}

	public void facebookTest() {


		try {
			driver.get("https://www.facebook.com/");
			driver.findElement(By.linkText("Create New Account")).click();

			//Entering First Name
			WebElement first_name = driver.findElement(By.name("firstname"));
			first_name.sendKeys("Amandeep");

			//Entering Last NAme
			WebElement last_name =  driver.findElement(By.name("lastname"));
			last_name.sendKeys("Singh");

			//Entering Email/Mobile

			WebElement email = driver.findElement(By.name("reg_email__"));
			email.sendKeys("amansoodan2018@gmail.com");
			//email.sendKeys("0424374959");
			Thread.sleep(3000);
			
			//Entering re-confirming email
			if(driver.findElement(By.name("reg_email_confirmation__")).isDisplayed()) {
			WebElement confirmEmail = driver.findElement(By.name("reg_email_confirmation__"));
			confirmEmail.sendKeys("amansoodan2018@gmail.com");
			}


			//Selecting Birth Day
			WebElement birthDay = driver.findElement(By.name("birthday_day"));
			Select day = new Select(birthDay);
			day.selectByVisibleText("12");

			//Selecting Birth Month
			WebElement birthMonth = driver.findElement(By.name("birthday_month"));
			Select month = new Select(birthMonth);
			//Thread.sleep(3000);
			month.selectByVisibleText("Sep");

			//Selecting Birth Year
			WebElement birthYear = driver.findElement(By.name("birthday_year"));
			Select year = new Select(birthYear);
			//	Thread.sleep(3000);
			year.selectByVisibleText("1987");

			//Selecting Gender

			//WebElement radio = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[2]/input"));
			WebElement radio = driver.findElement(By.xpath("//form/div[1]/div[7]/span/span[2]/input"));
			radio.click();



		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestGetCommands tgc = new TestGetCommands();
		tgc.invokeBrowser();
		//tgc.getCommands();
		tgc.facebookTest();

	}

}
