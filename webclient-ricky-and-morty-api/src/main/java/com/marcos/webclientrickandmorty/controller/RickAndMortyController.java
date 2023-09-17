package com.marcos.webclientrickandmorty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.webclientrickandmorty.client.RickAndMortyClientService;
import com.marcos.webclientrickandmorty.response.CharacterResponse;
import com.marcos.webclientrickandmorty.response.EpisodeResponse;
import com.marcos.webclientrickandmorty.response.ListOfEpisodesResponse;
import com.marcos.webclientrickandmorty.response.LocationResponse;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickAndMortyController {

	@Autowired
	RickAndMortyClientService rickAndMortyClient;
	
	@GetMapping("/character/{id}")
	public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
		return rickAndMortyClient.findCharacterById(id);
	}
	
	@GetMapping("/location/{id}")
	public Mono<LocationResponse> getLocationById(@PathVariable String id){
		return rickAndMortyClient.findLocationById(id);
	}
	
	@GetMapping("/episode/{id}")
	public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
		return rickAndMortyClient.findEpisopdeById(id);
	}
	
	@GetMapping("/episodes")
	public Flux<ListOfEpisodesResponse> getEpisodeById(){
		return rickAndMortyClient.getAllEpisopdes();
	}
}
