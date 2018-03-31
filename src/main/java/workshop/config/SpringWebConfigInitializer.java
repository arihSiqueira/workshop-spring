package workshop.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebConfigInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		/*Código para deixar sem web.xml mas utilizando xml para configurar spring*/
		/*XmlWebApplicationContext context = new XmlWebApplicationContext();
        context.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
 
        ServletRegistration.Dynamic dispatcher = container
          .addServlet("dispatcher", new DispatcherServlet(context));
 
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");*/
        
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("workshop.config");

        container.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher = container
        		.addServlet("dispatcher", new DispatcherServlet(context));
       
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
		
	}
	
	

}
