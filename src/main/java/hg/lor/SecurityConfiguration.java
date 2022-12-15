package hg.lor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	 @Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		  http.authorizeRequests()
					 .anyRequest().authenticated()
					 .and()
					 .formLogin()
					 .loginPage("/login")
					 .and()
					 .oauth2Login();
		  return http.build();
	 }
	 @Bean
	 public AuthorizationRequestRepository<OAuth2AuthorizationRequest>
	 authorizationRequestRepository() {

		  return new HttpSessionOAuth2AuthorizationRequestRepository();
	 }
}
