package Model;
import javafx.geometry.Pos;
import parser.ParserException;
import parser.XmlJsonParser;
import utils.MyFileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class ReservationModelManager
{
  private String fileName;
  private ReservationModelManager reservationModelManager;
  public ReservationModelManager(String fileName)
  {
    this.fileName = fileName;
  }
  public ReservationList getAllReservations()
  {
    ReservationList allReservations = new ReservationList();
    try
    {
      allReservations=(ReservationList)MyFileHandler.readFromBinaryFile(fileName);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File was not found, or could not be opened Reservation");
    }
    catch (IOException e)
    {
      System.out.println("Error reading from file Reservation");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Error reading from file Reservation");
    }
    return allReservations;
  }
  public void saveReservations(ReservationList reservations)
  {
    try
    {
      MyFileHandler.writeToBinaryFile(fileName, reservations);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File not found or could not be opened Reservation");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file Reservation ");
    }
  }
  public void saveToXML(ReservationList reservations, String fileNameXML)
  {
    try
    {
      XmlJsonParser parser = new XmlJsonParser();
      File file = parser.toXml(getAllReservations(), fileNameXML);
      System.out.println("Saved to Reservation XML");
      System.out.println(file.getAbsolutePath());
    }
    catch (ParserException e)
    {
      System.out.println("Error parsing to Reservation XML");
    }
  }
}