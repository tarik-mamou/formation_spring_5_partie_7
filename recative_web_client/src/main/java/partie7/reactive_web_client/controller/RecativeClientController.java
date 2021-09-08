package partie7.reactive_web_client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class RecativeClientController {


    @GetMapping("/livres")
    public ResponseEntity<Mono<String>> rechercherParNom(@RequestParam String nomLivre) {

        WebClient.ResponseSpec responseSpec = WebClient.create("http://localhost:8084")
                .get()
                .uri(uriBuilder -> uriBuilder.path("/livres")
                        .queryParam("nomLivre", nomLivre)
                        .build())
                .retrieve();

        // String result= responseSpec.bodyToMono(String.class).block();

        Mono<String> livreJson = responseSpec.bodyToMono(String.class);
        ResponseEntity<Mono<String>> monoResponseEntity = new ResponseEntity<>(livreJson, HttpStatus.OK);
        return monoResponseEntity;
    }
}