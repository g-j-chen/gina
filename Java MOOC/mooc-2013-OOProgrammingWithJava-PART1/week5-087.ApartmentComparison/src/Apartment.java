
public class Apartment {

    private int rooms;
    private int squareMeters;
    private int pricePerSquareMeter;

    public Apartment(int rooms, int squareMeters, int pricePerSquareMeter) {
        this.rooms = rooms;
        this.squareMeters = squareMeters;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }
    
    public boolean larger(Apartment otherApartment) {
        if(this.squareMeters > otherApartment.squareMeters) {
            return true;
        }
        return false;
    }
    
    public int priceDifference(Apartment otherApartment) {
        int thisApartmentPrice = this.squareMeters * this.pricePerSquareMeter;
        int otherApartmentPrice = otherApartment.squareMeters * otherApartment.pricePerSquareMeter;
        int difference = Math.abs(thisApartmentPrice - otherApartmentPrice);
        return difference;
    }
    
    public boolean moreExpensiveThan(Apartment otherApartment) {
        int thisApartmentPrice = this.squareMeters * this.pricePerSquareMeter;
        int otherApartmentPrice = otherApartment.squareMeters * otherApartment.pricePerSquareMeter;
        if(thisApartmentPrice > otherApartmentPrice) {
            return true;
        }
        return false;
    }
}
