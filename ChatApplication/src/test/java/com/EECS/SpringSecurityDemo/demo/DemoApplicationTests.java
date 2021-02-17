package com.EECS.SpringSecurityDemo.demo;

import com.EECS.SpringSecurityDemo.demo.Model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@LocalServerPort
	public int port;

	public static WebDriver driver;

	private String baseURL;

	@BeforeAll
	public static void beforeAll()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println(driver);
	}

	@AfterAll
	public static void afterAll()
	{
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach()
	{
		baseURL = "http://localhost:" + port;
	}

	@Test
	public void testUserSignup()
	{
		String firstname = "Abhishek";
		String lastname = "Iswalkar";
		String username = "aiswalkar";
		String password = "abc123";

		driver.get(baseURL+"/signup");

		SignupPage page = new SignupPage(driver);
		String  result = page.signupUser(firstname,lastname,username, password);
		assertEquals("You successfully signed up! Please continue to the login page.",result);
	}

	@Test
	public void testUserLogin()
	{
		driver.get(baseURL+"/login");
		String username = "aiswalkar";
		String password = "abc123";
		LoginPage page = new LoginPage(driver);
		String  result = page.loginUser(username, password);
		assertEquals("success",result);

		HomePage homePage = new HomePage(driver);
		homePage.setMessage("Hi Abhishek", "Shout");
		ChatMessage message = homePage.getMessage();
		assertEquals("aiswalkar",message.getUsername());
		assertEquals("HI ABHISHEK",message.getMessageText());
	}

	/*
	@Test
	public void testMessagePosting()
	{
		//driver.get(baseURL+"/home");
		HomePage homePage = new HomePage(driver);
		homePage.setMessage("Hi Abhishek", "Shout");
		ChatMessage message = homePage.getMessage();
		assertEquals("aiswalkar",message.getUsername());
		assertEquals("HI ABHISHEK",message.getMessageText());
	}
	 */
}
