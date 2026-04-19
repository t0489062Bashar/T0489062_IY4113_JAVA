import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigFileHandler {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static String filename = "config.json";
    private static boolean newFile = false;
    private static Config config = loadConfig();



    public static Config loadConfig() {
        Config loadConfigJson = new Config();
        try {
            FileReader reader = new FileReader(filename);
            Type configType = new TypeToken<Config>() {
            }.getType();
            loadConfigJson = gson.fromJson(reader, configType);
        } catch (Exception e) {
            System.err.println("No config file found. Starting with safe default values.");
            System.err.println("Creating config file...");
            ConfigFileHandler.newFile =true;
            saveConfig(loadConfigJson);
        }

        return loadConfigJson;
    }

    public static void saveConfig(Config config) {
        try {
            FileWriter writer = new FileWriter(filename);
            gson.toJson(config, writer);
            writer.close();
            System.out.println("Config file saved");

        } catch (Exception e) {
            System.err.println("Error saving config.");
            e.printStackTrace();
        }
    }

    public static void editCap(Scanner scanner) {
        boolean valid = false;
        int choice = 0;
        System.out.println("Which cap would you like to edit?");
        System.out.println("Enter 1 for Adult Cap");
        System.out.println("Enter 2 for Student Cap");
        System.out.println("Enter 3 for Child Cap");
        System.out.println("Enter 4 for Senior Cap");
        System.out.println("Choice: ");
        while (valid == false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        config.setAdultCap(getMoney(scanner,"Please enter the new Adult cap: "));
                        valid = true;
                        break;
                    case 2:
                        config.setStudentCap(getMoney(scanner,"Please enter the new Student cap: "));
                        valid = true;
                        break;
                    case 3:
                        config.setChildCap(getMoney(scanner,"Please enter the new Child cap: "));
                        valid = true;
                        break;
                    case 4:
                        config.setSeniorCap(getMoney(scanner,"Please enter the new Senior cap: "));
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
    }

    public static void editDiscount(Scanner scanner) {
        boolean valid = false;
        int choice = 0;
        System.out.println("Which cap would you like to edit?");
        System.out.println("Enter 1 for Adult Discount");
        System.out.println("Enter 2 for Student Discount");
        System.out.println("Enter 3 for Child Discount");
        System.out.println("Enter 4 for Senior Discount");
        System.out.println("Choice: ");
        while (valid == false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        config.setAdultDiscount(getDiscount(scanner,"Please enter the new Adult discount in decimals (0.50=50% discount!): "));
                        valid = true;
                        break;
                    case 2:
                        config.setStudentDiscount(getDiscount(scanner,"Please enter the new Student discount in decimals (0.50=50% discount!): "));
                        valid = true;
                        break;
                    case 3:
                        config.setChildDiscount(getDiscount(scanner,"Please enter the new Child discount in decimals (0.50=50% discount!): "));
                        valid = true;
                        break;
                    case 4:
                        config.setSeniorDiscount(getDiscount(scanner,"Please enter the new Senior discount in decimals (0.50=50% discount!): "));
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
    }

    public static int chooseZone(Scanner scanner, String message){
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
                }
            }
            catch (Exception e){
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
        return choice;
    }

    public static CityRideDataset.TimeBand chooseTime(Scanner scanner, String message) {
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

    public static void editBaseFare(Scanner scanner){
        int startZone=chooseZone(scanner,"Please choose starting zone");
        int endZone=chooseZone(scanner, "Please choose destination zone");
        CityRideDataset.TimeBand timeBand=chooseTime(scanner,"Please choose timeband");
        BigDecimal newFare=getMoney(scanner, "Please enter the new base fare: ");
        config.setBASE_FARE(startZone,endZone,timeBand,newFare);
    }

    public static void editConfig(Scanner scanner) {
        boolean valid = false;
        int choice = 0;
        System.out.println("What would you like to edit?");
        System.out.println("Enter 1 for Passenger Caps");
        System.out.println("Enter 2 for Passenger Discounts");
        System.out.println("Enter 3 for Base Fares");
        System.out.println("Choice: ");
        while (valid == false) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        editCap(scanner);
                        valid = true;
                        break;
                   case 2:
                        editDiscount(scanner);
                        valid = true;
                        break;
                    case 3:
                        editBaseFare(scanner);
                        valid = true;
                        break;
                    default:
                        System.out.println("Invalid choice, please try again");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Please enter a valid choice");
                scanner.nextLine();
            }
        }
}
    public static void displayConfig(){
        System.out.println("\n--- Config List ---");
        System.out.println("Adult Cap: " + config.getAdultCap());
        System.out.println("Student Cap: " + config.getStudentCap());
        System.out.println("Child Cap: " + config.getChildCap());
        System.out.println("Senior Cap: " + config.getSeniorCap());
        System.out.println("-----------------------------------");
        System.out.println("Adult Discount: " + config.getAdultDiscount() + "%");
        System.out.println("Student Discount: " + config.getStudentDiscount() + "%");
        System.out.println("Child Discount: " + config.getChildDiscount() + "%");
        System.out.println("Senior Discount: " + config.getSeniorDiscount() + "%");
        System.out.println("-----------------------------------");
        System.out.println(config.toString());
    }

    public static int getMenuChoice(Scanner scanner) {
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

    public static BigDecimal getMoney(Scanner scanner, String message) {
        String amount;
        BigDecimal money=new BigDecimal("0.00");
        boolean valid=false;
        System.out.println(message);
        while (valid==false){
            try {
                amount = scanner.nextLine();
                money=new BigDecimal(amount);
                valid=true;
            } catch (Exception e) {
                System.out.println("Please enter a valid amount");
            }
        }
        return money;
    }

    public static BigDecimal getDiscount(Scanner scanner, String message){
        BigDecimal discount=getMoney(scanner,message);
        boolean valid=false;
        while (!valid) {
            if (discount.compareTo(BigDecimal.ZERO) < 0 || discount.compareTo(BigDecimal.ONE) > 0) {
                System.out.println("Please enter a valid amount");
                discount=getMoney(scanner,message);
            }
            else {
                valid=true;
            }
        }
        return discount;
    }

    public static void showMenu(){
        System.out.println("\n ---Admin Menu--- ");
        System.out.println("1. View config file");
        System.out.println("2. Edit config file");
        System.out.println("3. Exit");
        System.out.println("Enter a choice");
    }

    public static void start(Scanner scanner) {
        if (!newFile) {
            int choice;
            do {
                showMenu();
                choice = getMenuChoice(scanner);
                switch (choice) {
                    case 1:
                        displayConfig();
                        break;
                    case 2:
                        editConfig(scanner);
                        saveConfig(config);
                        break;
                    case 3:
                        System.out.println("Program Ended!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again");
                }
            } while (choice != 3);
        }
    }
}
