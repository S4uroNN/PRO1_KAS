package application.controller;

import application.model.Hotel;
import application.model.Konference;
import storage.Storage;

public class Controller {
    //*--Konference-------------------------------------------------------------------------------------------
    public static Konference createKonference(String navn, String lokation, double pris) {
        Konference konference = new Konference(navn, lokation, pris);
        Storage.addKonference(konference);
        return konference;
    }

    public static void deleteKonference(Konference konference) {
        Storage.removeKonference(konference);
    }

    public static void updateKonference(Konference konference, String navn, String lokation, double pris){
        konference.setLokation(lokation);
        konference.setPris(pris);
        konference.setNavn(navn);

    }
    //*--Konference-------------------------------------------------------------------------------------------
    //*--Hotel------------------------------------------------------------------------------------------------//public static Hotel createHotel()
}
