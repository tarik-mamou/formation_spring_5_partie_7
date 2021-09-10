package partie7.service;

import partie7.persistence.dao.LivreRepository;
import partie7.persistence.entities.Livre;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

public class LivreService {

    private LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }


    public Mono<Livre> rechercherLivre(String nomLivre) {
        return livreRepository.findByNom(nomLivre);
    }

    public Flux<Livre> rechercherLivresParPrix(int prix) {
        return livreRepository.findByPrix(prix);
    }
}
