/**
 * 
 */
package com.push.test;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javapns.Push;
import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;





/**
 * @author 정명성
 * create date : 2016. 1. 12.
 * com.push.test.PushTwoController.java
 * google JavaPNS
 */
@Controller
public class PushTwoController {
	final static String KEY_STORE  = "d:\\555555.p12";
	final static String TOKEN      = "토큰값";
	final static String CERT_KEY   = "비밀번호";
    
	@RequestMapping(value="/push2.do")
	public void pushTestController() throws Exception{
	       /* Build a blank payload to customize */ 
        PushNotificationPayload payload = PushNotificationPayload.complex();
 

       /* Customize the payload */ 
        payload.addAlert("얼럿창 입니다.");
        payload.addCustomDictionary("mykey1", "My Value 1");
        payload.addSound("default");
        payload.addBadge(1);
        /* Push your custom payload */
        List<PushedNotification> notifications = Push.payload(payload, KEY_STORE, CERT_KEY, false, TOKEN);
        
        for(PushedNotification pn : notifications){
        	System.out.println(pn.isSuccessful());
        }
        
        // etc.
        // 아래는 badge랑 같이 보내는 법
        // Push.combined("안내안내", 1, "default", KEY_STORE, CERT_KEY, false, TOKEN);
        
	}

}
