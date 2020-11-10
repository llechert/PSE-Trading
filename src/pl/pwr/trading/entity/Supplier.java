/*
 * @(#)Supplier.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights 1999 Lukasz Lechert
*/

package pl.pwr.trading.entity;

import com.odi.util.OSVector;

/**
 * The class represents a supplier
 * 
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */
public class Supplier {

	// Tax number
	private String id;

	private String name;

	private Contact contact;

	private OSVector items;

	public Supplier(String id, String name, Contact contact) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		items = new OSVector();
	}

	public OSVector setItem(Item item) {
		items.addElement(item);
		return items;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Contact getContact() {
		return contact;
	}

	public OSVector getItems() {
		return items;
	}

	public String toString() {
		return "{" + "  id='" + this.id + "'" + ", name='" + this.name + "'" + "}";
	}
}
