package org.base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlink {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\eclipse-workspace\\Brokenlink\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int brokenlinkcount = 0;
		for (int i = 0; i < links.size(); i++) {
			WebElement link = links.get(i);
			String a = link.getAttribute("href");

			URL s = new URL(a);
			URLConnection openconnection = s.openConnection();
			HttpURLConnection response = (HttpURLConnection) openconnection;
			int responsecode = response.getResponseCode();
			if (responsecode >= 400 && responsecode <= 499) {
				System.out.println(a);
				brokenlinkcount++;
			}
		}
		System.out.println("no of broken link count is :" + brokenlinkcount);
	}

}
