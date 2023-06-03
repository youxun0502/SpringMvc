package com.liu.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

//相當於mvc-servlet.xml的java程式組態
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com", "tw.Evan" })
public class WebAppCofig implements WebMvcConfigurer {

	@Override // <mvc:default-servlet-handler/> 允許未經過處理的請求like HTML
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// 設定默認輸出格式為Json格式，
	@Bean
	public MappingJackson2JsonView jasonView() {
		MappingJackson2JsonView jView = new MappingJackson2JsonView();
		jView.setPrettyPrint(true);
		return jView;
	}

	@Bean
	public ContentNegotiatingViewResolver contentViewResolver() {
		ContentNegotiatingViewResolver cnViewResolver = new ContentNegotiatingViewResolver();
		List<View> lists = new ArrayList<>();
		lists.add(jasonView());
		cnViewResolver.setDefaultViews(lists);
		return cnViewResolver;
	}

	// 檔案上傳處理器
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	// 用於配置靜態資源的處理器
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/resources/img/");
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
	}

	// 導至首頁
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "html/Home.html");// 導至首頁的controller
		registry.addViewController("/Main/Register").setViewName("MemberRegister");
		registry.addViewController("/Main/Home").setViewName("Home");
	}

	@Bean // 內部資源視圖處理器
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irv = new InternalResourceViewResolver("/WEB-INF/view/", ".jsp");
		irv.setOrder(6);
		return irv;
	}

}
