package application.model;

import javafx.scene.control.skin.TextInputControlSkin;

public class Deltager extends Person {
    private boolean foredragsholder;
    private Ledsager ledsager;
    private Firma firma;

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
    //Link Meteder------------------------------
    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        if (this.firma != firma) {
            Firma oldFirma = this.firma;
            if (oldFirma != null) {
                oldFirma.removeDeltager(this);
            }
            this.firma = firma;
            if (firma != null)
                firma.addDeltager(this);
        }
    }
    public Ledsager getLedsager(){
        return ledsager;
    }
    public void setLedsager(Ledsager ledsager){

    }
    //Link metoder-----------------------------
}

