import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

final public class CityRideDataset {
    private CityRideDataset() {}

    public static final int MIN_ZONE = 1;
    public static final int MAX_ZONE = 5;
    public static Config config = ConfigFileHandler.loadConfig();

    public enum TimeBand {
        PEAK,
        OFF_PEAK
    }

    public enum PaymentMethod {
        CARD,
        CASH
    }

    public enum PassengerType {
        ADULT,
        STUDENT,
        CHILD,
        SENIOR_CITIZEN
    }

    public static Map<PassengerType, BigDecimal> DISCOUNT_RATE = Map.of(
            PassengerType.ADULT, config.getAdultDiscount(),
            PassengerType.STUDENT, config.getStudentDiscount(),
            PassengerType.CHILD, config.getChildDiscount(),
            PassengerType.SENIOR_CITIZEN, config.getSeniorDiscount()
    );

    public static final Map<PassengerType, BigDecimal> DAILY_CAP = Map.of(
            PassengerType.ADULT, config.getAdultCap(),
            PassengerType.STUDENT, config.getStudentCap(),
            PassengerType.CHILD, config.getChildCap(),
            PassengerType.SENIOR_CITIZEN, config.getSeniorCap()
    );

    public static final Map<String, BigDecimal> BASE_FARE = config.getBASE_FARE();

    public static BigDecimal getBaseFare(int fromZone, int toZone, TimeBand timeBand) {
        return BASE_FARE.get(key(fromZone, toZone, timeBand));
    }

    public static String key(int fromZone, int toZone, TimeBand timeBand) {
        return fromZone + "-" + toZone + "-" + timeBand.name();
    }


}


