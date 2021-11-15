package application.model;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private double pris;
    private final ArrayList<Deltager> deltagere = new ArrayList<>();
    private final ArrayList<Ledsager> ledsagere = new ArrayList<>();

    public Hotel(String name, double pris) {
        this.name = name;
        this.pris = pris;
    }

    //Getter & Setter---------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    //Getter & Setter---------------------------
    //Link metoder -----------------------------
    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public void addDeltager(Deltager deltager) {
        if (!deltagere.contains(deltager)) {
            deltagere.add(deltager);
            deltager.setHotel(this);
        }
    }



    public ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }

    public void addDeltager(Ledsager ledsager) {
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
            ledsager.setHotel(this);
        }
    }

    //Link metoder -----------------------------

}
