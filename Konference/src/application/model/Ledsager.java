package application.model;

public class Ledsager extends Person {
    private boolean ledsager;

    public Ledsager(String name, int age, boolean ledsager) {
        super(name, age); //henter fra superklassen
        this.ledsager = ledsager;
    }
    //Getter & Setter---------------------------
    public boolean isLedsager() {
        return ledsager;
    }

    public void setLedsager(boolean ledsager) {
        this.ledsager = ledsager;
    }
}


