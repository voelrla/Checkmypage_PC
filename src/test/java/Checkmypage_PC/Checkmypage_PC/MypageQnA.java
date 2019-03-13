package Checkmypage_PC.Checkmypage_PC;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.impl.Html;

import static com.codeborne.selenide.Selenide.*;

public class MypageQnA extends MypageStart {
	@Test
	public void Mypage_Rcoupon() throws Exception {
		open("http://www.wemakeprice.com/mypage/deal_qna_list");
//		$(By.id("pop_btn_don_show1")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//div[@id='content_area']/h3")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/deal_qna_list")); // URL 체크
		assertTrue(Htext.contains("상품Q&A")); // 정상 로그인 체크
		CheckRcode();
		screenshot("mypage_rqna");
	}

	@Test
	public void Mypage_Dcoupon() throws Exception {

		open("https://front.wemakeprice.com/cs/qna/list/prod");
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h4[contains(.,'상품Q&A')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "https://front.wemakeprice.com/cs/qna/list/prod")); // URL체크 // 체크
		assertTrue(Htext.contains("상품Q&A")); // 현재 페이지內 객체 체크
		CheckRcode(); // ResponseCode 200 체크
		screenshot("mypage_dqna");
	}
}
