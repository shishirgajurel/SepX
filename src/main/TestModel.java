package main;

import Model.*;
import parser.ParserException;
import utils.*;

public class TestModel
{
  public static void main(String[] args) throws ParserException
  {
    Cat cat0 = new Cat("Lea", 'f', "She ate a cup cake", new MyDate(4,4,1997), "White" ,new Customer("Ahmad", "1234567890", "asd@asd.asd"), "a good breed", "My mother");
    Cat cat1 = new Cat("Milo", 'm', "Loves to play", new MyDate(1,1,2018), "Black", new Customer("khaled", "1234567891", "john.doe@example.com"), "Persian", "John's family");
    Cat cat2 = new Cat("Bella", 'f', "Very affectionate", new MyDate(2,2,2019), "White", new Customer("Youssef", "1234567892", "jane.doe@example.com"), "Siamese", "Jane's family");
    Cat cat3 = new Cat("Oliver", 'm', "Curious and playful", new MyDate(3,3,2020), "Orange", new Customer("Thea", "1234567893", "alice.smith@example.com"), "Maine Coon", "Alice's family");
    Cat cat4 = new Cat("Luna", 'f', "Loves to climb", new MyDate(4,4,2021), "Gray", new Customer("Jack", "1234567894", "bob.johnson@example.com"), "Russian Blue", "Bob's family");
    Cat cat5 = new Cat("Charlie", 'm', "Very vocal", new MyDate(5,5,2022), "Brown", new Customer("Amir", "1234567895", "carol.williams@example.com"), "Bengal", "Carol's family");
    Cat cat6 = new Cat("Lucy", 'f', "Loves to nap", new MyDate(6,6,2023), "Calico", new Customer("Mahmood", "1234567896", "dave.brown@example.com"), "Ragdoll", "Dave's family");
    Cat cat7 = new Cat("Leo", 'm', "Very friendly", new MyDate(7,7,2024), "Golden", new Customer("Samir", "1234567897", "eve.davis@example.com"), "British Shorthair", "Eve's family");
    Cat cat8 = new Cat("Nala", 'f', "Loves to hunt", new MyDate(8,8,2025), "Black and White", new Customer("Sally", "1234567898", "frank.miller@example.com"), "Sphynx", "Frank's family");
    Cat cat9 = new Cat("Simba", 'm', "Very playful", new MyDate(9,9,2026), "Tabby", new Customer("Kinan", "1234567899", "grace.wilson@example.com"), "Abyssinian", "Grace's family");
    Cat cat10 = new Cat("Chloe", 'f', "Loves to cuddle", new MyDate(10,10,2027), "Tortoiseshell", new Customer("Salem", "1234567800", "hank.moore@example.com"), "Scottish Fold", "Hank's family");


    PetList petList = new PetList();
    petList.addPet(cat0);
    petList.addPet(cat1);
    petList.addPet(cat2);
    petList.addPet(cat3);
    petList.addPet(cat4);
    petList.addPet(cat5);
    petList.addPet(cat6);
    petList.addPet(cat7);
    petList.addPet(cat8);
    petList.addPet(cat9);
    petList.addPet(cat10);

    Bird bird0 = new Bird("Kiwi", 'm', "Very friendly", new MyDate(4,4,1997), "Green", 100, "Parrot", "Seeds");
    Sale sale0 = new Sale(new MyDate(4,4,1997), bird0, new Customer("Ahmad", "1234567890", "asd@asd.asd"));

    SalesLog salesLog = new SalesLog();
    salesLog.addSale(sale0);

    //    System.out.println(salesLog);
    Reservation reservation1 = new Reservation(cat1, new MyDate(6, 12, 2024), new MyDate(13, 1, 2025));
    Reservation reservation2 = new Reservation(cat2, new MyDate(8, 12, 2024), new MyDate(10, 12, 2024));
    Reservation reservation3 = new Reservation(cat3, new MyDate(11, 12, 2024), new MyDate(24, 12, 2024));
    Reservation reservation4 = new Reservation(cat4, new MyDate(25, 12, 2024), new MyDate(28, 12, 2024));
    Reservation reservation5 = new Reservation(cat5, new MyDate(6, 12, 2024), new MyDate(7, 12, 2024));
    Reservation reservation6 = new Reservation(cat6, new MyDate(7, 12, 2024), new MyDate(8, 12, 2024));
    Reservation reservation7 = new Reservation(cat7, new MyDate(6, 12, 2024), new MyDate(7, 12, 2024));
    Reservation reservation8 = new Reservation(cat8, new MyDate(6, 12, 2024), new MyDate(8, 12, 2024));
    Reservation reservation9 = new Reservation(cat9, new MyDate(6, 12, 2024), new MyDate(8, 12, 2024));
    //    Reservation reservation10 = new Reservation(cat10, new MyDate(6, 12, 2024), new MyDate(8, 12, 2024));
    //   Reservation reservation11 = new Reservation(cat0, new MyDate(1, 1, 2025), new MyDate(12, 1, 2025));
    //   Reservation reservation12 = new Reservation(cat0, new MyDate(6, 12, 2024), new MyDate(11, 12, 2024));
    //    Reservation reservation13 = new Reservation(cat0, new MyDate(6, 12, 2024), new MyDate(11, 12, 2024));
    //    Reservation reservation14 = new Reservation(cat0, new MyDate(6, 12, 2024), new MyDate(11, 12, 2024));
    //    Reservation reservation15 = new Reservation(cat0, new MyDate(6, 12, 2024), new MyDate(11, 12, 2024));
    //    Reservation reservation16 = new Reservation(cat0, new MyDate(6, 12, 2024), new MyDate(11, 12, 2024));


    ReservationList reservationList = new ReservationList();
    reservationList.addReservation(reservation1);
    reservationList.addReservation(reservation2);
    reservationList.addReservation(reservation3);
    reservationList.addReservation(reservation4);
    reservationList.addReservation(reservation5);
    reservationList.addReservation(reservation6);
    reservationList.addReservation(reservation7);
    reservationList.addReservation(reservation8);
    reservationList.addReservation(reservation9);
    //    reservationList.addReservation(reservation10);
    //    reservationList.addReservation(reservation11);

    //    reservation11.setStartDate(new MyDate(5, 12, 2024), reservationList);
    //    System.out.println(reservationList.getOverlappingReservationsCount(reservation3));

     ReservationModelManager reservationModelManager = new ReservationModelManager("reservations.bin");
      reservationModelManager.saveReservations(reservationList);
      reservationModelManager.saveToXML(reservationList, "reservations.xml");

    //PetModelManager petModelManager = new PetModelManager("pets.bin");
   // petModelManager.savePets(petList);
   // petModelManager.saveToXML(petList, "pets.xml");
  }
}