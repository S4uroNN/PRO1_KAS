package application.model;

import java.util.ArrayList;

public class Konference {
    private int tid;
    private String lokation;
    private double pris;
    private final ArrayList<Foredrag> foredrags = new ArrayList<>();

    public Konference(int tid, String lokation, double pris) {
        this.tid = tid;
        this.lokation = lokation;
        this.pris = pris;
    }

    //Getter & Setter---------------------------
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getLokation() {
        return lokation;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    //Getter & Setter-----------------------------
    //Link metoder--------------------------------
    public ArrayList<Foredrag> getForedrags() {
        return new ArrayList<>(foredrags);
    }

    public void addForedrag(Foredrag foredrag) {
        if (!foredrags.contains(foredrag)) {
            foredrags.add(foredrag);
            foredrag.setKonference(this);
        }
    }

    public void removeForedrag(Foredrag foredrag) {
        if (foredrags.contains(foredrag)) {
            foredrags.remove(foredrag);
        }
    }
    //Link metoder----------------------------------

}
