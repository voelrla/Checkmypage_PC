package Checkmypage_PC.Checkmypage_PC;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.impl.Html;

import static com.codeborne.selenide.Selenide.*;

public class Mypage_Cancel extends AppTest {

	@Test(priority = 1)
	public void Mypage_Recancel() throws Exception {
		open("http://www.wemakeprice.com/mypage/buylist/cancel_ing_list_v2");
//		$(By.id("pop_btn_don_show1")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h3[contains(.,'취소/교환/반품 조회')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/buylist/cancel_ing_list_v2")); // URL 체크
		assertTrue(Htext.contains("취소/교환/반품 조회")); // 정상 로그인 체크
		CheckRcode();
		screenshot("mypage_recancel");
	}

	@Test(priority = 2)
	public void Mypage_Decancel() throws Exception {

		$(By.linkText("상품beta")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h4[contains(.,'취소/교환/반품 조회')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "https://front.wemakeprice.com/mypage/claim")); // URL 체크
		assertTrue(Htext.contains("취소/교환/반품 조회")); // 현재 페이지內 객체 체크
		CheckRcode(); // ResponseCode 200 체크
		screenshot("mypage_decancel");
	}
}
