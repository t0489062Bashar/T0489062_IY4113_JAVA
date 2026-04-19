import java.util.Scanner;

public class AdminMode {
    public static void startAdminMode(Scanner scanner){
        String password="makemesad";
        String attempt;
        boolean correct=false;
        while (!correct){
            System.out.println("Enter admin password: ");
            attempt=scanner.nextLine();
            if (attempt.equals(password)){
                System.out.println("Welcome, Admin!");
                ConfigFileHandler.start(scanner);
                correct=true;
            }
            else {
                System.out.println("Incorrect password, please try again.");
            }
        }
    }
}
