package Gui;

import Model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PetController
{

  // Add Pet - Dog Tab
  @FXML private TextField dogNameField;
  @FXML private RadioButton dogMaleRadio;
  @FXML private RadioButton dogFemaleRadio;
  @FXML private DatePicker dogBirthDatePicker;
  @FXML private TextField dogColorField;
  @FXML private TextField dogPriceField;
  @FXML private TextField dogBreedField;
  @FXML private TextField dogBreederField;
  @FXML private TextArea dogCommentArea;
  @FXML private Button addDogButton;

  // Add Pet - Cat Tab
  @FXML private TextField catNameField;
  @FXML private RadioButton catMaleRadio;
  @FXML private RadioButton catFemaleRadio;
  @FXML private DatePicker catBirthDatePicker;
  @FXML private TextField catColorField;
  @FXML private TextField catPriceField;
  @FXML private TextField catBreedField;
  @FXML private TextField catBreederField;
  @FXML private TextArea catCommentArea;
  @FXML private Button addCatButton;

  // Add Pet - Rodent Tab
  @FXML private TextField rodentNameField;
  @FXML private RadioButton rodentMaleRadio;
  @FXML private RadioButton rodentFemaleRadio;
  @FXML private DatePicker rodentBirthDatePicker;
  @FXML private TextField rodentColorField;
  @FXML private TextField rodentPriceField;
  @FXML private TextField rodentSpeciesField;
  @FXML private TextArea rodentCommentArea;
  @FXML private Button addRodentButton;
  @FXML private RadioButton rodentIsBite;
  @FXML private RadioButton rodentIsNotBite;

  // Add Pet - Bird Tab
  @FXML private TextField birdNameField;
  @FXML private RadioButton birdMaleRadio;
  @FXML private RadioButton birdFemaleRadio;
  @FXML private DatePicker birdBirthDatePicker;
  @FXML private TextField birdColorField;
  @FXML private TextField birdPriceField;
  @FXML private TextField birdSpeciesField;
  @FXML private TextField birdFoodField;
  @FXML private TextArea birdCommentArea;
  @FXML private Button addBirdButton;

  // Add Pet - Fish Tab
  @FXML private TextField fishNameField;
  @FXML private RadioButton fishMaleRadio;
  @FXML private RadioButton fishFemaleRadio;
  @FXML private DatePicker fishBirthDatePicker;
  @FXML private TextField fishColorField;
  @FXML private TextField fishPriceField;
  @FXML private TextField fishSpeciesField;
  @FXML private RadioButton fishFreshWaterRadio;
  @FXML private RadioButton fishSaltWaterRadio;
  @FXML private RadioButton fishPredetor;
  @FXML private RadioButton fishNotPredetor;
  @FXML private TextArea fishCommentArea;
  @FXML private Button addFishButton;

  // Add Pet - Various Tab
  @FXML private TextField variousNameField;
  @FXML private RadioButton variousMaleRadio;
  @FXML private RadioButton variousFemaleRadio;
  @FXML private DatePicker variousBirthDatePicker;
  @FXML private TextField variousColorField;
  @FXML private TextField variousPriceField;
  @FXML private TextField variousSpeciesField;
  @FXML private TextArea variousCommentArea;
  @FXML private Button addVariousButton;

  // Modify Pet Tab
  @FXML private TableView<?> petListTable;
  @FXML private TextField modifyPetNameField;
  @FXML private TextField modifyPetCustomerField;
  @FXML private TextField modifyPetPriceField;
  @FXML private TextArea modifyPetCommentArea;
  @FXML private Button modifyPetButton;
  @FXML private Button removePetButton;
  PetList pets =new PetList();
  @FXML private void initialize()
  {

    // Initialize any necessary data or settings here
  }

  @FXML private void handleAddDog()
  {
    // Validate mandatory fields
    if (dogNameField.getText().isEmpty() || dogBreedField.getText().isEmpty())
    {
      System.out.println("Error: Dog name and breed are required.");
      return;
    }

    // Retrieve field values
    String name = dogNameField.getText();
    char gender ;
    if (dogMaleRadio.isSelected())
   {   gender='m';}
    else {  gender='F';}
    String comment = dogCommentArea.getText();
    String color = dogColorField.getText();
    int price;

    // Parse price, handling invalid input
    try
    {
      price = Integer.parseInt(dogPriceField.getText());
    }
    catch (NumberFormatException e)
    {
      System.out.println("Error: Invalid price entered.");
      return;
    }

    // Parse birth date
    MyDate birthDate = null;
    if (dogBirthDatePicker.getValue() != null)
    {
      birthDate = new MyDate(dogBirthDatePicker.getValue().getDayOfMonth(),
          dogBirthDatePicker.getValue().getMonthValue(),
          dogBirthDatePicker.getValue().getYear());
    }

    // Retrieve breed and breeder
    String breed = dogBreedField.getText();
    String breeder = dogBreederField.getText();

    // Create a new Dog object and set it into a petlist
    Dog newDog = new Dog(name, gender, comment, birthDate, color, price, breed,
        breeder);
    pets.addPet(newDog);

    // Log or store the dog (for now, just output to console)
    System.out.println("Dog added successfully: " + newDog);

    // Optionally, clear the form fields after adding
    clearDogForm();
  }

  // Helper method to clear the form fields after adding a dog
  private void clearDogForm()
  {
    dogNameField.clear();
    dogMaleRadio.setSelected(false);
    dogFemaleRadio.setSelected(false);
    dogBirthDatePicker.setValue(null);
    dogColorField.clear();
    dogPriceField.clear();
    dogBreedField.clear();
    dogBreederField.clear();
    dogCommentArea.clear();
  }

  @FXML private void handleAddCat()
  {
    // Validate mandatory fields
    if (catNameField.getText().isEmpty() || catBreedField.getText().isEmpty())
    {
      System.out.println("Error: Cat name and breed are required.");
      return;
    }

    // Retrieve field values
    String name = catNameField.getText();
    char gender = catMaleRadio.isSelected() ?
        'm' :
        catFemaleRadio.isSelected() ? 'F' : 'U'; // Default to 'U' for unknown
    String comment = catCommentArea.getText();
    String color = catColorField.getText();
    int price;

    // Parse price, handling invalid input
    try
    {
      price = Integer.parseInt(catPriceField.getText());
    }
    catch (NumberFormatException e)
    {
      System.out.println("Error: Invalid price entered.");
      return;
    }

    // Parse birth date
    MyDate birthDate = null;
    if (catBirthDatePicker.getValue() != null)
    {
      birthDate = new MyDate(catBirthDatePicker.getValue().getDayOfMonth(),
          catBirthDatePicker.getValue().getMonthValue(),
          catBirthDatePicker.getValue().getYear());
    }

    // Retrieve breed and breeder
    String breed = catBreedField.getText();
    String breeder = catBreederField.getText();

    // Create a new Cat object
    Cat newCat = new Cat(name, gender, comment, birthDate, color, price, breed,
        breeder);
    pets.addPet(newCat);

    // Log or store the cat (for now, just output to console)
    System.out.println("Cat added successfully: " + newCat);

    // Optionally, clear the form fields after adding
    clearCatForm();
  }

  // Helper method to clear the form fields after adding a cat
  private void clearCatForm()
  {
    catNameField.clear();
    catMaleRadio.setSelected(false);
    catFemaleRadio.setSelected(false);
    catBirthDatePicker.setValue(null);
    catColorField.clear();
    catPriceField.clear();
    catBreedField.clear();
    catBreederField.clear();
    catCommentArea.clear();
  }

  @FXML
  private void handleAddFish() {
    // Validate mandatory fields
    if (fishNameField.getText().isEmpty() || fishSpeciesField.getText().isEmpty()) {
      System.out.println("Error: Fish name and species are required.");
      return;
    }

    // Retrieve field values
    String name = fishNameField.getText();
    char gender = fishMaleRadio.isSelected() ? 'm' : fishFemaleRadio.isSelected() ? 'F' : 'U';
    String comment = fishCommentArea.getText();
    String color = fishColorField.getText();
    int price;

    try {
      price = Integer.parseInt(fishPriceField.getText());
    } catch (NumberFormatException e) {
      System.out.println("Error: Invalid price entered.");
      return;
    }

    MyDate birthDate = null;
    if (fishBirthDatePicker.getValue() != null) {
      birthDate = new MyDate(fishBirthDatePicker.getValue().getDayOfMonth(),
          fishBirthDatePicker.getValue().getMonthValue(),
          fishBirthDatePicker.getValue().getYear());
    }
    String species = fishSpeciesField.getText();
    boolean isFreshWater = fishFreshWaterRadio.isSelected();
    boolean isPredetor= fishPredetor.isSelected();


    Fish newFish = new Fish(name, gender, comment, birthDate, color, price, isFreshWater,isPredetor);
    pets.addPet(newFish);
    System.out.println("Fish added successfully: " + newFish);

    clearFishForm();
  }

  private void clearFishForm() {
    fishNameField.clear();
    fishMaleRadio.setSelected(false);
    fishFemaleRadio.setSelected(false);
    fishBirthDatePicker.setValue(null);
    fishColorField.clear();
    fishPriceField.clear();
    fishSpeciesField.clear();
    fishFreshWaterRadio.setSelected(false);
    fishSaltWaterRadio.setSelected(false);
    fishCommentArea.clear();
    fishPredetor.setSelected(false);
    fishNotPredetor.setSelected(false);
  }
  @FXML
  private void handleAddRodent() {
    // Validate mandatory fields
    if (rodentNameField.getText().isEmpty() || rodentSpeciesField.getText().isEmpty()) {
      System.out.println("Error: Rodent name and species are required.");
      return;
    }

    // Retrieve field values
    String name = rodentNameField.getText();
    char gender = rodentMaleRadio.isSelected() ? 'm' : rodentFemaleRadio.isSelected() ? 'F' : 'U';
    boolean doesItBite;
    if (rodentIsBite.isSelected())
      doesItBite=true;
    else doesItBite=false;

    String comment = rodentCommentArea.getText();
    String color = rodentColorField.getText();
    int price;

    try {
      price = Integer.parseInt(rodentPriceField.getText());
    } catch (NumberFormatException e) {
      System.out.println("Error: Invalid price entered.");
      return;
    }

    MyDate birthDate = null;
    if (rodentBirthDatePicker.getValue() != null) {
      birthDate = new MyDate(rodentBirthDatePicker.getValue().getDayOfMonth(),
          rodentBirthDatePicker.getValue().getMonthValue(),
          rodentBirthDatePicker.getValue().getYear());
    }
    String species = rodentSpeciesField.getText();
    Rodents newRodent = new Rodents(name, gender, comment, birthDate, color, price, species);
    newRodent.setBiteBehaviour(doesItBite);
pets.addPet(newRodent);
    System.out.println("Rodent added successfully: " + newRodent);

    clearRodentForm();
  }

  private void clearRodentForm() {
    rodentNameField.clear();
    rodentMaleRadio.setSelected(false);
    rodentFemaleRadio.setSelected(false);
    rodentBirthDatePicker.setValue(null);
    rodentColorField.clear();
    rodentPriceField.clear();
    rodentSpeciesField.clear();
    rodentCommentArea.clear();
    rodentIsBite.setSelected(false);
    rodentIsNotBite.setSelected(false);
  }

  @FXML
  private void handleAddBird() {
    // Validate mandatory fields
    if (birdNameField.getText().isEmpty() || birdSpeciesField.getText().isEmpty()) {
      System.out.println("Error: Bird name and species are required.");
      return;
    }

    // Retrieve field values
    String name = birdNameField.getText();
    char gender = birdMaleRadio.isSelected() ? 'm' : birdFemaleRadio.isSelected() ? 'F' : 'U';
    String comment = birdCommentArea.getText();
    String color = birdColorField.getText();
    String food = birdFoodField.getText();

    int price;

    try {
      price = Integer.parseInt(birdPriceField.getText());
    } catch (NumberFormatException e) {
      System.out.println("Error: Invalid price entered.");
      return;
    }

    MyDate birthDate = null;
    if (birdBirthDatePicker.getValue() != null) {
      birthDate = new MyDate(birdBirthDatePicker.getValue().getDayOfMonth(),
          birdBirthDatePicker.getValue().getMonthValue(),
          birdBirthDatePicker.getValue().getYear());
    }
    String species = birdSpeciesField.getText();

    Bird newBird = new Bird(name, gender, comment, birthDate, color, price, species, food);
    pets.addPet(newBird);
    System.out.println("Rodent added successfully: " + newBird);

    clearBirdForm();
  }

  private void clearBirdForm() {
    birdNameField.clear();
    birdMaleRadio.setSelected(false);
    birdFemaleRadio.setSelected(false);
    birdBirthDatePicker.setValue(null);
    birdColorField.clear();
    birdPriceField.clear();
    birdSpeciesField.clear();
    birdCommentArea.clear();
    birdFoodField.clear();
  }
  @FXML
  private void handleAddVarious() {
    // Validate mandatory fields
    if (variousNameField.getText().isEmpty() || variousSpeciesField.getText().isEmpty()) {
      System.out.println("Error: Various name and species are required.");
      return;
    }

    // Retrieve field values
    String name = variousNameField.getText();
    char gender = variousMaleRadio.isSelected() ? 'm' : variousFemaleRadio.isSelected() ? 'F' : 'U';
    String comment = variousCommentArea.getText();
    String color = variousColorField.getText();

    int price;

    try {
      price = Integer.parseInt(variousPriceField.getText());
    } catch (NumberFormatException e) {
      System.out.println("Error: Invalid price entered.");
      return;
    }

    MyDate birthDate = null;
    if (variousBirthDatePicker.getValue() != null) {
      birthDate = new MyDate(variousBirthDatePicker.getValue().getDayOfMonth(),
          variousBirthDatePicker.getValue().getMonthValue(),
          variousBirthDatePicker.getValue().getYear());
    }
    String species = variousSpeciesField.getText();

    Various newVarious = new Various(name, gender, comment, birthDate, color, price, species);
      pets.addPet(newVarious);
    System.out.println("Various successfully: " + newVarious);

    clearVariousForm();
  }

  private void clearVariousForm() {
    variousNameField.clear();
    variousMaleRadio.setSelected(false);
    variousFemaleRadio.setSelected(false);
    variousBirthDatePicker.setValue(null);
    variousColorField.clear();
    variousPriceField.clear();
    variousSpeciesField.clear();
    variousCommentArea.clear();
  }



}
