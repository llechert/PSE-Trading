/*
 * @(# CustomerServiceImpl.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights 1999 Lukasz Lechert
*/
package pl.pwr.trading.service.impl;

import java.util.Enumeration;

import com.odi.Database;
import com.odi.ObjectStore;
import com.odi.Transaction;
import com.odi.util.OSHashtable;

import pl.pwr.trading.entity.Customer;
import pl.pwr.trading.entity.Order;
import pl.pwr.trading.service.CustomerService;

/**
 * The interface supports any customer service. The implementation consists of
 * simple methods, like "Get the best customer ever with the highest amount
 * order"
 * 
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */
public class CustomerServiceImpl implements CustomerService {

	private Database database;

	private String name;

	public CustomerServiceImpl(Database database, String name) {
		this.database = database;
		this.name = name;
	}

	public Database getDatabase() {
		return database;
	}

	public String getName() {
		return name;
	}

	public OSHashtable getCustomers(String name) {
		return (OSHashtable) database.getRoot("hashSetCustomers");
	}

	public boolean remove(String name, String id) {
		boolean result = false;

		Transaction tr = Transaction.begin(ObjectStore.UPDATE);
		OSHashtable customers = (OSHashtable) database.getRoot("hashSetCustomers");

		if (customers.containsKey(id)) {
			Customer customer = (Customer) customers.get(id);
			if (customer.getOrders().isEmpty())
				customers.remove(id);
			result = true;
		}
		tr.commit();

		return result;
	}

	public Customer getBestCustomer(String name) {
		Customer result = null;
		double amount = 0.0;

		OSHashtable orders = (OSHashtable) database.getRoot("hashSetOrders");

		Order order;
		for (Enumeration o = orders.elements(); o.hasMoreElements();) {
			order = (Order) o.nextElement();

			if (order.getAmount() > amount) {
				result = order.getCustomer();
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "{ service='CustomerService', " + "  databasename='" + this.name + "'" + "}";
	}
}