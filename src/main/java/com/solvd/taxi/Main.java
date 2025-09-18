/*
Taxi
By Santiago Herrera
 */

package com.solvd.taxi;

import com.solvd.taxi.fileReader.WordCounter;
import com.solvd.taxi.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {


    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String Util task
        readFile(scanner);

        TaxiCompany company1 = new TaxiCompany("Bogota", "People", LocalDate.of(2010, 8, 11), "EasyTaxi");
        TaxiCompany company2 = new TaxiCompany("Monaco", "Meals", LocalDate.of(2021, 12, 11), "EasyMeals");
        TaxiCompany company3 = new TaxiCompany("Paris", "People", LocalDate.of(2023, 9, 11), "SuperDrive");
        TaxiCompany company4 = new TaxiCompany("London", "Pets", LocalDate.of(2011, 1, 11), "HappyDogs");
        TaxiCompany company5 = new TaxiCompany("Miami", "Commodities", LocalDate.of(2011, 8, 11), "EasyGoing");

        Map<String, TaxiCompany> companiesMap = new HashMap<>();
        companiesMap.put(company1.getName(), company1);
        companiesMap.put(company2.getName(), company2);
        companiesMap.put(company3.getName(), company3);
        companiesMap.put(company4.getName(), company4);
        companiesMap.put(company5.getName(), company5);

        Vehicle car1 = new Car("Toyota", "Red", 2020, 4, 45);
        Vehicle car2 = new Car("Sprint", "Gray", 2010, 4, 29);
        Vehicle car3 = new Car("Corsa", "Black", 2010, 4, 45);
        Vehicle car4 = new Car("Veloster", "Blue", 2011, 4, 33);
        Vehicle car5 = new Car("BMW", "Red", 2020, 4, 60);
        Vehicle car6 = new Car("Toyota", "Yellow", 2020, 4, 45);
        Vehicle car7 = new Car("Sprint", "White", 2010, 4, 35);
        Vehicle car8 = new Car("Clio", "Gray", 2010, 4, 45);
        Vehicle car9 = new Car("Sportage", "Gray", 2011, 4, 33);
        Vehicle car10 = new Car("BMW", "Green", 2020, 3, 60);

        Set<Vehicle> uniqueVehicles = new HashSet<>();
        uniqueVehicles.add(car1);
        uniqueVehicles.add(car2);
        uniqueVehicles.add(car3);
        uniqueVehicles.add(car4);
        uniqueVehicles.add(car5);
        uniqueVehicles.add(car6);
        uniqueVehicles.add(car7);
        uniqueVehicles.add(car8);
        uniqueVehicles.add(car9);
        uniqueVehicles.add(car10);

        try {
            Driver driver1 = new Driver("Carlos", "001", LocalDate.of(1980, 1, 11), 67, 175, true, true, car1, new Location(25, 65), false);
            Driver driver2 = new Driver("Felipe", "002", LocalDate.of(1990, 4, 22), 100, 160, true, true, car2, new Location(90, 100), false);
            Driver driver3 = new Driver("Richard", "003", LocalDate.of(1989, 2, 21), 90, 180, true, false, car3, new Location(10, 0), false);
            Driver driver4 = new Driver("Joe", "004", LocalDate.of(1999, 12, 12), 78, 170, true, true, car4, new Location(-25, -150), false);
            Driver driver5 = new Driver("John", "005", LocalDate.of(2001, 11, 15), 80, 177, true, true, car5, new Location(30, 50), false);
            Driver driver6 = new Driver("James", "006", LocalDate.of(1980, 1, 11), 67, 175, true, true, car6, new Location(25, 25), false);
            Driver driver7 = new Driver("Andrew", "007", LocalDate.of(1990, 4, 22), 100, 160, true, true, car7, new Location(-90, 20), false);
            Driver driver8 = new Driver("Ryan", "008", LocalDate.of(1989, 2, 21), 90, 180, true, true, car8, new Location(20, 60), false);
            Driver driver9 = new Driver("Joel", "009", LocalDate.of(1999, 12, 12), 78, 170, true, true, car9, new Location(30, 80), false);
            Driver driver10 = new Driver("Ross", "010", LocalDate.of(2001, 11, 15), 80, 177, true, false, car10, new Location(50, 120), false);

            company1.setDrivers(new ArrayList<>(Arrays.asList(driver1, driver3, driver4, driver5)));
            company2.setDrivers(new ArrayList<>(Arrays.asList(driver2, driver6)));
            company3.setDrivers(new ArrayList<>(Arrays.asList(driver7, driver8)));
            company4.setDrivers(new ArrayList<>(Arrays.asList(driver9)));
            company5.setDrivers(new ArrayList<>(Arrays.asList(driver10)));

        }catch (InvalidLocationException e){
            LOGGER.error("Error: "+ e.getMessage(),e);
        }

        ArrayList<Driver> allDrivers = new ArrayList<>();
        allDrivers.addAll(company1.getDrivers());
        allDrivers.addAll(company2.getDrivers());
        allDrivers.addAll(company3.getDrivers());
        allDrivers.addAll(company4.getDrivers());
        allDrivers.addAll(company5.getDrivers());

        LOGGER.info("Welcome to TaxiApp!");
        LOGGER.info("Please enter your name: ");
        String passengerName = scanner.nextLine();

        LOGGER.info("Enter your ID number: ");
        String passengerId = scanner.nextLine();

        LOGGER.info("Preferred payment method (Cash, Card, Crypto): ");
        String inputMethod = scanner.nextLine().trim().toUpperCase();

        PaymentMethod paymentMethod;
        try {
            paymentMethod = PaymentMethod.valueOf(inputMethod);
        } catch (IllegalArgumentException e) {
            LOGGER.info("Invalid payment method. Cash will be use by default.");
            paymentMethod = PaymentMethod.CASH;
        }
        Passenger passenger = new Passenger(passengerName, passengerId, paymentMethod);

        LOGGER.info("Where do you want to go? (latitude,longitude) Example: 42,11");
        String destinationInput = scanner.nextLine();

        LOGGER.info("Where are you right now? (latitude,longitude) Example: 13,33");
        String originInput = scanner.nextLine();


        Location origin = null;
        Location destination = null;
        String[] destCoords = destinationInput.split(",");
        String[] origCoords = originInput.split(",");
        try {
            destination = new Location(
                    Float.parseFloat(destCoords[0].trim()),
                    Float.parseFloat(destCoords[1].trim())
            );

            origin = new Location(
                    Float.parseFloat(origCoords[0].trim()),
                    Float.parseFloat(origCoords[1].trim())
            );
        } catch (InvalidLocationException customException) {
            LOGGER.error("Error: " + customException.getMessage(), customException);
        }

        Ride ride1 = null;
        Booking<Ride> booking1 = null;
        double fare = 0.0;
        LinkedList<Booking> bookingHistory = new LinkedList<>();
        PriorityQueue<Passenger> waitingPassengers = new PriorityQueue<>(Comparator.comparing(Passenger::getName));

        //Select the closest driver
        try {
            DriverAssigner<Driver> assigner = new DriverAssigner<>();
            Driver rideDriver = assigner.findClosestAvailableDriver(origin, allDrivers);
            TransportVerification verification = new TransportVerification();
            verification.runVerification(rideDriver);
            ride1 = new Ride(passenger, rideDriver, origin, destination, "001", "Pick 1 person",1);
            booking1 = new Booking<>(LocalDateTime.now(), ride1);
            bookingHistory.add(booking1);
            FareCalculator calculator = new StandarFareCalculator(50.00, 3.00);
            fare = calculator.calculateFare(ride1);
            LOGGER.info("Driver is near.");

        } catch (NoAvailableDriverException | VerificationFailedException | FareCalculatorException  | OverCapacityException customException) {
            LOGGER.error("Error: " + customException.getMessage(), customException);
        }


        LOGGER.info("============================ Ride Summary ============================");
        LOGGER.info("Passenger: " + ride1.getPassenger().getName());
        LOGGER.info("Passenger ID: " + ride1.getPassenger().getId());
        LOGGER.info("Payment method: " + paymentMethod);
        LOGGER.info("Driver: " + ride1.getDriver().getName() + " from Company: " + ride1.getDriver().getCompany().getName());
        LOGGER.info("Information: " + ride1.getDriver().getVehicle().toString());
        LOGGER.info("Estimated waiting time: " + ride1.getWaitingTime() + " minutes");
        LOGGER.info("Estimated ride distance: " + ride1.getDistance() + " units");
        LOGGER.info("Estimated ride duration: " + ride1.getDuration() + " minutes");
        LOGGER.info("Fare: $" + fare);
        LOGGER.info("Press 1 to confirm the ride. 2 to cancel it.");
        int confirm = scanner.nextInt();

        boolean isPaid = false;
        switch (confirm) {
            case 1:
                Payment<? extends Payable> payment1 = null;
                waitingPassengers.add(passenger);
                scanner.nextLine();
                switch (paymentMethod) {
                    case CARD:
                        LOGGER.info("Please enter your credit card number: ");
                        String creditCardNumber = scanner.nextLine();
                       payment1 = new CreditCardPayment(fare);
                        isPaid = payment1.processPayment();
                        break;

                    case CASH:
                      payment1 = new CashPayment(fare);
                        isPaid = payment1.processPayment();
                        break;

                    case CRYPTO:
                        LOGGER.info("Please enter your wallet address: ");
                        String walletAddress = scanner.nextLine();
                        LOGGER.info("Please enter your crypto type: (BTC / ETH)");
                        String cryptoType = scanner.nextLine();
                        payment1 = new CryptoPayment(fare, walletAddress, cryptoType);
                        isPaid = payment1.processPayment();
                        break;

                    default:
                        LOGGER.error("Unsupported payment method: " + paymentMethod);
                }

                ride1.getDriver().setAvailable(false);
                booking1.confirm();
                break;

            case 2:
                LOGGER.info("Ride is canceled. See you next time.");
                booking1.cancel();
                break;
            default:
                LOGGER.info("No answer was received.");
        }

        if (isPaid) {
            LOGGER.info("============================ Ride Completed ============================");
            LOGGER.info("Please rate your ride (1 to 5): ");
            float rating = Float.parseFloat(scanner.nextLine());

            LOGGER.info("Leave a comment: ");
            String comment = scanner.nextLine();

            Review review = new Review(ride1, rating, comment);

            LOGGER.info("You rated " + review.getRating() + " stars with comment: \"" + review.getComment() + "\"");
            LOGGER.info("Thank you for your feedback. See you soon!");
            ride1.getDriver().setAvailable(true);
        }
        scanner.close();
    }
    public static void readFile(Scanner scanner)  {
        LOGGER.info(" Please write the word you want to count in the input article.");
        String word = scanner.nextLine();
        try{
            WordCounter.countWords(word);
            LOGGER.info("Word count updated in target/output.txt");
        } catch (IOException e) {
            LOGGER.info("Input file failed to open. "+ e.getMessage());
        }
    }

}


