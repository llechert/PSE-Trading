/*
 * @(s Customer.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights 1999 Lukasz Lechert
*/

package pl.pwr.trading.entity;

import com.odi.util.OSVector;

/**
 * The entity class represents a customer
 * 
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */
public class Customer {

	// Pesel
	private String id;

	private String firstName;

	private String name;

	private Contact contact;

	private OSVector orders;

	public Customer(String id, String firstName, String name, Contact contact) {
		this.id = id;
		this.firstName = firstName;
		this.name = name;
		this.contact = contact;

		orders = new OSVector();
	}

	public String getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getName() {
		return this.name;
	}

	public Contact getContact() {
		return this.contact;
	}

	public OSVector getOrders() {
		return orders;
	}

	public OSVector setOrder(Order order) {
		orders.addElement(order);
		return orders;
	}

	@Override
	public String toString() {
		return "{" + "  id='" + this.id + "'" + ", firstName='" + this.firstName + "'" + ", name='" + this.name + "'"
				+ "}";
	}
}