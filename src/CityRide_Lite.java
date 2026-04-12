import java.util.Scanner;



public class CityRide_Lite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JourneyList journeyList = new JourneyList();
        int choice=0;

        do {
            System.out.println("\n CityRide Lite");
            System.out.println("1. Add Journey");
            System.out.println("2. View All Journeys");
            System.out.println("3. Filter Journeys");
            System.out.println("4. Delete Journey");
            System.out.println("5. Clear Day");
            System.out.println("6. View Daily Summary");
            System.out.println("7. View Summary by Passenger Type");
            System.out.println("8. Exit");
            System.out.println("Choice: ");
            boolean valid=false;
            while (valid==false){
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    valid=true;
                } catch (Exception e) {
                    System.out.println("Please enter a valid choice");
                    scanner.nextLine();
                }
            }

            switch (choice) {
                case 1:
                    journeyList.addJourney(new Journey(scanner));
                    break;
                case 2:
                    journeyList.showAllJourney();
                    break;
                case 3:
                    if (journeyList.getJourneyList().isEmpty()) {
                        System.out.println("Journey list is empty.");
                    }
                    else {
                        JourneyFilter.filterJourney(scanner, journeyList.getJourneyList());
                    }
                    break;

                case 4:
                    int confirm;
                    System.out.println("Are you sure you'd like to delete a journey?");
                    System.out.println("Enter 1 to confirm");
                    try{
                        confirm = scanner.nextInt();
                        scanner.nextLine();
                        if (confirm==1){
                            System.out.println(journeyList.deleteJourneyByID(scanner));
                        }
                        else {
                            System.out.println("Confirmation declined");
                        }
                    }
                    catch (Exception e){
                        System.out.println("Confirmation declined");
                    }
                    break;
                case 5:
                    System.out.println("Are you sure you'd like to clear all journeys?");
                    System.out.println("Enter 1 to confirm");
                    try{
                        confirm = scanner.nextInt();
                        scanner.nextLine();
                        if (confirm==1){
                            journeyList.clearDay();
                        }
                        else{
                            System.out.println("Confirmation declined");
                        }
                    }
                    catch(Exception e){
                        System.out.println("Confirmation declined");

                    }
                    break;
                case 6:
                    JourneySummariser.dailySummary(journeyList.getJourneyList());
                    break;
                case 7:
                    JourneySummariser.passengerSummary(journeyList.getJourneyList());
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
        while (choice != 8);
        scanner.close();

    }

}
