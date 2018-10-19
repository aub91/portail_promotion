package fr.afcepf.al32.groupe2.web.app;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;

import org.apache.myfaces.webapp.StartupServletContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.ServletContextAware;

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

	@Override
	public void setServletContext(ServletContext servletContext) {
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
	}
}
