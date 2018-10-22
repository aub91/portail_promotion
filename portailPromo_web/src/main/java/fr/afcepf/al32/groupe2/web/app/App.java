package fr.afcepf.al32.groupe2.web.app;

import java.util.Properties;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.apache.myfaces.webapp.StartupServletContextListener;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.context.ServletContextAware;

import com.google.common.collect.ImmutableMap;

@SpringBootApplication(scanBasePackages= {"fr.afcepf.al32.groupe2"})
@EntityScan(basePackages="fr.afcepf.al32.groupe2.entity")
public class App implements ServletContextAware{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
            new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<StartupServletContextListener> jsfConfigureListener() {
        return new ServletListenerRegistrationBean<StartupServletContextListener>(
            new StartupServletContextListener());
    }
    
    @Bean
    public static CustomScopeConfigurer viewScope() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.setScopes(
                new ImmutableMap.Builder<String, Object>().put("view", new ViewScope()).build());
        return configurer;
    }

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
		servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "client");
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername("aubin.guilhem@gmail.com");
	    mailSender.setPassword("jkkqeomjitdzriaj");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return mailSender;
	}
}
