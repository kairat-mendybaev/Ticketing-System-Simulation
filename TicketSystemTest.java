import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketSystemTest {

    private TicketSystem system;

    @BeforeEach
    public void setUp() {
        system = new TicketSystem();
    }

    @Test
    public void testUniqueTicketNumberGeneration() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        assertNotEquals(ticket1.getTicketNumber(), ticket2.getTicketNumber(), "Ticket numbers should be unique");
    }

    @Test
    public void testTimestampCreation() {
        Ticket ticket = new Ticket();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        assertNotNull(ticket.getTimestamp(), "Timestamp should not be null");
        assertDoesNotThrow(() -> LocalDateTime.parse(ticket.getTimestamp(), formatter), "Timestamp should be in the correct format");
    }

    @Test
    public void testAddingTicketsToQueue() {
        system.generateTickets(1);
        assertEquals(1, system.getQueueSize(), "Queue should have 1 ticket after generation");
    }

    @Test
    public void testQueueSizeAfterGeneration() {
        int numberOfTickets = 5;
        system.generateTickets(numberOfTickets);
        assertEquals(numberOfTickets, system.getQueueSize(), "Queue size should match the number of generated tickets");
    }

    @Test
    public void testFIFOOrderProcessing() {
        system.generateTickets(3);
        Ticket firstTicket = system.processNextTicket();
        Ticket secondTicket = system.processNextTicket();
        assertTrue(firstTicket.getTicketNumber() < secondTicket.getTicketNumber(), "Tickets should be processed in FIFO order");
    }

    @Test
    public void testTicketProcessingCompleteness() {
        system.generateTickets(3);
        while (system.getQueueSize() > 0) {
            system.processNextTicket();
        }
        assertEquals(0, system.getQueueSize(), "Queue should be empty after processing all tickets");
    }
}
