# IY4113 Milestone 4

| Assessment Details | Please Complete All Details                            |
| ------------------ | ------------------------------------------------------ |
| Group              | A                                                      |
| Module Title       | IY4113 Applied Software Engineering                    |
| Assessment Type    | Milestone 4                                            |
| Module Tutor Name  | Jonathan Shore                                         |
| Student ID Number  | P489062                                                |
| Date of Submission | 15/02/2026                                             |
| Word Count         | 1302                                                   |
| GItHub Link        | https://github.com/t0489062Bashar/T0489062_IY4113_JAVA |

- [x] *I confirm that this assignment is my own work. Where I have referred to academic sources, I have provided in-text citations and included the sources in
  the final reference list.*
- [x] *Where I have used AI, I have cited and referenced appropriately.

------------------------------------------------------------------------------------------------------------------------------

### Program Code

---

Paste the current program code created so far. It does not have to be runnable code (document though if it does not work!)
------------------------------------------------------------------------------------------------------------------------------

import java.util.Scanner;  
import java.util.ArrayList;  
import java.util.List;  
import java.time.*;  
import java.util.UUID;  
import java.math.BigDecimal;  
import java.math.RoundingMode;  
import java.util.HashMap;  
import java.util.Map;  

final class CityRideDataset {  

    private CityRideDataset() {}  
    
    public static final int MIN_ZONE = 1;  
    public static final int MAX_ZONE = 5;  
    
    public enum TimeBand {  
        PEAK,  
        OFF_PEAK  
    }  
    
    public enum PassengerType {  
        ADULT,  
        STUDENT,  
        CHILD,  
        SENIOR_CITIZEN  
    }  
    
    public static final Map<PassengerType, BigDecimal> DISCOUNT_RATE = Map.of(  
            PassengerType.ADULT, new BigDecimal("0.00"),  
            PassengerType.STUDENT, new BigDecimal("0.25"),  
            PassengerType.CHILD, new BigDecimal("0.50"),  
            PassengerType.SENIOR_CITIZEN, new BigDecimal("0.30")  
    );  
    
    public static final Map<PassengerType, BigDecimal> DAILY_CAP = Map.of(  
            PassengerType.ADULT, new BigDecimal("8.00"),  
            PassengerType.STUDENT, new BigDecimal("6.00"),  
            PassengerType.CHILD, new BigDecimal("4.00"),  
            PassengerType.SENIOR_CITIZEN, new BigDecimal("7.00")  
    );  
    
    public static final Map<String, BigDecimal> BASE_FARE = buildBaseFare();  
    
    public static BigDecimal getBaseFare(int fromZone, int toZone, TimeBand timeBand) {  
        return BASE_FARE.get(key(fromZone, toZone, timeBand));  
    }  
    
    public static String key(int fromZone, int toZone, TimeBand timeBand) {  
        return fromZone + "-" + toZone + "-" + timeBand.name();  
    }  
    
