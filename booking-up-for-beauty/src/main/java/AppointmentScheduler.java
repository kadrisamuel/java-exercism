import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();
        String toPrintStr = scheduler.schedule("7/25/2019 13:45:00").toString();
        System.out.println(toPrintStr);
        System.out.println(scheduler.getDescription(LocalDateTime.of(2019, 03, 29, 15, 0, 0)));

    }
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, formatter);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();
        return (hour >= 12 && hour < 18);
    }

    public String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'You have an appointment on' EEEE, MMMM dd, yyyy, 'at' h:mm a.");
        return appointmentDate.format(formatter);
        
    }

    public LocalDate getAnniversaryDate() {
        //// => LocalDate.of(<current year>, 9, 15)
        return LocalDate.of(LocalDate.now().getYear(), 9, 15);
    }
}
