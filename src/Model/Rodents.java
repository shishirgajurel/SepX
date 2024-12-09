package Model;
import java.util.Date;

/**
 * A class representing a rodent
 * @version 1.0
 * @author Group6
 */
public class Rodents extends Pet
{
  /**
   * instance variables
   */
  private boolean biteBehaviour;
  private String species;

  /**
   * constructor with price-pet for sale
   */
  public Rodents(String name, char gender, String comment, MyDate birthDate, String color, int price, String species)
  {
    super(name, gender, comment, birthDate, color, price);
    this.species = species;
  }

  /**
   * check if the rodent has bite behaviour
   * @return biteBehaviour
   */
  public boolean isBiteBehaviour()
  {
    return biteBehaviour;
  }

  /**
   * Set bite behaviour
   * @param biteBehaviour to set
   */
  public void setBiteBehaviour(boolean biteBehaviour)
  {
    this.biteBehaviour = biteBehaviour;
  }

  /**
   * Get species
   * @return species of the roden
   */
  public String getSpecies()
  {
    return species;
  }
  /**
   * toString method for rodent
   * @return String with rodent species
   */
  public String toString()
  {
    String str = "Rodents\n"+super.toString() + "\nSpecies: " + species + "\nBite Behaviour: ";

    if (biteBehaviour)
    {
      str+= "bites";
    }
    else
    {
      str += "Does not bite";
    }
    return str;
  }

  /**
   * equals method for rodent  if it is identical to the rodent
   * @return boolean if the rodent is equal to another rodent
   * @param obj to compare
   */
  public boolean equals(Object obj)
  {
    if (obj==null||obj.getClass()!=this.getClass())
    {
      return false;
    }
    Rodents other = (Rodents) obj;
    return species.equals(other.species) && biteBehaviour == other.biteBehaviour;
  }

}
