package configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.apache.tomcat.jdbc.pool.DataSourceFactory;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "AOP,com.CRM,DAO")
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class CRMFrontController implements WebMvcConfigurer{
	
	@Override
	   public void addViewControllers(ViewControllerRegistry registry) {
	      registry.addViewController("/").setViewName("index");
	   }

	   @Bean
	   public ViewResolver viewResolver() {
	      InternalResourceViewResolver bean = new InternalResourceViewResolver();

	      bean.setViewClass(JstlView.class);
	      bean.setPrefix("/WEB-INF/view/");
	      bean.setSuffix(".jsp");

	      return bean;
	   }
	   
//	   @Bean
//	   public DataSource dataSource() {
//	       DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//	       dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	       dataSource.setUsername("root");
//	       dataSource.setPassword("smartsoul");
//	       dataSource.setUrl(
//	         "jdbc:mysql://localhost:3306/myDb?createDatabaseIfNotExist=true"); 
//	       
//	       return dataSource;
//	   }
//	   @Bean
//	   public LocalContainerEntityManagerFactoryBean
//	     entityManagerFactoryBean(){
//		   HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		    vendorAdapter.setGenerateDdl(true);
//
//		    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		    factory.setJpaVendorAdapter(vendorAdapter);
//		    factory.setPackagesToScan("com.CRM,DAO");
//		    factory.setDataSource(dataSource());
//		    return factory;
//	   }
//	   
//	   @Bean
//	   public PlatformTransactionManager transactionManager(){
//	      JpaTransactionManager transactionManager = new JpaTransactionManager();
//	      transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//	      return transactionManager;
//	   }
}



//<?xml version="1.0" encoding="UTF-8"?>
//<beans xmlns="http://www.springframework.org/schema/beans"
//	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
//	xmlns:context="http://www.springframework.org/schema/context"
//	xmlns:tx="http://www.springframework.org/schema/tx"
//	xmlns:mvc="http://www.springframework.org/schema/mvc"
//	xmlns:aop="http://www.springframework.org/schema/aop" 
//	xsi:schemaLocation="
//		http://www.springframework.org/schema/beans
//    	http://www.springframework.org/schema/beans/spring-beans.xsd
//    	http://www.springframework.org/schema/context
//    	http://www.springframework.org/schema/context/spring-context.xsd
//    	http://www.springframework.org/schema/mvc
//        http://www.springframework.org/schema/mvc/spring-mvc.xsd
//        http://www.springframework.org/schema/aop   
//        http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
//
//   <context:component-scan base-package = "com.CRM,DAO" />
//   <mvc:annotation-driven />
//
//   <bean class = "org.springframework.web.servlet.view.InternalResourceViewResolver">
//      <property name = "prefix" value = "/WEB-INF/view/" />
//      <property name = "suffix" value = ".jsp" />
//   </bean>
//  <context:property-placeholder location="classpath:customer.properties"/>
//   
//   <!-- https://mvnrepository.com/artifact/org.jvnet.staxex/stax-ex -->
//
//</beans>