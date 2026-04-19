import java.util.Scanner;



public class CityRide_Lite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean valid=false;
        int choice;
        System.out.println("\n Welcome to CityRide Lite");
        System.out.println("Enter 1 for Admin Mode (Password Protected)");
        System.out.println("Enter 2 for Rider Mode");
        System.out.println("Choice: ");
        while (valid == false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        AdminMode.startAdminMode(scanner);
                        valid = true;
                        break;
                    case 2:
                        RiderMode.startRiderMode(scanner);
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
        scanner.close();

    }

}
