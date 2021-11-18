package application.model;


import java.util.ArrayList;

public class Ledsager extends Person {
    private Deltager deltager;
    private final ArrayList<Arrangement> arrangements = new ArrayList<>();
    private Hotel hotel;

    public Ledsager(String name, int age) {
        super(name, age); //henter fra superklassen
    }

    //Getter & Setter---------------------------
//    //public boolean isLedsager() {
//        return ledsager;
//    }
//
//    //public void setLedsager(boolean ledsager) {
//        this.ledsager = ledsager;
//    }

    //Getter & Setter---------------------------
    //Link metoder -----------------------------
    public Deltager getDeltager() {
        return deltager;
    }

    public void setDeltager(Deltager deltager) {
        if (this.deltager != deltager) {
            this.deltager = deltager;
        }
    }

    public ArrayList<Arrangement> getArrangements(){
        return new ArrayList<>(arrangements);
    }

    public void addArrangements(Arrangement arrangement){
        if(!arrangements.contains(arrangement)){
            arrangements.add(arrangement);
            arrangement.addLedsager(this);
        }
    }
    public void removeArrangements(Arrangement arrangement){
        arrangements.remove(arrangement);
        arrangement.removeLedsager(this);
    }
    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            this.hotel = hotel;
        }
    }
    public void removeHotel(Hotel hotel) {
        if (this.hotel == hotel) {
            this.hotel = null;
        }
    }
    //Link metoder------------------------------
}



