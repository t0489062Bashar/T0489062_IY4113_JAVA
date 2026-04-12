import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.util.UUID;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.math.*;


class journeyList {

    private List<Journey> journeyList = new ArrayList<>();


    public static Map<CityRideDataset.PassengerType, BigDecimal> PASSENGER_TOTAL = new HashMap<>();
    static {
        PASSENGER_TOTAL.put(CityRideDataset.PassengerType.ADULT, new BigDecimal("0.00"));
        PASSENGER_TOTAL.put(CityRideDataset.PassengerType.STUDENT, new BigDecimal("0.00"));
        PASSENGER_TOTAL.put(CityRideDataset.PassengerType.CHILD, new BigDecimal("0.00"));
        PASSENGER_TOTAL.put(CityRideDataset.PassengerType.SENIOR_CITIZEN, new BigDecimal("0.00"));
    }

    public List<Journey> getJourneyList(){
        return journeyList;
    }


    public void addJourney(Journey c){
        journeyList.add(c);
        System.out.println("Journey with ID: " + c.getJourneyID() + " has been added.");

    }
    public Journey findJourneyByID(String ID){
        for(Journey c : journeyList){
            if(c.getJourneyID().equalsIgnoreCase(ID)){
                return c;
            }
        }
        return null;
    }


    public void dailySummary(Scanner scanner){
        int journeyCount=0;
        String highestJourneyID="";
        BigDecimal totalCost= new BigDecimal(0);
        BigDecimal highestFare= new BigDecimal(0);
        int peakCounter=0;
        int offPeakCounter=0;
        int zone1counter=0;
        int zone2counter=0;
        int zone3counter=0;
        int zone4counter=0;
        int zone5counter=0;
        if (journeyList.isEmpty()) {
            System.out.println("Journey list is empty.");
        }
        else {
            for (Journey c : journeyList) {
                journeyCount = journeyCount + 1;
                totalCost = totalCost.add(c.getFinalFare());
                if (c.getFinalFare().compareTo(highestFare) > 0) {
                    highestJourneyID = c.getJourneyID();
                    highestFare = c.getFinalFare();
                }
                if (c.getJourneyTime()== CityRideDataset.TimeBand.PEAK){
                    peakCounter+=1;
                }
                else {
                    offPeakCounter+=1;
                }
                if (c.getEndZone()==1 || c.getStartZone()==1){
                    zone1counter+=1;
                }
                if (c.getEndZone()==2 || c.getStartZone()==2){
                    zone2counter+=1;
                }
                if (c.getEndZone()==3 || c.getStartZone()==3){
                    zone3counter+=1;
                }
                if (c.getEndZone()==4 || c.getStartZone()==4){
                    zone4counter+=1;
                }
                if (c.getEndZone()==5 || c.getStartZone()==5){
                    zone5counter+=1;
                }

            }

            System.out.println("Total number of journeys: " + journeyCount);
            System.out.println("Total cost: " + totalCost);
            System.out.println("Average fare : " + (totalCost.divide(new BigDecimal(journeyCount))).setScale(2, RoundingMode.HALF_UP));
            System.out.println("Highest Fare: " + highestFare + " with journey ID: " + highestJourneyID);
            System.out.println("Number of peak journeys: " + peakCounter);
            System.out.println("Number of off-peak journeys: " + offPeakCounter);
            System.out.println("Number of journeys to/from Central Zone: " + zone1counter);
            System.out.println("Number of journeys to/from Inner Zone: " + zone2counter);
            System.out.println("Number of journeys to/from Suburban Zone: " + zone3counter);
            System.out.println("Number of journeys to/from Outer Zone: " + zone4counter);
            System.out.println("Number of journeys to/from Rural Zone: " + zone5counter);
        }

    }

