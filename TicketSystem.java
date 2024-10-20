import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TicketSystem {
    private Queue<Ticket> ticketQueue;

    public TicketSystem() {
        ticketQueue = new LinkedList<>();
    }

    public void generateTickets(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            Ticket newTicket = new Ticket();
            ticketQueue.add(newTicket);
            System.out.println("Generated " + newTicket);
            try {
                // Simulate random interval for ticket generation
                Thread.sleep(new Random().nextInt(1000));  // sleep up to one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void processTickets() {
        while (!ticketQueue.isEmpty()) {
            Ticket ticket = ticketQueue.poll();
            System.out.println("Processing " + ticket);
            try {
                // Simulate processing time
                Thread.sleep(new Random().nextInt(1000));  // process time up to one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();
        // Generate tickets
        system.generateTickets(3);  // simulate 3 customers arriving

        // Process all tickets
        system.processTickets();
    }

    public int getQueueSize() {
        return ticketQueue.size();
    }

    public Ticket processNextTicket() {
        return ticketQueue.poll();
    }
}

// Time Complexity:
//O(n): Both generating and processing tickets involve iterating through each ticket once. Since each ticket operation (either generating a ticket or processing a ticket) is considered to be O(1)O(1), the overall time complexity for generating and processing nn tickets is O(n)O(n).
//Space Complexity:
//O(n): The maximum space used by the application is dictated by the queue that holds all generated tickets at once. Since each ticket occupies a fixed amount of space and we are generating nn tickets, the space complexity is linearly proportional to the number of tickets, hence O(n)O(n).
//In summary, the system operates linearly in both time and space with respect to the number of tickets, making it efficient and straightforward for scenarios where the total number of tickets is known and manageable.