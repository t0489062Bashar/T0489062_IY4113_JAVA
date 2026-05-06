| Assessment Details | Please Complete All Details                                             |
| ------------------ | ----------------------------------------------------------------------- |
| Group              | A                                                                       |
| Module Title       | IY4113 Applied Software Engineering using Object-Orientated Programming |
| Assessment Type    | Milestone 2                                                             |
| Module Tutor Name  | Jonathan Shore                                                          |
| Student ID Number  | P489062                                                                 |
| Date of Submission | 12/04/2026                                                              |
| Word Count         | 6101                                                                    |
| GitHub Link        |                                                                         |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in
  the final reference list.*
- [x] *Where I have used AI, I have cited and referenced appropriately.

------------------------------------------------------------------------------------------------------------------------------

### Research (minimum of 2, at least 3)

---

Conduct research to support your coding process, including use of code examples, tutortials, documentation and AI tools (if used).
Use the structure below to capture your evidence:

------------------------------------------------------------------------------------------------------------------------------

Title of research: Predicate (Java Platform SE 8)
Reference (link): https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
How does the research help with coding practise?:  Predicate allows the passing of boolean expressions as parameters to functions, allowing the creation of highly reusable and streamlined filtering functions.
Key coding ideas you could reuse in your program: Using the Predicate interface allows the creation of one singular function to filter journeys by passenger type, destination, or starting zone
Screenshot of research:![](C:\Users\paper\AppData\Roaming\marktext\images\2026-04-29-21-09-23-image.png)

------------------------------------------------------------------------------------------------------------------------------

Title of research: Lambda Expressions
Reference (link): https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
How does the research help with coding practise?: Lambda expressions, which are function style code blocks, can be used in a widely versatile manner, such as function parameters.
Key coding ideas you could reuse in your program: Lambda expressions could be used alongside the previously mentioned Predicate interface to compose concise and flexible filter statements for the software's filtering functionality
Screenshot of research:![](C:\Users\paper\AppData\Roaming\marktext\images\2026-04-29-21-26-05-image.png)

---

Title of research: Gson
Reference (link): https://github.com/google/gson

How does the research help with coding practise?: The gson library allows the serialisation and deserialisation of java objects to and from JSON fromat.
Key coding ideas you could reuse in your program: The gson library will allow the conversion and saving of user profiles, as well as the config file.
Screenshot of research: ![](C:\Users\paper\AppData\Roaming\marktext\images\2026-04-29-21-37-56-image.png)

------------------------------------------------------------------------------------------------------------------------------

### Program Code

---

import java.util.Scanner;  

public class CityRide_Lite {  

