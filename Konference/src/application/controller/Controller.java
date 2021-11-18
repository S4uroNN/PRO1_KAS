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

    public static void updateKonference(Konference konference, String navn, String lokation, double pris) {
        konference.setLokation(lokation);
        konference.setPris(pris);
        konference.setNavn(navn);

    }
    public static ArrayList<Konference> getKonferencer(){
        return Storage.getKonferencer();
    }
    //*--Konference-------------------------------------------------------------------------------------------

    //*--Deltager-------------------------------------------------------------------------------------------
    public static Deltager createDeltager(String name, int age, boolean foredragsholder) {
        Deltager deltager = new Deltager(name, age, foredragsholder);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static void deleteDeltager(Deltager deltager) {
        Storage.removeDeltager(deltager);
    }

    public static void updateDeltager(Deltager deltager, String name, int age, boolean foredgagsholder) {
        deltager.setName(name);
        deltager.setAge(age);
        deltager.setForedragsholder(foredgagsholder);
    }
    public void addDeltagerToKonference(Deltager deltager, Konference konference){
        konference.addDeltager(deltager);
    }
    //*--Deltager------------------------------------------------------------------------------------------------

    //*--Ledsager-------------------------------------------------------------------------------------------
    public static void addLedsager(Ledsager ledsager){
        Storage.addLedsager(ledsager);
    }

    public static void deleteLedsager(Ledsager ledsager) {
        Storage.removeLedsager(ledsager);
    }

    public static void updateLedsager(Ledsager ledsager, String name, int age, boolean isLedsager) {
        ledsager.setName(name);
        ledsager.setAge(age);
    }
    //*--Ledsager------------------------------------------------------------------------------------------------

    //*--Foredrag-------------------------------------------------------------------------------------------
    public static Foredrag createForedrag(String emne, int tid, String lokale) {
        Foredrag foredrag = new Foredrag(emne, tid, lokale);
        return foredrag;
    }

    public static void deleteForedrag(Foredrag foredrag) {
        Storage.removeForedrag(foredrag);
    }

    public static void updateForedrag(Foredrag foredrag, String emne, int tid, String lokale) {
        foredrag.setEmne(emne);
        foredrag.setTid(tid);
        foredrag.setLokale(lokale);
    }
    public static void addForedragToKonference(Foredrag foredrag, Konference konference) {
        konference.addForedrag(foredrag);
    }
    //*--Foredrag-----------------------------------------------------------------------------------------------

    //*--Arrangements-----------------------------------------------------------------------------------------------
    public static void addArragement(Arrangement arrangement){
        Storage.addArrangements(arrangement);
    }

    public static void deleteArrangement(Arrangement arrangement) {
        Storage.removeArrangements(arrangement);
    }

    public static void updateArrangement(Arrangement arrangement, String lokation, double pris, Konference konference) {
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

    public static void updateHotel(Konference konference, String navn, String lokation, double pris) {
        konference.setLokation(lokation);
        konference.setPris(pris);
        konference.setNavn(navn);
    }
    //*--Hotel------------------------------------------------------------------------------------------------

    //*--Firma------------------------------------------------------------------------------------------------
    public static Firma createFirma(String cvr, String name) {
        Firma firma = new Firma(cvr, name);
        Storage.addFirma(firma);
        return firma;
    }
    public static void deleteFirma(Firma firma){
        Storage.removeFirma(firma);
    }
    public static void updateFirma(Firma firma, String cvr, String name){
        firma.setCvr(cvr);
        firma.setName(name);
    }
    //*--Firma------------------------------------------------------------------------------------------------

    public static void initStorage(){
        Konference k1 = Controller.createKonference("Hav & Himmel","Odense",1500);
        Konference k2 = Controller.createKonference("V8 for liver","Aarhus", 2000);
        Konference k3 = Controller.createKonference("Java is Life", "København", 2000);


        Deltager d1 = Controller.createDeltager("Jan Magnussen", 38,false);
        Deltager d2 = Controller.createDeltager("Lisbeth Jakobsen",38,false);
        Deltager d3 = Controller.createDeltager("Jens Jensen",38, true);

    }
    public static void init(){
        initStorage();
    }
}