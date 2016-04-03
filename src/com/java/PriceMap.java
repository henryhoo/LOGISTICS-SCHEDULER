package com.java;

public class PriceMap {
	// PriceMap class can represent the relationship with each line's price.
	// element price and whos works like hashmap, but it allow duplication of
	// keys(price) as prices can be the same sometime.
	double price;
	int whos;
	String name;

	public PriceMap(double price, int whos, String name) {
		super();
		this.price = price;
		this.whos = whos;
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getWhos() {
		return whos;
	}

	public void setWhos(int whos) {
		this.whos = whos;
	}

}
