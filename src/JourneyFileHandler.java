import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class JourneyFileHandler {

    public static void writeJourneysToFile(String fileName, List<Journey> journeys) {

        try {

            PrintWriter writer = new PrintWriter(new FileWriter(fileName+".csv"));
            writer.println("Journey Date,Journey Time,Start Zone,End Zone,Passenger Type,Base Fare,Discounted Fare,Final Fare,Journey ID");
            for(Journey journey:journeys){
                writer.println(journey.toCSV());
            }
            writer.close();
            System.out.println("Journey data successfully written to file:");

        }
        catch(IOException e){
            System.out.println("Error writing to file!");
        }


    }

    public static List<Journey> readRidersFromFile(String fileName) {

        List<Journey> journeys = new ArrayList<>();
        try{
            int journeyCount=0;
            File file=new File(fileName+".csv");
            Scanner scanner =new Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] data = line.split(",");
                LocalDate date = LocalDate.parse(data[0]);
                CityRideDataset.TimeBand time = CityRideDataset.TimeBand.valueOf(data[1]);
                int startZone = Integer.parseInt(data[2]);
                int endZone = Integer.parseInt(data[3]);
                CityRideDataset.PassengerType passenger = CityRideDataset.PassengerType.valueOf(data[4]);
                BigDecimal baseFare = new BigDecimal(data[5]);
                BigDecimal discountFare = new BigDecimal(data[6]);
                BigDecimal finalFare = new BigDecimal(data[7]);
                String ID = data[8];
                Journey journey = new Journey(time,date,startZone,endZone,passenger,baseFare,discountFare,finalFare,ID );
                journeys.add(journey);
                journeyCount=journeyCount+1;
            }
            System.out.println(journeyCount +" previous journey(s) found.");
        }
        catch(FileNotFoundException e){
            System.out.println("No previous journeys found.");
        }
        catch(NumberFormatException e){
            System.out.println("Error: Invalid number in file!");
        }




        return journeys;
    }

}
