package application.model;

public class Arrangement {
    private String lokation;
    private double pris;

    public Arrangement(String lokation, double pris) {
        this.lokation = lokation;
        this.pris = pris;
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
    //Getter & Setter---------------------------
}
