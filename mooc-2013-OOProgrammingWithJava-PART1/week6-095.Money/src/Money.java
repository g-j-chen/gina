
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    @Override
    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }
    
    public Money plus(Money added) {
        int sumEuros = this.euros + added.euros;
        int sumCents = this.cents + added.cents;
        return new Money(sumEuros, sumCents);
        
    }
    
    public boolean less(Money compared) {
        if (this.euros < compared.euros) {
            return true;
        }
        if (this.euros == compared.euros) {
            if (this.cents < compared.cents) {
                return true;
            } else {
                return false;
            }
        }
        return false;
        //return (100 * this.euros + cents) < (100 * compared.euros + compared.cents);
    }
    
    public Money minus(Money decremented) {
        int sumEuros = this.euros - decremented.euros;
        int sumCents = this.cents - decremented.cents;
        if (sumCents < 0) {
            sumEuros -= 1;
            sumCents = 100 + sumCents;
        }
        if (sumEuros < 0) {
            return new Money(0,0);
        }
        return new Money(sumEuros, sumCents);
    }

}