    public static void main(String[]
args) {  
        Scanner scanner = new
Scanner(System.*in*);  
        boolean valid=false;  
        int choice;  
        System.*out*.println("\n
Welcome to CityRide Lite");  
        System.*out*.println("Enter
1 for Admin Mode (Password Protected)");  
        System.*out*.println("Enter
2 for Rider Mode");  
        System.*out*.println("Choice:
");  
        while (valid == false) {  
            try {  
                choice = scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        AdminMode.*startAdminMode*(scanner);  
                        valid = true;  
                        break;  
                    case 2:  
                        RiderMode.*startRiderMode*(scanner);  
                        valid = true;  
                        break;  

                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        break;  

                }  
            }  
            catch(Exception e){  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        scanner.close();  

    }  

}

import
java.util.Scanner;  

public class AdminMode {  
    public static void
startAdminMode(Scanner scanner){  
        String
password="makemesad";  
        String attempt;  
        boolean correct=false;  
        while (!correct){  
            System.*out*.println("Enter
admin password: ");  
            attempt=scanner.nextLine();  
            if
(attempt.equals(password)){  
                System.*out*.println("Welcome,
Admin!");  
                ConfigFileHandler.*start*(scanner);  
                correct=true;  
            }  
            else {  
                System.*out*.println("Incorrect
password, please try again.");  
            }  
        }  
    }  
}

import
java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.util.HashMap;  
import java.util.Map;  

final public class CityRideDataset {  
    private CityRideDataset() {}  

    public static final int *MIN_ZONE* =
1;  
    public static final int *MAX_ZONE* =
5;  
    public static Config *config* =
ConfigFileHandler.*loadConfig*();  

    public enum TimeBand {  
        *PEAK*,  
        *OFF_PEAK*    }  

    public enum PaymentMethod {  
        *CARD*,  
        *CASH*    }  

    public enum PassengerType {  
        *ADULT*,  
        *STUDENT*,  
        *CHILD*,  
        *SENIOR_CITIZEN*    }  

    public static Map<PassengerType,
BigDecimal> *DISCOUNT_RATE* = Map.*of*(  
            PassengerType.*ADULT*, *config*.getAdultDiscount(),  
            PassengerType.*STUDENT*, *config*.getStudentDiscount(),  
            PassengerType.*CHILD*, *config*.getChildDiscount(),  
            PassengerType.*SENIOR_CITIZEN*, *config*.getSeniorDiscount()  
    );  

    public static final
Map<PassengerType, BigDecimal> *DAILY_CAP* = Map.*of*(  
            PassengerType.*ADULT*, *config*.getAdultCap(),  
            PassengerType.*STUDENT*, *config*.getStudentCap(),  
            PassengerType.*CHILD*, *config*.getChildCap(),  
            PassengerType.*SENIOR_CITIZEN*, *config*.getSeniorCap()  
    );  

    public static final Map<String,
BigDecimal> *BASE_FARE* = *config*.getBASE_FARE();  

    public static BigDecimal
getBaseFare(int fromZone, int toZone, TimeBand timeBand) {  
        return *BASE_FARE*.get(*key*(fromZone,
toZone, timeBand));  
    }  

    public static String key(int
fromZone, int toZone, TimeBand timeBand) {  
        return fromZone + "-" +
toZone + "-" + timeBand.name();  
    }  

}  

import java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Map;  

public class Config {  
    private BigDecimal adultDiscount;  
    private BigDecimal studentDiscount;  
    private BigDecimal childDiscount;  
    private BigDecimal seniorDiscount;  

    private BigDecimal adultCap;  
    private BigDecimal studentCap;  
    private BigDecimal childCap;  
    private BigDecimal seniorCap;  
    private Map<String, BigDecimal>
BASE_FARE;  

    public static String key(int
fromZone, int toZone, CityRideDataset.TimeBand timeBand) {  
        return fromZone + "-" +
toZone + "-" + timeBand.name();  
    }  

    private static BigDecimal
money(String amount) {  
        return new
BigDecimal(amount).setScale(2, RoundingMode.*HALF_UP*);  
    }  

    public static Map<String,
BigDecimal> buildBaseFare() {  
        Map<String, BigDecimal> m =
new HashMap<>();  

        // Peak fares  
        *put*(m,1,1,
CityRideDataset.TimeBand.*PEAK*,"2.50"); *put*(m,1,2,
CityRideDataset.TimeBand.*PEAK*,"3.20");  
        *put*(m,1,3,
CityRideDataset.TimeBand.*PEAK*,"3.80"); *put*(m,1,4,
CityRideDataset.TimeBand.*PEAK*,"4.40");  
        *put*(m,1,5,
CityRideDataset.TimeBand.*PEAK*,"5.00");  

        *put*(m,2,1,
CityRideDataset.TimeBand.*PEAK*,"3.20"); *put*(m,2,2,
CityRideDataset.TimeBand.*PEAK*,"2.30");  
        *put*(m,2,3,
CityRideDataset.TimeBand.*PEAK*,"3.10"); *put*(m,2,4,
CityRideDataset.TimeBand.*PEAK*,"3.80");  
        *put*(m,2,5,
CityRideDataset.TimeBand.*PEAK*,"4.50");  

        *put*(m,3,1,
CityRideDataset.TimeBand.*PEAK*,"3.80"); *put*(m,3,2,
CityRideDataset.TimeBand.*PEAK*,"3.10");  
        *put*(m,3,3,
CityRideDataset.TimeBand.*PEAK*,"2.10"); *put*(m,3,4,
CityRideDataset.TimeBand.*PEAK*,"3.00");  
        *put*(m,3,5,
CityRideDataset.TimeBand.*PEAK*,"3.70");  

        *put*(m,4,1,
CityRideDataset.TimeBand.*PEAK*,"4.40"); *put*(m,4,2,
CityRideDataset.TimeBand.*PEAK*,"3.80");  
        *put*(m,4,3,
CityRideDataset.TimeBand.*PEAK*,"3.00"); *put*(m,4,4,
CityRideDataset.TimeBand.*PEAK*,"2.00");  
        *put*(m,4,5,
CityRideDataset.TimeBand.*PEAK*,"2.90");  

        *put*(m,5,1,
CityRideDataset.TimeBand.*PEAK*,"5.00"); *put*(m,5,2,
CityRideDataset.TimeBand.*PEAK*,"4.50");  
        *put*(m,5,3,
CityRideDataset.TimeBand.*PEAK*,"3.70"); *put*(m,5,4,
CityRideDataset.TimeBand.*PEAK*,"2.90");  
        *put*(m,5,5,
CityRideDataset.TimeBand.*PEAK*,"1.90");  

        // Off-peak fares  
        *put*(m,1,1,
CityRideDataset.TimeBand.*OFF_PEAK*,"2.00"); *put*(m,1,2,
CityRideDataset.TimeBand.*OFF_PEAK*,"2.70");  
        *put*(m,1,3,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.20"); *put*(m,1,4,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.70");  
        *put*(m,1,5,
CityRideDataset.TimeBand.*OFF_PEAK*,"4.20");  

        *put*(m,2,1,
CityRideDataset.TimeBand.*OFF_PEAK*,"2.70"); *put*(m,2,2,
CityRideDataset.TimeBand.*OFF_PEAK*,"1.90");  
        *put*(m,2,3,
CityRideDataset.TimeBand.*OFF_PEAK*,"2.60"); *put*(m,2,4,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.20");  
        *put*(m,2,5,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.80");  

        *put*(m,3,1,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.20"); *put*(m,3,2,
CityRideDataset.TimeBand.*OFF_PEAK*,"2.60");  
        *put*(m,3,3,
CityRideDataset.TimeBand.*OFF_PEAK*,"1.70"); *put*(m,3,4,
CityRideDataset.TimeBand.*OFF_PEAK*,"2.50");  
        *put*(m,3,5,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.10");  

        *put*(m,4,1,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.70"); *put*(m,4,2,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.20");  
        *put*(m,4,3,
CityRideDataset.TimeBand.*OFF_PEAK*,"2.50"); *put*(m,4,4,
CityRideDataset.TimeBand.*OFF_PEAK*,"1.60");  
        *put*(m,4,5,
CityRideDataset.TimeBand.*OFF_PEAK*,"2.40");  

        *put*(m,5,1,
CityRideDataset.TimeBand.*OFF_PEAK*,"4.20"); *put*(m,5,2,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.80");  
        *put*(m,5,3,
CityRideDataset.TimeBand.*OFF_PEAK*,"3.10"); *put*(m,5,4,
CityRideDataset.TimeBand.*OFF_PEAK*,"2.40");  
        *put*(m,5,5,
CityRideDataset.TimeBand.*OFF_PEAK*,"1.50");  

        return Map.*copyOf*(m);  
    }  

    private static void
put(Map<String, BigDecimal> m, int from, int to, CityRideDataset.TimeBand
band, String amount) {  
        m.put(*key*(from, to, band), *money*(amount));  
    }  

    public Config(){  
        adultDiscount=new
BigDecimal("0.00");  
        studentDiscount=new
BigDecimal("0.25");  
        childDiscount=new
BigDecimal("0.50");  
        seniorDiscount=new
BigDecimal("0.30");  

        adultCap=new
BigDecimal("8.00");  
        studentCap=new
BigDecimal("6.00");  
        childCap=new
BigDecimal("4.00");  
        seniorCap=new
BigDecimal("7.00");  

        BASE_FARE = *buildBaseFare*();  

    }  

    public BigDecimal getAdultDiscount(){  
        return adultDiscount;  
    }  
    public BigDecimal
getStudentDiscount(){  
        return studentDiscount;  
    }  
    public BigDecimal getChildDiscount(){  
        return childDiscount;  
    }  
    public BigDecimal
getSeniorDiscount(){  
        return seniorDiscount;  
    }  

    public BigDecimal getAdultCap() {  
        return adultCap;  
    }  
    public BigDecimal getStudentCap(){  
        return studentCap;  
    }  
    public BigDecimal getChildCap() {  
        return childCap;  
    }  
    public BigDecimal getSeniorCap() {  
        return seniorCap;  
    }  

    public void
setAdultDiscount(BigDecimal discount){  
        this.adultDiscount=discount;  
    }  
    public void
setStudentDiscount(BigDecimal discount){  
        this.studentDiscount=discount;  
    }  
    public void
setChildDiscount(BigDecimal discount){  
        this.childDiscount=discount;  
    }  
    public void setSeniorDiscount(BigDecimal
discount){  
        this.seniorDiscount=discount;  
    }  

    public void setAdultCap(BigDecimal
cap){  
        this.adultCap=cap;  
    }  
    public void setStudentCap(BigDecimal
cap){  
        this.studentCap=cap;  
    }  
    public void setChildCap(BigDecimal
cap){  
        this.childCap=cap;  
    }  
    public void setSeniorCap(BigDecimal
cap){  
        this.seniorCap=cap;  
    }  

    public Map<String, BigDecimal>
getBASE_FARE() {  
        return BASE_FARE;  
    }  
    public void setBASE_FARE(int
startZone, int endZone, CityRideDataset.TimeBand time, BigDecimal money) {  
        BASE_FARE.put(*key*(startZone,endZone,time),money);  
    }  

    //adarshr(2012)  
    //Function for pretty printing maps  
    public String toString() {  
        StringBuilder sb = new
StringBuilder();  
        Iterator<Map.Entry<String,
BigDecimal>> iter = BASE_FARE.entrySet().iterator();  
        while (iter.hasNext()) {  
            Map.Entry<String,
BigDecimal> entry = iter.next();  
            sb.append(entry.getKey());  
            sb.append('=').append('"');  
            sb.append(entry.getValue());  
            sb.append('"');  
            if (iter.hasNext()) {  
                sb.append("\n");  
            }  
        }  
        return sb.toString();  

    }  
}

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
    private static Gson *gson* = new
GsonBuilder().setPrettyPrinting().create();  
    private static String *filename* =
"config.json";  
    private static boolean *newFile* =
false;  
    private static Config *config* = *loadConfig*();  

    public static Config loadConfig() {  
        Config loadConfigJson = new
Config();  
        try {  
            FileReader reader = new
FileReader(*filename*);  
            Type configType = new
TypeToken<Config>() {  
            }.getType();  
            loadConfigJson = *gson*.fromJson(reader,
configType);  
        } catch (Exception e) {  
            System.*err*.println("No
config file found. Starting with safe default values.");  
            System.*err*.println("Creating
config file...");  
            ConfigFileHandler.*newFile* =true;  
            *saveConfig*(loadConfigJson);  
        }  

        return loadConfigJson;  
    }  

    public static void saveConfig(Config
config) {  
        try {  
            FileWriter writer = new
FileWriter(*filename*);  
            *gson*.toJson(config,
writer);  
            writer.close();  
            System.*out*.println("Config
file saved");  

        } catch (Exception e) {  
            System.*err*.println("Error
saving config.");  
            e.printStackTrace();  
        }  
    }  

    public static void editCap(Scanner
scanner) {  
        boolean valid = false;  
        int choice = 0;  
        System.*out*.println("Which
cap would you like to edit?");  
        System.*out*.println("Enter
1 for Adult Cap");  
        System.*out*.println("Enter
2 for Student Cap");  
        System.*out*.println("Enter
3 for Child Cap");  
        System.*out*.println("Enter
4 for Senior Cap");  
        System.*out*.println("Choice:
");  
        while (valid == false) {  
            try {  
                choice = scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        *config*.setAdultCap(*getMoney*(scanner,"Please
enter the new Adult cap: "));  
                        valid = true;  
                        break;  
                    case 2:  
                        *config*.setStudentCap(*getMoney*(scanner,"Please
enter the new Student cap: "));  
                        valid = true;  
                        break;  
                    case 3:  
                        *config*.setChildCap(*getMoney*(scanner,"Please
enter the new Child cap: "));  
                        valid = true;  
                        break;  
                    case 4:  
                        *config*.setSeniorCap(*getMoney*(scanner,"Please
enter the new Senior cap: "));  
                        valid = true;  
                        break;  
                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        break;  

                }  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
    }  

    public static void
editDiscount(Scanner scanner) {  
        boolean valid = false;  
        int choice = 0;  
        System.*out*.println("Which
cap would you like to edit?");  
        System.*out*.println("Enter
1 for Adult Discount");  
        System.*out*.println("Enter
2 for Student Discount");  
        System.*out*.println("Enter
3 for Child Discount");  
        System.*out*.println("Enter
4 for Senior Discount");  
        System.*out*.println("Choice:
");  
        while (valid == false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        *config*.setAdultDiscount(*getDiscount*(scanner,"Please
enter the new Adult discount in decimals (0.50=50% discount!): "));  
                        valid = true;  
                        break;  
                    case 2:  
                        *config*.setStudentDiscount(*getDiscount*(scanner,"Please
enter the new Student discount in decimals (0.50=50% discount!): "));  
                        valid = true;  
                        break;  
                    case 3:  
                        *config*.setChildDiscount(*getDiscount*(scanner,"Please
enter the new Child discount in decimals (0.50=50% discount!): "));  
                        valid = true;  
                        break;  
                    case 4:  
                        *config*.setSeniorDiscount(*getDiscount*(scanner,"Please
enter the new Senior discount in decimals (0.50=50% discount!): "));  
                        valid = true;  
                        break;  
                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        break;  

                }  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
    }  

    public static int chooseZone(Scanner
scanner, String message){  
        boolean valid=false;  
        int choice=0;  
        System.*out*.println(message);  
        System.*out*.println("Enter
1 for Central Zone");  
        System.*out*.println("Enter
2 for Inner Zone");  
        System.*out*.println("Enter
3 for Suburban Zone");  
        System.*out*.println("Enter
4 for Outer Zone");  
        System.*out*.println("Enter
5 for Rural Zone");  
        System.*out*.println("Choice:
");  
        while (valid==false) {  

            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                if (choice >=
CityRideDataset.*MIN_ZONE* && choice <= CityRideDataset.*MAX_ZONE*)
{  
                    valid = true;  
                } else {  
                    System.*out*.println("Invalid
choice, please try again");  
                }  
            }  
            catch (Exception e){  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return choice;  
    }  

    public static
CityRideDataset.TimeBand chooseTime(Scanner scanner, String message) {  
        boolean valid = false;  
        int choice;  
        CityRideDataset.TimeBand
timeBand= CityRideDataset.TimeBand.*PEAK*;  
        System.*out*.println(message);  
        System.*out*.println("Enter
1 for Peak-time travel");  
        System.*out*.println("Enter
2 for Off-peak travel");  
        System.*out*.println("Choice:
");  
        while (valid == false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        timeBand =
CityRideDataset.TimeBand.*PEAK*;  
                        valid = true;  
                        break;  
                    case 2:  
                        timeBand =
CityRideDataset.TimeBand.*OFF_PEAK*;  
                        valid = true;  
                        break;  

                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        break;  

                }  
            }  
            catch(Exception e){  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return timeBand;  
    }  

    public static void
editBaseFare(Scanner scanner){  
        int startZone=*chooseZone*(scanner,"Please
choose starting zone");  
        int endZone=*chooseZone*(scanner,
"Please choose destination zone");  
        CityRideDataset.TimeBand
timeBand=*chooseTime*(scanner,"Please choose timeband");  
        BigDecimal newFare=*getMoney*(scanner,
"Please enter the new base fare: ");  
        *config*.setBASE_FARE(startZone,endZone,timeBand,newFare);  
    }  

    public static void editConfig(Scanner
scanner) {  
        boolean valid = false;  
        int choice = 0;  
        System.*out*.println("What
would you like to edit?");  
        System.*out*.println("Enter
1 for Passenger Caps");  
        System.*out*.println("Enter
2 for Passenger Discounts");  
        System.*out*.println("Enter
3 for Base Fares");  
        System.*out*.println("Choice:
");  
        while (valid == false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        *editCap*(scanner);  
                        valid = true;  
                        break;  
                   case 2:  
                        *editDiscount*(scanner);  
                        valid = true;  
                        break;  
                    case 3:  
                        *editBaseFare*(scanner);  
                        valid = true;  
                        break;  
                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        break;  

                }  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
}  
    public static void displayConfig(){  
        System.*out*.println("\n---
Config List ---");  
        System.*out*.println("Adult
Cap: " + *config*.getAdultCap());  
        System.*out*.println("Student
Cap: " + *config*.getStudentCap());  
        System.*out*.println("Child
Cap: " + *config*.getChildCap());  
        System.*out*.println("Senior
Cap: " + *config*.getSeniorCap());  
        System.*out*.println("-----------------------------------");  
        System.*out*.println("Adult
Discount: " + *config*.getAdultDiscount() + "%");  
        System.*out*.println("Student
Discount: " + *config*.getStudentDiscount() + "%");  
        System.*out*.println("Child
Discount: " + *config*.getChildDiscount() + "%");  
        System.*out*.println("Senior
Discount: " + *config*.getSeniorDiscount() + "%");  
        System.*out*.println("-----------------------------------");  
        System.*out*.println(*config*.toString());  
    }  

    public static int
getMenuChoice(Scanner scanner) {  
        int choice=0;  
        boolean valid=false;  
        while (valid==false){  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                valid=true;  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return choice;  
    }  

    public static BigDecimal
getMoney(Scanner scanner, String message) {  
        String amount;  
        BigDecimal money=new
BigDecimal("0.00");  
        boolean valid=false;  
        System.*out*.println(message);  
        while (valid==false){  
            try {  
                amount =
scanner.nextLine();  
                money=new
BigDecimal(amount);  
                valid=true;  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid amount");  
            }  
        }  
        return money;  
    }  

    public static BigDecimal
getDiscount(Scanner scanner, String message){  
        BigDecimal discount=*getMoney*(scanner,message);  
        boolean valid=false;  
        while (!valid) {  
            if
(discount.compareTo(BigDecimal.*ZERO*) < 0 ||
discount.compareTo(BigDecimal.*ONE*) > 0) {  
                System.*out*.println("Please
enter a valid amount");  
                discount=*getMoney*(scanner,message);  
            }  
            else {  
                valid=true;  
            }  
        }  
        return discount;  
    }  

    public static void showMenu(){  
        System.*out*.println("\n
---Admin Menu--- ");  
        System.*out*.println("1.
View config file");  
        System.*out*.println("2.
Edit config file");  
        System.*out*.println("3.
Exit");  
        System.*out*.println("Enter
a choice");  
    }  

    public static void start(Scanner
scanner) {  
        if (!*newFile*) {  
            int choice;  
            do {  
                *showMenu*();  
                choice = *getMenuChoice*(scanner);  
                switch (choice) {  
                    case 1:  
                        *displayConfig*();  
                        break;  
                    case 2:  
                        *editConfig*(scanner);  
                        *saveConfig*(*config*);  
                        break;  
                    case 3:  
                        System.*out*.println("Program
Ended!");  
                        break;  
                    default:  
                        System.*out*.println("Invalid
choice. Try again");  
                }  
            } while (choice != 3);  
        }  
    }  
}

import java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.time.LocalDate;  
import java.util.Scanner;  
import java.util.UUID;  

public class Journey {  
    private CityRideDataset.TimeBand
journeyTime;  
    private LocalDate journeyDate;  
    private int startZone;  
    private int endZone;  
    private CityRideDataset.PassengerType
passenger;  
    private BigDecimal baseFare;  
    private BigDecimal discountFare;  
    private BigDecimal finalFare;  
    private String journeyID;  

    public Journey(Scanner scanner){  
        journeyTime = chooseTime(scanner,
"Please choose timeband");  
        journeyDate =LocalDate.*now*();  
        startZone = chooseZone(scanner,
"Please choose starting zone");  
        endZone = chooseZone(scanner,
"Please choose destination zone");  
        passenger =
choosePassenger(scanner, "Please choose passenger type");  
        baseFare= CityRideDataset.*getBaseFare*(startZone,endZone,journeyTime);  
        discountFare=discount();  
        finalFare=finalFare();  
        journeyID = UUID.*randomUUID*().toString();  

    }  

    public
Journey(CityRideDataset.TimeBand journeyTime,LocalDate journeyDate,int
startZone,int endZone,CityRideDataset.PassengerType passenger,BigDecimal
baseFare,BigDecimal discountFare,BigDecimal finalFare,String journeyID){  
        this.journeyTime = journeyTime;  
        this.journeyDate =journeyDate;  
        this.startZone = startZone;  
        this.endZone = endZone;  
        this.passenger = passenger;  
        this.baseFare= baseFare;  
        this.discountFare=discountFare;  
        this.finalFare=finalFare;  
        this.journeyID = journeyID;  

    }  

    public CityRideDataset.TimeBand
chooseTime(Scanner scanner, String message) {  
        boolean valid = false;  
        int choice;  
        CityRideDataset.TimeBand
timeBand= CityRideDataset.TimeBand.*PEAK*;  
        System.*out*.println(message);  
        System.*out*.println("Enter
1 for Peak-time travel");  
        System.*out*.println("Enter
2 for Off-peak travel");  
        System.*out*.println("Choice:
");  
        while (valid == false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        timeBand =
CityRideDataset.TimeBand.*PEAK*;  
                        valid = true;  
                        break;  
                    case 2:  
                        timeBand =
CityRideDataset.TimeBand.*OFF_PEAK*;  
                        valid = true;  
                        break;  

                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        break;  

                }  
            }  
            catch(Exception e){  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return timeBand;  
    }  
    public int chooseZone(Scanner
scanner, String message){  
        boolean valid=false;  
        int choice=0;  
        System.*out*.println(message);  
        System.*out*.println("Enter
1 for Central Zone");  
        System.*out*.println("Enter
2 for Inner Zone");  
        System.*out*.println("Enter 3
for Suburban Zone");  
        System.*out*.println("Enter
4 for Outer Zone");  
        System.*out*.println("Enter
5 for Rural Zone");  
        System.*out*.println("Choice:
");  
        while (valid==false) {  

            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                if (choice >=
CityRideDataset.*MIN_ZONE* && choice <= CityRideDataset.*MAX_ZONE*)
{  
                    valid = true;  
                } else {  
                    System.*out*.println("Invalid
choice, please try again");  
                }  
            }  
            catch (Exception e){  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return choice;  
    }  
    public CityRideDataset.PassengerType
choosePassenger(Scanner scanner, String message){  
        boolean valid=false;  
        int choice;  
        CityRideDataset.PassengerType
passenger = CityRideDataset.PassengerType.*ADULT*;  
        System.*out*.println(message);  
        System.*out*.println("Enter
1 for Adult passenger");  
        System.*out*.println("Enter
2 for Student passenger");  
        System.*out*.println("Enter
3 for Child passenger");  
        System.*out*.println("Enter
4 for Senior passenger");  
        System.*out*.println("Choice:
");  
        while (valid==false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        passenger =
CityRideDataset.PassengerType.*ADULT*;  
                        valid = true;  
                        break;  
                    case 2:  
                        passenger =
CityRideDataset.PassengerType.*STUDENT*;  
                        valid = true;  
                        break;  
                    case 3:  
                        passenger =
CityRideDataset.PassengerType.*CHILD*;  
                        valid = true;  
                        break;  
                    case 4:  
                        passenger =
CityRideDataset.PassengerType.*SENIOR_CITIZEN*;  
                        valid = true;  
                        break;  
                    default:  
                        System.*out*.println("Invalid
choice, please try again");  

                }  
            }  
            catch (Exception e){  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return passenger;  
    }  
    public BigDecimal discount(){  
        BigDecimal discountfare;  
        discountfare=(baseFare.subtract(CityRideDataset.*DISCOUNT_RATE*.get(passenger).multiply(baseFare))).setScale(2,
RoundingMode.*HALF_UP*);  
        return discountfare;  

    }  
    public BigDecimal finalFare() {  
        if
(((discountFare.add(JourneyList.*PASSENGER_TOTAL*.get(getPassenger()))).compareTo(CityRideDataset.*DAILY_CAP*.get(getPassenger())))

> = 0) {  
>             finalFare = (CityRideDataset.*DAILY_CAP*.get(getPassenger())).subtract(JourneyList.*PASSENGER_TOTAL*.get(getPassenger()));  
>         }  
>         else{  
>             finalFare=discountFare;  
>         }  
>         JourneyList.*PASSENGER_TOTAL*.put(passenger,
> JourneyList.*PASSENGER_TOTAL*.get(passenger).add(finalFare));  
>         return finalFare;  

    }  

    public CityRideDataset.TimeBand
getJourneyTime(){  
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
    public CityRideDataset.PassengerType
getPassenger(){  
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

    public void setJourneyTime(Scanner
scanner){  
        this.journeyTime =
chooseTime(scanner, "Please choose travel time" );  

    }  
    public void setJourneyDate(){  
        this.journeyDate =LocalDate.*now*();  
    }  
    public void setStartZone(Scanner
scanner){  
        this.startZone
=chooseZone(scanner,"Please choose starting zone" );  
    }  
    public void setEndZone(Scanner
scanner){  
        this.endZone
=chooseZone(scanner,"Please choose starting zone");  
    }  
    public void setPassenger(Scanner
scanner){  
        this.passenger
=choosePassenger(scanner, "Please choose passenger type");  
    }  
    public void setBaseFare(){  
        this.baseFare = CityRideDataset.*getBaseFare*(startZone,
endZone, journeyTime);  
    }  

    public void setDiscountFare(){  
        this.discountFare = discount();  
    }  
    public void setFinalFare(){  
        this.finalFare = finalFare();  
    }  

    public String toCSV(){  
        return journeyDate +
","+ journeyTime + "," + startZone + "," +
endZone + "," + passenger + "," + baseFare + ","

+ discountFare + "," + finalFare + "," + journeyID;  
      }  

    public void displayDetails(){  
        System.*out*.println("["

+ journeyDate + "] Time: "+ journeyTime + "| Starting Zone:
  " + startZone + "| Destination Zone: " + endZone + "| Zones
  Crossed: " + (Math.*abs*(endZone - startZone) + 1) + "|
  Passenger Type: " + passenger + " | Base Fare: £" + baseFare +
  "| Discount Applied: "+ CityRideDataset.*DISCOUNT_RATE*.get(passenger).movePointRight(2).setScale(0,
  RoundingMode.*HALF_UP*) + "% | Discounted Fare: £" +
  discountFare + "| Final Fare: £" + finalFare + "| Journey ID:
  " + journeyID);  

    }  
}

import java.io.*;  
import java.math.BigDecimal;  
import java.time.LocalDate;  
import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  

public class JourneyFileHandler {  

    public static void
writeJourneysToFile(String fileName, List<Journey> journeys) {  

        try {  

            PrintWriter writer = new
PrintWriter(new FileWriter(fileName+".csv"));  
            writer.println("Journey
Date,Journey Time,Start Zone,End Zone,Passenger Type,Base Fare,Discounted
Fare,Final Fare,Journey ID");  
            for(Journey
journey:journeys){  
                writer.println(journey.toCSV());  
            }  
            writer.close();  
            System.*out*.println("Journey
data successfully written to file:");  

        }  
        catch(IOException e){  
            System.*out*.println("Error
writing to file!");  
        }  

    }  

    public static List<Journey>
readRidersFromFile(String fileName) {  

        List<Journey> journeys =
new ArrayList<>();  
        try{  
            int journeyCount=0;  
            File file=new File(fileName+".csv");  
            Scanner scanner =new
Scanner(file);  

            if (scanner.hasNextLine()) {  
                scanner.nextLine();  
            }  

            while(scanner.hasNextLine()){  
                String line =
scanner.nextLine();  
                String[] data =
line.split(",");  
                LocalDate date =
LocalDate.*parse*(data[0]);  
                CityRideDataset.TimeBand
time = CityRideDataset.TimeBand.*valueOf*(data[1]);  
                int startZone = Integer.*parseInt*(data[2]);  
                int endZone = Integer.*parseInt*(data[3]);  
                CityRideDataset.PassengerType passenger = CityRideDataset.PassengerType.*valueOf*(data[4]);  
                BigDecimal baseFare = new
BigDecimal(data[5]);  
                BigDecimal discountFare =
new BigDecimal(data[6]);  
                BigDecimal finalFare =
new BigDecimal(data[7]);  
                String ID = data[8];  
                Journey journey = new
Journey(time,date,startZone,endZone,passenger,baseFare,discountFare,finalFare,ID
);  
                journeys.add(journey);  
                journeyCount=journeyCount+1;  
            }  
            System.*out*.println(journeyCount
+" previous journey(s) found.");  
        }  
        catch(FileNotFoundException e){  
            System.*out*.println("No
previous journeys found.");  
        }  
        catch(NumberFormatException e){  
            System.*out*.println("Error:
Invalid number in file!");  
        }  

        return journeys;  
    }  

}

import java.time.LocalDate;  
import java.util.Scanner;  
import java.util.List;  
import java.util.function.Predicate;  

 public class JourneyFilter {  

    static private void filter
(List<Journey> journeyList, Predicate<Journey> condition){  
        boolean found=false;  
        for(Journey c : journeyList) {  
            if (condition.test(c)) {  
                found=true;  
                c.displayDetails();  
            }  
        }  
        if (found==false){  
            System.*out*.println("No
matches found.");  
        }  
    }  

    static private void
filterPassenger(Scanner scanner, List<Journey> journeyList){  
        boolean valid = false;  
        int choice;  
        System.*out*.println("Please
choose passenger to search for:");  
        System.*out*.println("1.
Adult");  
        System.*out*.println("2.
Student");  
        System.*out*.println("3.
Child");  
        System.*out*.println("4.
Senior");  
        System.*out*.println("Please
enter choice (1-4): ");  
        while (valid==false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        *filter*(journeyList,
c->c.getPassenger()== CityRideDataset.PassengerType.*ADULT*);  
                        valid = true;  
                        break;  
                    case 2:  
                        *filter*(journeyList,
c->c.getPassenger()== CityRideDataset.PassengerType.*STUDENT*);  
                        valid = true;  
                        break;  
                    case 3:  
                        *filter*(journeyList,
c->c.getPassenger()== CityRideDataset.PassengerType.*CHILD*);  
                        valid = true;  
                        break;  
                    case 4:  
                        *filter*(journeyList,
c->c.getPassenger()== CityRideDataset.PassengerType.*SENIOR_CITIZEN*);  
                        valid = true;  
                        break;  
                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        choice = scanner.nextInt();  
                        scanner.nextLine();  

                }  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
    }  

    static private void
filterTime(Scanner scanner, List<Journey> journeyList){  
        boolean valid = false;  
        int choice;  
        System.*out*.println("Please
choose time-band to search for:");  
        System.*out*.println("1.
Peak");  
        System.*out*.println("2.
Off-Peak");  
        System.*out*.println("Please
enter choice (1-2): ");  
        while (valid==false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        *filter*(journeyList,
c->c.getJourneyTime()== CityRideDataset.TimeBand.*PEAK*);  
                        valid = true;  
                        break;  
                    case 2:  
                        *filter*(journeyList,
c->c.getJourneyTime()== CityRideDataset.TimeBand.*OFF_PEAK*);  
                        valid = true;  
                        break;  
                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        choice =
scanner.nextInt();  
                        scanner.nextLine();  

                }  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
    }  

    static private void
filterZone(Scanner scanner, List<Journey> journeyList, boolean
startZone){  
        //A boolean "switch" is
used here to allow for one function to handle the filtering of both start and
end zones  
        boolean valid = false;  
        int choice;  
        boolean found=false;  
        System.*out*.println("Please
choose zone to search for:");  
        System.*out*.println("Enter
1 for Central Zone");  
        System.*out*.println("Enter
2 for Inner Zone");  
        System.*out*.println("Enter
3 for Suburban Zone");  
        System.*out*.println("Enter
4 for Outer Zone");  
        System.*out*.println("Enter
5 for Rural Zone");  
        System.*out*.println("Choice:
");  
        while (valid==false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                if (choice>0
&& choice<6) {  
                    final int finalChoice
= choice;  
                    if (startZone) {  
                        *filter*(journeyList,
c -> c.getStartZone() == finalChoice);  
                    }  
                    else{  
                        *filter*(journeyList,
c -> c.getEndZone() == finalChoice);  
                    }  
                    valid = true;  
                }  
                else{  
                        System.*out*.println("Invalid
choice, please try again");  
                        choice =
scanner.nextInt();  
                        scanner.nextLine();  

                }  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
    }  

    static private void
filterDate(Scanner scanner, List<Journey> journeyList) {  
        System.*out*.println("Please
enter date to search for:");  
        boolean valid = false;  
        while (valid == false) {  
            try {  
                System.*out*.println("Please
enter day (dd): ");  
                int day =
scanner.nextInt();  
                scanner.nextLine();  
                System.*out*.println("Please
enter month (MM): ");  
                int month =
scanner.nextInt();  
                scanner.nextLine();  
                System.*out*.println("Please
enter year (yyyy): ");  
                int year =
scanner.nextInt();  
                scanner.nextLine();  
                LocalDate date=
LocalDate.*of*(year,month,day);  
                *filter*(journeyList,
c->c.getJourneyDate().equals(date));  
                valid = true;  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
    }  

    static public void
filterJourney(Scanner scanner, List<Journey> journeyList){  
        boolean valid = false;  
        int choice;  
        System.*out*.println("Please
choose filter category:");  
        System.*out*.println("1.
Passenger Type");  
        System.*out*.println("2.
Time Band");  
        System.*out*.println("3.
Start Zone");  
        System.*out*.println("4.
End Zone");  
        System.*out*.println("5.
Date");  
        System.*out*.println("Please
enter choice (1-5): ");  
        while (valid==false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        *filterPassenger*(scanner,journeyList);  
                        valid = true;  
                        break;  
                    case 2:  
                        *filterTime*(scanner,journeyList);  
                        valid = true;  
                        break;  
                    case 3:  
                        *filterZone*(scanner,journeyList,
true);  
                        valid = true;  
                        break;  
                    case 4:  
                        *filterZone*(scanner,journeyList,
false);  
                        valid = true;  
                        break;  
                    case 5:  
                        *filterDate*(scanner,journeyList);  
                        valid = true;  
                        break;  
                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        choice =
scanner.nextInt();  
                        scanner.nextLine();  

                }  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  

    }  
}

import java.math.BigDecimal;  
import java.util.*;  

public class JourneyList {  
    private List<Journey>
journeyList = new ArrayList<>();  

    public static
Map<CityRideDataset.PassengerType, BigDecimal> *PASSENGER_TOTAL* =
new HashMap<>();  
    static {  
        *PASSENGER_TOTAL*.put(CityRideDataset.PassengerType.*ADULT*,
new BigDecimal("0.00"));  
        *PASSENGER_TOTAL*.put(CityRideDataset.PassengerType.*STUDENT*,
new BigDecimal("0.00"));  
        *PASSENGER_TOTAL*.put(CityRideDataset.PassengerType.*CHILD*,
new BigDecimal("0.00"));  
        *PASSENGER_TOTAL*.put(CityRideDataset.PassengerType.*SENIOR_CITIZEN*,
new BigDecimal("0.00"));  
    }  

    public List<Journey>
getJourneyList(){  
        return journeyList;  
    }  

    public void
setJourneyList(List<Journey> journeyList){  
        this.journeyList=journeyList;  
    }  

    public void addJourney(Journey c){  
        journeyList.add(c);  
        System.*out*.println("Journey
with ID: " + c.getJourneyID() + " has been added.");  

    }  
    public Journey findJourneyByID(String
ID){  
        for(Journey c : journeyList){  
            if(c.getJourneyID().equalsIgnoreCase(ID)){  
                return c;  
            }  
        }  
        return null;  
    }  

    public String
deleteJourneyByID(Scanner scanner){  
        String ID;  
        System.*out*.println("Please
input ID to delete: ");  
        ID=scanner.nextLine();  
        for(Journey c : journeyList){  
            if(c.getJourneyID().equalsIgnoreCase(ID)){  
                *PASSENGER_TOTAL*.put(c.getPassenger(),new
BigDecimal(0));  
                journeyList.remove(c);  
                for(Journey d :
journeyList) {  
                    if(d.getPassenger()==c.getPassenger()) {  
                        d.setFinalFare();  
                    }  

                }  

                return "Journey with
ID "+ ID +" has been deleted.";  
            }  

        }  
        return "Journey not
found";  
    }  

    public void showAllJourney(){  
        if (journeyList.isEmpty()) {  
            System.*out*.println("Journey
list is empty.");  
        }  
        else{  
            for(Journey c : journeyList) {  
                c.displayDetails();  
            }  
        }  
    }  

    public void clearDay(){  
        if (journeyList.isEmpty()) {  
            System.*out*.println("Journey
list is empty.");  
        }  
        else{  
            journeyList.clear();  
            *PASSENGER_TOTAL*.put(CityRideDataset.PassengerType.*ADULT*,new
BigDecimal(0));  
            *PASSENGER_TOTAL*.put(CityRideDataset.PassengerType.*STUDENT*,new
BigDecimal(0));  
            *PASSENGER_TOTAL*.put(CityRideDataset.PassengerType.*CHILD*,new
BigDecimal(0));  
            *PASSENGER_TOTAL*.put(CityRideDataset.PassengerType.*SENIOR_CITIZEN*,new
BigDecimal(0));  
            System.*out*.println("Day
cleared successfully.");  
        }  
    }  
}

import java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.time.LocalDate;  
import java.util.List;  
import java.util.Scanner;  

public class JourneySummariser {  
    static public void
dailySummary(Scanner scanner, List<Journey> journeyList, String
riderName, LocalDate date){  
        int journeyCount=0;  
        String
highestJourneyID="";  
        BigDecimal totalCost= new
BigDecimal(0);  
        BigDecimal highestFare= new
BigDecimal(0);  
        BigDecimal averageFare= new
BigDecimal(0);  
        BigDecimal moneySaved= new
BigDecimal(0);  
        int peakCounter=0;  
        int offPeakCounter=0;  
        int zone1counter=0;  
        int zone2counter=0;  
        int zone3counter=0;  
        int zone4counter=0;  
        int zone5counter=0;  
        boolean capReached=false;  
        int confirm=0;  
        if (journeyList.isEmpty()) {  
            System.*out*.println("Journey
list is empty.");  
        }  
        else {  
            for (Journey c : journeyList)
{  
                journeyCount =
journeyCount + 1;  
                totalCost =
totalCost.add(c.getFinalFare());  
                if
(c.getFinalFare().compareTo(highestFare) > 0) {  
                    highestJourneyID =
c.getJourneyID();  
                    highestFare =
c.getFinalFare();  
                }  
                if (c.getJourneyTime()==
CityRideDataset.TimeBand.*PEAK*){  
                    peakCounter+=1;  
                }  
                else {  
                    offPeakCounter+=1;  
                }  
                if (c.getEndZone()==1 ||
c.getStartZone()==1){  
                    zone1counter+=1;  
                }  
                if (c.getEndZone()==2 ||
c.getStartZone()==2){  
                    zone2counter+=1;  
                }  
                if (c.getEndZone()==3 ||
c.getStartZone()==3){  
                    zone3counter+=1;  
                }  
                if (c.getEndZone()==4 ||
c.getStartZone()==4){  
                    zone4counter+=1;  
                }  
                if (c.getEndZone()==5 ||
c.getStartZone()==5){  
                    zone5counter+=1;  
                }  

            }  
            moneySaved=moneySaved.add(*capSummariser*(journeyList,
CityRideDataset.PassengerType.*ADULT*));  
            moneySaved=moneySaved.add(*capSummariser*(journeyList,
CityRideDataset.PassengerType.*STUDENT*));  
            moneySaved=moneySaved.add(*capSummariser*(journeyList,
CityRideDataset.PassengerType.*CHILD*));  
            moneySaved=moneySaved.add(*capSummariser*(journeyList,
CityRideDataset.PassengerType.*SENIOR_CITIZEN*));  
            averageFare=(totalCost.divide(new BigDecimal(journeyCount))).setScale(2,
RoundingMode.*HALF_UP*);  

            System.*out*.println("Total
number of journeys: " + journeyCount);  
            System.*out*.println("Total
cost: " + totalCost);  
            System.*out*.println("Average
fare : " + averageFare);  
            System.*out*.println("Highest
Fare: " + highestFare + " with journey ID: " +
highestJourneyID);  
            System.*out*.println("Number
of peak journeys: " + peakCounter);  
            System.*out*.println("Number
of off-peak journeys: " + offPeakCounter);  
            System.*out*.println("Number
of journeys to/from Central Zone: " + zone1counter);  
            System.*out*.println("Number
of journeys to/from Inner Zone: " + zone2counter);  
            System.*out*.println("Number
of journeys to/from Suburban Zone: " + zone3counter);  
            System.*out*.println("Number
of journeys to/from Outer Zone: " + zone4counter);  
            System.*out*.println("Number
of journeys to/from Rural Zone: " + zone5counter);  
            if
((moneySaved.compareTo(BigDecimal.*ZERO*))==1){  
                System.*out*.println("Cap
was reached");  
                capReached=true;  
                System.*out*.println("Money
saved due to cap: " + moneySaved);  
            }  
            System.*out*.println("Would
you like to export this summary?");  
            System.*out*.println("Enter
1 to export");  
            System.*out*.println("Enter
any other value to decline");  
            try{  
                confirm =
scanner.nextInt();  
                scanner.nextLine();  
                if (confirm==1){  
                    String summaryCSV =
riderName + "," + date + "," + journeyCount + ","

+ totalCost + "," + averageFare + "," + highestFare +
  "," + highestJourneyID + "," + capReached + "," +
  moneySaved + "," + peakCounter + "," + offPeakCounter +
  "," + zone1counter + "," + zone2counter + "," +
  zone3counter + "," + zone4counter + "," + zone5counter;  
                      SummaryFileHandler.*writeSummariesToCSVFile*("reports",summaryCSV);  
                      SummaryFileHandler.*writeSummariesToTXTFile*("reports",riderName,date,journeyCount,highestJourneyID,totalCost,highestFare,averageFare,moneySaved,peakCounter,offPeakCounter,zone1counter,zone2counter,zone3counter,zone4counter,zone5counter,capReached);  
                  }  
                  else{  
                      System.*out*.println("Export
  declined");  
                  }  
              }  
              catch(Exception e){  
                  System.*out*.println("Export
  declined");  

            }  
        }  

    }  
    static private void
passengerSummariser(List<Journey> journeyList,
CityRideDataset.PassengerType passenger, String type) {//Shortened method to
adhere to guide to good programming.  
        int journeyCount = 0;  
        BigDecimal preDiscountSum = new
BigDecimal(0);  
        BigDecimal discountedSum = new
BigDecimal(0);  
        BigDecimal chargedSum = new
BigDecimal(0);  
        if (journeyList.isEmpty()) {  
            System.*out*.println("Journey
list is empty.");  
        } else {  
            boolean found = false;  
            for (Journey c : journeyList)
{  
                if (c.getPassenger() ==
passenger) {  
                    journeyCount =
journeyCount + 1;  
                    preDiscountSum =
preDiscountSum.add(c.getBaseFare());  
                    discountedSum =
discountedSum.add(c.getDiscountFare());  
                    chargedSum =
chargedSum.add(c.getFinalFare());  
                    found = true;  
                }  

            }  
            if (found == false) {  
                System.*out*.println("No
" + type.toLowerCase() + " journeys found.");  
            } else {  
                System.*out*.println("|
" + type.toUpperCase() + " JOURNEYS |");  
                System.*out*.println("No.
of " + type + " journeys: " + journeyCount);  
                System.*out*.println(type

+ " journeys total base fare: " + preDiscountSum);  
                  System.*out*.println(type
+ " journeys total discounted fare: " + discountedSum);  
                  System.*out*.println(type
+ " journeys total charged fare: " + chargedSum);  
                  if
  ((chargedSum.compareTo(CityRideDataset.*DAILY_CAP*.get(passenger))) == 0)
  {  
                      System.*out*.println("Cap
  was reached");  

                } else {  
                    System.*out*.println("Cap
was not reached");  
                }  
            }  
        }  
    }  

    static private BigDecimal
capSummariser(List<Journey> journeyList, CityRideDataset.PassengerType
passenger) {  
        BigDecimal discountedSum = new
BigDecimal(0);  
        BigDecimal chargedSum = new
BigDecimal(0);  
        BigDecimal moneySaved = new
BigDecimal(0);  
            for (Journey c : journeyList)
{  
                if (c.getPassenger() ==
passenger) {  
                    discountedSum =
discountedSum.add(c.getDiscountFare());  
                    chargedSum =
chargedSum.add(c.getFinalFare());  
                }  
            }  
                if
((chargedSum.compareTo(CityRideDataset.*DAILY_CAP*.get(passenger))) == 0)
{  
                    System.*out*.println("Cap
was reached");  
                    moneySaved=discountedSum.subtract(chargedSum);  

                }  
                return moneySaved;  
            }  

    static public void
passengerSummary(List<Journey> journeyList){  
        if (journeyList.isEmpty()) {  
            System.*out*.println("Journey
list is empty.");  
        } else {  
            *passengerSummariser*(journeyList,
CityRideDataset.PassengerType.*ADULT*, "Adult");  
            *passengerSummariser*(journeyList,
CityRideDataset.PassengerType.*STUDENT*, "Student");  
            *passengerSummariser*(journeyList,
CityRideDataset.PassengerType.*CHILD*, "Child");  
            *passengerSummariser*(journeyList,
CityRideDataset.PassengerType.*SENIOR_CITIZEN*, "Senior");  
        }  
    }  
}

import java.util.Scanner;  
import java.util.UUID;  

public class Rider {  
    private String name;  
    private String riderID;  
    private CityRideDataset.PassengerType
passenger;  
    private CityRideDataset.PaymentMethod
paymentMethod;  
    public Rider() {  
    }  

    public Rider(Scanner scanner,String
name) {  
        this.name = name;  
        this.passenger=choosePassenger(scanner,"Please choose passenger
type.");  
        this.paymentMethod=chooseMethod(scanner,"Please choose default
payment method");  
        riderID = UUID.*randomUUID*().toString();  
    }  

    public CityRideDataset.PassengerType
choosePassenger(Scanner scanner, String message){  
        boolean valid=false;  
        int choice;  
        CityRideDataset.PassengerType
passenger = CityRideDataset.PassengerType.*ADULT*;  
        System.*out*.println(message);  
        System.*out*.println("Enter
1 for Adult passenger");  
        System.*out*.println("Enter
2 for Student passenger");  
        System.*out*.println("Enter
3 for Child passenger");  
        System.*out*.println("Enter
4 for Senior passenger");  
        System.*out*.println("Choice:
");  
        while (valid==false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        passenger =
CityRideDataset.PassengerType.*ADULT*;  
                        valid = true;  
                        break;  
                    case 2:  
                        passenger =
CityRideDataset.PassengerType.*STUDENT*;  
                        valid = true;  
                        break;  
                    case 3:  
                        passenger =
CityRideDataset.PassengerType.*CHILD*;  
                        valid = true;  
                        break;  
                    case 4:  
                        passenger =
CityRideDataset.PassengerType.*SENIOR_CITIZEN*;  
                        valid = true;  
                        break;  
                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        scanner.nextLine();  

                }  
            }  
            catch (Exception e){  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return passenger;  
    }  
    public CityRideDataset.PaymentMethod
chooseMethod(Scanner scanner, String message) {  
        boolean valid = false;  
        int choice;  
        CityRideDataset.PaymentMethod
paymentMethod= CityRideDataset.PaymentMethod.*CARD*;  
        System.*out*.println(message);  
        System.*out*.println("Enter
1 for Card");  
        System.*out*.println("Enter
2 for Cash");  
        System.*out*.println("Choice:
");  
        while (valid == false) {  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                switch (choice) {  
                    case 1:  
                        paymentMethod =
CityRideDataset.PaymentMethod.*CARD*;  
                        valid = true;  
                        break;  
                    case 2:  
                        paymentMethod =
CityRideDataset.PaymentMethod.*CASH*;  
                        valid = true;  
                        break;  

                    default:  
                        System.*out*.println("Invalid
choice, please try again");  
                        break;  

                }  
            }  
            catch(Exception e){  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return paymentMethod;  
    }  

    public CityRideDataset.PassengerType
getPassenger(){  
        return passenger;  
    }  
    public void setPassenger(Scanner
scanner){  
        this.passenger
=choosePassenger(scanner, "Please choose passenger type");  
    }  
    public CityRideDataset.PaymentMethod
getMethod(){  
        return paymentMethod;  
    }  
    public void setMethod(Scanner
scanner){  
        this.paymentMethod
=chooseMethod(scanner, "Please choose passenger type");  
    }  
    public String getName() {  
        return name;  
    }  

    public void setName(String username)
{  
        this.name = username;  
    }  
    public String getRiderID() {  
        return riderID;  
    }  

    public void setRiderID(String
riderID) {  
        this.riderID = riderID;  
    }  

}

import com.google.gson.Gson;  
import com.google.gson.GsonBuilder;  
import com.google.gson.reflect.TypeToken;  

import java.io.FileReader;  
import java.io.FileWriter;  
import java.lang.reflect.Type;  
import java.util.ArrayList;  
import java.util.Scanner;  

public class RiderManager {  
    private ArrayList<Rider>
riders;  
    private Gson gson;  
    private String filename;  

    public RiderManager(){  
        gson = new
GsonBuilder().setPrettyPrinting().create();  
        filename =
"riders.json";  
        riders = loadRiders();  
    }  

    private ArrayList<Rider>
loadRiders(){  
        ArrayList<Rider>
loadUsersJson = new ArrayList<>();  
        try{  
            FileReader reader = new
FileReader(filename);  
            Type userListType = new
TypeToken<ArrayList<Rider>>() {}.getType();  
            loadUsersJson =
gson.fromJson(reader, userListType);  
        }  
        catch (Exception e){  
            System.*err*.println("No
existing riders found. Starting with empty list.");  
        }  

        return loadUsersJson;  
    }  

    private void saveRiders(){  
        try{  

            FileWriter writer = new
FileWriter(filename);  
            gson.toJson(riders,writer);  
            writer.close();  
            System.*out*.println("Users
saved to file");  

        }  
        catch (Exception e){  
            System.*err*.println("Error
saving users.");  
            e.printStackTrace();  
        }  
    }  
    private void addRider(Scanner
scanner){  
        String newRiderName;  
        System.*out*.println("Enter
rider name: ");  
        newRiderName=scanner.nextLine();  
        Rider newRider = new
Rider(scanner,newRiderName);  
        riders.add(newRider);  
        System.*out*.println("Rider
added successfully");  
    }  

    private void displayRiders(){  
        if(riders.isEmpty()) {  

            System.*out*.println("No
riders found!");  
        }  
        else{  
            int riderNo=1;  
            System.*out*.println("\n---
Rider Profile List ---");  
            for(Rider rider: riders){  
                System.*out*.println("Rider
Number: " + riderNo);  
                System.*out*.println("Name:
" + rider.getName());  
                System.*out*.println("ID:
" + rider.getRiderID());  
                System.*out*.println("Passenger
Type: " + rider.getPassenger());  
                System.*out*.println("Default
Payment method: " + rider.getMethod());  
                riderNo=riderNo+1;  
                System.*out*.println("-----------------------------------");  
            }  
        }  
    }  

    private Rider selectRider(Scanner
scanner){  
        Rider selectedRider=new Rider();  
        displayRiders();  
        if (!(riders.isEmpty())){  
            boolean valid=false;  
            do {  
                System.*out*.println("Please
enter the Rider Number of the profile you'd like to load: ");  
                int choice =
scanner.nextInt();  
                scanner.nextLine();  
                if(choice>0 &&
choice<(riders.size())+1){  
                    selectedRider=riders.get(choice-1);  
                    valid=true;  
                }  
                else{  
                    System.*out*.println("Invalid
choice, please try again.");  
                }  
            }while (!valid);  

        }  
        return selectedRider;  
    }  

    private int getMenuChoice(Scanner
scanner) {  
        int choice=0;  
        boolean valid=false;  
        while (valid==false){  
            try {  
                choice =
scanner.nextInt();  
                scanner.nextLine();  
                valid=true;  
            } catch (Exception e) {  
                System.*out*.println("Please
enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return choice;  
    }  

    private void showMenu(){  
        System.*out*.println("\n
---User Menu--- ");  
        System.*out*.println("1.
View all riders");  
        System.*out*.println("2.
Add a new rider");  
        System.*out*.println("3.
Select rider profile");  
        System.*out*.println("Enter
a choice");  
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
                    System.*out*.println("Invalid
choice. Try again");  
                    break;  
            }  
        }while (rider.getName()==null);  
        return rider;  
    }  
}

import java.time.LocalDate;  
import java.util.Scanner;  

public class RiderMode {  

    static public void
startRiderMode(Scanner scanner){  
        RiderManager riderManager = new
RiderManager();  
        Rider
rider=riderManager.start(scanner);  
        JourneyList journeyList = new
JourneyList();  
        journeyList.setJourneyList(JourneyFileHandler.*readRidersFromFile*(rider.getRiderID()));  

        int choice=0;  

        do {  
            System.*out*.println("\n
CityRide Lite");  
            System.*out*.println("1.
Add Journey");  
            System.*out*.println("2.
View All Journeys");  
            System.*out*.println("3.
Filter Journeys");  
            System.*out*.println("4.
Delete Journey");  
            System.*out*.println("5.
Clear Day");  
            System.*out*.println("6.
View Daily Summary");  
            System.*out*.println("7.
View Summary by Passenger Type");  
            System.*out*.println("8.
Exit");  
            System.*out*.println("Choice:
");  
            boolean valid=false;  
            while (valid==false){  
                try {  
                    choice =
scanner.nextInt();  
                    scanner.nextLine();  
                    valid=true;  
                } catch (Exception e) {  
                    System.*out*.println("Please
enter a valid choice");  
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
                    if
(journeyList.getJourneyList().isEmpty()) {  
                        System.*out*.println("Journey
list is empty.");  
                    }  
                    else {  
                        JourneyFilter.*filterJourney*(scanner,
journeyList.getJourneyList());  
                    }  
                    break;  

                case 4:  
                    int confirm;  
                    System.*out*.println("Are
you sure you'd like to delete a journey?");  
                    System.*out*.println("Enter
1 to confirm");  
                    try{  
                        confirm = scanner.nextInt();  
                        scanner.nextLine();  
                        if (confirm==1){  
                            System.*out*.println(journeyList.deleteJourneyByID(scanner));  
                        }  
                        else {  
                            System.*out*.println("Confirmation
declined");  
                        }  
                    }  
                    catch (Exception e){  
                        System.*out*.println("Confirmation
declined");  
                    }  
                    break;  
                case 5:  
                    System.*out*.println("Are
you sure you'd like to clear all journeys?");  
                    System.*out*.println("Enter
1 to confirm");  
                    System.*out*.println("Enter
any other value to decline");  
                    try{  
                        confirm =
scanner.nextInt();  
                        scanner.nextLine();  
                        if (confirm==1){  
                            journeyList.clearDay();  
                        }  
                        else{  
                            System.*out*.println("Confirmation
declined");  
                        }  
                    }  
                    catch(Exception e){  
                        System.*out*.println("Confirmation
declined");  

                    }  
                    break;  
                case 6:  
                    JourneySummariser.*dailySummary*(scanner,journeyList.getJourneyList(),
rider.getName(), LocalDate.*now*());  
                    break;  
                case 7:  
                    JourneySummariser.*passengerSummary*(journeyList.getJourneyList());  
                    break;  
                case 8:  
                    System.*out*.println("Would
you like to save this session's journeys?");  
                    System.*out*.println("Enter
1 to save");  
                    System.*out*.println("Enter
any other value to decline");  
                    try{  
                        confirm =
scanner.nextInt();  
                        scanner.nextLine();  
                        if (confirm==1){  
                            JourneyFileHandler.*writeJourneysToFile*(rider.getRiderID(),journeyList.getJourneyList());  
                        }  
                        else{  
                            System.*out*.println("Save
declined");  
                        }  
                    }  
                    catch(Exception e){  
                        System.*out*.println("Save
declined");  

                    }  
                    System.*out*.println("Exiting...");  
                    break;  
                default:  
                    System.*out*.println("Invalid
choice, please try again");  
                    break;  
            }  
        }  
        while (choice != 8);  
    }  
}

import
java.io.FileWriter;  
import java.io.IOException;  
import java.io.PrintWriter;  
import java.io.File;  
import java.math.BigDecimal;  
import java.time.LocalDate;  

public class SummaryFileHandler {  
    public static void
writeSummariesToCSVFile(String fileName,String data) {  

        try {  
            if (!(new File(System.*getProperty*("user.dir")+"/"+fileName+".csv").isFile()))
{  
                PrintWriter writer = new
PrintWriter(new FileWriter(fileName+".csv"));  
                writer.println("Rider Name,Date of Summary,Number of Journeys,Total
Cost,Average Cost Per Journey,Highest Fare,Most Expensive Journey,Cap
Reached?,Savings Due to Cap,Number of peak journeys,Number of off-peak
journeys,Number of journeys to/from Central Zone,Number of journeys to/from
Inner Zone,Number of journeys to/from Suburban Zone,Number of journeys to/from
Outer Zone,Number of journeys to/from Rural Zone");  
                writer.close();  
            }  
            PrintWriter writer = new
PrintWriter(new FileWriter(fileName+".csv",true));  
            writer.println(data);  
            writer.close();  
            System.*out*.println("Journey
data successfully written to file:");  

        }  
        catch(IOException e){  
            System.*out*.println("Error
writing to file!");  
        }  

    }  

    public static void
writeSummariesToTXTFile(String fileName, String riderName, LocalDate date, int
journeyCount, String highestJourneyID, BigDecimal totalCost, BigDecimal
highestFare, BigDecimal averageFare, BigDecimal moneySaved, int peakCounter,
int offPeakCounter, int zone1counter, int zone2counter, int zone3counter, int
zone4counter, int zone5counter, boolean capReached) {  

        try {  
            PrintWriter writer = new
PrintWriter(new FileWriter(fileName+".txt",true));  
            writer.println("-----------------------------------------------------------------------------------");  
            writer.println("Rider
Name: " + riderName);  
            writer.println("Summary
Date: " + date);  
            writer.println("Total
number of journeys: " + journeyCount);  
            writer.println("Total
cost: " + totalCost);  
            writer.println("Average
fare : " + averageFare);  
            writer.println("Highest
Fare: " + highestFare + " with journey ID: " +
highestJourneyID);  
            writer.println("Number
of peak journeys: " + peakCounter);  
            writer.println("Number
of off-peak journeys: " + offPeakCounter);  
            writer.println("Number
of journeys to/from Central Zone: " + zone1counter);  
            writer.println("Number
of journeys to/from Inner Zone: " + zone2counter);  
            writer.println("Number
of journeys to/from Suburban Zone: " + zone3counter);  
            writer.println("Number
of journeys to/from Outer Zone: " + zone4counter);  
            writer.println("Number
of journeys to/from Rural Zone: " + zone5counter);  
            if (capReached){  
                System.*out*.println("Cap
was reached");  
                System.*out*.println("Money
saved due to cap: " + moneySaved);  
            }  
            writer.close();  
            System.*out*.println("Journey
data successfully written to file:");  

        }  
        catch(IOException e){  
            System.*out*.println("Error
writing to file!");  
        }  

    }  
}*

### Updated Gantt Chart

------------------------------------------------------------------------------------------------------------------------------

![](C:\Users\paper\AppData\Roaming\marktext\images\2026-05-04-00-06-52-image.png)
------------------------------------------------------------------------------------------------------------------------------

### Diary Entries (at least 4)

------------------------------------------------------------------------------------------------------------------------------

12/04/2026 Diary Entry 1 - The Great Refactoring
------------------------------------------------------------------------------------------------------------------------------

To begin with, I analysed the code I had already written for part one, and began looking for ways to improve it before starting work on the functionality required for part 2. I began by decomposing the JourneyList function into smaller sub-classes, along with some of its methods. This was done as the first iteration of the program did not meet the requirement of functional decomposition, due to all methods existing within the JourneyList class. To ammend this, JourneyList was decomposed into less broad sub-classes, such as JourneySummariser and JourneyFilter, which have clear purposes. The relevant methods were also moved from JourneyList to the appropriate sub-classes. I then set out to eliminate any repititve code blocks within the classes, in order to reduce the massive line count. In order to do so I decided to research advanced java interfaces, such as Predicate, which I would begin working on at a later date.

## 14/04/2026 Diary Entry 2 - The Refactoring Continues

As previously stated, I began looking for duplicate code blocks throughout my classes and methods. Most egregiously, the JourneyFilter class was 400 lines long, most of which could be attributed to repetive filter logic. To address this issue, I decided to research the Predicate interface, which would allow the passing of logical comparisons as parameters, to create a singular filter method to be used throughout the whole class. In order to successfully construct a predicate however, I had to first research and learn how to implement lambda expressions. This was not a difficult task due to how similarly lambda expressions functioned compared to functions and methods, bar for some major differences in syntax. I then set out to find a more efficient way for the system to filter by zone. Specifically how it behaves when the user chooses to filter by the starting zone versus the destination zone. In the previous iteration of the program, JourneyList had 2 completely seperate methods, one for filtering by starting zone and another for filtering by destination zone, which was quite inefficient as both functions had the exact same prompts, near identical logic, and produced the same data type. After much deliberation, it was decided to combine both methods into one singular filterZone method, which expected a boolean parameter that acted as a switch within the function, to let the system know whether to filter by start zone or end zone. That change, combined with the implementation of the predicate interface and the newly developed filter method, allowed the JourneyFilter line count to be reduced from roughly 400, to just over 200, a bewildering 50% decrease in line count. Finally, I set out to patch the existing bugs in the system, such as when filtering dates and resetting the day.

## 17/04/2026 Diary Entry 3 - Rider Mode

After patching up the existent code, I began planning to implement the requirements for part 2. Firstly, I decided to implement the functionality for the rider side of the program, including the rider profiles, summary file handling, saving and loading journey data, and exporting human readable reports. None of this was particularly challenging, especially because we had done most of the work in class, such as the code required to read and write both CSV and JSON files. All I had to do was adapt the code to work with my program, which was more tedious than it was difficult. I created a rider class to encapsulate the data required to be stored about each rider, such as the name, passenger type, and payment method. Then, I reformatted how some of the data is written to files, tested the functions, and confirmed that everything functioned correctly and as expected.

## 20/04/2026 Diary Entry 4 - Admin Mode

Lastly I began work on the admin side of the program. I created a ConfigFileHandler class which contained the methods necessary for viewing, editing and saving the fare rules, passenger caps and discount rates used by the rider side of the program. I once again used the same principles we applied in class to save the config data to a JSON file which is loaded on program use, and a new file is initialised and created if one does not currently exist. The admin is protected by a case-sensitive password that the user must enter. The password is "makemesad". Finally, I created a menu that displays on program launch to allow the user to choose what mode to access.
