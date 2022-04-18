package com.group.exam.member.controller;
import java.io.IOException;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.group.exam.member.command.GoogleOAuthRequest;
import com.group.exam.member.command.GoogleOAuthResponse;

@Controller
public class MemberGoogleController {
	/**
	 * Authentication Code를 전달 받는 엔드포인트
	 **/
	@RequestMapping("/login/google/auth")
	public String googleAuth(Model model, @RequestParam(value = "code") String authCode)
			throws JsonProcessingException {
		
		//HTTP Request를 위한 RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		//Google OAuth Access Token 요청을 위한 파라미터 세팅
		GoogleOAuthRequest googleOAuthRequestParam = new GoogleOAuthRequest();
		googleOAuthRequestParam.setClientId("구글클라이언트ID");
		googleOAuthRequestParam.setClientSecret("구글클라이언트비번");
		googleOAuthRequestParam.setCode(authCode);
		googleOAuthRequestParam.setRedirectUri("http://localhost:8080/exam/login/google/auth"); //아 여기 바꿔야함
		googleOAuthRequestParam.setGrantType("authorization_code");

		
		//JSON 파싱을 위한 기본값 세팅
		//요청시 파라미터는 스네이크 케이스로 세팅되므로 Object mapper에 미리 설정해준다.
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		mapper.setSerializationInclusion(Include.NON_NULL);

		//AccessToken 발급 요청
		ResponseEntity<String> resultEntity = restTemplate.postForEntity("http://localhost:8080/exam/member/google/auth" /*GOOGLE_TOKEN_BASE_URL이게 뭐임...*/ , googleOAuthRequestParam, String.class);

		//Token Request
		GoogleOAuthResponse result;
		try {
			result = mapper.readValue(resultEntity.getBody(), new TypeReference<GoogleOAuthResponse>() {
			});
			//ID Token만 추출 (사용자의 정보는 jwt로 인코딩 되어있다)
			String jwtToken = result.getIdToken();
			String requestUrl = 
					UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
					.queryParam("id_token", jwtToken)
					.toUriString();
			
			String resultJson = restTemplate.getForObject(requestUrl, String.class);
			
			Map<String,String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>(){});
			model.addAllAttributes(userInfo);
			model.addAttribute("token", result.getAccessToken());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




		return "/google.html";

	}

}