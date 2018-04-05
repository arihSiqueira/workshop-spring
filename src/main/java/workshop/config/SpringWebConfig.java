package workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.resourceresolver.SpringResourceResourceResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.TemplateResolver;


@Configuration
@EnableWebMvc
@ComponentScan({ "workshop.controller",
				 "workshop.config"})
public class SpringWebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public TemplateResolver templateResolver() {
		TemplateResolver resolver = new TemplateResolver();
		resolver.setResourceResolver(thymeleafResourceResolver());
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setCacheable(false);
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}

	@Bean
	public SpringResourceResourceResolver thymeleafResourceResolver() {
		return new SpringResourceResourceResolver();
	}

	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		return engine;
	}

	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[] { "*" });
		viewResolver.setCache(false);
		return viewResolver;
	}

	@Bean
    @Description("Spring Message Resolver")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
	}
	
	
	 @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }
	
	
}
