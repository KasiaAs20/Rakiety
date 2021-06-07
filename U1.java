package kasia16;

import java.util.ArrayList;

public class U1 extends Rocket {

	public U1(int rocketId, ArrayList<Item> cargoList, int currentWeight) {

		this.rocketIdUnique = rocketId;

		this.cargoList = cargoList;

		this.currWeight = currentWeight;

		rocketUniqueCost = 100;

		rocketIdWeight = 10000;

		maxWeightinKG = 18000;

		chanceOfLaunchExplosion = 0.05;

		chanceOfLandingCrash = 0.01;

	}

	@Override

	public boolean launch() {

		int cargoCarried = currWeight - this.rocketIdWeight;

		int cargoLimitinKg = this.maxWeightinKG - this.rocketIdWeight;

		double ifprobabilityTrue = this.chanceOfLaunchExplosion * cargoCarried / cargoLimitinKg;

		boolean success = Math.random() >= ifprobabilityTrue;

		if (!success)
			System.out.println(" Rakieta U1 eksplodowala po wyslaniu-zostanie wysłana kolejna");

		return success;

	}

	@Override

	public boolean land() {

		int cargoCarried = currWeight - this.rocketIdWeight;

		int cargoLimit2 = this.maxWeightinKG - this.rocketIdWeight;

		double ifprobabilityTrue2 = this.chanceOfLandingCrash * cargoCarried / cargoLimit2;

		boolean success = Math.random() >= ifprobabilityTrue2;

		if (!success)
			System.out.println(" Rakieta U1 zderzyła się z ziemią,zostanie wysłana ponownie");

		return success;

	}

}