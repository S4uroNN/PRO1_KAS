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
    private static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<Deltager>(deltagere);
    }

    private static void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    private static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    //Deltager
    //Ledsager
    private static ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<Ledsager>(ledsagere);
    }

    private static void addLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);
    }

    private static void removeLedsager(Ledsager ledsager) {
        ledsagere.remove(ledsager);
    }

    //Deltager
    //Foredrag
    private static ArrayList<Foredrag> getForedrages() {
        return new ArrayList<Foredrag>(foredrages);
    }

    private static void addForedrag(Foredrag foredrag) {
        foredrages.add(foredrag);
    }

    private static void removeForedrag(Foredrag foredrag) {
        foredrages.remove(foredrag);
    }

    //Foredrag
    //Arrangements
    private static ArrayList<Arrangement> getArrangements() {
        return new ArrayList<Arrangement>(arrangements);
    }

    private static void addArrangements(Arrangement arrangement) {
        arrangements.add(arrangement);
    }
    private static void removeArrangements(Arrangement arrangement){
        arrangements.remove(arrangement);
    }
    //Arrangements
    //Hotel


    //Hotel
    //Firma

    private static ArrayList<Hotel> getHotels(){
        return new ArrayList<Hotel>(hotels);
    }
    private static void addHotels(Hotel hotel){
        hotels.add(hotel);
    }
    private static void removeHotel(Hotel hotel){
        hotels.remove(hotel);
    }
    //Hotel
    //Firma
    private static ArrayList<Firma> getFirmas(){
        return new ArrayList<Firma>(firmas);
    }
    private static void addFirma(Firma firma){
        firmas.add(firma);
    }
    private static void removeFirma(Firma firma){
        firmas.remove(firma);
    }
    //Firma
}
