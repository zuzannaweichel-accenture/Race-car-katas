package tddmicroexercises.turnticketdispenser;

public class TurnTicket
{
    private final int turnNumber;

    public TurnTicket(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getTurnNumber()
    {
        return turnNumber;
    }

    @Override
    public String toString(){
        return this.turnNumber+"";
    }
    public boolean equals(TurnTicket tt){
       int diff = tt.getTurnNumber() - this.turnNumber;
       boolean result = false;
        if (diff == 0 ){
            result = true;
        }
        return result;
    }
}
