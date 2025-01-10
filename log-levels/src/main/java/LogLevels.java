public class LogLevels {
    
    public static void main (String[] args) {
        String result = LogLevels.message("[ERROR]: Disk almost full");
        System.out.println(result);
        String level = LogLevels.logLevel("[ERROR]: Unsafe password");
        System.out.println(level);
        level = LogLevels.logLevel("[WARNING]:Unsafe password");
        System.out.println(level);
        level = LogLevels.reformat("[INFO]:Unsafe password");
        System.out.println(level);

    }

    public static String message(String logLine) {
        logLine = (logLine.contains("[ERROR]:")) ? logLine.replace("[ERROR]:", "") : logLine;
        logLine = (logLine.contains("[WARNING]:")) ? logLine.replace("[WARNING]:", "") : logLine;
        logLine = (logLine.contains("[INFO]:")) ? logLine.replace("[INFO]:", "") : logLine;
        return logLine.trim();
    }

    public static String logLevel(String logLine) {
        logLine = (logLine.contains("ERROR")) ? "error" : logLine;
        logLine = (logLine.contains("WARNING")) ? "warning" :  logLine;
        logLine = (logLine.contains("INFO")) ? "info" :  logLine;
        return logLine;
    }

    public static String reformat(String logLine) {
        logLine = String.format("%1$s (%2$s)", message(logLine), logLevel(logLine));        ;
        //logLine = LogLevels.message(logLine) + " " + "(" + LogLevels.logLevel(logLine) + ")";
        return logLine;
    }
}