    public void passengerSummary(Scanner scanner){
        int journeyCount=0;
        BigDecimal preDiscountSum=new BigDecimal(0);
        BigDecimal discountedSum=new BigDecimal(0);
        BigDecimal chargedSum=new BigDecimal(0);
        if (journeyList.isEmpty()) {
            System.out.println("Journey list is empty.");
        }
        else{
            boolean found=false;
            for(Journey c : journeyList) {
                if (c.getPassenger()==CityRideDataset.PassengerType.ADULT){
                    journeyCount=journeyCount+1;
                    preDiscountSum=preDiscountSum.add(c.getBaseFare());
                    discountedSum=discountedSum.add(c.getDiscountFare());
                    chargedSum=chargedSum.add(c.getFinalFare());
                    found=true;
                }


            }
            if (found==false){
                System.out.println("No adult journeys found.");
            }
            else {
                System.out.println("| ADULT JOURNEYS |");
                System.out.println("No. of adult journeys: " + journeyCount);
                System.out.println("Adult journeys total base fare: " + preDiscountSum);
                System.out.println("Adult journeys total discounted fare: " + discountedSum);
                System.out.println("Adult journeys total charged fare: " + chargedSum);
                if((chargedSum.compareTo(CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.ADULT)))==0){
                    System.out.println("Cap was reached");
                }
                else{
                    System.out.println("Cap was not reached");
                }
            }
            journeyCount=0;
            preDiscountSum=new BigDecimal(0);
            discountedSum=new BigDecimal(0);
            chargedSum=new BigDecimal(0);
            for(Journey c : journeyList) {
                if (c.getPassenger()==CityRideDataset.PassengerType.STUDENT){
                    journeyCount=journeyCount+1;
                    preDiscountSum=preDiscountSum.add(c.getBaseFare());
                    discountedSum=discountedSum.add(c.getDiscountFare());
                    chargedSum=chargedSum.add(c.getFinalFare());
                    found=true;
                }


            }
            if (found==false){
                System.out.println("No student journeys found.");
            }
            else {
                System.out.println("| STUDENT JOURNEYS |");
                System.out.println("No. of student journeys: " + journeyCount);
                System.out.println("Student journeys total base fare: " + preDiscountSum);
                System.out.println("Student journeys total discounted fare: " + discountedSum);
                System.out.println("Student journeys total charged fare: " + chargedSum);
                if((chargedSum.compareTo(CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.STUDENT)))==0){
                    System.out.println("Cap was reached");
                }
                else{
                    System.out.println("Cap was not reached");
                }
            }
            journeyCount=0;
            preDiscountSum=new BigDecimal(0);
            discountedSum=new BigDecimal(0);
            chargedSum=new BigDecimal(0);
            for(Journey c : journeyList) {
                if (c.getPassenger()==CityRideDataset.PassengerType.CHILD){
                    journeyCount=journeyCount+1;
                    preDiscountSum=preDiscountSum.add(c.getBaseFare());
                    discountedSum=discountedSum.add(c.getDiscountFare());
                    chargedSum=chargedSum.add(c.getFinalFare());
                    found=true;
                }


            }
            if (found==false){
                System.out.println("No child journeys found.");
            }
            else {
                System.out.println("| CHILD JOURNEYS |");
                System.out.println("No. of child journeys: " + journeyCount);
                System.out.println("Child journeys total base fare: " + preDiscountSum);
                System.out.println("Child journeys total discounted fare: " + discountedSum);
                System.out.println("Child journeys total charged fare: " + chargedSum);
                if((chargedSum.compareTo(CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.CHILD)))==0){
                    System.out.println("Cap was reached");
                }
                else{
                    System.out.println("Cap was not reached");
                }
            }
            journeyCount=0;
            preDiscountSum=new BigDecimal(0);
            discountedSum=new BigDecimal(0);
            chargedSum=new BigDecimal(0);
            for(Journey c : journeyList) {
                if (c.getPassenger()==CityRideDataset.PassengerType.SENIOR_CITIZEN){
                    journeyCount=journeyCount+1;
                    preDiscountSum=preDiscountSum.add(c.getBaseFare());
                    discountedSum=discountedSum.add(c.getDiscountFare());
                    chargedSum=chargedSum.add(c.getFinalFare());
                    found=true;
                }


            }
            if (found==false){
                System.out.println("No senior journeys found.");
            }
            else {
                System.out.println("| SENIOR JOURNEYS |");
                System.out.println("No. of senior journeys: " + journeyCount);
                System.out.println("Senior journeys total base fare: " + preDiscountSum);
                System.out.println("Senior journeys total discounted fare: " + discountedSum);
                System.out.println("Senior journeys total charged fare: " + chargedSum);
                if((chargedSum.compareTo(CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.SENIOR_CITIZEN)))==0){
                    System.out.println("Cap was reached");
                }
                else{
                    System.out.println("Cap was not reached");
                }
            }
        }
    }

    public String deleteJourneyByID(Scanner scanner){
        String ID;
        int counter=0;
        System.out.println("Please input ID to delete: ");
        ID=scanner.nextLine();
        for(Journey c : journeyList){
            counter+=1;
            if(c.getJourneyID().equalsIgnoreCase(ID)){
                PASSENGER_TOTAL.put(c.getPassenger(),new BigDecimal(0));
                journeyList.remove(c);
                for(Journey d : journeyList) {
                    if(d.getPassenger()==c.getPassenger()) {
                        d.setFinalFare();
                    }

                }

                return "Journey with ID "+ ID +" has been deleted.";
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

    public void clearDay(){
        if (journeyList.isEmpty()) {
            System.out.println("Journey list is empty.");
        }
        else{
            journeyList.clear();
            System.out.println("Day cleared successfully.");
            }
        }
}



public class CityRide_Lite {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        journeyList journeyList = new journeyList();
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
                    journeyList.dailySummary(scanner);
                    break;
                case 7:
                    journeyList.passengerSummary(scanner);
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
