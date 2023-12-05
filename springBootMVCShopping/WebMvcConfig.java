package springBootMVCShopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer{
	@Autowired
	InterceptorConfig interceptorConfig;
	
 @Override
public void addInterceptors(InterceptorRegistry registry) {
	List<String>addList = new ArrayList<String>();
	addList.add("/employee/**/*");
	addList.add("/member/**/*");
	addList.add("/goods/**/*");
	addList.add("/purchase/**/*");
	addList.add("/inquire/**/*");
	addList.add("/mypage/**/*");
	
	
	List<String>excludeList = new ArrayList<String>();
	excludeList.add("/register/**/*");
	excludeList.add("/help/**/*");
	excludeList.add("/login/**/*");
	excludeList.add("/corner/**/*");
	
	registry.addInterceptor(interceptorConfig);
			.addPathpatterns("addList") //세션이 없으면 로그인 페이지로 이동
			.excludePathPatterns("excludeList")//세션이 없어도 그대로 사용
 }
 
}
