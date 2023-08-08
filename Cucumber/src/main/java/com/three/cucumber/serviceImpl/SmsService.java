package com.three.cucumber.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.three.cucumber.vo.PhoneMesVO;
import com.three.cucumber.vo.PhoneReqSMSVO;
import com.three.cucumber.vo.PhoneResSMSVO;
import com.three.cucumber.vo.PhoneVO;

@Service("smsService")
public class SmsService {
	Long time = System.currentTimeMillis();
    public PhoneResSMSVO sendSms(String recipientPhoneNumber) throws ParseException, JsonProcessingException, UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, URISyntaxException {
        // 보내는 사람에게 내용을 보냄.
    	Makenum mk = new Makenum();
    	String content = mk.random();
		List<PhoneMesVO> messages = new ArrayList<PhoneMesVO>();
		messages.add(new PhoneMesVO(recipientPhoneNumber));
        // 전체 json에 대해 메시지를 만든다.
        PhoneReqSMSVO PhoneReqSMSVO = new PhoneReqSMSVO("SMS", "COMM", "82", new PhoneVO().getFrom(), content, messages);

        // 쌓아온 바디를 json 형태로 변환시켜준다.
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(PhoneReqSMSVO);

        // 헤더에서 여러 설정값들을 잡아준다.
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("x-ncp-apigw-timestamp", time.toString());
        headers.set("x-ncp-iam-access-key", new PhoneVO().getAccessKey());

        // 제일 중요한 signature 서명하기.
        String sig = makeSignature();
        headers.set("x-ncp-apigw-signature-v2", sig);

        // 위에서 조립한 jsonBody와 헤더를 조립한다.
        HttpEntity<String> body = new HttpEntity<String>(jsonBody, headers);
        System.out.println(body.getBody());

        // restTemplate로 post 요청을 보낸다. 별 일 없으면 202 코드 반환된다.
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        PhoneResSMSVO PhoneResSMSVO = restTemplate.postForObject(new URI("https://sens.apigw.ntruss.com/sms/v2/services/"+ new PhoneVO().getServiceId()+"/messages"), body, PhoneResSMSVO.class);
        PhoneResSMSVO.setContent(content);
        System.out.println(PhoneResSMSVO.getContent());
        return PhoneResSMSVO;
    }

    public String makeSignature() throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
    	
    	String space = " ";					// one space
        String newLine = "\n";					// new line
        String method = "POST";					// method
        String url = "/sms/v2/services/"+ new PhoneVO().getServiceId()+"/messages";	// url (include query string)
        String timestamp = time.toString();			// current timestamp (epoch)
        String accessKey = new PhoneVO().getAccessKey();			// access key id (from portal or Sub Account)
        String secretKey = new PhoneVO().getSecretKey();
        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();

        SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        
        byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
        
        //String encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
		String encodeBase64String = Base64.encodeBase64String(rawHmac);

        return encodeBase64String;
    }
}
