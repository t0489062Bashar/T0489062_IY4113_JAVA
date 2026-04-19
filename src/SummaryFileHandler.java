import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;


public class SummaryFileHandler {
    public static void writeSummariesToCSVFile(String fileName,String data) {

        try {
            if (!(new File(System.getProperty("user.dir")+"/"+fileName+".csv").isFile())) {
                PrintWriter writer = new PrintWriter(new FileWriter(fileName+".csv"));
                writer.println("Rider Name,Date of Summary,Number of Journeys,Total Cost,Average Cost Per Journey,Highest Fare,Most Expensive Journey,Cap Reached?,Savings Due to Cap,Number of peak journeys,Number of off-peak journeys,Number of journeys to/from Central Zone,Number of journeys to/from Inner Zone,Number of journeys to/from Suburban Zone,Number of journeys to/from Outer Zone,Number of journeys to/from Rural Zone");
                writer.close();
            }
            PrintWriter writer = new PrintWriter(new FileWriter(fileName+".csv",true));
            writer.println(data);
            writer.close();
            System.out.println("Journey data successfully written to file:");

        }
        catch(IOException e){
            System.out.println("Error writing to file!");
        }


    }

    public static void writeSummariesToTXTFile(String fileName, String riderName, LocalDate date, int journeyCount, String highestJourneyID, BigDecimal totalCost, BigDecimal highestFare, BigDecimal averageFare, BigDecimal moneySaved, int peakCounter, int offPeakCounter, int zone1counter, int zone2counter, int zone3counter, int zone4counter, int zone5counter, boolean capReached) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName+".txt",true));
            writer.println("-----------------------------------------------------------------------------------");
            writer.println("Rider Name: " + riderName);
            writer.println("Summary Date: " + date);
            writer.println("Total number of journeys: " + journeyCount);
            writer.println("Total cost: " + totalCost);
            writer.println("Average fare : " + averageFare);
            writer.println("Highest Fare: " + highestFare + " with journey ID: " + highestJourneyID);
            writer.println("Number of peak journeys: " + peakCounter);
            writer.println("Number of off-peak journeys: " + offPeakCounter);
            writer.println("Number of journeys to/from Central Zone: " + zone1counter);
            writer.println("Number of journeys to/from Inner Zone: " + zone2counter);
            writer.println("Number of journeys to/from Suburban Zone: " + zone3counter);
            writer.println("Number of journeys to/from Outer Zone: " + zone4counter);
            writer.println("Number of journeys to/from Rural Zone: " + zone5counter);
            if (capReached){
                System.out.println("Cap was reached");
                System.out.println("Money saved due to cap: " + moneySaved);
            }
            writer.close();
            System.out.println("Journey data successfully written to file:");

        }
        catch(IOException e){
            System.out.println("Error writing to file!");
        }


    }
}
