package com.jcohy.recruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

		registry.addViewController("/user/login").setViewName("front/login");

		registry.addViewController("/user/register").setViewName("front/register");

		registry.addViewController("/user/index").setViewName("front/user");
	}
}
