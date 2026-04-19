import java.math.BigDecimal;
import java.util.*;

public class JourneyList {
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

    public void setJourneyList(List<Journey> journeyList){
        this.journeyList=journeyList;
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

    public String deleteJourneyByID(Scanner scanner){
        String ID;
        System.out.println("Please input ID to delete: ");
        ID=scanner.nextLine();
        for(Journey c : journeyList){
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
            PASSENGER_TOTAL.put(CityRideDataset.PassengerType.ADULT,new BigDecimal(0));
            PASSENGER_TOTAL.put(CityRideDataset.PassengerType.STUDENT,new BigDecimal(0));
            PASSENGER_TOTAL.put(CityRideDataset.PassengerType.CHILD,new BigDecimal(0));
            PASSENGER_TOTAL.put(CityRideDataset.PassengerType.SENIOR_CITIZEN,new BigDecimal(0));
            System.out.println("Day cleared successfully.");
        }
    }
}
