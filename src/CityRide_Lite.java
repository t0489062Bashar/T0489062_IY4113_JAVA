import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.util.UUID;


class Journey {
    private LocalTime journeyTime;
    private LocalDate journeyDate;
    private String startZone;
    private String endZone;
    private String passenger;
    private double baseFare;
    private double discountFare;
    private String journeyID;
    private double total;

    public Journey(Scanner scanner){
        journeyTime = LocalTime.now();
        journeyDate =LocalDate.now();
        startZone = chooseZone(scanner, "Please choose starting zone");
        endZone = chooseZone(scanner, "Please choose destination zone");
        passenger = choosePassenger(scanner, "Please choose passenger type");
        baseFare =8.0;//Base fare will be calculated once dataset is made available
        discountFare=discount();
        journeyID = UUID.randomUUID().toString();

    }

    public String chooseZone(Scanner scanner, String message){
        boolean valid=false;
        int choice=0;
        String zone="";
        System.out.println(message);
        System.out.println("Enter 1 for Central Zone");
        System.out.println("Enter 2 for Inner Zone");
        System.out.println("Enter 3 for Suburban Zone");
        System.out.println("Enter 4 for Outer Zone");
        System.out.println("Enter 5 for Rural Zone");
        System.out.println("Choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        while (valid==false) {
            switch (choice) {
                case 1:
                    zone = "Central Zone";
                    valid = true;
                    break;
                case 2:
                    zone = "Inner Zone";
                    valid = true;
                    break;
                case 3:
                    zone = "Suburban Zone";
                    valid=true;
                    break;
                case 4:
                    zone = "Outer Zone";
                    valid=true;
                    break;

                case 5:
                    zone = "Rural Zone";
                    valid=true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    break;
            }
        }
        return zone;
    }
    public String choosePassenger(Scanner scanner, String message){
        boolean valid=false;
        int choice;
        String passenger="";
        System.out.println(message);
        System.out.println("Enter 1 for Adult passenger");
        System.out.println("Enter 2 for Student passenger");
        System.out.println("Enter 3 for Child passenger");
        System.out.println("Enter 4 for Senior passenger");
        System.out.println("Choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        while (valid==false) {
            switch (choice) {
                case 1:
                    passenger = "Adult";
                    valid = true;
                    break;
                case 2:
                    passenger = "Student";
                    valid = true;
                    break;
                case 3:
                    passenger = "Child";
                    valid=true;
                    break;
                case 4:
                    passenger = "Senior";
                    valid=true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    choice = scanner.nextInt();
                    scanner.nextLine();

            }
        }
        return passenger;
    }
    public double discount(){
        double newfare;
        if (passenger =="Senior"){
            newfare =baseFare-(baseFare*0.30);


        }
        else if (passenger =="Child"){
            newfare =baseFare-(baseFare*0.50);


        }
        else if (passenger =="Student"){
            newfare =baseFare-(baseFare*0.30);


        }
        else{
            newfare= baseFare;
        }
        return newfare;

    }




    public LocalTime getJourneyTime(){
        return journeyTime;

    }
    public LocalDate getJourneyDate(){
        return journeyDate;

    }
    public String getStartZone(){
        return startZone;

    } public String getEndZone(){
        return endZone;

    }
    public String getPassenger(){
        return passenger;

    }
    public double getBaseFare(){
        return baseFare;

    }
    public double getDiscountFare(){
        return discountFare;

    }
    public String getJourneyID(){
        return journeyID;

    }

    public void setJourneyTime(){
        this.journeyTime = LocalTime.now();

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
    public void setBaseFare(double baseFare){
        this.baseFare = baseFare;
    }

    public void setDiscountFare(){
        this.discountFare = discount();
    }

    public void displayDetails(){
        System.out.println("[" + journeyDate + "] Time: "+ journeyTime + "| Starting Zone: " + startZone + "| Destination Zone: " + endZone + "| Passenger Type: " + passenger + " | Base Price: £" + baseFare + "| Discounted Fare: £" + discountFare + "| Journey ID: " + journeyID);

    }
}
class journeyList {

    private List<Journey> journeyList = new ArrayList<>();
    private double childTotal=0;
    private double seniorTotal=0;
    private double studentTotal=0;
    private double adultTotal=0;


    public void addJourney(Journey c){
        journeyList.add(c);
        System.out.println("Journey with ID: " + c.getJourneyID() + " has been added.");
        if (c.getPassenger()=="Senior"){
            seniorTotal+=c.getDiscountFare();
        }
        else if (c.getPassenger()=="Child"){
            childTotal+=c.getDiscountFare();
        }
        else if (c.getPassenger()=="Student"){
            studentTotal+=c.getDiscountFare();
        }
        else{
            adultTotal+=c.getDiscountFare();
        }
    }
    public Journey findJourneyByID(String ID){
        for(Journey c : journeyList){
            if(c.getJourneyID().equalsIgnoreCase(ID)){
                return c;
            }
        }
        return null;
    }

    public String deleteJourneyByID(Scanner scanner){
        String ID;
        System.out.println("Please input ID to delete: ");
        ID=scanner.nextLine();
        for(Journey c : journeyList){
            if(c.getJourneyID().equalsIgnoreCase(ID)){
                journeyList.remove(c);
                return "Journey with ID "+ ID +"has been deleted.";
            }

        }
        return "Journey not found";
    }

    public void showAllJourney(){
        if (journeyList.isEmpty()) {
            System.out.println("Journey list is empty.");
        }
        else{
            for(Journey c : journeyList) {
                c.displayDetails();
            }
        }
    }
    public void countTotal(){


    }
}



public class CityRide_Lite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        journeyList journeyList = new journeyList();
        int choice;

        do {
            System.out.println("\n CityRide Lite");
            System.out.println("1. Add Journey");
            System.out.println("2. View All Journeys");
            System.out.println("3. Update Journey Details");
            System.out.println("4. Delete Journey");
            System.out.println("5. Exit");
            System.out.println("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    journeyList.addJourney(new Journey(scanner));
                    break;
                case 2:
                    journeyList.showAllJourney();
                    break;
                case 3:
                    System.out.println("Enter ID to update: ");
                    String searchID = scanner.nextLine();
                    Journey foundjourney = journeyList.findJourneyByID(searchID);

                    if (foundjourney != null) {
                        System.out.println("4. Enter new base fare: ");
                        double newPrice = scanner.nextDouble();
                        foundjourney.setBaseFare(newPrice);
                        foundjourney.setDiscountFare();
                        System.out.println("Price updated successfully");
                    } else {
                        System.out.println("Journey not found");
                    }
                    break;

                case 4:
                    System.out.println(journeyList.deleteJourneyByID(scanner));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;
            }
        }
        while (choice != 5);
        scanner.close();

    }

}
