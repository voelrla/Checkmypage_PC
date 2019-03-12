package Checkmypage_PC.Checkmypage_PC;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.impl.Html;

import static com.codeborne.selenide.Selenide.*;

public class MypageNuseticket extends MypageStart {

	@Test(priority = 1)
	public void Mypage_Nuticketapply() throws Exception {
		open("http://www.wemakeprice.com/mypage/buylist/unused_refund_list");
//		$(By.id("pop_btn_don_show1")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h3[contains(.,'미사용티켓 환불신청')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/buylist/unused_refund_list")); // URL 체크
		assertTrue(Htext.contains("미사용티켓 환불신청")); // 정상 로그인 체크
		CheckRcode();
		screenshot("mypage_nuticket_apply");
	}

	@Test(priority = 2)
	public void Mypage_Nuticketlist() throws Exception {

		$(By.linkText("미사용티켓 환불현황")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h3[contains(.,'미사용티켓 환불신청')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/buylist/unused_refund_result_list")); // URL체크																														// 체크
		assertTrue(Htext.contains("미사용티켓 환불신청")); // 현재 페이지內 객체 체크
		CheckRcode(); // ResponseCode 200 체크
		screenshot("mypage_nuticket_list");
	}
}
