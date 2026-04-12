import java.util.Scanner;
import java.util.List;

final public class JourneyFilter {

    static public void filterPassenger(Scanner scanner, List<Journey> journeyList){
        boolean valid = false;
        int choice;
        boolean found=false;
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
                            for(Journey c : journeyList) {
                                if (c.getPassenger()== CityRideDataset.PassengerType.ADULT) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 2:
                            for(Journey c : journeyList) {
                                if (c.getPassenger()== CityRideDataset.PassengerType.STUDENT) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 3:
                            for(Journey c : journeyList) {
                                if (c.getPassenger()== CityRideDataset.PassengerType.CHILD) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 4:
                            for(Journey c : journeyList) {
                                if (c.getPassenger()== CityRideDataset.PassengerType.SENIOR_CITIZEN) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
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

    static public void filterTime(Scanner scanner, List<Journey> journeyList){
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
                        if (journeyList.isEmpty()) {
                            System.out.println("Journey list is empty.");
                        }
                        else{
                            boolean found=false;
                            for(Journey c : journeyList) {
                                if (c.getJourneyTime()== CityRideDataset.TimeBand.PEAK) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        }
                        valid = true;
                        break;
                    case 2:
                        if (journeyList.isEmpty()) {
                            System.out.println("Journey list is empty.");
                        }
                        else{
                            boolean found=false;
                            for(Journey c : journeyList) {
                                if (c.getJourneyTime()== CityRideDataset.TimeBand.OFF_PEAK) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        }
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

    static public void filterStartZone(Scanner scanner, List<Journey> journeyList){
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
                switch (choice) {
                    case 1:
                            for(Journey c : journeyList) {
                                if (c.getStartZone()== 1) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 2:
                            for(Journey c : journeyList) {
                                if (c.getStartZone()== 2) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 3:
                            for(Journey c : journeyList) {
                                if (c.getStartZone()== 3) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 4:
                            for(Journey c : journeyList) {
                                if (c.getStartZone()== 4) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 5:
                            for(Journey c : journeyList) {
                                if (c.getStartZone()== 5) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
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

    static public void filterEndZone(Scanner scanner, List<Journey> journeyList){
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
                switch (choice) {
                    case 1:
                            for(Journey c : journeyList) {
                                if (c.getEndZone()== 1) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 2:
                            for(Journey c : journeyList) {
                                if (c.getEndZone()== 2) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 3:
                            for(Journey c : journeyList) {
                                if (c.getEndZone()== 3) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 4:
                            for(Journey c : journeyList) {
                                if (c.getEndZone()== 4) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
                        valid = true;
                        break;
                    case 5:
                            for(Journey c : journeyList) {
                                if (c.getEndZone()== 5) {
                                    found=true;
                                    c.displayDetails();
                                }
                            }
                            if (found==false){
                                System.out.println("No matches found.");
                            }
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
    static public void filterDate(Scanner scanner, List<Journey> journeyList) {
        System.out.println("Please enter date to search for:");
        boolean valid = false;
        while (valid == false) {
            try {
                System.out.println("Please enter day (dd): ");
                String day = scanner.nextLine();
                System.out.println("Please enter month (MM): ");
                String month = scanner.nextLine();
                System.out.println("Please enter year (yyyy): ");
                String year = scanner.nextLine();
                String date= year + "-" + month + "-" + day;
                boolean found=false;
                for(Journey c : journeyList) {
                    if (c.getJourneyDate().toString()== date) {
                        found=true;
                        c.displayDetails();
                    }
                }
                if (found==false){
                    System.out.println("No matches found.");
                }
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
                        filterStartZone(scanner,journeyList);
                        valid = true;
                        break;
                    case 4:
                        filterEndZone(scanner,journeyList);
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
