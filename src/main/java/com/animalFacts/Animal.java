package com.animalFacts;

//import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Animal{

	//@JsonProperty("fact")
	private String fact;

	//@JsonProperty("name")
	private String name;

	public void setFact(String fact){
		this.fact = fact;
	}

	public String getFact(){
		return fact;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Animal{" + 
			"fact = '" + fact + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}