    private static BigDecimal money(String amount) {  
        return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);  
    }  
    
    private static Map<String, BigDecimal> buildBaseFare() {  
        Map<String, BigDecimal> m = new HashMap<>();  
    
        // Peak fares  
        put(m,1,1,TimeBand.PEAK,"2.50"); put(m,1,2,TimeBand.PEAK,"3.20");  
        put(m,1,3,TimeBand.PEAK,"3.80"); put(m,1,4,TimeBand.PEAK,"4.40");  
        put(m,1,5,TimeBand.PEAK,"5.00");  
    
        put(m,2,1,TimeBand.PEAK,"3.20"); put(m,2,2,TimeBand.PEAK,"2.30");  
        put(m,2,3,TimeBand.PEAK,"3.10"); put(m,2,4,TimeBand.PEAK,"3.80");  
        put(m,2,5,TimeBand.PEAK,"4.50");  
    
        put(m,3,1,TimeBand.PEAK,"3.80"); put(m,3,2,TimeBand.PEAK,"3.10");  
        put(m,3,3,TimeBand.PEAK,"2.10"); put(m,3,4,TimeBand.PEAK,"3.00");  
        put(m,3,5,TimeBand.PEAK,"3.70");  
    
        put(m,4,1,TimeBand.PEAK,"4.40"); put(m,4,2,TimeBand.PEAK,"3.80");  
        put(m,4,3,TimeBand.PEAK,"3.00"); put(m,4,4,TimeBand.PEAK,"2.00");  
        put(m,4,5,TimeBand.PEAK,"2.90");  
    
        put(m,5,1,TimeBand.PEAK,"5.00"); put(m,5,2,TimeBand.PEAK,"4.50");  
        put(m,5,3,TimeBand.PEAK,"3.70"); put(m,5,4,TimeBand.PEAK,"2.90");  
        put(m,5,5,TimeBand.PEAK,"1.90");  
    
        // Off-peak fares  
        put(m,1,1,TimeBand.OFF_PEAK,"2.00"); put(m,1,2,TimeBand.OFF_PEAK,"2.70");  
        put(m,1,3,TimeBand.OFF_PEAK,"3.20"); put(m,1,4,TimeBand.OFF_PEAK,"3.70");  
        put(m,1,5,TimeBand.OFF_PEAK,"4.20");  
    
        put(m,2,1,TimeBand.OFF_PEAK,"2.70"); put(m,2,2,TimeBand.OFF_PEAK,"1.90");  
        put(m,2,3,TimeBand.OFF_PEAK,"2.60"); put(m,2,4,TimeBand.OFF_PEAK,"3.20");  
        put(m,2,5,TimeBand.OFF_PEAK,"3.80");  
    
        put(m,3,1,TimeBand.OFF_PEAK,"3.20"); put(m,3,2,TimeBand.OFF_PEAK,"2.60");  
        put(m,3,3,TimeBand.OFF_PEAK,"1.70"); put(m,3,4,TimeBand.OFF_PEAK,"2.50");  
        put(m,3,5,TimeBand.OFF_PEAK,"3.10");  
    
        put(m,4,1,TimeBand.OFF_PEAK,"3.70"); put(m,4,2,TimeBand.OFF_PEAK,"3.20");  
        put(m,4,3,TimeBand.OFF_PEAK,"2.50"); put(m,4,4,TimeBand.OFF_PEAK,"1.60");  
        put(m,4,5,TimeBand.OFF_PEAK,"2.40");  
    
        put(m,5,1,TimeBand.OFF_PEAK,"4.20"); put(m,5,2,TimeBand.OFF_PEAK,"3.80");  
        put(m,5,3,TimeBand.OFF_PEAK,"3.10"); put(m,5,4,TimeBand.OFF_PEAK,"2.40");  
        put(m,5,5,TimeBand.OFF_PEAK,"1.50");  
    
        return Map.copyOf(m);  
    }  
    
    private static void put(Map<String, BigDecimal> m, int from, int to, TimeBand band, String amount) {  
        m.put(key(from, to, band), money(amount));  
    }  

}  

class Journey {  
    private CityRideDataset.TimeBand journeyTime;  
    private LocalDate journeyDate;  
    private int startZone;  
    private int endZone;  
    private CityRideDataset.PassengerType passenger;  
    private BigDecimal baseFare;  
    private BigDecimal discountFare;  
    private String journeyID;  
    private BigDecimal total;  

    public Journey(Scanner scanner){  
        journeyTime = chooseTime(scanner, "Please choose timeband");  
        journeyDate =LocalDate.now();  
        startZone = chooseZone(scanner, "Please choose starting zone");  
        endZone = chooseZone(scanner, "Please choose destination zone");  
        passenger = choosePassenger(scanner, "Please choose passenger type");  
        baseFare= CityRideDataset.getBaseFare(startZone,endZone,journeyTime);//Base fare will be calculated once dataset is made available  
        discountFare=discount();  
        journeyID = UUID.randomUUID().toString();  
    
    }  
    
