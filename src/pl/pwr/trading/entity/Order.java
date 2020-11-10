/*
 * @(#)Order.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights 1999 Lukasz Lechert
*/

package pl.pwr.trading.entity;

import java.time.LocalTime;
import com.odi.util.OSVector;

/**
 * The class represents an order
 *
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */

public class Order {

	private long id;

	private LocalTime date;

	private char paymentType;

	private double amount;

	private Customer customer;

	private OSVector items;

	public Order(long id, char paymentType, Customer customer) {
		this.id = id;
		this.date = LocalTime.now();

		this.amount = 0.0;
		this.paymentType = paymentType;
		this.customer = customer;
		items = new OSVector();
	}

	public long getId() {
		return this.id;
	}

	public LocalTime getDate() {
		return this.date;
	}

	public char getPaymentType() {
		return this.paymentType;
	}

	public double getAmount() {
		return this.amount;
	}

	public double setItem(Item item) {
		items.addElement(item);
		amount = amount + item.getPrice();

		return amount;
	}

	public OSVector getItems() {
		return this.items;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	@Override
	public String toString() {
		return "{" + "  id='" + this.id + "'" + "  date='" + this.date + "'" + ", paymentType='" + this.paymentType
				+ "'" + ", amount='" + this.amount + "'" + "}";
	}
}