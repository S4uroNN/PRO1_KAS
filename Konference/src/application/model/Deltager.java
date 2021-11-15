package application.model;

import javafx.scene.control.skin.TextInputControlSkin;

public class Deltager extends Person {
    private boolean foredragsholder;
    private Ledsager ledsager;
    private Firma firma;
    private Konference konference;
    private Hotel hotel;

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

    public Ledsager getLedsager() {
        return ledsager;
    }

    public void setLedsager(Ledsager ledsager) {
        if (this.ledsager != ledsager) {
            this.ledsager = ledsager;
        }
    }

    public Konference getKonference() {
        return konference;
    }

    public void addKonference(Konference konference) {
        if (this.konference != konference) {
            this.konference = konference;
        }
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            this.hotel = hotel;
        }
    }
    //Link metoder-----------------------------
}

