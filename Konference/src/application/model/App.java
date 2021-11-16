package application.model;

import javax.swing.*;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Konference k1 = new Konference("Hav & Himmel", "Odense",1500);
        Hotel h1 = new Hotel("Hvide svane",1050);
        Hotel h2 = new Hotel("Hvide svane m wifi",1300);

        Arrangement a1 = k1.createArrangemtens("Egeskov",75);
        Arrangement a2 = k1.createArrangemtens("Trapholt",200);
        Arrangement a3 = k1.createArrangemtens("Byrundtur",125);

        Deltager d1 = new Deltager("Finn Madsen", 25,false);
        Tilmelding t1 = d1.createTilmelding(3);
        t1.addKonference(k1);
        System.out.println(t1.beregnPris());

        Deltager d2 =new Deltager("Niels Pedersen",69,false);
        Tilmelding t2 = d2.createTilmelding(3);
        t2.addKonference(k1);
        t2.addHotel(h1);
        System.out.println(t2.beregnPris());

        Deltager d3 = new Deltager("Peter Sommer", 30,false);
        Ledsager l1 = new Ledsager("Mie Sommer", 18,true);

        Tilmelding t3 = d3.createTilmelding(3);
        t3.addKonference(k1);
        t3.addHotel(h2);
        t3.addArrangement(a1);
        t3.addArrangement(a2);
        a1.addLedsager(l1);
        a2.addLedsager(l1);
        System.out.println(t3.beregnPris());

        Deltager d4 = new Deltager("Lone Jensen", 50,true);
        Ledsager l2 = new Ledsager("Jan Madsen", 25,true);
        Tilmelding t4 = d4.createTilmelding(3);
        t4.addKonference(k1);
        t4.addLedsager(l2);
        t4.addArrangement(a1);
        t4.addArrangement(a3);
        t4.addHotel(h2);

        System.out.println(t4.beregnPris());



    }
}
