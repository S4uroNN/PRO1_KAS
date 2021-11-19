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
    public static void deleteDeltagerFromKonference(Deltager deltager, Konference konference){
        konference.removeDeltager(deltager);
        deltager.removeKonference(konference);
        Storage.removeDeltager(deltager);
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
    public static void addDeltagerToKonference(Deltager deltager, Konference konference){
        konference.addDeltager(deltager);
    }
    public static ArrayList<Deltager> getDeltager(Konference konference){
        return new ArrayList<>(konference.getDeltagere());
    }

    public static Tilmelding createTilmeldning(Deltager deltager,Ledsager ledsager, int days, Hotel hotel, Tilvalg tilvalg, Arrangement arrangement, Konference konference){
        Tilmelding tilmelding = deltager.createTilmelding(days);
        tilmelding.addArrangement(arrangement);
        tilmelding.addKonference(konference);
        konference.addDeltager(deltager);
        tilmelding.addLedsager(ledsager);
        arrangement.addLedsager(ledsager);
        tilmelding.addHotel(hotel);
        tilmelding.addTilvalg(tilvalg);
        return tilmelding;
    }

    //*--Deltager------------------------------------------------------------------------------------------------

    //*--Ledsager------------------------------------------------------------------------------------------------
    public static Ledsager createLedsager(Deltager deltager, String name, int age) {
        Ledsager ledsager = deltager.createLedsager(name, age);
        return ledsager;
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
    public static Arrangement createArrangement(Konference konference,String navn, String lokation, double pris){
       Arrangement arrangement = konference.createArrangemtens(navn, lokation, pris,konference);
       Storage.addArrangements(arrangement);
       return arrangement;
    }
    public static void addArragement(Arrangement arrangement){
        Storage.addArrangements(arrangement);
    }

    public static void deleteArrangement( Arrangement arrangement ,Konference konference) {
        konference.removeArrangenments(arrangement);
        Storage.removeArrangements(arrangement);
    }

    public static void updateArrangement(Arrangement arrangement, String lokation, double pris, Konference konference) {
        arrangement.setLokation(lokation);
        arrangement.setPris(pris);
        arrangement.setKonference(konference);
    }
    public static ArrayList<Arrangement> getArrangement(Konference konference) {
        return konference.getArrangements();
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
    //*--Tilvalg----------------------------------------------------------------------------------------------'
    private static Tilvalg createTilvalg(String info, double pris){
        Tilvalg tilvalg = new Tilvalg(info, pris);
        Storage.addTilvalg(tilvalg);
        return tilvalg;
    }

    //*--Tilvalg----------------------------------------------------------------------------------------------
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
        Konference k3 = Controller.createKonference("Java is Life", "København", 2500);

        Hotel h1 = Controller.createHotel("Hvide Sande",1050);
        Hotel h2 = Controller.createHotel("Hvide Sande",1250);
        Hotel h3 = Controller.createHotel("Hotel Phønix",700);
        Hotel h4 = Controller.createHotel("Hotel Phønix",800);
        Hotel h5 = Controller.createHotel("Penstion Tusindfryd",500);
        Hotel h6 = Controller.createHotel("Penstion Tusindfryd",600);

        Tilvalg t1 = Controller.createTilvalg("Wifi",50);
        Tilvalg t2 = Controller.createTilvalg("Bad",200);
        Tilvalg t3 = Controller.createTilvalg("Mad",100);
        Tilvalg t4 = Controller.createTilvalg("WiFi",75);

        Deltager d1 = Controller.createDeltager("Jan Magnussen", 38,false);
        Deltager d2 = Controller.createDeltager("Lisbeth Jakobsen",38,false);
        Deltager d3 = Controller.createDeltager("Jens Jensen",38, true);

        Ledsager l1 = Controller.createLedsager(d1,"Hanne Sommer",38);
        Ledsager l2 = Controller.createLedsager(d2,"Maibrith Nielsen", 28);

        Arrangement a1 = Controller.createArrangement(k1,"Gåtur" ,"Odense",120);
        Arrangement a2 = Controller.createArrangement(k1,"Akvarie", "Kolding",200);

        Controller.createTilmeldning(d1,l1,6,h1,t1,a1,k1);


    }
    public static void init(){
        initStorage();
    }
}