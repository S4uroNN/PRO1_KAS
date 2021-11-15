package application.model;

public class Foredrag {
    private String emne;
    private int tid;
    private String lokale;
    private Konference konference;

    public Foredrag(String emne, int tid, String lokale) {
        this.emne = emne;
        this.tid = tid;
        this.lokale = lokale;
    }

    //Getter & Setter---------------------------
    public String getEmne() {
        return emne;
    }

    public void setEmne(String emne) {
        this.emne = emne;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getLokale() {
        return lokale;
    }

    public void setLokale(String lokale) {
        this.lokale = lokale;
    }

    //Getter & Setter-----------------------------------
    //Link Metoder--------------------------------------
    public Konference getKonference() {
        return konference;
    }

    public void setKonference(Konference konference) {
        if (this.konference != konference) {
            Konference oldKonference = this.konference;
            if (oldKonference != null) {
                oldKonference.removeForedrag(this);
            }
            this.konference = konference;
            if (konference != null)
                konference.addForedrag(this);
        }
    }
    //Link Metoder---------------------------------------
}