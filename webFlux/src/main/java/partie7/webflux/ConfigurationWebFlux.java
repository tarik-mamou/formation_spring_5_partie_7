package partie7.webflux;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import partie7.service.ConfigurationService;
//depuis
//https://medium.com/pictet-technologies-blog/reactive-programming-with-spring-data-r2dbc-ee9f1c24848b
@Configuration
@Import({ConfigurationService.class})
public class ConfigurationWebFlux {

}
