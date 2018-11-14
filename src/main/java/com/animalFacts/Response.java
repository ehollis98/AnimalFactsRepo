package com.animalFacts;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("animal")
	private Animal animal;

	public Animal getAnimal() {
		return animal;
	}

}