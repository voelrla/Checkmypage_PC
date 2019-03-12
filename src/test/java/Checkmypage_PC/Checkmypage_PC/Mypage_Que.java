package Checkmypage_PC.Checkmypage_PC;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.impl.Html;

import static com.codeborne.selenide.Selenide.*;

public class Mypage_Que extends AppTest {
	@Test(priority = 1)
	public void Mypage_Rcoupon() throws Exception {
		open("http://www.wemakeprice.com/mypage/qna");
//		$(By.id("pop_btn_don_show1")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h3[contains(.,'1:1문의')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/qna")); // URL 체크
		assertTrue(Htext.contains("문의")); // 정상 로그인 체크
		CheckRcode();
		screenshot("mypage_qun");
	}

}
