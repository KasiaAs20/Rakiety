package kasia16;

public class Item {

	
	public String toString(int i) {
		return "Element ekwipunku "+ i + " [nazwa=" + name + ", waga=" + weight + " kg ]";
	}

	public Item(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	private String name;

	private int weight;

}