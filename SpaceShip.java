package kasia16;

public interface SpaceShip {

	boolean launch();

	boolean land();

	boolean canCarry(Item item);

	void carry(Item item);

}
