package partie7.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import partie7.persistence.entities.Livre;
import partie7.service.LivreService;
import reactor.core.publisher.Mono;

@RestController
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping("/livres")
    public ResponseEntity<Mono<Livre>> rechercherParNom(@RequestParam String nomLivre) {

        Mono<Livre> livre = livreService.rechercherLivre(nomLivre);
        ResponseEntity<Mono<Livre> > monoResponseEntity=new ResponseEntity<>(livre, HttpStatus.OK);
        return monoResponseEntity;
    }
}