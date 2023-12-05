package springBootMVCShopping;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Component
public class SpringBootConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception {
		httpsecurity.csrf().disable()//csrf방지
					.formLogin().disable();
		return httpsecurity.build();
	}
	@Bean(value = "jsonView")
	public MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView();
	}
}
