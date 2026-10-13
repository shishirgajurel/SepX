# Pet Shop & Kennel Management — JavaFX (SEP1, Group 6)

A desktop application for a pet shop that also runs a kennel, built as the **1st-semester project (SEP1)** at VIA University College by a team of students.

Staff can register customers, keep track of pets for sale, book kennel stays and record sales — all from one JavaFX interface.

## Features
- **Customers**: add, edit and search customers (including search by phone number)
- **Pets for sale**: dogs, cats, birds, fish, rodents and other animals, each with its own details
- **Kennel reservations**: book a stay for a customer's pet with a date picker, and search reservations
- **Sales**: sell a pet to a customer and keep a sales log
- **Saved data**: customers, pets, reservations and sales are stored in binary files so they survive restarts; the pet list is also exported to XML

## How it's built
- **Object-oriented model**: an abstract `Pet` class with subclasses (`Dog`, `Cat`, `Bird`, `Fish`, `Rodents`, `Various`)
- **Model managers** (`CustomerModelManager`, `PetModelManager`, `ReservationModelManager`, `SaleModelManager`) separate the logic from the GUI
- **JavaFX + FXML** views with one controller per screen
- **File handling** (`MyFileHandler`) for binary and text files

```
src/
├── Gui/      FXML views and controllers (customers, pets, reservations, sales)
├── Model/    Domain classes and model managers
├── main/     Application entry point
└── utils/    File reading/writing
```

## Run it
Requires **Java 17+** and **JavaFX**. Open the project in IntelliJ IDEA, add the JavaFX SDK as a library, and run `main.MainApp`.

## Tech
Java · JavaFX · FXML · OOP · file persistence · XML
