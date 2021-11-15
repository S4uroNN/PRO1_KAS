package application.model;

public class Ledsager extends Person {
    private boolean ledsager;
    private Deltager deltager;

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
    //Getter & Setter---------------------------
    //Link metoder -----------------------------
    public Deltager getDeltager(){
        return deltager;
    }
    public void setDeltager(Deltager deltager){
        if(this.deltager != deltager){
            Deltager oldDeltager = this.deltager;
            if(oldDeltager != null){
                oldDeltager.removeLedsager();
            }
        }this.deltager=deltager;
        if(deltager != null){
            deltager.setLedsager(this);
        }
    }
}


