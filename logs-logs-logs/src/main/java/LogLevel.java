public enum LogLevel {
    UNKNOWN("", 0),
    TRACE("TRC", 1),
    DEBUG("DBG", 2),
    INFO("INF", 4),
    WARNING("WRN", 5),
    ERROR("ERR", 6),
    FATAL("FTL", 42);


    private final String abbreviation;
    private final int shortLog;

    LogLevel(String abbreviation, int shortLog) {
        this.abbreviation = abbreviation;
        this.shortLog = shortLog;
    }
    public String getAbbreviation() {
        return abbreviation;
    }

    public int getShortLog() {
        return shortLog;
    }

}
