package configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Web implements WebApplicationInitializer{

	@Override
    public void onStartup(final ServletContext sc) throws ServletException {

        AnnotationConfigWebApplicationContext root = 
          new AnnotationConfigWebApplicationContext();
        
        root.scan("configuration");
        sc.addListener(new ContextLoaderListener(root));

        ServletRegistration.Dynamic appServlet = 
          sc.addServlet("CRMFrontController", new DispatcherServlet(new GenericWebApplicationContext()));
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/");
    }
}



//<?xml version="1.0" encoding="UTF-8"?>
//<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//	xmlns="http://xmlns.jcp.org/xml/ns/javaee"
//	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
//	id="WebApp_ID" version="4.0">
//	<display-name>CRM</display-name>
//	<welcome-file-list>
//		<welcome-file>index.html</welcome-file>
//		<welcome-file>index.htm</welcome-file>
//		<welcome-file>index.jsp</welcome-file>
//		<welcome-file>default.html</welcome-file>
//		<welcome-file>default.htm</welcome-file>
//		<welcome-file>default.jsp</welcome-file>
//	</welcome-file-list>
//
//
//	<servlet>
//		<servlet-name>CRMFrontController</servlet-name>
//		<servlet-class>
//			org.springframework.web.servlet.DispatcherServlet
//		</servlet-class>
//		<init-param>
//			<param-name>contextConfigLocation</param-name>
//			<param-value>/WEB-INF/CRMFrontController-servlet.xml</param-value>
//		</init-param>
//		<load-on-startup>1</load-on-startup>
//	</servlet>
//	
//	<servlet-mapping>
//		<servlet-name>CRMFrontController</servlet-name>
//		<url-pattern>/</url-pattern>
//	</servlet-mapping>
//	
//	
//</web-app>