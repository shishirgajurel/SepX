
package Model;
import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CustomerModelManager
{
  private String fileName;

  public CustomerModelManager(String fileName)
  {
    this.fileName = fileName;
  }

  public CustomerList getAllCustomers()
  {
    CustomerList allCustomers = new CustomerList();
    try
    {
      allCustomers=(CustomerList)MyFileHandler.readFromBinaryFile(fileName);

    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened Customer");
    }
    catch (IOException e)
    {
      System.out.println("Error reading from file Customer");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Error reading from file Customer");
    }
    return allCustomers;
  }

  public void saveCustomers(CustomerList customers)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(fileName, customers);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found or could not be opened Customer");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file  Customer");
    }
  }

  public void changeEmailAddress(CustomerList customers, String phoneNumber, String newEmailAddress)
  {
    customers.getCustomerByPhoneNumber(phoneNumber).setEmailAddress(newEmailAddress);
    saveCustomers(customers);
  }

  public void changePhoneNumber(CustomerList customers, String phoneNumber, String newPhoneNumber)
  {
    for (int i = 0; i < customers.size(); i++)
    {
      if (customers.getByIndex(i).getPhoneNumber().equals(newPhoneNumber))
      {
        throw new IllegalArgumentException("Phone number already exists Customer");
      }
      customers.getCustomerByPhoneNumber(phoneNumber).setPhoneNumber(newPhoneNumber);
      saveCustomers(customers);
    }
  }

  public void changeName(CustomerList customers, String phoneNumber, String newName)
  {
    customers.getCustomerByPhoneNumber(phoneNumber).setName(newName);
    saveCustomers(customers);
  }
}
