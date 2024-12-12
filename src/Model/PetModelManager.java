package Model;
import parser.ParserException;
import parser.XmlJsonParser;
import utils.MyFileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PetModelManager
{
  private String fileName;

  public PetModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  public PetList getAllPets()
  {
    PetList allPets = new PetList();
    try
    {
      allPets=(PetList)MyFileHandler.readFromBinaryFile(fileName);

    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened");
    }
    catch (IOException e)
    {
      System.out.println("IO Error reading from file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Error reading from file");
    }
    return allPets;
  }

  public void savePets(PetList pets)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(fileName, pets);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found or could not be opened");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file ");
    }
  }

  public void changePetComments(PetList pets, String petName, Customer customer ,String newComments)
  {
    pets.getPetByNameAndCustomer(petName, customer).setComment(newComments);
    savePets(pets);
  }

  public void changePetName(PetList pets,Customer customer, String petName, String newPetName)
  {
    pets.getPetByNameAndCustomer(petName, customer).setName(newPetName);
    savePets(pets);
  }

  public void changePetPrice(PetList pets,Customer customer, String petName, int newPrice)
  {
    pets.getPetByNameAndCustomer(petName,customer).setPrice(newPrice);
    savePets(pets);
  }

  // add method saveToXML with xml parser.

  public void saveToXML(PetList pets, String fileNameXML)
  {
    try
    {
      XmlJsonParser parser = new XmlJsonParser();
      File file = parser.toXml(getAllPets(), fileNameXML);
      System.out.println("File saved as: " + file.getAbsolutePath());
    }
    catch (ParserException e)
    {
      throw new RuntimeException(e);
    }
  }

}