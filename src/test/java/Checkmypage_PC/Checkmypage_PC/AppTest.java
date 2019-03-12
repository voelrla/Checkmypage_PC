package Checkmypage_PC.Checkmypage_PC;

import static com.codeborne.selenide.Selenide.open;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import com.codeborne.selenide.WebDriverRunner;

public class AppTest {
	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverRunner.setWebDriver(driver);
		open("http://wemakeprice.com");

		try {
			File f2 = new File("login.txt");
			FileReader fr = new FileReader(f2);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				StringTokenizer str = new StringTokenizer(line, ";");
				while (str.hasMoreTokens()) {
					String name = str.nextToken();
					String value = str.nextToken();
					String domain = str.nextToken();
					String path = str.nextToken();
					Date expiry = null;
					String dt;
					if (!(dt = str.nextToken()).equals("null")) {
						// expiry = new Date(dt);
					}
					boolean isSecure = new Boolean(str.nextToken()).booleanValue();
					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
					driver.manage().addCookie(ck);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void CheckRcode() throws Exception {
		URL url = new URL(driver.getCurrentUrl());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		int code = connection.getResponseCode();
		System.out.println("ResponseCode :" + code);
		AssertJUnit.assertEquals(200, code);
	}

}
