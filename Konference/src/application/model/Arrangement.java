package application.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Arrangement {
    private String lokation;
    private double pris;
    private Konference konference;
    private final ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private final ArrayList<Tilmelding> tilmeldninger = new ArrayList<>();

    Arrangement(String lokation, double pris,Konference konference) {
        this.lokation = lokation;
        this.pris = pris;
        this.konference = konference;
    }

    //Getter & Setter---------------------------
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
    public Konference getKonference(){
        return konference;
    }
    //Getter & Setter---------------------------
    //Link attributter--------------------------
    public ArrayList<Ledsager> getLedsagere(){
        return new ArrayList<Ledsager>(ledsagere);
    }
    public void addLedsager(Ledsager ledsager){
        if(!ledsagere.contains(ledsager)){
            ledsagere.add(ledsager);
            ledsager.addArrangements(this);
        }
    }
    public void removeLedsager(Ledsager ledsager){
        if(ledsagere.contains(ledsager)){
            ledsagere.remove(ledsager);
            ledsager.removeArrangements(this);
        }
    }
    public void addTilmelding (Tilmelding tilmelding){
        if(!tilmeldninger.contains(tilmelding)){
            tilmeldninger.add(tilmelding);
            tilmelding.addArrangement(this);
        }
    }
    //Link attributter--------------------------
}
