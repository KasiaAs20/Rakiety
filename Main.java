package kasia16;

import java.io.File;

import java.io.FileNotFoundException;

import java.text.DecimalFormat;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		DecimalFormat formatter = new DecimalFormat("#,###");

		File faza1 = new File("src/phase-1.txt");

		ArrayList<Item> itemListF1;

		itemListF1 = Simulation.loadItems(faza1);

		Simulation.showPhaseItems(itemListF1, 1);

		File faza2 = new File("src/phase-2.txt");

		ArrayList<Item> itemListF2;

		itemListF2 = Simulation.loadItems(faza2);

		Simulation.showPhaseItems(itemListF2, 2);

		ArrayList<Rocket> rocketListU1P1 = new ArrayList<>();

		ArrayList<U1> tempListidU1P1;
		tempListidU1P1 = Simulation.loadU1(itemListF1);

		for (Rocket r : tempListidU1P1) {
			rocketListU1P1.add(r);
		}

		ArrayList<Rocket> rocketListidU1P2 = new ArrayList<>();

		ArrayList<U1> tempListU1P2;
		tempListU1P2 = Simulation.loadU1(itemListF2);

		for (Rocket r : tempListU1P2) {
			rocketListidU1P2.add(r);
		}

		System.out.println("****************************************");



		ArrayList<Rocket> rocketListU2P1 = new ArrayList<>();

		ArrayList<U2> tempListU2P1;
		tempListU2P1 = Simulation.loadU2(itemListF1);

		for (Rocket r : tempListU2P1) {
			rocketListU2P1.add(r);
		}

		ArrayList<Rocket> rocketListU2P2 = new ArrayList<>();

		ArrayList<U2> tempListU2P2;
		tempListU2P2 = Simulation.loadU2(itemListF2);

		for (Rocket r : tempListU2P2) {
			rocketListU2P2.add(r);
		}

		System.out.println("****************************************");



		System.out.println("*******Rakiety U1 Faza I ************");

		double totalCostU1P1 = Simulation.runSimulation(rocketListU1P1);

		System.out.println("******** Rakiety U2- Faza 1 ************");

		double totalCostU2P1 = Simulation.runSimulation(rocketListU2P1);

		System.out.println("****** Rakiety U1- Faza 2********");

		double totalCostU1P2 = Simulation.runSimulation(rocketListidU1P2);

		System.out.println("*******Rakiety U2 -Faza 2  ************");

		double totalCostU2P2 = Simulation.runSimulation(rocketListU2P2);

		
	}

}
