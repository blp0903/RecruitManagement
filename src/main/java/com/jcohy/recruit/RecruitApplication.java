package com.jcohy.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class RecruitApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(RecruitApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		//前台首页
		registry.addViewController("/").setViewName("front/index");


		//管理员主页，从登录
		registry.addViewController("/admin").setViewName("/login");


		//管理员主页，从登录
		registry.addViewController("/admin/main").setViewName("/admin/main");


		registry.addViewController("/admin/lab/index").setViewName("/admin/lab/index");

		registry.addViewController("/admin/plan/index").setViewName("/admin/plan/index");

		registry.addViewController("/admin/college/index").setViewName("/admin/college/index");

		registry.addViewController("/admin/addcollege/index").setViewName("/admin/addcollege/index");

		//学院主页，从登录
		registry.addViewController("/college/main").setViewName("/college/main");

		registry.addViewController("/user/login").setViewName("front/login");

		registry.addViewController("/user/register").setViewName("front/register");

		registry.addViewController("/user/index").setViewName("front/user");
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大
		factory.setMaxFileSize("102400KB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}
}
