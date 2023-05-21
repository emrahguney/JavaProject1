package Mortgage;

public class Users {
    private String username;
    private String whichCondtiton;
    private String houseType;
    private int roomCount;
    private int downPayment;
    private int longTerm;
    private StatesTax stateTax;

    public Users(String username, String whichCondtiton, String houseType, int roomCount, int downPayment, int longTerm, StatesTax stateTax) {
        this.username = username;
        this.whichCondtiton = whichCondtiton;
        this.houseType = houseType;
        this.roomCount = roomCount;
        this.downPayment = downPayment;
        this.longTerm = longTerm;
        this.stateTax = stateTax;
    }

    public String getUsername() {
        return username;
    }

    public String getWhichCondtiton() {
        return whichCondtiton;
    }

    public String getHouseType() {
        return houseType;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getDownPayment() {
        return downPayment;
    }

    public int getLongTerm() {
        return longTerm;
    }

    public StatesTax getStateTax() {
        return stateTax;
    }

}

