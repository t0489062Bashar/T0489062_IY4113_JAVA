import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.function.Predicate;

 public class JourneyFilter {

    static private void filter (List<Journey> journeyList, Predicate<Journey> condition){
        boolean found=false;
        for(Journey c : journeyList) {
            if (condition.test(c)) {
                found=true;
                c.displayDetails();
            }
        }
        if (found==false){
            System.out.println("No matches found.");
        }
    }


    static private void filterPassenger(Scanner scanner, List<Journey> journeyList){
        boolean valid = false;
        int choice;
        System.out.println("Please choose passenger to search for:");
        System.out.println("1. Adult");
        System.out.println("2. Student");
        System.out.println("3. Child");
        System.out.println("4. Senior");
        System.out.println("Please enter choice (1-4): ");
        while (valid==false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        filter(journeyList, c->c.getPassenger()== CityRideDataset.PassengerType.ADULT);
                        valid = true;
                        break;
                    case 2:
                        filter(journeyList, c->c.getPassenger()== CityRideDataset.PassengerType.STUDENT);
                        valid = true;
                        break;
                    case 3:
                        filter(journeyList, c->c.getPassenger()== CityRideDataset.PassengerType.CHILD);
                        valid = true;
                        break;
                    case 4:
                        filter(journeyList, c->c.getPassenger()== CityRideDataset.PassengerType.SENIOR_CITIZEN);
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        choice = scanner.nextInt();
                        scanner.nextLine();

                }
            } catch (Exception e) {
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
    }

    static private void filterTime(Scanner scanner, List<Journey> journeyList){
        boolean valid = false;
        int choice;
        System.out.println("Please choose time-band to search for:");
        System.out.println("1. Peak");
        System.out.println("2. Off-Peak");
        System.out.println("Please enter choice (1-2): ");
        while (valid==false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        filter(journeyList, c->c.getJourneyTime()== CityRideDataset.TimeBand.PEAK);
                        valid = true;
                        break;
                    case 2:
                        filter(journeyList, c->c.getJourneyTime()== CityRideDataset.TimeBand.OFF_PEAK);
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        choice = scanner.nextInt();
                        scanner.nextLine();

                }
            } catch (Exception e) {
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
    }

    static private void filterZone(Scanner scanner, List<Journey> journeyList, boolean startZone){
        //A boolean "switch" is used here to allow for one function to handle the filtering of both start and end zones
        boolean valid = false;
        int choice;
        boolean found=false;
        System.out.println("Please choose zone to search for:");
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
                if (choice>0 && choice<6) {
                    final int finalChoice = choice;
                    if (startZone) {
                        filter(journeyList, c -> c.getStartZone() == finalChoice);
                    }
                    else{
                        filter(journeyList, c -> c.getEndZone() == finalChoice);
                    }
                    valid = true;
                }
                else{
                        System.out.println("Invalid choice, please try again");
                        choice = scanner.nextInt();
                        scanner.nextLine();

                }
            } catch (Exception e) {
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
    }

    static private void filterDate(Scanner scanner, List<Journey> journeyList) {
        System.out.println("Please enter date to search for:");
        boolean valid = false;
        while (valid == false) {
            try {
                System.out.println("Please enter day (dd): ");
                int day = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter month (MM): ");
                int month = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter year (yyyy): ");
                int year = scanner.nextInt();
                scanner.nextLine();
                LocalDate date= LocalDate.of(year,month,day);
                filter(journeyList, c->c.getJourneyDate().equals(date));
                valid = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
    }

    static public void filterJourney(Scanner scanner, List<Journey> journeyList){
        boolean valid = false;
        int choice;
        System.out.println("Please choose filter category:");
        System.out.println("1. Passenger Type");
        System.out.println("2. Time Band");
        System.out.println("3. Start Zone");
        System.out.println("4. End Zone");
        System.out.println("5. Date");
        System.out.println("Please enter choice (1-5): ");
        while (valid==false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        filterPassenger(scanner,journeyList);
                        valid = true;
                        break;
                    case 2:
                        filterTime(scanner,journeyList);
                        valid = true;
                        break;
                    case 3:
                        filterZone(scanner,journeyList, true);
                        valid = true;
                        break;
                    case 4:
                        filterZone(scanner,journeyList, false);
                        valid = true;
                        break;
                    case 5:
                        filterDate(scanner,journeyList);
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        choice = scanner.nextInt();
                        scanner.nextLine();

                }
            } catch (Exception e) {
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }


    }
}
