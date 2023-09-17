package com.marcos.webclientrickandmorty.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class EpisodeResponse {

	private String id;
	private String name;
	private String air_date;
	private String episode;
	private List<String> characters;
	private String url;
}
