import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Journey {
    private CityRideDataset.TimeBand journeyTime;
    private LocalDate journeyDate;
    private int startZone;
    private int endZone;
    private CityRideDataset.PassengerType passenger;
    private BigDecimal baseFare;
    private BigDecimal discountFare;
    private BigDecimal finalFare;
    private String journeyID;
    private BigDecimal total;

    public Journey(Scanner scanner){
        journeyTime = chooseTime(scanner, "Please choose timeband");
        journeyDate =LocalDate.now();
        startZone = chooseZone(scanner, "Please choose starting zone");
        endZone = chooseZone(scanner, "Please choose destination zone");
        passenger = choosePassenger(scanner, "Please choose passenger type");
        baseFare= CityRideDataset.getBaseFare(startZone,endZone,journeyTime);//Base fare will be calculated once dataset is made available
        discountFare=discount();
        finalFare=finalFare();
        journeyID = UUID.randomUUID().toString();

    }

    public CityRideDataset.TimeBand chooseTime(Scanner scanner, String message) {
        boolean valid = false;
        int choice;
        CityRideDataset.TimeBand timeBand= CityRideDataset.TimeBand.PEAK;
        System.out.println(message);
        System.out.println("Enter 1 for Peak-time travel");
        System.out.println("Enter 2 for Off-peak travel");
        System.out.println("Choice: ");
        while (valid == false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        timeBand = CityRideDataset.TimeBand.PEAK;
                        valid = true;
                        break;
                    case 2:
                        timeBand = CityRideDataset.TimeBand.OFF_PEAK;
                        valid = true;
                        break;

                    default:
                        System.out.println("Invalid choice, please try again");
                        break;

                }
            }
            catch(Exception e){
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
        return timeBand;
    }
    public int chooseZone(Scanner scanner, String message){
        boolean valid=false;
        int choice=0;
        System.out.println(message);
        System.out.println("Enter 1 for Central Zone");
        System.out.println("Enter 2 for Inner Zone");
        System.out.println("Enter 3 for Suburban Zone");
        System.out.println("Enter 4 for Outer Zone");
        System.out.println("Enter 5 for Rural Zone");
        System.out.println("Choice: ");
        while (valid==false) {


            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= CityRideDataset.MIN_ZONE && choice <= CityRideDataset.MAX_ZONE) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice, please try again");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
            }
            catch (Exception e){
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
        return choice;
    }
    public CityRideDataset.PassengerType choosePassenger(Scanner scanner, String message){
        boolean valid=false;
        int choice;
        CityRideDataset.PassengerType passenger = CityRideDataset.PassengerType.ADULT;
        System.out.println(message);
        System.out.println("Enter 1 for Adult passenger");
        System.out.println("Enter 2 for Student passenger");
        System.out.println("Enter 3 for Child passenger");
        System.out.println("Enter 4 for Senior passenger");
        System.out.println("Choice: ");
        while (valid==false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        passenger = CityRideDataset.PassengerType.ADULT;
                        valid = true;
                        break;
                    case 2:
                        passenger = CityRideDataset.PassengerType.STUDENT;
                        valid = true;
                        break;
                    case 3:
                        passenger = CityRideDataset.PassengerType.CHILD;
                        valid = true;
                        break;
                    case 4:
                        passenger = CityRideDataset.PassengerType.SENIOR_CITIZEN;
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        scanner.nextLine();

                }
            }
            catch (Exception e){
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
        return passenger;
    }
    public BigDecimal discount(){
        BigDecimal discountfare;
        discountfare=(baseFare.subtract(CityRideDataset.DISCOUNT_RATE.get(passenger).multiply(baseFare))).setScale(2, RoundingMode.HALF_UP);
        return discountfare;

    }
    public BigDecimal finalFare() {
        if (((discountFare.add(JourneyList.PASSENGER_TOTAL.get(getPassenger()))).compareTo(CityRideDataset.DAILY_CAP.get(getPassenger()))) >= 0) {
            finalFare = (CityRideDataset.DAILY_CAP.get(getPassenger())).subtract(JourneyList.PASSENGER_TOTAL.get(getPassenger()));
        }
        else{
            finalFare=discountFare;
        }
        JourneyList.PASSENGER_TOTAL.put(passenger, JourneyList.PASSENGER_TOTAL.get(passenger).add(finalFare));
        return finalFare;

    }


    public CityRideDataset.TimeBand getJourneyTime(){
        return journeyTime;

    }
    public LocalDate getJourneyDate(){
        return journeyDate;

    }
    public int getStartZone(){
        return startZone;

    } public int getEndZone(){
        return endZone;

    }
    public CityRideDataset.PassengerType getPassenger(){
        return passenger;

    }
    public BigDecimal getBaseFare(){
        return baseFare;

    }
    public BigDecimal getDiscountFare(){
        return discountFare;

    }
    public BigDecimal getFinalFare(){
        return finalFare;

    }
    public String getJourneyID(){
        return journeyID;

    }

    public void setJourneyTime(Scanner scanner){
        this.journeyTime = chooseTime(scanner, "Please choose travel time" );

    }
    public void setJourneyDate(){
        this.journeyDate =LocalDate.now();
    }
    public void setStartZone(Scanner scanner){
        this.startZone =chooseZone(scanner,"Please choose starting zone" );
    }
    public void setEndZone(Scanner scanner){
        this.endZone =chooseZone(scanner,"Please choose starting zone");
    }
    public void setPassenger(Scanner scanner){
        this.passenger =choosePassenger(scanner, "Please choose passenger type");
    }
    public void setBaseFare(){
        this.baseFare = CityRideDataset.getBaseFare(startZone, endZone, journeyTime);
    }

    public void setDiscountFare(){
        this.discountFare = discount();
    }
    public void setFinalFare(){
        this.finalFare = finalFare();
    }

    public void displayDetails(){
        System.out.println("[" + journeyDate + "] Time: "+ journeyTime + "| Starting Zone: " + startZone + "| Destination Zone: " + endZone + "| Zones Crossed: " + (Math.abs(endZone - startZone) + 1) + "| Passenger Type: " + passenger + " | Base Fare: £" + baseFare + "| Discount Applied: "+ CityRideDataset.DISCOUNT_RATE.get(passenger).movePointRight(2).setScale(0, RoundingMode.HALF_UP) + "% | Discounted Fare: £" + discountFare + "| Final Fare: £" + finalFare + "| Journey ID: " + journeyID);

    }
}
