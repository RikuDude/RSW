package de.solutioazubi.rsw.gameelemnets;

import java.util.List;
import java.util.stream.Collectors;

import de.solutioazubi.rsw.player.Player;

public class Planet {
	
	// FIELDS
	private String name;
	private Player controllingPlayer;
	private List<Fleet> fleetsInOrbit;
	private int defenseShipsOnPlanet;

	// CONSTRUCTORS
	public Planet() {
		
	}
	
	public Planet(String name) {
		this.name = name;
	}
	
	// METHODS
	
	public String getName() {
		return this.name;
	}
	
	public Player getControllingPlayer() {
		return this.controllingPlayer;
	}
	
	public void updateControllingPlayer() {
		// @formatter:off
		List<Player> playersInOrbit = fleetsInOrbit.stream().
			map(Fleet::getControllingPlayer).
			distinct().
			collect(Collectors.toList());
		// @formatter:on
		
		if (playersInOrbit.size() == 1 && defenseShipsOnPlanet == 0) {
			// @formatter:off
			controllingPlayer = playersInOrbit.stream().
					findFirst().
					get(); 
			// @formatter:on
		}
		
		if (playersInOrbit.size() == 0 && defenseShipsOnPlanet == 0) {
			controllingPlayer = null;
		}
	}
	
	
}
