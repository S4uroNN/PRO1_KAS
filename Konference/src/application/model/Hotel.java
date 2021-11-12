package application.model;

public class Hotel {
    private String name;
    private double pris;

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
    //Getter & Setter---------------------------

}