    public CityRideDataset.TimeBand chooseTime(Scanner scanner, String message) {  
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
    public int chooseZone(Scanner scanner, String message){  
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
            choice = scanner.nextInt();  
            scanner.nextLine();  
    
            try {  
                if (choice >= CityRideDataset.MIN_ZONE && choice <= CityRideDataset.MAX_ZONE) {  
                    valid = true;  
                } else {  
                    System.out.println("Invalid choice, please try again");  
                    choice = scanner.nextInt();  
                    scanner.nextLine();  
                }  
            }  
            catch (Exception e){  
                System.out.println("Please enter a valid choice");  
                scanner.nextLine();  
            }  
        }  
        return choice;  
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
            choice = scanner.nextInt();  
            scanner.nextLine();  
            try {  
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
                        choice = scanner.nextInt();  
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
    public BigDecimal discount(){  
        BigDecimal newfare;  
        newfare=(baseFare.subtract(CityRideDataset.DISCOUNT_RATE.get(passenger).multiply(baseFare))).setScale(2, RoundingMode.HALF_UP);  
        return newfare;  
    
    }  
    
    
    
    
    public CityRideDataset.TimeBand getJourneyTime(){  
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
    public CityRideDataset.PassengerType getPassenger(){  
        return passenger;  
    
    }  
    public BigDecimal getBaseFare(){  
        return baseFare;  
    
    }  
    public BigDecimal getDiscountFare(){  
        return discountFare;  
    
    }  
    public String getJourneyID(){  
        return journeyID;  
    
    }  
    
    public void setJourneyTime(Scanner scanner){  
        this.journeyTime = chooseTime(scanner, "Please choose travel time" );  
    
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
    public void setBaseFare(){  
        this.baseFare = CityRideDataset.getBaseFare(startZone, endZone, journeyTime);  
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
    private BigDecimal childTotal=new BigDecimal("0.0");  
    private BigDecimal seniorTotal=new BigDecimal("0.0");  
    private BigDecimal studentTotal=new BigDecimal("0.0");  
    private BigDecimal adultTotal=new BigDecimal("0.0");  
    
    
    public void addJourney(Journey c){  
        journeyList.add(c);  
        System.out.println("Journey with ID: " + c.getJourneyID() + " has been added.");  
        if (c.getPassenger()==CityRideDataset.PassengerType.SENIOR_CITIZEN){  
            seniorTotal=c.getDiscountFare().add(seniorTotal);  
        }  
        else if (c.getPassenger()==CityRideDataset.PassengerType.CHILD){  
            childTotal=c.getDiscountFare().add(childTotal);  
        }  
        else if (c.getPassenger()==CityRideDataset.PassengerType.STUDENT){  
            studentTotal=c.getDiscountFare().add(studentTotal);  
        }  
        else{  
            adultTotal=c.getDiscountFare().add(adultTotal);  
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
                if (c.getPassenger()==CityRideDataset.PassengerType.SENIOR_CITIZEN){  
                    seniorTotal=c.getDiscountFare().subtract(seniorTotal);  
                }  
                else if (c.getPassenger()==CityRideDataset.PassengerType.CHILD){  
                    childTotal=c.getDiscountFare().subtract(childTotal);  
                }  
                else if (c.getPassenger()==CityRideDataset.PassengerType.STUDENT){  
                    studentTotal=c.getDiscountFare().subtract(studentTotal);  
                }  
                else{  
                    adultTotal=c.getDiscountFare().subtract(adultTotal);  
                }  
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
            System.out.println("3. Filter Journeys");  
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
                        System.out.println("Enter new base fare: ");  
                        double newPrice = scanner.nextDouble();  
                        foundjourney.setBaseFare();  
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

### Updated Gantt Chart

------------------------------------------------------------------------------------------------------------------------------

![](C:\Users\paper\AppData\Roaming\marktext\images\2026-02-15-23-49-38-image.png)
------------------------------------------------------------------------------------------------------------------------------

### Diary Entries

------------------------------------------------------------------------------------------------------------------------------

*11/02/2026*
------------------------------------------------------------------------------------------------------------------------------

Fixed scanner bug, fixed infinite loop when choosing zones, implemented deleting journeys, implemented running totals, will begin implementation of caps.

## 14/02/2026

Added further integration with the provided data set. Reworked the way zones are stored from strings to integers. changed journeyTime from reading system time, to declaring whether the journey is peak or off-peak. implemented PassengerType and TimeBand custom data types. Need to implement caps, filtering journeys, viewing totals per passenger type and resetting day. exception handling would also be appreciated.

## 15/02/2026

Implemented exception handling.


