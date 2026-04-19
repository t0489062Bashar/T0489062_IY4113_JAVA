import java.util.Scanner;
import java.util.UUID;

public class Rider {
    private String name;
    private String riderID;
    private CityRideDataset.PassengerType passenger;
    private CityRideDataset.PaymentMethod paymentMethod;
    public Rider() {
    }

    public Rider(Scanner scanner,String name) {
        this.name = name;
        this.passenger=choosePassenger(scanner,"Please choose passenger type.");
        this.paymentMethod=chooseMethod(scanner,"Please choose default payment method");
        riderID = UUID.randomUUID().toString();
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
    public CityRideDataset.PaymentMethod chooseMethod(Scanner scanner, String message) {
        boolean valid = false;
        int choice;
        CityRideDataset.PaymentMethod paymentMethod= CityRideDataset.PaymentMethod.CARD;
        System.out.println(message);
        System.out.println("Enter 1 for Card");
        System.out.println("Enter 2 for Cash");
        System.out.println("Choice: ");
        while (valid == false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        paymentMethod = CityRideDataset.PaymentMethod.CARD;
                        valid = true;
                        break;
                    case 2:
                        paymentMethod = CityRideDataset.PaymentMethod.CASH;
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
        return paymentMethod;
    }

    public CityRideDataset.PassengerType getPassenger(){
        return passenger;
    }
    public void setPassenger(Scanner scanner){
        this.passenger =choosePassenger(scanner, "Please choose passenger type");
    }
    public CityRideDataset.PaymentMethod getMethod(){
        return paymentMethod;
    }
    public void setMethod(Scanner scanner){
        this.paymentMethod =chooseMethod(scanner, "Please choose passenger type");
    }
    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }
    public String getRiderID() {
        return riderID;
    }

    public void setRiderID(String riderID) {
        this.riderID = riderID;
    }

}
