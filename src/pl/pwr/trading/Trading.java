/* @(#)Trading.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyright (c) 1999 Lukasz Lechert
*/

package pl.pwr.trading;

import java.util.Enumeration;

import com.odi.Database;
import com.odi.DatabaseNotFoundException;
import com.odi.ObjectStore;
import com.odi.util.OSHashtable;
import com.odi.util.OSVector;

import pl.pwr.trading.entity.Customer;
import pl.pwr.trading.entity.Order;
import pl.pwr.trading.service.CustomerService;
import pl.pwr.trading.service.OrderService;
import pl.pwr.trading.service.Service;
import pl.pwr.trading.service.impl.CustomerServiceImpl;
import pl.pwr.trading.service.impl.DatabaseInsertDataServiceImpl;
import pl.pwr.trading.service.impl.OrderServiceImpl;

/**
 * 
 * Main class and program
 * 
 * @author Lukasz Lechert
 */
public class Trading {

	public static void main(String argv[]) {

		// Configuration
		System.out.println("Processing configuration ...");
		String id = "u4";
		double amount = 2000.00d; // PLN
		String dbName = "trading.odb";
		switch (argv.length) {
		case 1:
			dbName = argv[0];
			break;
		case 2:
			amount = Double.parseDouble(argv[1]);
			break;
		case 3:
			id = argv[2];
			break;
		default:
			System.out.println("Syntax: java Trading [database name] [Amount] [customer's id to remove]");
		}
		// Actor: Administrator
		// Populate database
		System.out.println("Creating database ...");
		Database database;
		try {
			database = Database.open(dbName, ObjectStore.UPDATE);
		} catch (DatabaseNotFoundException ex) {
			database = Database.create(dbName, ObjectStore.ALL_READ | ObjectStore.ALL_WRITE);
		}
		System.out.println("Populating database ...");
		Service dbService = new DatabaseInsertDataServiceImpl(database, dbName);
		dbService.execute();

		// Actor: Shop assistant
		// Orders
		OrderService orderService = new OrderServiceImpl(database, dbName);
		// List all orders
		System.out.println("Getting all orders ...");
		OSHashtable orders = orderService.getOrders(dbName);
		for (Enumeration o = orders.elements(); o.hasMoreElements();) {
			System.out.println(o.nextElement().toString());
		}
		// List orders by amount
		System.out.println("Getting orders by amount > " + amount + " ...");
		OSVector ordersAmount = orderService.getOrdersByAmount(dbName, amount);
		for (Enumeration o = ordersAmount.elements(); o.hasMoreElements();) {
			System.out.println(o.nextElement().toString());
		}
		// List best order
		System.out.println("Getting the best order ...");
		Order order = orderService.getBestOrder(dbName);
		if (order != null) {
			System.out.println(order.toString());
		}

		// Customers
		CustomerService customerService = new CustomerServiceImpl(database, dbName);
		// List all customers
		System.out.println("Getting all customers ...");
		OSHashtable customers = customerService.getCustomers(dbName);
		for (Enumeration c = customers.elements(); c.hasMoreElements();) {
			System.out.println(c.nextElement().toString());
		}
		// List best customer
		System.out.println("Getting the best customer ...");
		Customer customer = customerService.getBestCustomer(dbName);
		if (customer != null) {
			System.out.println(customer.toString());
		}
		// Actor: Administrator
		// Remove a customer
		System.out.println("Romoving the customer. Id: " + id);
		if (customerService.remove(dbName, id)) {
			System.out.println("Customer " + id + "Removed successful ...");
		} else {
			System.out.println("Customer " + id + "Sorry, but not removed ...");
		}

		database.close();
		System.out.println("Finished ...");
	}
}
