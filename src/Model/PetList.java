package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

/**
 * A class representing a list of pets
 * @author  Group6
 * @version 1.0
 */
public class PetList implements Serializable
{
  /**
   * instance variables
   */
  private ArrayList<Pet> pets;
  /**
   * constructor
   */
  public PetList()
  {
    pets = new ArrayList<Pet>();
  }

  /**
   * Get a number of pets
   * @param pet  to add
   */
  public void addPet(Pet pet)
  {
    pets.add(pet);
  }

  /**
   * Get a pet by index.
   * @return pet.
   */
  public Pet getPet(int index)
  {
    return pets.get(index);
  }

  /**
   * Get a number of pets
   * @return number of pets
   */
  public int size()
  {
    return pets.size();
  }

  /**
   * Get a pet by index
   * @param index to search for pet
   * @return pet
   */
  public Pet getByIndex(int index)
  {
    return pets.get(index);
  }

  /**
   * Get pets by their customer
   * @return number of pets that share the same customer
   * @param customer to search for pets.
   */
  public PetList getPetsByCustomer(Customer customer)
  {
    PetList petList = new PetList();
    for (int i = 0; i < pets.size(); i++)
    {
      if (pets.get(i).getCustomer() != null && pets.get(i).getCustomer().equals(customer))
      {
        petList.addPet(pets.get(i));
      }
    }
    return petList;
  }

  /**
   * Get pets by their name
   * @param name to search for pets.
   * @return a list of pets that share the same name
   */
  public PetList getPetsByName(String name)
  {
    PetList petList = new PetList();
    for (int i = 0; i < pets.size(); i++)
    {
      if (pets.get(i).getName().toLowerCase().contains(name.toLowerCase(Locale.ROOT)))
      {
        petList.addPet(pets.get(i));
      }
    }
    return petList;
  }

  /**
   * Get pets by their name and customer
   * @param name to search for pets.
   * @param customer to search for pets.
   * @return a list of pets that share the same name and customer
   */
  public Pet getPetByNameAndCustomer(String name, Customer customer)
  {
    for (int i = 0; i < pets.size(); i++)
    {
      if (pets.get(i).getName().equals(name) && pets.get(i).getCustomer().equals(customer))
      {
        return pets.get(i);
      }
    }
    throw new IllegalArgumentException("Pet not found");
  }

  /**
   * remove a pet from the list
   * @param pet to remove
   */
  public void removePet(Pet pet)
  {
    pets.remove(pet);
  }

  /**
   * toString method
   * @return a string representation of the pet list
   */
  public String toString()
  {
    String str = "";
    for (int i = 0; i < pets.size(); i++)
    {
      str += pets.get(i).toString() + "\n";
    }
    return str;
  }

  /**
   * equals method
    * @param obj to compare
   * @return true if the object is equal to the pet list
   */
  public boolean equals(Object obj)
  {
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    PetList other = (PetList) obj;
    if (pets.size() != other.pets.size())
    {
      return false;
    }
    for (int i = 0; i < pets.size(); i++)
    {
      if (!pets.get(i).equals(other.pets.get(i)))
      {
        return false;
      }
    }
    return true;
  }
}