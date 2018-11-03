package de.solutioazubi.rsw.gameelements;

import java.util.ArrayList;
import java.util.List;

public class Gate {

	// FIELDS
		private Planet planet1;
		private Planet planet2;
		
		// CONSTRUCTOR
		public Gate(Planet planet1, Planet planet2) {
			this.planet1 = planet1;
			this.planet2 = planet2;
		}
		
		
		// METHODS
		public List<Planet> getConnectedPlanets() {
			List<Planet> connectedPlanets = new ArrayList<Planet>();
			connectedPlanets.add(planet1);
			connectedPlanets.add(planet2);
			return connectedPlanets;
		}
	
}
