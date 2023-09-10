package com.marcos.webclientrickandmorty.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.marcos.webclientrickandmorty.response.CharacterResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClient {

	private final WebClient webClient;
	
	public RickAndMortyClient(WebClient.Builder builder) {
		this.webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}
	
	// no webFlux quando tratamos de somente um dado
	public Mono<CharacterResponse> findAndCharacterById(String id){
		log.debug("Buscando o personagem com o id [{}]", id);
		return webClient.get().uri("/character/" + id).accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(CharacterResponse.class);
//				inserir tratamento
//				.onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique os parametros informados!")))
//				.body;
	}
	
}
