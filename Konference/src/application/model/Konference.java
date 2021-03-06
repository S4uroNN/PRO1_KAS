package application.model;

import java.util.ArrayList;

public class Konference {


    private String navn;
    private String lokation;
    private double pris;
    private final ArrayList<Foredrag> foredrags = new ArrayList<>();
    private final ArrayList<Arrangement> arrangements = new ArrayList<>();
    private final ArrayList<Deltager> deltagere = new ArrayList<>();

    public Konference(String navn, String lokation, double pris) {
        this.navn = navn;
        this.lokation = lokation;
        this.pris = pris;
    }

    //Getter & Setter---------------------------
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
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

    @Override
    public String toString() {
        return navn + " (" + pris + " kroner)";
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
    public ArrayList<Arrangement> getArrangements(){
        return new ArrayList<>(arrangements);
    }

    public Arrangement createArrangemtens(String navn, String lokation, double pris, Konference konference){
        Arrangement arrangement = new Arrangement(navn,lokation, pris,this);
        arrangements.add(arrangement);
        return arrangement;
    }
    public void removeArrangenments(Arrangement arrangement){
        arrangements.remove(arrangement);
    }
    public ArrayList<Deltager> getDeltagere(){
        return new ArrayList<>(deltagere);
    }

    public void addDeltager(Deltager deltager){
        if(!deltagere.contains(deltager)){
            deltagere.add(deltager);
            deltager.addKonference(this);
        }
    }
    public void removeDeltager(Deltager deltager){
        deltagere.remove(deltager);
        deltager.removeKonference(this);
    }
    //Link metoder----------------------------------

}
