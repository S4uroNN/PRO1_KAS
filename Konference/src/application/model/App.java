package application.model;

import application.controller.Controller;

public class App {
    public static void main(String[] args) {
        Konference k1 = new Konference("Hav & Himmel", "Odense",1500);
        Hotel h1 = new Hotel("Hvide svane",1050);
        Hotel h2 = new Hotel("Hvide svane m wifi",1250);


        Tilvalg til1 = new Tilvalg("Wifi",50);
        Tilvalg til1_1=new Tilvalg("Wifi",75);
        Tilvalg til2 = new Tilvalg("Bad",200);
        Tilvalg til3 = new Tilvalg("Morgenmad", 100);

        h2.addTilvalg(til1);

        Arrangement a1 = k1.createArrangemtens("Egeskov",75, k1);
        Arrangement a2 = k1.createArrangemtens("Trapholt",200, k1);
        Arrangement a3 = k1.createArrangemtens("Byrundtur",125, k1);

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
        Ledsager l1 = new Ledsager("Mie Sommer", 18);

        Tilmelding t3 = d3.createTilmelding(3);
        t3.addKonference(k1);
        t3.addHotel(h2);
        t3.addArrangement(a1);
        t3.addArrangement(a2);
        t3.addTilvalg(til1);
        a1.addLedsager(l1);
        a2.addLedsager(l1);
        System.out.println(t3.beregnPris());

        Deltager d4 = new Deltager("Lone Jensen", 50,true);
        Ledsager l2 = new Ledsager("Jan Madsen", 25);
        Tilmelding t4 = d4.createTilmelding(3);
        t4.addKonference(k1);
        t4.addLedsager(l2);
        t4.addArrangement(a1);
        t4.addArrangement(a3);
        t4.addTilvalg(til1);
        t4.addHotel(h2);

        System.out.println(t4.beregnPris());

        for(Tilvalg s : t4.getTilvalgs()){
            System.out.println(s.getInfo());
        }

        Controller.createFirma("99999","EAAA");
        Konference k2 = Controller.createKonference("Miljø2","Odense",1500);
        Foredrag f1 = Controller.createForedrag("Miljø",12,"Lokale 12C");
        Arrangement arrangement = k2.createArrangemtens("Odense",125, k2);
        Hotel hotel = Controller.createHotel("Hvide",1250);
        Controller.addForedragToKonference(f1,k1);
        Deltager deltager = Controller.createDeltager("Jens poulsen",58,false);
        Ledsager l5 = deltager.createLedsager("Lisbeth",58);
        Tilmelding t5 = deltager.createTilmelding(3);
        t5.addKonference(k2);
        t5.addHotel(hotel);
        t5.addLedsager(l5);
        t5.addTilvalg(til1);
        t5.addArrangement(arrangement);

        System.out.println(t5.beregnPris());
    }
}



