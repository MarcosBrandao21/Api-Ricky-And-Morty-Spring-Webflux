package com.marcos.webclientrickandmorty.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.marcos.webclientrickandmorty.response.CharacterResponse;
import com.marcos.webclientrickandmorty.response.EpisodeResponse;
import com.marcos.webclientrickandmorty.response.ListOfEpisodesResponse;
import com.marcos.webclientrickandmorty.response.LocationResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickAndMortyClientService {

	private final WebClient webClient;
	
	private static final String ERROR_REQUEST = "verifique os parâmetros informados";
	
	public RickAndMortyClientService(WebClient.Builder builder) {
		this.webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}
	
	// no webFlux quando tratamos de somente um dado
	public Mono<CharacterResponse> findCharacterById(String id){
		log.debug("Buscando o personagem com o id [{}]", id);
		return webClient.get().uri("/character/" + id).accept(MediaType.APPLICATION_JSON).exchangeToMono(
				response -> {
					if(response.statusCode().is4xxClientError()) {
						return  Mono.error(new RuntimeException(ERROR_REQUEST));
					}else {
						return response.bodyToMono(CharacterResponse.class);
					}
				});
	}
	
	public Mono<LocationResponse> findLocationById(String id){
		log.debug("Buscando o Localização com o id [{}]", id);
		return webClient.get().uri("/location/" + id).accept(MediaType.APPLICATION_JSON).exchangeToMono(
				response -> {
					if(response.statusCode().is4xxClientError()) {
						return  Mono.error(new RuntimeException(ERROR_REQUEST));
					}else {
						return response.bodyToMono(LocationResponse.class);
					}
				});
	}
	
	public Mono<EpisodeResponse> findEpisopdeById(String id){
		log.debug("Buscando o Episodio com o id [{}]", id);
		return webClient.get().uri("/episode/" + id).accept(MediaType.APPLICATION_JSON).exchangeToMono(
				response -> {
					if(response.statusCode().is4xxClientError()) {
						return  Mono.error(new RuntimeException(ERROR_REQUEST));
					}else {
						return response.bodyToMono(EpisodeResponse.class);
					}
				});
	}
	
	public Flux<ListOfEpisodesResponse> getAllEpisopdes(){
		log.debug("Listando todos os Episodios");
		return webClient.get().uri("/episode").accept(MediaType.APPLICATION_JSON).exchangeToFlux(
				response -> {
					if(response.statusCode().is4xxClientError()) {
						return  Flux.error(new RuntimeException(ERROR_REQUEST));
					}else {
						return response.bodyToFlux(ListOfEpisodesResponse.class);
					}
				});
	}
}
