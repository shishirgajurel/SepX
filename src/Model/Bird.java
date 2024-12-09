package Model;

/**
 * @author Group6
 * @version 1.0
 * A class representing a bird
 */
public class Bird extends Pet
{
  /**
   * instance variables of the class Bird that has preferredFood,species.
   */
  private String preferredFood;
  private String species;

  /**
   * constructor with price-pet for sale
   */
  public Bird(String name, char gender , String comment, MyDate birthDate, String color, int price, String species, String preferredFood)
  {
    super(name, gender, comment, birthDate, color, price);
    this.species = species;
    this.preferredFood = preferredFood;
  }
  /**
   * constructor with customer-kenneled pet
   */

  public Bird(String name, char gender , String comment, MyDate birthDate, String color,Customer customer ,String species, String preferredFood)
  {
    super(name, gender, comment, birthDate, color, customer);
    this.species = species;
    this.preferredFood = preferredFood;
  }
  /**
   * Get preferred food
   * @return preferred food
   */
  public String getPreferredFood()
  {
    return preferredFood;
  }
  /**
   * Set preferred food
   * @param preferredFood the food of the bird that prefer
   */

  public void setPreferredFood(String preferredFood)
  {
    this.preferredFood = preferredFood;
  }

  /**
   * Get species
   * @return species of the bird class
   */
  public String getSpecies()
  {
    return species;
  }

  /**
   * toString method for bird
   * @return String with bird species and preferred food
   */
  public String toString()
  {
    return "Bird\n"+super.toString() + "\nSpecies: " + species + "\nPreferred food: "+ preferredFood;

  }

  /**
   * equals method
   * @param obj to compare with the bird class in case if it is identical or not
   * @return true if the object is equal to this object or false if it is not
   *
   */
  public boolean equals(Object obj)
  {
    if(obj==null||this.getClass()!=obj.getClass())
    {
      return false;
    }
    Bird other = (Bird) obj;
    return super.equals(other) && species.equals(other.species);
  }
}