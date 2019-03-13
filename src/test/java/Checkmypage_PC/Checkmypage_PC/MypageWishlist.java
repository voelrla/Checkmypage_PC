package Checkmypage_PC.Checkmypage_PC;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.impl.Html;

import static com.codeborne.selenide.Selenide.*;

public class MypageWishlist extends MypageStart {

	@Test
	public void Mypage_ReWish() throws Exception {
		open("http://www.wemakeprice.com/mypage/buylist/wish_list");
//		$(By.id("pop_btn_don_show1")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h3[contains(.,'찜 리스트 - 찜한상품은 최대 2개월간 저장됩니다.')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/buylist/wish_list")); // URL 체크
		assertTrue(Htext.contains("찜 리스트")); // 정상 로그인 체크
		CheckRcode();
		screenshot("mypage_rewish");
	}

	@Test
	public void Mypage_DeWish() throws Exception {

		open("https://front.wemakeprice.com/mypage/wishlist");
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h4[contains(.,'찜 리스트')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "https://front.wemakeprice.com/mypage/wishlist")); // URL체크 // 체크
		assertTrue(Htext.contains("찜 리스트")); // 현재 페이지內 객체 체크
		CheckRcode(); // ResponseCode 200 체크
		screenshot("mypage_dewish");
	}

	@Test
	public void Mypage_PaWish() throws Exception {

		open("https://front.wemakeprice.com/mypage/wishlist/partnermall");
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h4[contains(.,'찜 리스트')]")).getText();

		System.out.println(Curl);
//		System.out.println(Htext);

		assertTrue(Html.text.contains(Curl, "https://front.wemakeprice.com/mypage/wishlist/partnermall")); // URL체크 //
																											// 체크
		assertTrue(Htext.contains("찜 리스트")); // 현재 페이지內 객체 체크
//		CheckRcode(); // ResponseCode 200 체크
		screenshot("mypage_pawish");
	}
}
