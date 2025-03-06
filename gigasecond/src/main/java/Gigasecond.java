import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private final static long GIGA_SECOND = 1_000_000_000;
    private final LocalDateTime datetime;

    public Gigasecond(LocalDate moment) {
        this.datetime = moment.atStartOfDay();
    }

    public Gigasecond(LocalDateTime moment) {
        this.datetime = moment;
    }

    public LocalDateTime getDateTime() {
        return this.datetime.plusSeconds(GIGA_SECOND);
    }
}