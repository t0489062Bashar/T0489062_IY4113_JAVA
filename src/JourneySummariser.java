import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class JourneySummariser {
    static public void dailySummary(List<Journey> journeyList){
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
    static private void passengerSummariser(List<Journey> journeyList, CityRideDataset.PassengerType passenger, String type) {//Shortened method to adhere to guide to good programming.
        int journeyCount = 0;
        BigDecimal preDiscountSum = new BigDecimal(0);
        BigDecimal discountedSum = new BigDecimal(0);
        BigDecimal chargedSum = new BigDecimal(0);
        if (journeyList.isEmpty()) {
            System.out.println("Journey list is empty.");
        } else {
            boolean found = false;
            for (Journey c : journeyList) {
                if (c.getPassenger() == passenger) {
                    journeyCount = journeyCount + 1;
                    preDiscountSum = preDiscountSum.add(c.getBaseFare());
                    discountedSum = discountedSum.add(c.getDiscountFare());
                    chargedSum = chargedSum.add(c.getFinalFare());
                    found = true;
                }


            }
            if (found == false) {
                System.out.println("No " + type.toLowerCase() + " journeys found.");
            } else {
                System.out.println("| " + type.toUpperCase() + " JOURNEYS |");
                System.out.println("No. of " + type + " journeys: " + journeyCount);
                System.out.println(type + " journeys total base fare: " + preDiscountSum);
                System.out.println(type + " journeys total discounted fare: " + discountedSum);
                System.out.println(type + " journeys total charged fare: " + chargedSum);
                if ((chargedSum.compareTo(CityRideDataset.DAILY_CAP.get(CityRideDataset.PassengerType.ADULT))) == 0) {
                    System.out.println("Cap was reached");
                } else {
                    System.out.println("Cap was not reached");
                }
            }
        }
    }

    static public void passengerSummary(List<Journey> journeyList){
        passengerSummariser(journeyList, CityRideDataset.PassengerType.ADULT,"Adult");
        passengerSummariser(journeyList, CityRideDataset.PassengerType.STUDENT,"Student");
        passengerSummariser(journeyList, CityRideDataset.PassengerType.CHILD,"Child");
        passengerSummariser(journeyList, CityRideDataset.PassengerType.SENIOR_CITIZEN,"Senior");
    }
}
