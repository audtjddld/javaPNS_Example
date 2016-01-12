/**
 * 
 */
package com.push.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.ApnsServiceBuilder;

import javapns.Push;

/**
 * @author 정명성 create date : 2016. 1. 11. 
 * com.example.PushController.java
 * github : https://github.com/notnoop/java-apns 예제
 */
@Controller
public class PushController {

	@RequestMapping(value = "/push.do")
	public void pushTest() throws Exception {

		String token = "토큰값";

		// .withCert("d:\\smartDevLab.p12", "Dh9675235")
		// 개발, 운영인지
		String type = "dev";
		String message = "문제문제문제";

		String certPath7 = "d:\\555555.p12";

		pushMessage(certPath7, message, token, 1);
		//pushMessage(certPath7, message, token, 4);
		//pushMessage(certPath7, message, token, 5);
		//pushMessage(certPath7, message, token, 6);
		//pushMessage(certPath7, message, token, 7);

		System.out.println("호출 ");

	}

	public void pushMessage(String certPath, String message, String token, int badge) throws Exception{
		ApnsServiceBuilder serviceBuilder = APNS.newService();
		serviceBuilder.withCert(certPath, "Dh9675235").withSandboxDestination();
		
		ApnsService service = serviceBuilder.build();

		String payload = APNS.newPayload().badge(badge)
								.alertTitle("alert")
								.alertBody(message)
								.sound("default")
								.customField("messageFrom", "메시지").build();
		
		Push.alert(message, "d:\\555555.p12", "비밀번호", false, token);
		
		System.out.println("payload: " + payload);
		service.push(token, payload);
	}
}
