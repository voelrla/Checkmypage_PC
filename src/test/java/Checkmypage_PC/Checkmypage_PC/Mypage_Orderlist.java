package Checkmypage_PC.Checkmypage_PC;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.codeborne.selenide.impl.Html;

import static com.codeborne.selenide.Selenide.*;

public class Mypage_Orderlist extends AppTest {

	@Test(priority = 1)
	public void MypageMain() throws Exception {

//		$(By.linkText("마이페이지")).click();
		open("http://www.wemakeprice.com/mypage/buylist");
		$(By.id("pop_btn_don_show1")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//p[contains(.,'이승재님 반갑습니다!')]")).getText();

		System.out.println(Curl);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/buylist")); // URL 체크
		assertTrue(Htext.contains("반갑습니다!")); // 정상 로그인 체크
		CheckRcode();
		screenshot("mypage_main");
	}

	@Test(priority = 2)
	public void Mypage_Deorder() throws Exception {

		$(By.linkText("상품beta")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h4[contains(.,'주문배송조회')]")).getText();

		System.out.println(Curl);

		assertTrue(Html.text.contains(Curl, "https://front.wemakeprice.com/mypage/orders")); // URL 체크
		assertTrue(Htext.contains("주문배송조회")); // 현재 페이지內 객체 체크
		CheckRcode(); // ResponseCode 200 체크
		screenshot("mypage_deorder");
	}

	@Test(priority = 3)
	public void Mypage_ticket() throws Exception {

		$(By.linkText("티켓")).click();
		String Curl = driver.getCurrentUrl();
		String Htext = $(By.xpath("//h3[contains(.,'주문배송조회')]")).getText();

		System.out.println(Curl);

		assertTrue(Html.text.contains(Curl, "http://www.wemakeprice.com/mypage/buylist/usable_ticket_list")); // URL 체크
		assertTrue(Htext.contains("주문배송조회")); // 현재 페이지內 객체 체크
		CheckRcode(); // ResponseCode 200 체크
		screenshot("mypage_ticket");
	}

	@Test(priority = 4)
	public void Mypage_Airticket() throws Exception {

		$(By.linkText("항공·호텔 예약")).click();
		switchTo().window(1); // 탭 이동
		String Curl = driver.getCurrentUrl();
//		String Htext = $(By.xpath("//h4[contains(.,'주문배송조회')]")).getText();

		System.out.println(Curl);

		assertTrue(Html.text.contains(Curl, "https://www.wonder-shopping.com/mypage/reservation/?&is_login=true")); // URL
																													// 체크
//		assertTrue(Htext.contains("주문배송조회")); // 현재 페이지內 객체 체크
		CheckRcode(); // ResponseCode 200 체크
		screenshot("mypage_airticket");
		switchTo().window(0); // 탭 이동
	}
}
