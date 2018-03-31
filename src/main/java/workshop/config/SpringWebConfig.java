package workshop.config;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@EnableWebMvc
@Configuration
@ComponentScan({ "workshop" })
public class SpringWebConfig {

	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
	 
	@Bean
	@Description("Thymeleaf Template Resolver")
	public ServletContextTemplateResolver templateResolver() {
	    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
	    templateResolver.setPrefix("/views/");
	    templateResolver.setSuffix(".html");
	    templateResolver.setCharacterEncoding("UTF-8");
	    templateResolver.setTemplateMode("HTML5");
	 
	    return templateResolver;
	}
	
	@Bean
	@Description("Thymeleaf Template Engine")
	public SpringTemplateEngine templateEngine() {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver());
	    templateEngine.setTemplateEngineMessageSource(messageSource());
	    return templateEngine;
	}
	
	@Bean
    @Description("Spring Message Resolver")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
	}
	
	
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }
	
	
}
