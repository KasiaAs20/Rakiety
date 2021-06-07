package kasia16;

import java.util.ArrayList;

public class U2 extends Rocket {

	public U2(int rocketId, ArrayList<Item> cargoList, int currentWeight) {

		this.rocketIdUnique = rocketId;

		this.cargoList = cargoList;

		this.currWeight = currentWeight;

		rocketUniqueCost = 120;

		rocketIdWeight = 18000;

		maxWeightinKG = 29000;

		chanceOfLaunchExplosion = 0.04;

		chanceOfLandingCrash = 0.08;

	}

	@Override

	public boolean launch() {

		int cargoCarried = currWeight - rocketIdWeight;

		int cargoLimit = maxWeightinKG - rocketIdWeight;

		double ifprobabilityTrue3 = this.chanceOfLaunchExplosion * cargoCarried / cargoLimit;

		boolean success = Math.random() >= ifprobabilityTrue3;

		if (!success)
			System.out.println(" Rakieta U2 eksplodowala po wyslaniu-zostanie wysalana ponownie");

		return success;

	}

	@Override

	public boolean land() {

		int cargoCarried = currWeight - rocketIdWeight;

		int cargoLimit = maxWeightinKG - rocketIdWeight;

		double probabilityTrue = this.chanceOfLandingCrash * cargoCarried / cargoLimit;

		boolean success = Math.random() >= probabilityTrue;

		if (!success)
			System.out.println("Rakieta U1 zderzyła się z ziemią,zostanie wysłana ponownie");

		return success;

	}

}
