 package Gui;
import Model.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
 public class ReservationController extends Application{


  @FXML private TextField searchByPhoneNumber;
  @FXML private Button AddReservation;
  @FXML private Button checkAvailability;
  @FXML  private Button searchButton;
  @FXML  private TextArea available;
  @FXML  private DatePicker startDate;
  @FXML private DatePicker endDate;
 // @FXML private TableColumn<Pet, String> listOfPets;
   @FXML private TableColumn<Pet, String> petName;
   @FXML private TableView<Pet> petTable;
   @FXML private TableView<Reservation> listOfReservations;
  @FXML private TextField listOfSearchByPhoneNumber;
  @FXML private TextField listOfSearchByCustomerName;
  @FXML private Button listOfPetsSearchButton;
  @FXML private DatePicker listOfStartDate;
  @FXML private DatePicker listOfEndDate;
  @FXML private Button listOfCheckAvailability;
  @FXML private TextArea listOfAvailable;
  @FXML private TableColumn<Reservation, String> listOfPetCustomer;
  @FXML private TableColumn<Reservation, String> listOfPetName;
  @FXML private TableColumn<Reservation, MyDate> listoflistOfStartDate;
  @FXML private TableColumn<Reservation, MyDate> listoflistOfEndDate;
  @FXML private Button listOfUpdate;
  @FXML private Button listOfDelete;


  public void initialize()
  {

    listOfPetName.setCellValueFactory(new PropertyValueFactory<>("petName"));
    listOfPetCustomer.setCellValueFactory(new PropertyValueFactory<>("customer"));
    listoflistOfStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
    listoflistOfEndDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));

    petName.setCellValueFactory(new PropertyValueFactory<>("name"));
    PetModelManager petModelManager = new PetModelManager("pets.bin");
    PetList allPets = petModelManager.getAllPets();
    petTable.getItems().clear();
    for (int i = 0; i < allPets.size(); i++)
    {
      petTable.getItems().add(allPets.getByIndex(i));
    }


    ReservationModelManager reservationModelManager = new ReservationModelManager("reservations.bin");
    ReservationList allReservations = reservationModelManager.getAllReservations();
    listOfReservations.getItems().clear();

    for (int i = 0; i < allReservations.size(); i++)
    {
      listOfReservations.getItems().add(allReservations.getByIndex(i));
    }
    // how to lead property value factory to read start date and end date from reservation class not from Cat class



  }

  @FXML public void start(Stage window) throws IOException
  {
    window.setTitle("Reservation");
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Gui/Reservation.fxml"));
    Scene scene = new Scene(loader.load());
    window.setScene(scene);
    window.show();
  }

  @FXML
  private void handel(ActionEvent event) {

    if (event.getSource() == AddReservation){
      Alert alert = new Alert(Alert.AlertType.INFORMATION,
          "Do you really want to add a reservation?",
          ButtonType.YES, ButtonType.NO);
      alert.setTitle("Exit");
      alert.setHeaderText(null);
      alert.showAndWait();
      if (alert.getResult() == ButtonType.YES) {
        System.out.println("AddReservation");
      }

    }
    else if (event.getSource() == listOfUpdate){
      Alert alert = new Alert(Alert.AlertType.INFORMATION,
          "Do you really want to update ??",
          ButtonType.YES, ButtonType.NO);
      alert.setTitle("Exit");
      alert.setHeaderText(null);
      alert.showAndWait();
      if (alert.getResult() == ButtonType.YES) {
        System.out.println("Updated Sucessfully");
      }
    }
    else if (event.getSource() == listOfDelete){
      Alert alert = new Alert(Alert.AlertType.INFORMATION,
          "Do you really Remove ??",
          ButtonType.YES, ButtonType.NO);
      alert.setTitle("Exit");
      alert.setHeaderText(null);
      alert.showAndWait();
      if (alert.getResult() == ButtonType.YES) {

        System.out.println("Deleted Sucessfully");
      }
    }
    else if (event.getSource() == checkAvailability ){
      ReservationModelManager reservationModelManager = new ReservationModelManager("reservations.bin");
      ReservationList allReservations = reservationModelManager.checkAvailability(searchByPhoneNumber.getText(), startDate.getValue(), endDate.getValue());
    }
    else if (event.getSource() == searchButton){
      CustomerModelManager customerModelManager = new CustomerModelManager("customers.bin");
      CustomerList allCustomers = customerModelManager.getAllCustomers();
     Customer petsByCustomer = allCustomers.getCustomerByPhoneNumber(searchByPhoneNumber.getText());

      PetModelManager petModelManager = new PetModelManager("pets.bin");
      PetList allPets = petModelManager.getAllPets();
     PetList petCustomerx = allPets.getPetsByCustomer(petsByCustomer);
      petTable.getItems().clear();
      System.out.println(petCustomerx);
      for (int i = 0; i < petCustomerx.size(); i++)
      {
        petTable.getItems().add(petCustomerx.getByIndex(i));
      }
    }
    MyDate addreservationBirthDate = null;
    if (event.getSource() == startDate){
      addreservationBirthDate = new MyDate(startDate.getValue().getDayOfMonth(), startDate.getValue().getMonthValue(), startDate.getValue().getYear());
    }


    MyDate addreservationEndDate = null;
    if (event.getSource() == endDate){
      addreservationEndDate = new MyDate(endDate.getValue().getDayOfMonth(), endDate.getValue().getMonthValue(), endDate.getValue().getYear());
    }


  }
}


