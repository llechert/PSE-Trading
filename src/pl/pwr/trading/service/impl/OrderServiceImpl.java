/*
 * @(# Service.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights 1999 Lukasz Lechert
*/
package pl.pwr.trading.service.impl;

import java.util.Enumeration;

import com.odi.Database;
import com.odi.util.OSHashtable;
import com.odi.util.OSVector;

import pl.pwr.trading.entity.Order;
import pl.pwr.trading.service.OrderService;

/**
 * The interface supports any Order service. The implementation consists of
 * simple methods, like "Get the best order ever"
 * 
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */
public class OrderServiceImpl implements OrderService {

	private Database database;

	private String name;

	public OrderServiceImpl(Database database, String name) {
		this.database = database;
		this.name = name;
	}

	public Database getDatabase() {
		return database;
	}

	public String getName() {
		return name;
	}

	public OSHashtable getOrders(String name) {
		return (OSHashtable) database.getRoot("hashSetOrders");
	}

	public OSVector getOrdersByAmount(String name, double amount) {
		OSVector result = new OSVector();
		OSHashtable orders = (OSHashtable) database.getRoot("hashSetOrders");

		Order order;
		for (Enumeration o = orders.elements(); o.hasMoreElements();) {
			order = (Order) o.nextElement();

			if (order.getAmount() > amount) {
				result.addElement(order);
			}
		}
		return result;
	}

	public Order getBestOrder(String name) {
		Order result = null;
		double amount = 0.0;

		OSHashtable orders = (OSHashtable) database.getRoot("hashSetOrders");

		Order order;
		for (Enumeration o = orders.elements(); o.hasMoreElements();) {
			order = (Order) o.nextElement();

			if (order.getAmount() > amount) {
				result = order;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "{ service='OrderService', " + "  databasename='" + this.name + "'" + "}";
	}
}