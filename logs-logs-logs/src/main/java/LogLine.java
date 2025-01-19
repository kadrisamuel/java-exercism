public class LogLine {
    private final String logLine;

    public static void main(String[] args) {
        var logLine = new LogLine("[ERR]: File deleted");
        System.out.println(logLine.getLogLevel());
        System.out.println(logLine.getOutputForShortLog());
    }

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {

        for (LogLevel l : LogLevel.values()) {
            if (l.getAbbreviation().equals(logLine.substring(1, 4))) {
                return l;
            }
        }
        return LogLevel.UNKNOWN;
    }

    public String getOutputForShortLog() {
        return getLogLevel().getShortLog() + ":" + logLine.substring(7);
    }
}
