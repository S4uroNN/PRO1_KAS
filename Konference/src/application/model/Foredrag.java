package application.model;

public class Foredrag {
    private String emne;
    private int tid;
    private String lokale;

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
    //Getter & Setter---------------------------
}
