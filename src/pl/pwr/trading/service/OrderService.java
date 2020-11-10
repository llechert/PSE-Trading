/*
 * @(# Service.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights 1999 Lukasz Lechert
*/

package pl.pwr.trading.service;

import com.odi.util.OSHashtable;
import com.odi.util.OSVector;

import pl.pwr.trading.entity.Order;

/**
 * The interface represents any order service
 * 
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */
public interface OrderService {

	/**
	 * Gives back all available orders
	 * 
	 * @param name Database name
	 * @return OSHashtable All orders returned
	 */
	public OSHashtable getOrders(String name);

	/**
	 * Gives back all available orders that amount is higher than given parameter
	 * 
	 * @param name   Database name
	 * @param amount An amount to compare to
	 * @return OSVector All orders with amount higher than given parameter
	 */
	public OSVector getOrdersByAmount(String name, double amount);

	/**
	 * Gives back the best order ever with the highest amount"
	 * 
	 * @param name Database name
	 * @return Order An Order with the best amount
	 */
	public Order getBestOrder(String name);
}