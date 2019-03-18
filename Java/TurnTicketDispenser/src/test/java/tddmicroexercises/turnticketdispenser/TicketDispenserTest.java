package tddmicroexercises.turnticketdispenser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class TicketDispenserTest {

    private TicketDispenser dispenser;
    @Before
    public void setup(){
        dispenser = new TicketDispenser();
    }
    @After
    public void teardown(){
        dispenser.resetDispenser();
    }

    @Test
    public void getTicket(){
        TurnTicket ticket = new TurnTicket(1);

        dispenser.getTurnTicket();

        assertTrue(ticket.equals(dispenser.getTurnTicket()));
    }

    @Test
    public void twoDispencers_diferentNumbers(){
        TicketDispenser dispenser1 = new TicketDispenser();
        TicketDispenser dispenser2 = new TicketDispenser();

        TurnTicket ticket1 = new TurnTicket(0);
        TurnTicket ticket2 = new TurnTicket(1);

        assertTrue(ticket1.equals(dispenser1.getTurnTicket()));
        assertTrue(ticket2.equals(dispenser2.getTurnTicket()));
    }

    @Test
    public void manyDispensers_rightTickets(){
        TicketDispenser dispenser1 = new TicketDispenser();
        TicketDispenser dispenser2 = new TicketDispenser();
        TurnTicket ticket1 = new TurnTicket(2);
        TurnTicket ticket2 = new TurnTicket(5);

        dispenser1.getTurnTicket();
        dispenser2.getTurnTicket();

        assertTrue(ticket1.equals(dispenser1.getTurnTicket()));

        dispenser1.getTurnTicket();
        dispenser2.getTurnTicket();

        assertTrue(ticket2.equals(dispenser2.getTurnTicket()));
    }
}
