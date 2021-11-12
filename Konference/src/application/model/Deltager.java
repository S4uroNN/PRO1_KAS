package application.model;

public class Deltager extends Person {
    private boolean foredragsholder;

    public Deltager(String name, int age, boolean foredragsholder) {
        super(name, age); //henter fra superklassen
        this.foredragsholder = foredragsholder;
    }
    //Getter & Setter---------------------------
    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }
    //Getter & Setter---------------------------

}
