/*
 * @(# InsertServiceImpl.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights 1999 Lukasz Lechert
*/
package pl.pwr.trading.service.impl;

import com.odi.*;
import com.odi.util.OSHashtable;

import pl.pwr.trading.entity.Contact;
import pl.pwr.trading.entity.Customer;
import pl.pwr.trading.entity.Item;
import pl.pwr.trading.entity.Order;
import pl.pwr.trading.entity.Supplier;
import pl.pwr.trading.service.Service;

/**
 * 
 * The class implements the interface Service. The class populates the database
 * by data
 * 
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */
public class DatabaseInsertDataServiceImpl implements Service {

	private Database database;

	private String name;

	public DatabaseInsertDataServiceImpl(Database database, String name) {
		this.database = database;
		this.name = name;
	}

	public Database getDatabase() {
		return database;
	}

	public String getName() {
		return name;
	}

	public void execute() {

		Transaction tr = Transaction.begin(ObjectStore.UPDATE);

		// Contacts
		OSHashtable contacts = new OSHashtable();
		Contact c1 = new Contact("1 Maja 2a", "Poznan", "43-453", "(0-61) 8123112");
		contacts.put("c1", c1);
		Contact c2 = new Contact("Poznanska 91", "Radom", "51-200", "(0-23) 123563");
		contacts.put("c2", c2);
		Contact c3 = new Contact("Reja 11/2", "Wroclaw", "91-342", "(0-71) 3452111");
		contacts.put("c3", c3);
		Contact c4 = new Contact("B.Prusa 12", "Poznan", "43-453", "(0-61) 8987123");
		contacts.put("c4", c4);
		Contact c5 = new Contact("Sienkiewicza 23b", "Konin", "62-510", "(0-63) 2752876");
		contacts.put("c5", c5);
		Contact c6 = new Contact("Wittiga 8", "Wroclaw", "91-387", "(0-71) 3456123");
		contacts.put("c6", c6);
		Contact c7 = new Contact("Warszawska 12", "Slupca", "62-400", "(0-63) 275453");
		contacts.put("c7", c7);

		// Suppliers
		OSHashtable suppliers = new OSHashtable();
		Supplier s1 = new Supplier("891-12-6721", "Sony Corp", c1);
		suppliers.put("s1", s1);
		Supplier s2 = new Supplier("861-10-6621", "Aiwa Ltd", c2);
		suppliers.put("s2", s2);
		Supplier s3 = new Supplier("881-12-6001", "Panasonic", c3);
		suppliers.put("s3", s3);

		// Customers
		OSHashtable customers = new OSHashtable();
		Customer u1 = new Customer("74031298678", "Jan", "Nowak", c4);
		customers.put("u1", u1);
		Customer u2 = new Customer("75050192658", "Tomasz", "Kowalski", c5);
		customers.put("u2", u2);
		Customer u3 = new Customer("51061112618", "Maciej", "Nowacki", c6);
		customers.put("u3", u3);
		Customer u4 = new Customer("70041998679", "Krzysztof", "Nowakowski", c7);
		customers.put("u4", u4);

		// Items
		OSHashtable items = new OSHashtable();
		Item i1 = new Item("1", "Wieza Sony RX 50", 1699.99, 2, s1);
		items.put("i1", i1);
		Item i2 = new Item("2", "Walkman Aiwa 23k", 199.99, 3, s2);
		items.put("i2", i2);
		Item i3 = new Item("3", "TV Sony Trinitron", 2599.99, 2, s1);
		items.put("i3", i3);
		Item i4 = new Item("4", "Kamera Pansonic EW200", 3100.99, 3, s3);
		items.put("i4", i4);

		// Orders
		OSHashtable orders = new OSHashtable();
		Order o1 = new Order(1, 'M', u1);
		o1.setItem(i1);
		o1.setItem(i2);
		orders.put("o1", o1);

		Order o2 = new Order(2, 'C', u1);
		o2.setItem(i3);
		o2.setItem(i4);
		orders.put("o2", o2);

		Order o3 = new Order(3, 'C', u2);
		o3.setItem(i1);
		orders.put("o3", o3);

		Order o4 = new Order(4, 'C', u3);
		o4.setItem(i1);
		o4.setItem(i2);
		o4.setItem(i3);
		o4.setItem(i4);
		orders.put("o4", o4);

		database.createRoot("hashSetContacts", contacts);
		database.createRoot("hashSetSuppliers", suppliers);
		database.createRoot("hashSetCustomers", customers);
		database.createRoot("hashSetItems", items);
		database.createRoot("hashSetOrders", orders);

		tr.commit();
	}

	@Override
	public String toString() {
		return "{ service='InsertDataService', " + "  databasename='" + this.name + "'" + "}";
	}
}