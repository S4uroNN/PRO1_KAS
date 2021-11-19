package storage;

import application.model.*;

import java.awt.image.AreaAveragingScaleFilter;

import java.lang.reflect.Array;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private static ArrayList<Foredrag> foredrages = new ArrayList<>();
    private static ArrayList<Arrangement> arrangements = new ArrayList<>();
    private static ArrayList<Hotel> hotels = new ArrayList<>();
    private static ArrayList<Firma> firmas = new ArrayList<>();
    private static ArrayList<Tilvalg> tilvalgs = new ArrayList<>();

    //Konference
    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<Konference>(konferencer);
    }

    public static void addKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void removeKonference(Konference konference) {
        konferencer.remove(konference);
    }

    //konference
    //Deltager
    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<Deltager>(deltagere);
    }

    public static void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    //Deltager
    //Ledsager
    public static ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<Ledsager>(ledsagere);
    }

    public static void addLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);
    }

    public static void removeLedsager(Ledsager ledsager) {
        ledsagere.remove(ledsager);
    }

    //Deltager
    //Foredrag
    public static ArrayList<Foredrag> getForedrages() {
        return new ArrayList<Foredrag>(foredrages);
    }

    public static void addForedrag(Foredrag foredrag) {
        foredrages.add(foredrag);
    }

    public static void removeForedrag(Foredrag foredrag) {
        foredrages.remove(foredrag);
    }

    //Foredrag
    //Arrangements
    public static ArrayList<Arrangement> getArrangements() {
        return new ArrayList<Arrangement>(arrangements);
    }

    public static void addArrangements(Arrangement arrangement) {
        arrangements.add(arrangement);
    }
    public static void removeArrangements(Arrangement arrangement){
        arrangements.remove(arrangement);
    }
    //Arrangements
    //Tilvalg
    public static ArrayList<Tilvalg> getTilvalgs(){
        return new ArrayList<Tilvalg>(tilvalgs);
    }
    public static void addTilvalg(Tilvalg tilvalg){
        tilvalgs.add(tilvalg);
    }
    public static void removeTilvalg(Tilvalg tilvalg){
        tilvalgs.remove(tilvalg);
    }
    //Tilvalg
    //Hotel

    public static ArrayList<Hotel> getHotels(){
        return new ArrayList<Hotel>(hotels);
    }
    public static void addHotels(Hotel hotel){
        hotels.add(hotel);
    }
    public static void removeHotel(Hotel hotel){
        hotels.remove(hotel);
    }
    //Hotel
    //Firma
    public static ArrayList<Firma> getFirmas(){
        return new ArrayList<Firma>(firmas);
    }
    public static void addFirma(Firma firma){
        firmas.add(firma);
    }
    public static void removeFirma(Firma firma){
        firmas.remove(firma);
    }
    //Firma
}
