package partie7.persistence.dao;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import partie7.persistence.entities.Livre;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface LivreRepository extends ReactiveCrudRepository<Livre, Long> {
    Mono<Livre> findByNom(String nom);

    Flux<Livre> findByPrix(int prix);
}
