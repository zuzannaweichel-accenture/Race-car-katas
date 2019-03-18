package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TurnTicketTest {

    @Test
    public void getNumber_returnPassedInNumber(){
        int seven = 7;
        TurnTicket tt = new TurnTicket(seven);

        assertEquals(seven, tt.getTurnNumber());
    }
}
