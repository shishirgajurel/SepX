package Model;
import parser.ParserException;
import parser.XmlJsonParser;
import utils.MyFileHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
      System.out.println("File was not found, or could not be opened");
    }
    catch (IOException e)
    {
      System.out.println("Error reading from file");
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Error reading from file");
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
      System.out.println("File not found or could not be opened");
    }
    catch (IOException e)
    {
      System.out.println("IO Error writing to file ");
    }
  }
  public void changeStartDate(ReservationList reservations, String phoneNumber ,MyDate newStartDate)
  {
    reservations.getReservationByCustomersPhoneNumber(phoneNumber).setStartDate(newStartDate, reservations);
    saveReservations(reservations);
  }
  public void changeEndDate(ReservationList reservations, String phoneNumber ,MyDate newEndDate)
  {
    reservations.getReservationByCustomersPhoneNumber(phoneNumber).setEndDate(newEndDate, reservations);
    saveReservations(reservations);
  }

  public void setStartDate(ReservationList reservations, String phoneNumber ,MyDate newStartDate)
  {
    reservations.getReservationByCustomersPhoneNumber(phoneNumber).setStartDate(newStartDate, reservations);
    saveReservations(reservations);
  }
  public void setEndDate(ReservationList reservations, String phoneNumber ,MyDate newEndDate)
  {
    reservations.getReservationByCustomersPhoneNumber(phoneNumber).setEndDate(newEndDate, reservations);
    saveReservations(reservations);
  }
  public void saveToXML(ReservationList reservations, String fileNameXML)
  {
    try
    {
      XmlJsonParser parser = new XmlJsonParser();
      File file = parser.toXml(getAllReservations(), fileNameXML);
      System.out.println("Saved to XML");
      System.out.println(file.getAbsolutePath());
    }
    catch (ParserException e)
    {
      System.out.println("Error parsing to XML");
    }
  }

  public void checkAvailability(ReservationList reservations, String phoneNumber, MyDate startDate, MyDate endDate)
  {
    reservations.checkAvailability(phoneNumber, startDate, endDate);
  }

}