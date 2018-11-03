package de.solutioazubi.rsw.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import de.solutioazubi.rsw.gameelements.Gate;
import de.solutioazubi.rsw.gameelements.Planet;
import de.solutioazubi.rsw.gameelements.Universe;

public class UniverseGenerator {

	// PRIVATE CONSTRUCTOR
		private UniverseGenerator() {

		}

		// STATIC METHODS
		public static Universe generateUniverse(int playerCount) {
			int planetCount = getRandomNumberInRange(15, 20) * playerCount;
			List<Planet> planets = new ArrayList<Planet>();
			for (int i = 0; i < planetCount; i++) {
				planets.add(new Planet("Planet"+i));
			}
			List<Gate> gates = createGatesForPlanets(planets);
			
			return new Universe(planets, gates);

		}
		
		private static List<Gate> createGatesForPlanets(List<Planet> planets) {
			List<Gate> gates = new LinkedList<Gate>();
			// @formatter:off
			planets.stream().
				forEach(planet -> {
					int numberOfGatesForPlanet = getRandomNumberInRange(2, 4);
					int numberOfGatesConnectedToPlanet = 0;
					while (checkIfPlanetNeedsMoreGates(planet, gates) && numberOfGatesConnectedToPlanet < numberOfGatesForPlanet) {
						Planet randomPlanetFromList;
						do {
							Random rand = new Random();
							randomPlanetFromList = planets.get(rand.nextInt(planets.size()));
						} while (randomPlanetFromList.equals(planet) || checkIfPlanetHasMaximumGates(randomPlanetFromList, gates));
						gates.add(new Gate(planet, randomPlanetFromList));
						numberOfGatesConnectedToPlanet++;
					}
				});
			// @formatter:on
				return gates;
		}
		
		
		private static boolean checkIfPlanetNeedsMoreGates(Planet planet, List<Gate> gates) {
			Predicate<Gate> predicate = gate -> gate.getConnectedPlanets().contains(planet);
			long connectionsCount = gates.stream().filter(predicate).count();
			if (connectionsCount < 2) {
				return true;
			}
			return false;
		}
		
		private static boolean checkIfPlanetHasMaximumGates(Planet planet, List<Gate> gates) {
			Predicate<Gate> predicate = gate -> gate.getConnectedPlanets().contains(planet);
			long connectionsCount = gates.stream().filter(predicate).count();
			if (connectionsCount >= 4) {
				return true;
			}
			return false;
		}

		private static int getRandomNumberInRange(int min, int max) {
			if (min >= max) {
				throw new IllegalArgumentException("max must be greater than min");
			}
			return new Random().nextInt((max - min) + 1) + min;
		}
	
}
