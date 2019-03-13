package Checkmypage_PC.Checkmypage_PC;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.impl.Html;

import static com.codeborne.selenide.Selenide.*;

public class MypageMmodify extends MypageStart {
	@Test
	public void Mypage_Rcoupon() throws Exception {
		open("https://front.wemakeprice.com/user/verify");
//		$(By.id("pop_btn_don_show1")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//div[2]/p")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "https://front.wemakeprice.com/user/verify")); // URL 체크
		assertTrue(Htext.contains("개인정보")); // 정상 로그인 체크
		CheckRcode();
		screenshot("mypage_modify");
	}

}
