package kasia16;

import java.io.File;

import java.io.FileNotFoundException;

import java.text.DecimalFormat;

import java.util.ArrayList;

import java.util.Scanner;

public class Simulation {

	public static double runSimulation(ArrayList<Rocket> rocketAllList) {

		System.out.println("***** Poczatek symulacji***********");

		DecimalFormat formatter = new DecimalFormat("#,###");

		double toTlBudget = 0;

		boolean rocketLaunchedchOk;

		boolean rocketLandedOk;

		int x = 1;

		int y = 0;

		int z = 0;

		for (Rocket rocket : rocketAllList) {

			double rocketAllCost = rocket.getAllRocketCost();

			System.out.println("Rakieta" + x + " zostaje wysłana jej koszt w dolarach  US$ " + formatter.format(rocketAllCost)
					+ " milion");

			rocketLaunchedchOk = rocket.launch();

			rocketLandedOk = rocket.land();

			while (!rocketLaunchedchOk || !rocketLandedOk) {

				toTlBudget = toTlBudget + rocketAllCost;

				if (!(rocketLaunchedchOk))
					y++;

				if (!(rocketLandedOk))
					z++;

				rocketLaunchedchOk = rocket.launch();

				rocketLandedOk = rocket.land();

			}

			toTlBudget = toTlBudget + rocket.getAllRocketCost();

			System.out.println("Rakieta wystartowała i wylądowała z sukcesem");

			x++;

		}

		System.out.println("************** Statystyki ************");

		System.out.println(" Budzet wszystkich rakiet w dolarach " + formatter.format(toTlBudget) + " million");

		System.out.println(" Ilość rakiet wysłanych z sukcesem " + String.valueOf(x - 1));

		System.out.println("Ilość rakiet eksplodujących po wysłaniu" + String.valueOf(y));

		System.out.println("Ilosć rakiet ,które zderzyły się z ziemią: " + String.valueOf(z));

		System.out.println("************ Koniec symulacji ***************");

		return toTlBudget;

	}

	public static ArrayList<U1> loadU1(ArrayList<Item> itemList) {

		int i;

		int j;

		ArrayList<U1> rocketListU1 = new ArrayList<U1>();

		ArrayList<Item> cargoAllList = new ArrayList<Item>();

		U1 rocketModel;

		int currentAllWeight = 0;

		System.out.println("************początek ladownaia rakiet U1 *************");

		i = 1;

		j = 1;

		rocketModel = new U1(j, cargoAllList, currentAllWeight);

		rocketModel.initializeRocketModel(j);

		System.out.println("Ladownaie rakiety U1" + j + ": " + rocketModel);

		for (Item item : itemList) {

			if (rocketModel.canCarry(item)) {

				rocketModel.carry(item);

				System.out.println("Rakieta U1 " + j + ": jest zaladowana " + item.toString(i));

				i++;

			}

			else {

				rocketListU1.add(rocketModel);

				currentAllWeight = rocketModel.getCurrWeight();

				System.out.println(
						"Rakieta U1 " + j + " dodane do listy zaladunku , całkowita waga " + currentAllWeight + " kg");

				j++;

				rocketModel = new U1(j, cargoAllList, currentAllWeight);

				rocketModel.initializeRocketModel(j);

				System.out.println("Zaladowanie rakiety U1" + j + ": " + rocketModel);

				rocketModel.carry(item);

				System.out.println("Rakieta U1  " + j + ": ladowanie " + item.toString(i));

				i++;

			}

		}

		rocketListU1.add(rocketModel);

		currentAllWeight = rocketModel.getCurrWeight();

		System.out.println("Rakieta U1" + j + " dodana do listy rakiet U1,calkowiata waga" + currentAllWeight + " kg");

		System.out.println("*********** koniec ladownaia rakiet U1***************");

		return rocketListU1;

	}

	public static ArrayList<U2> loadU2(ArrayList<Item> itemList) {

		int i;

		int j;

		ArrayList<U2> rocketListU2 = new ArrayList<U2>();

		ArrayList<Item> cargoList = new ArrayList<Item>();

		U2 rocket;

		int currentWeight = 0;

		System.out.println("************ Poczatek ladowania rakietU2****************");

		i = 1;

		j = 1;

		rocket = new U2(j, cargoList, currentWeight);

		rocket.initializeRocketModel(j);

		System.out.println("Ladowanie rakiety U2 " + j + ": " + rocket);

		for (Item item : itemList) {

			if (rocket.canCarry(item)) {

				rocket.carry(item);

				System.out.println("Rakieta U2  " + j + ": zaladowana " + item.toString(i));

				i++;

			}

			else {

				rocketListU2.add(rocket);

				currentWeight = rocket.getCurrWeight();

				System.out.println(
						"Rakieta U2 " + j + "  dodana do listy rakiet U2 ,calkoiwta waga " + currentWeight + " kg");

				j++;

				rocket = new U2(j, cargoList, currentWeight);

				rocket.initializeRocketModel(j);

				System.out.println(" Ladowanie rakiety U2 " + j + ": " + rocket);

				rocket.carry(item);

				System.out.println("Rakieta U2 " + j + ": zaladowana " + item.toString(i));

				i++;

			}

		}

		rocketListU2.add(rocket);

		currentWeight = rocket.getCurrWeight();

		System.out.println("Rakieta U2 " + j + " dodana do listy rakiet U2 ,całkowita waga" + currentWeight + " kg");

		System.out.println("***********koniec ladowania rakiety U2 *****************");

		return rocketListU2;

	}

	public static ArrayList<Item> loadItems(File file) throws FileNotFoundException {

		ArrayList<Item> itemsList = new ArrayList<Item>();

		int i = 1;

		Scanner s = new Scanner(file);



		while (s.hasNextLine()) {

			String line = s.nextLine();

			String[] items = line.split("=");

			Item item = new Item(items[0], Integer.valueOf(items[1]));

			itemsList.add(item);

			//System.out.println(item.toString(i));

			i++;

		}

		s.close();
		

		return itemsList;

	}

	public static void showCargo(ArrayList<Rocket> rocketList) {
		ArrayList<Item> cargoList;

		int i = 1;

		int j = 1;

		for (Rocket rocket : rocketList) {

			System.out.println("Rakieta " + j + ": " + rocket);

			cargoList = rocket.getCargoList();

			for (Item item : cargoList) {

				System.out.println(item.toString(i));

				i++;

			}

			j++;

		}

	}

	public static void showPhaseItems(ArrayList<Item> itemList, int phase) {
		int i = 1;

		System.out.println(" Caly ekwipunek  fazy " + phase + " :");

		for (Item item : itemList) {
			System.out.println(item.toString(i));
			i++;
		}

	}

}
