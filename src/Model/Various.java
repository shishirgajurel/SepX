package Model;

/**
 * this is a subclass Various that extends the superclass Pet
 * @author Group6
 * @version 1.0
 */
public class Various extends Pet
{
  /**
   * this field is added to the Various class, as it is a field needed specifically for Various
   */
  private String species;

  /**
   * this constructor is to create an object of various in the pet shop showcased by having a price
   * @param name, @param gender, @param comment, @param birthdate, @param color, @param price from the super class
   * @param species new field added to the Various class
   */
  public Various(String name, char gender, String comment, MyDate birthDate, String color, int price, String species)
  {
    super(name, gender ,comment, birthDate, color, price);
    this.species = species;
  }

  /**
   * this is a get method to get the species for the pet
   *@return it returns species of the pet
   */
  public String getSpecies()
  {
    return species;
  }
  /**
   * this creates a toString method for Various
   *@return it returns String for Various with added species field
   */
  public String toString()
  {
    return "Various\n"+super.toString() + "\nSpecies: " + species + "\n";
  }
  /**
   * equals method for various pet
   * @return boolean if the various pet is equal to another various pet
   * @param obj to compare with the various pet
   */
  public boolean equals(Object obj)
  {
    if (obj==null||obj.getClass()!=this.getClass())
    {
      return false;
    }
    Various other = (Various) obj;
    return species.equals(other.species);
  }
}