package application.controller;

import application.model.*;
import storage.Storage;

import java.util.ArrayList;

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

    //*--Deltager-------------------------------------------------------------------------------------------
    public static Deltager createDeltager(String name, int age, boolean foredragsholder){
        Deltager deltager = new Deltager(name, age, foredragsholder);
        Storage.addDeltager(deltager);
        return deltager;
    }
    public static void deleteDeltager(Deltager deltager){
        Storage.removeDeltager(deltager);
    }
    public static void updateDeltager(Deltager deltager, String name, int age, boolean foredgagsholder){
        deltager.setName(name);
        deltager.setAge(age);
        deltager.setForedragsholder(foredgagsholder);
    }
    //*--Deltager------------------------------------------------------------------------------------------------

    //*--Ledsager-------------------------------------------------------------------------------------------
    public static Ledsager createLedsager(String name, int age, boolean isLedsager){
        Ledsager ledsager = new Ledsager(name, age, isLedsager);
        return ledsager;
    }
    public static void deleteLedsager(Ledsager ledsager){
        Storage.removeLedsager(ledsager);
    }
    public static void updateLedsager(Ledsager ledsager, String name, int age, boolean isLedsager){
        ledsager.setName(name);
        ledsager.setAge(age);
        ledsager.setLedsager(isLedsager);
    }
    //*--Ledsager------------------------------------------------------------------------------------------------

    //*--Foredrag-------------------------------------------------------------------------------------------
    public static Foredrag createForedrag(String emne, int tid, String lokale) {
        Foredrag foredrag = new Foredrag(emne, tid, lokale);
        return foredrag;
    }
    public static void deleteForedrag(Foredrag foredrag){
        Storage.removeForedrag(foredrag);
    }
    public static void updateForedrag(Foredrag foredrag, String emne, int tid, String lokale){
        foredrag.setEmne(emne);
        foredrag.setTid(tid);
        foredrag.setLokale(lokale);
    }
    //*--Foredrag-----------------------------------------------------------------------------------------------

    //*--Arrangements-----------------------------------------------------------------------------------------------
    public static Arrangement createArrangement(String lokation, double pris, Konference konference){
        Arrangement arrangement = new Arrangement(lokation, pris, konference);
        return arrangement;
    }
    public static void deleteArrangement(Arrangement arrangement){
        Storage.removeArrangements(arrangement);
    }
    public static void updateArrangement(Arrangement arrangement, String lokation, double pris, Konference konference){
        arrangement.setLokation(lokation);
        arrangement.setPris(pris);
        arrangement.setKonference(konference);
    }
    //*--Arrangements------------------------------------------------------------------------------------------------

    //*--Hotel------------------------------------------------------------------------------------------------
    public static Hotel createHotel(String name, double pris) {
        Hotel hotel = new Hotel(name, pris);
        Storage.addHotels(hotel);
        return hotel;
    }
    public static void deleteHotel(Hotel hotel) {
        Storage.removeHotel(hotel);
    }
    public static void updateHotel(Konference konference, String navn, String lokation, double pris){
        konference.setLokation(lokation);
        konference.setPris(pris);
        konference.setNavn(navn);
    }
    //*--Hotel------------------------------------------------------------------------------------------------

    //*--Firma------------------------------------------------------------------------------------------------
    public static Firma createFirma(String cvr, String name){
        Firma firma = new Firma(cvr, name);
        Storage.addFirma(firma);
        return firma;
    }
    //*--Firma------------------------------------------------------------------------------------------------

}
