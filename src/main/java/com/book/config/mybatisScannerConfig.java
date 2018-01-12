package com.book.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mybatisScannerConfig {

	@Bean
	public static MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer mConfigurer=new MapperScannerConfigurer();
		mConfigurer.setBasePackage("com.book.Mapper");
		mConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mConfigurer;
	}
}
