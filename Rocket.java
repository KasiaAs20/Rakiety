package kasia16;

import java.util.ArrayList;

public class Rocket implements SpaceShip {

	ArrayList<Item> cargoList = new ArrayList<Item>();

	int rocketIdUnique;

	int currWeight;

	double rocketUniqueCost;

	int rocketIdWeight;

	int maxWeightinKG;

	double chanceOfLaunchExplosion;

	double chanceOfLandingCrash;

	@Override

	public boolean launch() {

		return true;

	}

	@Override

	public boolean land() {

		return true;

	}

	public boolean canCarry(Item item) {

		return (currWeight + item.getWeight() <= maxWeightinKG);

	}

	public void carry(Item item) {

		cargoList.add(item);

		this.currWeight = this.currWeight + item.getWeight();

	}

	public ArrayList<Item> getCargoList() {

		return this.cargoList;

	}

	public int getCurrWeight() {

		return this.currWeight;

	}

	public double getAllRocketCost() {

		return this.rocketUniqueCost;

	}

	public void initializeRocketModel(int rocketId) {

		this.rocketIdUnique = rocketId;

		this.cargoList = new ArrayList<Item>();

		this.currWeight = rocketIdWeight;

	}

}