package Model;

/**
 * this class is a subclass from a super class pet
 * @author Group6
 * @version 1.0
*/
public class Cat extends Pet

{

  /**
   * Two extra fields more than the super class as needed for the Cat class.
   */
  private String breed;
  private String breeder;

  /**
   *
   * @param name,gender,comment,birthDate,color,price form super class
   * @param breed,breeder specific for this class
   * This constructor is to create an object of a cat in the pet shop "Has a price"
   */
  public Cat(String name, char gender, String comment, MyDate birthDate, String color, int price, String breed, String breeder)
  {
    super(name, gender, comment, birthDate, color, price);
    this.breed = breed;
    this.breeder = breeder;
  }

  /**
   *
   * @param name,gender,comment,birthDate,color,customer form super class
   * @param breed,breeder specific for this class
   *  This constructor is to create an object of a cat in the pet shop "Has a customer, and no price"
   */
  public Cat(String name, char gender, String comment, MyDate birthDate, String color, Customer customer, String breed, String breeder)
  {
    super(name, gender, comment, birthDate, color, customer);
    this.breed = breed;
    this.breeder = breeder;
  }

  /**
   * get breed method
   * @return the breed
   */
  public String getBreed()
  {
    return breed;
  }

  /**
   * get breeder method
   * @return the breeder
   */
  public String getBreeder()
  {
    return breeder;
  }
}
