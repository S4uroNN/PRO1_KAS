package application.model;

public class Konference {
    private int tid;
    private String lokation;
    private double pris;

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
    //Getter & Setter---------------------------

}
