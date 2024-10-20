import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private static int ticketCounter = 1;
    private int ticketNumber;
    private LocalDateTime timestamp;

    public Ticket() {
        this.ticketNumber = ticketCounter++;
        this.timestamp = LocalDateTime.now();
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

    public String toString() {
        return "Ticket Number: " + ticketNumber + ", Time: " + getTimestamp();
    }
}
