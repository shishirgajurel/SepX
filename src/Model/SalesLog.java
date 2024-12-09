package Model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * A class representing a sales log
 * @author Group6
 * @version 1.0
 */
public class SalesLog implements Serializable
{
  /**
   * instance variables
   */
  private ArrayList<Sale> sales;

  /**
   * constructor
   */
  public SalesLog()
  {
    sales= new ArrayList<>();
  }

  /**
   * add a sale to the list if the pet belongs in the pet shop.
   * @param sale to add
   */
  public void addSale(Sale sale)
  {
    sales.add(sale);
  }

  public int size()
  {
    return sales.size();
  }

  /**
   * get a sale by index
   * @param index to search for in the sales log.
   * @return the sale at the index
   */
  public Sale getByIndex(int index)
  {
    return sales.get(index);
  }

  public Sale getSaleByPet(Pet pet)
  {
    for (int i = 0; i < sales.size(); i++)
    {
      if (sales.get(i).getPet().equals(pet))
      {
        return sales.get(i);
      }
    }
    throw new IllegalArgumentException("Pet not found in sales log");
  }

  /**
   * Get a sale by customer
   * @return number of sales that the customer has made
   * @param customer to search for in the sales log.
   */
  public SalesLog getSalesByCustomer(Customer customer)
  {
    SalesLog temp = new SalesLog();
    for (int i = 0; i < sales.size(); i++)
    {
      if (sales.get(i).getPet().getCustomer().equals(customer))
      {
        temp.addSale(sales.get(i));
      }
    }
    return temp;
  }

  /**
   * toString method
   * @return a string representation of the sales log
   */
  public String toString()
  {
    String str = "";
    for (int i = 0; i < sales.size(); i++)
    {
      str += sales.get(i).toString() + "\n";
    }
    return str;
  }

  /**
   * equals method
   * @param obj to compare with
   * @return true if the object is equal to the sales log
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }

    SalesLog other = (SalesLog) obj;

    if (sales.size() != other.sales.size())
    {
      return false;
    }

    for (int i = 0; i < sales.size(); i++)
    {
      if (!sales.get(i).equals(other.sales.get(i)))
      {
        return false;
      }
    }
    return true;
  }
}