package application.model;

import java.util.ArrayList;

public class Firma {
    private String cvr;
    private String name;

    private final ArrayList<Deltager> deltagere = new ArrayList<>();


    public Firma(String cvr, String name) {
        this.cvr = cvr;
        this.name = name;
    }

    //Getter & Setter---------------------------
    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getter & Setter---------------------------
    //Link metoder------------------------------
    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>();
    }
    public void addDeltager(Deltager deltager){
        if(!deltagere.contains(deltager)){
            deltagere.add(deltager);
            deltager.setFirma(this);
        }
    }
    public void removeDeltager(Deltager deltager){
        if(deltagere.contains(deltager)){
            deltagere.remove(deltager);
        }
    }

}
