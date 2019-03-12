package Checkmypage_PC.Checkmypage_PC;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.impl.Html;

import static com.codeborne.selenide.Selenide.*;

public class MypagePoint extends MypageStart {

	@Test(priority = 1)
	public void Mypage_Rcoupon() throws Exception {
		open("http://www.wemakeprice.com/mypage/point_new");
//		$(By.id("pop_btn_don_show1")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h3[contains(.,'포인트 내역')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/point_new")); // URL 체크
		assertTrue(Htext.contains("포인트")); // 정상 로그인 체크
		CheckRcode();
		screenshot("mypage_point");
	}
}
