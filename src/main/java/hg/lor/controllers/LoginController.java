package hg.lor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
/*import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.security.Principal;
import java.util.Map;*/

@RestController
public class LoginController {
	 @Autowired
	 private OAuth2AuthorizedClientService authorizedClientService;

	 @GetMapping("/uInfo")
	 public String getLoginPage() {
		  DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  System.out.println(user.getFullName() + " " + user.getEmail() + " " + user.getPicture());
		  return "<h1>Hello " + user.getFullName()+"</h1>";
	 }

	 /*@GetMapping("/doneLoginViaGoogle")
	 @ResponseBody
	 public Principal userinfo(OAuth2AuthenticationToken authentication, Principal principal) {
		  OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());

		  String userInfoEndpointUri = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();

		  if (!StringUtils.isEmpty(userInfoEndpointUri)) {
				RestTemplate restTemplate = new RestTemplate();
				HttpHeaders headers = new HttpHeaders();
				headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
				HttpEntity<String> entity = new HttpEntity<>("", headers);
				ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
				Map userAttributes = response.getBody();
				System.out.println("name: " + userAttributes.get("name") + "\nemail: " + userAttributes.get("email") + "\nimgUrl: " + userAttributes.get("picture"));
		  }
		  return principal;
	 }*/
}
