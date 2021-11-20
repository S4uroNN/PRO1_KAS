package application.model;

import java.util.ArrayList;

public class Hotel {
    private String name;
    private double pris;
    private final ArrayList<Deltager> deltagere = new ArrayList<>();
    private final ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private final ArrayList<Tilvalg> tilvalgs = new ArrayList<>();

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

    @Override
    public String toString() {
        return name + " " + pris;
    }

    //Getter & Setter---------------------------
    //Link metoder -----------------------------
    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<Deltager>(deltagere);
    }

    public void addDeltager(Deltager deltager) {
        if (!deltagere.contains(deltager)) {
            deltagere.add(deltager);
            deltager.setHotel(this);
        }
    }

    public void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
        deltager.removeHotel(this);
    }


    public ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }

    public void addLedsager(Ledsager ledsager) {
        if (!ledsagere.contains(ledsager)) {
            ledsagere.add(ledsager);
            ledsager.setHotel(this);
        }
    }

    public void removeLedsager(Ledsager ledsager) {
        deltagere.remove(ledsager);
        ledsager.removeHotel(this);
    }

    public ArrayList<Tilvalg> getTilvalgs() {
        return new ArrayList<>(tilvalgs);
    }

    public void addTilvalg(Tilvalg tilvalg) {
        if (!tilvalgs.contains(tilvalg)) {
            tilvalgs.add(tilvalg);
            tilvalg.addHotel(this);
        }
    }

    public void removeTilvalg(Tilvalg tilvalg) {
        tilvalgs.remove(tilvalg);
        tilvalg.removeHotel();
    }

    //Link metoder -----------------------------
}

