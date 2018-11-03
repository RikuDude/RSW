package de.solutioazubi.rsw.gameelemnets;

import java.util.List;

public class Universe {

	// FIELDS
	List<Planet> planets;
	List<Gate> gates;
	
	// CONSTRUCTOR
	public Universe(List<Planet> planets, List<Gate> gates) {
		this.planets = planets;
		this.gates = gates;
	}
	
	// METHODS
	
	public void beginNextRound() {
		//stuff happenes here
		
		// @formatter:off
		planets.stream().
			forEach(planet -> planet.updateControllingPlayer());
		// @formatter:on

		
		
	}
	
}
