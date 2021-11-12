package application.model;

public class Firma {
    private String cvr;
    private String name;


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
}
