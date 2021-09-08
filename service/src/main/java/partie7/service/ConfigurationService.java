package partie7.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import partie7.persistence.ConfigurationPersistence;
import partie7.persistence.dao.LivreRepository;

@Configuration
@Import({ConfigurationPersistence.class})
public class ConfigurationService {


    @Bean
    public LivreService livreService(LivreRepository livreRepository){
         return  new LivreService(livreRepository);
    }
}
