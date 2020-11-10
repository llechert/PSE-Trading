/*
 * @(#)Item.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights Lukasz Lechert
*/

package pl.pwr.trading.entity;

/**
 * The class represents an item
 *
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */
public class Item {

	private String id;

	private String name;

	private double price;

	private int warranty;

	private Supplier supplier;

	public Item(String id, String name, double price, int warranty, Supplier supplier) {
		this.id = id;
		this.name = name;
		this.price = price;
		if (warranty < 0) {
			this.warranty = 0;
		} else {
			this.warranty = warranty;
		}
		this.supplier = supplier;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public int getWarranty() {
		return this.warranty;
	}

	public int setWarranty(int warranty) {
		if (warranty < 0) {
			this.warranty = 0;
		} else {
			this.warranty = warranty;
		}
		return this.warranty;
	}

	public Supplier getSpplier() {
		return supplier;
	}

	@Override
	public String toString() {
		return "{" + " id='" + this.id + "'" + "  name='" + this.name + "'" + ", price='" + this.price + "'"
				+ ", warranty='" + this.warranty + "'" + "}";
	}
}