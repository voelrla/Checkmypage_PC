package Checkmypage_PC.Checkmypage_PC;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.impl.Html;

import static com.codeborne.selenide.Selenide.*;

public class MypageCoupon extends MypageStart {

	@Test(priority = 1)
	public void Mypage_Rcoupon() throws Exception {
		open("http://www.wemakeprice.com/mypage/saleCoupon/usable");
//		$(By.id("pop_btn_don_show1")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h3[contains(.,'할인쿠폰')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/saleCoupon/usable")); // URL 체크
		assertTrue(Htext.contains("할인쿠폰")); // 정상 로그인 체크
		CheckRcode();
		screenshot("mypage_rcoupon");
	}

	@Test(priority = 2)
	public void Mypage_Dcoupon() throws Exception {

		$(By.linkText("상품beta")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h4[contains(.,'할인쿠폰')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "https://front.wemakeprice.com/mypage/coupon")); // URL체크 // 체크
		assertTrue(Htext.contains("할인쿠폰")); // 현재 페이지內 객체 체크
		CheckRcode(); // ResponseCode 200 체크
		screenshot("mypage_dcoupon");
	}
}
