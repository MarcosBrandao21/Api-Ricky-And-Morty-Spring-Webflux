package com.marcos.webclientrickandmorty.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ListOfEpisodesResponse {
	
	private List<EpisodeResponse> results;

}
