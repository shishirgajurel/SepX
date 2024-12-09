package Model;

import java.io.Serializable;

/**
 * Represents a sale of a pet.
 * The sale has a pet, a discount, a sale date, and a price.
 * The price of the pet is set to -1 when the pet is sold.
 * @author Group6
 * @version 1.0
 */
public class Sale implements Serializable
{
  /**
   * Instance variables.
   */
  private Pet pet;
  private double discount;
  private MyDate saleDate;
  private double price;

  /**
   * Constructor with 3 parameters.
   *
   * @param saleDate,pet,customer parameters.
   * sets the customer of the pet to the customer parameter, and sets the price of the pet to -1.
   * @throws IllegalArgumentException if the pet belongs to a customer.
   */
  public Sale (MyDate saleDate, Pet pet, Customer customer)
  {
    if (pet.getPrice() == -1)
    {
      throw new IllegalArgumentException("pet belongs to someone else, and cannot be sold");
    }
    else
    {
      this.saleDate = saleDate.copy();
      this.pet = pet;
      this.discount = 0.0;
      this.pet.setCustomer(customer);
      this.price = pet.getPrice();
      this.pet.setPrice(-1);
    }
  }

  /**
   * get the sale date.
   * @return copy of the sale date.
   */
  public MyDate getSaleDate()
  {
    return saleDate.copy();
  }

  /**
   * get the pet.
   * @return the pet.
   */
  public Pet getPet()
  {
    return pet;
  }

  /**
   * get the customer.
   * @return the customer.
   */
  public Customer getCustomer()
  {
    return pet.getCustomer();
  }

  /**
   * get the discount as a double.
   * @return the discount.
   */
  public double getDiscount()
  {
    return discount;
  }

  /**
   * set the discount as a double.
   * @param discount as double.
   */
  public void setDiscount(double discount)
  {
    this.discount = discount;
  }

  /**
   * get the final price of the pet.
   * multiplies the price of the pet by the discount.
   * @return the final price.
   */
  public double getFinalPrice()
  {
    price = price - price*discount;
    return price;
  }

  /**
   * get the price of the pet.
   * @return the price.
   */
  public double getPrice()
  {
    return price;
  }

  /**
   * Provides a string representation of the Sale.
   * @return a formatted string of the sale.
   */
  public String toString()
  {
    return "Pet: "+pet + "\nCustomer: "+pet.getCustomer()+"\nPrice after discount: "+getFinalPrice()+"\nDate: "+saleDate;
  }

  /**
   * Compares the sale to another object.
   * @param obj the object to compare with.
   * @return true if the object is a Sale with the same pet, discount, and sale date, false otherwise.
   */
  public boolean equals(Object obj)
  {
    if (obj == null || obj.getClass() != this.getClass())
    {
      return false;
    }
    Sale other = (Sale) obj;
    return pet.equals(other.pet) && discount == other.discount && saleDate.equals(other.saleDate) && price == other.price;
  }
}
