/*
 * @(# CustomerService.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights 1999 Lukasz Lechert
*/
package pl.pwr.trading.service;

import com.odi.util.OSHashtable;

import pl.pwr.trading.entity.Customer;

/**
 * The interface represents any customer service
 * 
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */
public interface CustomerService {

	/**
	 * Gives back all available customers
	 * 
	 * @param name Database name
	 * @return OSHashtable All customers
	 */
	public OSHashtable getCustomers(String name);

	/**
	 * Removes a single customer
	 * 
	 * @param name Database name
	 * @param id   customer's id
	 * 
	 * @return if pass true else false
	 */
	public boolean remove(String name, String id);

	/**
	 * Gives back the best customer ever with the highest order"
	 * 
	 * @param name Database name
	 * @return Customer A Customer with the best orders
	 */
	public Customer getBestCustomer(String name);

}