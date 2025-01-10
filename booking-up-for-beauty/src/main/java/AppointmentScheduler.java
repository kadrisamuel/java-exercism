import java.time.LocalDate;
import java.time.LocalDateTime;

class AppointmentScheduler {
    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();
        System.out.println(scheduler.schedule("7/25/2019 13:45:00"));
    }
    public LocalDateTime schedule(String appointmentDateDescription) {
        LocalDateTime parsed = LocalDateTime.parse(appointmentDateDescription.replace(' ', 'T' ));
        return parsed;
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        throw new UnsupportedOperationException("Please implement the AppointmentScheduler.hasPassed() method");
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        throw new UnsupportedOperationException("Please implement the AppointmentScheduler.isAfternoonAppointment() method");
    }

    public String getDescription(LocalDateTime appointmentDate) {
        throw new UnsupportedOperationException("Please implement the AppointmentScheduler.getDescription() method");
    }

    public LocalDate getAnniversaryDate() {
        throw new UnsupportedOperationException("Please implement the AppointmentScheduler.getAnniversaryDate() method");
    }
}
