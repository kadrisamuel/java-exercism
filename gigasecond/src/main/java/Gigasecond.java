import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private final static long GIGA_SECOND = 1_000_000_000;
    private final LocalDateTime futureTime;

    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.futureTime = moment.plusSeconds(GIGA_SECOND);
    }

    public LocalDateTime getDateTime() {
        return this.futureTime;
    }
}