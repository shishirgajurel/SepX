package Model;

import java.io.Serializable;

/**
 * The class is abstract and has two constructors, one for the pet shop and one for the kennel.
 * @author Group6
 * @version 1.0
 */
public abstract class Pet implements Serializable
{
  /**
   * Instance variables.
   */
  private String name;
  private char gender;
  private String comment;
  private MyDate birthDate;
  private String color;
  private int price;
  private Customer customer;

  /**
   * Constructor with 6 parameters. to make an object of the class Pet in the pet shop.
   *
   * @param name,gender,comment,birthDate,color,price has price but no customer
   */
  public Pet(String name, char gender, String comment, MyDate birthDate,
      String color, int price)
  {
    this.name = name;
    this.gender = gender;
    this.comment = comment;
    this.birthDate = birthDate.copy();
    this.color = color;
    this.price = price;
    this.customer = null;
  }

  /**
   * Constructor with 7 parameters. to make an object of the class Pet in the kennel.
   *
   * @param name,gender,comment,birthDate,color,price,customer has customer and price set to -1.
   */
  public Pet(String name, char gender, String comment, MyDate birthDate,
      String color, Customer customer)
  {
    this.name = name;
    this.gender = gender;
    this.comment = comment;
    this.birthDate = birthDate.copy();
    this.color = color;
    this.price = -1;
    this.customer = customer;
  }

  /**
   * get name of the pet.
   *
   * @return name of the pet.
   */
  public String getName()
  {
    return name;
  }

  /**
   * set name of the pet.
   *
   * @param name of the pet.
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * get the gender of the pet
   *
   * @return gender as char
   */
  public char getGender()
  {
    return gender;
  }

  /**
   * get the comment of the pet
   *
   * @return comment as string
   */
  public String getComment()
  {
    return comment;
  }

  /**
   * set the comment of the pet
   *
   * @param comment as string
   */
  public void setComment(String comment)
  {
    this.comment = comment;
  }

  /**
   * get the birthdate of the pet
   *
   * @return birthdate as MyDate object
   */
  public MyDate getBirthDate()
  {
    return birthDate.copy();
  }

  /**
   * get the color of the pet
   *
   * @return color as string
   */
  public String getColor()
  {
    return color;
  }

  /**
   * get the price of the pet
   *
   * @return price as int
   */
  public int getPrice()
  {
    return price;
  }

  /**
   * set the price of the pet
   *
   * @param price as int
   */
  public void setPrice(int price)
  {
    this.price = price;
  }

  /**
   * set the customer of the pet
   *
   * @param customer as Customer object
   */
  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  /**
   * get the customer of the pet
   *
   * @return customer as Customer object
   */
  public Customer getCustomer()
  {
    return customer;
  }

  /**
   * Provides a string representation of the Pet.
   *
   * @return a formatted string of the pet details, gender as string, customer if price is (-1), otherwise returns price.
   */
  public String toString()
  {
    String strGender;

    if (gender == 'm')
    {
      strGender = "Male";
    }
    else
    {
      strGender = "Female";
    }

    String str =
        "Name: " + name + "\nGender : " + strGender + "\nDate of birth : "
            + birthDate + "\nColor : " + color + "\nComment : " + comment;

    if (price != -1)
    {
      str += "\nPrice : " + price;
    }
    else
    {
      str += "\nOwner:\n" + customer;
    }
    return str;
  }

  /**
   * Checks if this pet is equal to another object.
   * @param obj the object to compare with.
   * @return true if the objects are equal, false otherwise.
   */
  public boolean equals(Object obj)
  {
    if (obj == null || this.getClass() != obj.getClass())
    {
      return false;
    }

    Pet other = (Pet) obj;
    return other.name.equals(name) && other.gender == gender && other.comment
        .equals(comment) && other.birthDate.equals(birthDate) && other.color
        .equals(color) && other.price == price && other.customer.equals(customer);
  }
}
