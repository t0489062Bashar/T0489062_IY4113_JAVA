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
    private Map<String, BigDecimal> BASE_FARE;

    public static String key(int fromZone, int toZone, CityRideDataset.TimeBand timeBand) {
        return fromZone + "-" + toZone + "-" + timeBand.name();
    }

    private static BigDecimal money(String amount) {
        return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public static Map<String, BigDecimal> buildBaseFare() {
        Map<String, BigDecimal> m = new HashMap<>();

        // Peak fares
        put(m,1,1, CityRideDataset.TimeBand.PEAK,"2.50"); put(m,1,2, CityRideDataset.TimeBand.PEAK,"3.20");
        put(m,1,3, CityRideDataset.TimeBand.PEAK,"3.80"); put(m,1,4, CityRideDataset.TimeBand.PEAK,"4.40");
        put(m,1,5, CityRideDataset.TimeBand.PEAK,"5.00");

        put(m,2,1, CityRideDataset.TimeBand.PEAK,"3.20"); put(m,2,2, CityRideDataset.TimeBand.PEAK,"2.30");
        put(m,2,3, CityRideDataset.TimeBand.PEAK,"3.10"); put(m,2,4, CityRideDataset.TimeBand.PEAK,"3.80");
        put(m,2,5, CityRideDataset.TimeBand.PEAK,"4.50");

        put(m,3,1, CityRideDataset.TimeBand.PEAK,"3.80"); put(m,3,2, CityRideDataset.TimeBand.PEAK,"3.10");
        put(m,3,3, CityRideDataset.TimeBand.PEAK,"2.10"); put(m,3,4, CityRideDataset.TimeBand.PEAK,"3.00");
        put(m,3,5, CityRideDataset.TimeBand.PEAK,"3.70");

        put(m,4,1, CityRideDataset.TimeBand.PEAK,"4.40"); put(m,4,2, CityRideDataset.TimeBand.PEAK,"3.80");
        put(m,4,3, CityRideDataset.TimeBand.PEAK,"3.00"); put(m,4,4, CityRideDataset.TimeBand.PEAK,"2.00");
        put(m,4,5, CityRideDataset.TimeBand.PEAK,"2.90");

        put(m,5,1, CityRideDataset.TimeBand.PEAK,"5.00"); put(m,5,2, CityRideDataset.TimeBand.PEAK,"4.50");
        put(m,5,3, CityRideDataset.TimeBand.PEAK,"3.70"); put(m,5,4, CityRideDataset.TimeBand.PEAK,"2.90");
        put(m,5,5, CityRideDataset.TimeBand.PEAK,"1.90");

        // Off-peak fares
        put(m,1,1, CityRideDataset.TimeBand.OFF_PEAK,"2.00"); put(m,1,2, CityRideDataset.TimeBand.OFF_PEAK,"2.70");
        put(m,1,3, CityRideDataset.TimeBand.OFF_PEAK,"3.20"); put(m,1,4, CityRideDataset.TimeBand.OFF_PEAK,"3.70");
        put(m,1,5, CityRideDataset.TimeBand.OFF_PEAK,"4.20");

        put(m,2,1, CityRideDataset.TimeBand.OFF_PEAK,"2.70"); put(m,2,2, CityRideDataset.TimeBand.OFF_PEAK,"1.90");
        put(m,2,3, CityRideDataset.TimeBand.OFF_PEAK,"2.60"); put(m,2,4, CityRideDataset.TimeBand.OFF_PEAK,"3.20");
        put(m,2,5, CityRideDataset.TimeBand.OFF_PEAK,"3.80");

        put(m,3,1, CityRideDataset.TimeBand.OFF_PEAK,"3.20"); put(m,3,2, CityRideDataset.TimeBand.OFF_PEAK,"2.60");
        put(m,3,3, CityRideDataset.TimeBand.OFF_PEAK,"1.70"); put(m,3,4, CityRideDataset.TimeBand.OFF_PEAK,"2.50");
        put(m,3,5, CityRideDataset.TimeBand.OFF_PEAK,"3.10");

        put(m,4,1, CityRideDataset.TimeBand.OFF_PEAK,"3.70"); put(m,4,2, CityRideDataset.TimeBand.OFF_PEAK,"3.20");
        put(m,4,3, CityRideDataset.TimeBand.OFF_PEAK,"2.50"); put(m,4,4, CityRideDataset.TimeBand.OFF_PEAK,"1.60");
        put(m,4,5, CityRideDataset.TimeBand.OFF_PEAK,"2.40");

        put(m,5,1, CityRideDataset.TimeBand.OFF_PEAK,"4.20"); put(m,5,2, CityRideDataset.TimeBand.OFF_PEAK,"3.80");
        put(m,5,3, CityRideDataset.TimeBand.OFF_PEAK,"3.10"); put(m,5,4, CityRideDataset.TimeBand.OFF_PEAK,"2.40");
        put(m,5,5, CityRideDataset.TimeBand.OFF_PEAK,"1.50");

        return Map.copyOf(m);
    }

    private static void put(Map<String, BigDecimal> m, int from, int to, CityRideDataset.TimeBand band, String amount) {
        m.put(key(from, to, band), money(amount));
    }


    public Config(){
        adultDiscount=new BigDecimal("0.00");
        studentDiscount=new BigDecimal("0.25");
        childDiscount=new BigDecimal("0.50");
        seniorDiscount=new BigDecimal("0.30");

        adultCap=new BigDecimal("8.00");
        studentCap=new BigDecimal("6.00");
        childCap=new BigDecimal("4.00");
        seniorCap=new BigDecimal("7.00");

        BASE_FARE = buildBaseFare();


    }

    public BigDecimal getAdultDiscount(){
        return adultDiscount;
    }
    public BigDecimal getStudentDiscount(){
        return studentDiscount;
    }
    public BigDecimal getChildDiscount(){
        return childDiscount;
    }
    public BigDecimal getSeniorDiscount(){
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

    public void setAdultDiscount(BigDecimal discount){
        this.adultDiscount=discount;
    }
    public void setStudentDiscount(BigDecimal discount){
        this.studentDiscount=discount;
    }
    public void setChildDiscount(BigDecimal discount){
        this.childDiscount=discount;
    }
    public void setSeniorDiscount(BigDecimal discount){
        this.seniorDiscount=discount;
    }

    public void setAdultCap(BigDecimal cap){
        this.adultCap=cap;
    }
    public void setStudentCap(BigDecimal cap){
        this.studentCap=cap;
    }
    public void setChildCap(BigDecimal cap){
        this.childCap=cap;
    }
    public void setSeniorCap(BigDecimal cap){
        this.seniorCap=cap;
    }

    public Map<String, BigDecimal> getBASE_FARE() {
        return BASE_FARE;
    }
    public void setBASE_FARE(int startZone, int endZone, CityRideDataset.TimeBand time, BigDecimal money) {
        BASE_FARE.put(key(startZone,endZone,time),money);
    }


    //adarshr(2012)
    //Function for pretty printing maps
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, BigDecimal>> iter = BASE_FARE.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, BigDecimal> entry = iter.next();
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
