package com.EECS.SeleniumJUnitdemo;

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
class SeleniumJUnitdemoApplicationTests {
	@LocalServerPort
	private Integer port;
	private static WebDriver driver;
	private CounterPage counter;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}

	@BeforeEach
	public void beforeEach() {
		driver.get("http://localhost:" + port + "/counter");
		counter = new CounterPage(driver);
	}

	@Test
	public void testIncrement() {
		int prevCount = counter.getDisplayCount();
		counter.incrementCount();
		assertEquals(prevCount + 1, counter.getDisplayCount());
	}

	@Test
	public void testIncrementTenTimes() {
		int prevCount = counter.getDisplayCount();

		for (int i = 0; i < 10; i++) {
			assertEquals(prevCount + i, counter.getDisplayCount());
			counter.incrementCount();
		}
	}

	@Test
	public void testReset()
	{
		counter.resetCount(10);
		assertEquals(10,counter.getDisplayCount());
		counter.resetCount(20);
		assertEquals(20,counter.getDisplayCount());
	}

}
