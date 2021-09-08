package partie7.blocking_web_client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigurationWebClient {

    @Bean
    public CommandLineRunner demarrer() {
        return (args) -> {
          /*  WebClient client = WebClient.create("http://localhost:8084");
            WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = client.method(HttpMethod.GET);
            WebClient.RequestBodySpec bodySpec = uriSpec.uri(
                    uriBuilder -> uriBuilder.pathSegment("/livres").build());

            WebClient.RequestHeadersSpec<?> headersSpec = bodySpec.body(
                    Mono.just("livre_1"), String.class);

            WebClient.ResponseSpec responseSpec = headersSpec.header(
                            HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                    .acceptCharset(StandardCharsets.UTF_8)
                    .ifNoneMatch("*")
                    .ifModifiedSince(ZonedDateTime.now())
                    .retrieve();

            Mono<String> response = headersSpec.retrieve()
                    .bodyToMono(String.class);
            String result = response.block();
            System.out.println(result);*/
            WebClient.ResponseSpec responseSpec =   WebClient.create("http://localhost:8084")
                    .get()
                    .uri(uriBuilder -> uriBuilder.path("/livres")
                            .queryParam("nomLivre", "livre_1")
                            .build())
                    .retrieve();

           String result= responseSpec.bodyToMono(String.class).block();
            System.out.println(result);

        };
    }
}
