package platform.web.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*@Configuration
@ComponentScan("platform.web.springmvc")*/
public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
    protected Class < ? > [] getRootConfigClasses() {
        return new Class[] {
        		HibernateConf.class
        };
    }

	@Override
    protected Class < ? > [] getServletConfigClasses() {
        return new Class[] {
            WebMvcConfig.class
        };
    }

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	/*
	 * @Bean RestTemplate restTemplate() { RestTemplate restTemplate = new
	 * RestTemplate(); MappingJacksonHttpMessageConverter converter = new
	 * MappingJacksonHttpMessageConverter(); converter.setObjectMapper(new
	 * ObjectMapper()); restTemplate.getMessageConverters().add(converter); return
	 * restTemplate; }
	 */
}