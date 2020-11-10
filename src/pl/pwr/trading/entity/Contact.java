/*
 * @(# Contact.java	1.0 99/05/24
 * Licensed under the GNU GPL v2 (June 1991)
 * 
 * Copyrights 1999 Lukasz Lechert
*/
package pl.pwr.trading.entity;

/**
 * The entity class represents contacts
 * 
 * @author Lukasz Lechert
 * @version 1.0, 99/05/24
 */

public class Contact{

  private String street;

  private String city;

  private String postalCode;

  private String phoneNumber;

  public Contact(String street, String city, String postalCode, String phoneNumber){
    this.street = street;
    this.city = city;
    this.postalCode = postalCode;
    this.phoneNumber = phoneNumber;
  }

  public String getStreet(){
    return this.street;
  }

  public String getCity(){
    return this.city;
  }

  public String getPostalCode(){
    return this.postalCode;
  }

  public String getPhoneNumber(){
    return this.phoneNumber;
  }

  @Override
  public String toString(){
    return "{" +
      "  street='" + this.street + "'" +
      ", city='" + this.city + "'" +
      ", postalCode='" + this.postalCode + "'" +
      ", phoneNumber='" + this.phoneNumber + "'" +
      "}";
  }
}