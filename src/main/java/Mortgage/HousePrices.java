package Mortgage;

public class HousePrices extends Users {
    private int price;
    public HousePrices(String username, String whichCondtiton, String houseType, int roomCount, int downPayment, int longTerm, StatesTax stateTax) {
        super(username, whichCondtiton, houseType, roomCount, downPayment, longTerm, stateTax);

        roomCountToPrice();
        conditionToPrice();
        houseTypeToPrice();
        calculateTax();
    }
    public void roomCountToPrice() {
        switch (getRoomCount()) {
            case 0:
                price += 10000;
                break;
            case 1:
                price += 20000;
                break;
            case 2:
                price += 30000;
                break;
            case 3:
                price += 40000;
                break;
            case 4:
                price += 50000;
                break;
            case 5:
                price += 60000;
                break;
        }
    }
    public void conditionToPrice() {
        switch (getWhichCondtiton()) {
            case "new":
                price += 50000;
                break;
            case "Like New":
                price += 40000;
                break;
            case "Old":
                price += 30000;
                break;
            case "Renew Required":
                price += 15000;
                break;
        }
    }
    public void houseTypeToPrice() {
        switch (getHouseType()) {
            case "Apartment":
                price += 20000;
                break;
            case "condo":
                price += 30000;
                break;
            case "House":
                price += 40000;
                break;
        }
    }
    public void calculateTax() {
        price += ((price * getStateTax().getTax()) / 100);
    }
    public int getPriceTotal() {
        return price;
    }
    public int getPriceEachMonth() {
        int pesinat=(price-getDownPayment());
        return (pesinat / getLongTerm());
    }

}




