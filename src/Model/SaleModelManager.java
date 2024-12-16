package Model;
import utils.MyFileHandler;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SaleModelManager
{
    private String fileName;

    public SaleModelManager(String fileName)
    {
        this.fileName = fileName;
    }

    public SalesLog getAllSales()
    {
        SalesLog allSales = new SalesLog();

        try
        {
          allSales = (SalesLog) MyFileHandler.readFromBinaryFile(fileName);
        }
        catch (FileNotFoundException e)
        {
          System.out.println("File not found sale");
        }
        catch (IOException e)
        {
          System.out.println("IO Error reading file sale");
        }
        catch (ClassNotFoundException e)
        {
          System.out.println("Class Not Found sale");
        }
        return allSales;
    }

    public void saveSales(SalesLog sales)
    {
        try
        {
          MyFileHandler.writeToBinaryFile(fileName, sales);
        }
        catch (FileNotFoundException e)
        {
          System.out.println("File not found or could not be opened sale");
        }
        catch (IOException e)
        {
          System.out.println("IO Error writing to file sale ");
        }
    }

    public void changeDiscount(SalesLog sales, Pet pet, int newDiscount)
    {
        sales.getSaleByPet(pet).setDiscount(newDiscount);
        saveSales(sales);
    }
}