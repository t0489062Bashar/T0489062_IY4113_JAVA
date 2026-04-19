import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class RiderManager {
    private ArrayList<Rider> riders;
    private Gson gson;
    private String filename;

    public RiderManager(){
        gson = new GsonBuilder().setPrettyPrinting().create();
        filename = "riders.json";
        riders = loadRiders();
    }

    private ArrayList<Rider> loadRiders(){
        ArrayList<Rider> loadUsersJson = new ArrayList<>();
        try{
            FileReader reader = new FileReader(filename);
            Type userListType = new TypeToken<ArrayList<Rider>>() {}.getType();
            loadUsersJson = gson.fromJson(reader, userListType);
        }
        catch (Exception e){
            System.err.println("No existing riders found. Starting with empty list.");
        }

        return loadUsersJson;
    }

    private void saveRiders(){
        try{

            FileWriter writer = new FileWriter(filename);
            gson.toJson(riders,writer);
            writer.close();
            System.out.println("Users saved to file");

        }
        catch (Exception e){
            System.err.println("Error saving users.");
            e.printStackTrace();
        }
    }
    private void addRider(Scanner scanner){
        String newRiderName;
        System.out.println("Enter rider name: ");
        newRiderName=scanner.nextLine();
        Rider newRider = new Rider(scanner,newRiderName);
        riders.add(newRider);
        System.out.println("Rider added successfully");
    }

    private void displayRiders(){
        if(riders.isEmpty()) {

            System.out.println("No riders found!");
        }
        else{
            int riderNo=1;
            System.out.println("\n--- Rider Profile List ---");
            for(Rider rider: riders){
                System.out.println("Rider Number: " + riderNo);
                System.out.println("Name: " + rider.getName());
                System.out.println("ID: " + rider.getRiderID());
                System.out.println("Passenger Type: " + rider.getPassenger());
                System.out.println("Default Payment method: " + rider.getMethod());
                riderNo=riderNo+1;
                System.out.println("-----------------------------------");
            }
        }
    }

    private Rider selectRider(Scanner scanner){
        Rider selectedRider=new Rider();
        displayRiders();
        if (!(riders.isEmpty())){
            boolean valid=false;
            do {
                System.out.println("Please enter the Rider Number of the profile you'd like to load: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if(choice>0 && choice<(riders.size())+1){
                    selectedRider=riders.get(choice-1);
                    valid=true;
                }
                else{
                    System.out.println("Invalid choice, please try again.");
                }
            }while (!valid);

        }
        return selectedRider;
    }

    private int getMenuChoice(Scanner scanner) {
        int choice=0;
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
        return choice;
    }

    private void showMenu(){
        System.out.println("\n ---User Menu--- ");
        System.out.println("1. View all riders");
        System.out.println("2. Add a new rider");
        System.out.println("3. Select rider profile");
        System.out.println("Enter a choice");
    }

    public Rider start(Scanner scanner){
        int choice;
        Rider rider=new Rider();
        do {
            showMenu();
            choice=getMenuChoice(scanner);
            switch (choice){
                case 1:
                    displayRiders();
                    break;
                case 2:
                    addRider(scanner);
                    saveRiders();
                    break;
                case 3:
                    rider=selectRider(scanner);
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
                    break;
            }
        }while (rider.getName()==null);
        return rider;
    }
}
