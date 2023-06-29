package com.spring.config;


import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.spring.filter.AdminInterceptor;
import com.spring.filter.LoginInterceptor;
import com.spring.filter.UserInterceptor;



@Configuration
public class WebMVCConfig implements WebMvcConfigurer{
	
	@Autowired
	AdminInterceptor adminInterceptor;
	
	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Autowired
	UserInterceptor userInterceptor;
	
	
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.addBasenames("classpath:i18n/label" ,
				            "classpath:message/validation");
		source.setDefaultEncoding(StandardCharsets.UTF_8.name());
		return source;
	}

	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("vi"));
		resolver.setCookieMaxAge(60 * 60 * 24 * 7);
		return resolver;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(loginInterceptor)
			.addPathPatterns("/admin/**" , "/category/**" , "/users/**" , "/cart/**")
			.excludePathPatterns("/product" , "/info" , "/detail" , "/index", "/register");
			
			registry.addInterceptor(userInterceptor)
			.addPathPatterns("/admin/**" , "/category/**" , "/users/**")
			.excludePathPatterns("/product" , "/info" , "/detail" ,"/register", "/cart/**" ,"/index");
			
			LocaleChangeInterceptor locale = new LocaleChangeInterceptor();
			locale.setParamName("language");
			
			registry.addInterceptor(locale)
					.addPathPatterns("/**");
//					.excludePathPatterns("/admin/**" , "/category/**" , "/users/**");
//				
			
			registry.addInterceptor(adminInterceptor)
			.addPathPatterns("/login");
	}
}
