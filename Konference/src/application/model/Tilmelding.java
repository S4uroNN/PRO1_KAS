package application.model;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Tilmelding {
    private int attendingDays;
    private double pris;

    private Hotel hotel;
    private Ledsager ledsager;
    private Deltager deltager;
    private Konference konference;
    private final ArrayList<Arrangement> arrangements = new ArrayList<>();
    private final ArrayList<Tilvalg> tilvalgs = new ArrayList<>();

    public Tilmelding(int attendingDays) {
        this.attendingDays = attendingDays;
    }

    public int getAttendingDays() {
        return attendingDays;
    }

    public void setAttendingDays(int attendingDays) {
        this.attendingDays = attendingDays;
    }

    public void addDeltager(Deltager deltager) {
        if (this.deltager != deltager) {
            this.deltager = deltager;
        }
    }

    public void addHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            this.hotel = hotel;
        }
    }

    public void addLedsager(Ledsager ledsager) {
        if (this.ledsager != ledsager) {
            this.ledsager = ledsager;
        }
    }

    public void addKonference(Konference konference) {
        if (this.konference != konference) {
            this.konference = konference;
        }
    }

    public ArrayList<Arrangement> getArrangements() {
        return new ArrayList<>(arrangements);
    }

    public void addArrangement(Arrangement arrangement) {
        if (!arrangements.contains(arrangement)) {
            arrangements.add(arrangement);
            arrangement.addTilmelding(this);
        }
    }

    public ArrayList<Tilvalg> getTilvalgs() {
        return new ArrayList<>(tilvalgs);
    }

    public void addTilvalg(Tilvalg tilvalg) {
        if (!tilvalgs.contains(tilvalg)) {
            tilvalgs.add(tilvalg);
            tilvalg.addTilmelding(this);
        }
    }

    public double beregnPris() {
        double tilvalgsPris = 0.0;
        double endeligPris = 0.0;
        for (Arrangement s : arrangements) {
            endeligPris += s.getPris();
        }
        for (Tilvalg s : tilvalgs) {
            tilvalgsPris += s.getPris();
        }
        if (deltager.isForedragsholder()) {

            if (hotel == null && arrangements.size() == 0) {
                pris = 0;
            } else if (hotel == null && arrangements.size() != 0) {
                pris += endeligPris;
            } else if (hotel != null && arrangements.size() == 0) {
                pris = (hotel.getPris() * (attendingDays - 1));
            } else {
                pris = (hotel.getPris() * (attendingDays - 1)) + endeligPris;
            }
        } else {
            if (hotel == null && arrangements.size() == 0) {
                pris = getAttendingDays() * konference.getPris();
            } else if (arrangements.size() == 0 && hotel != null) {
                pris = (getAttendingDays() * konference.getPris()) + (hotel.getPris() * (attendingDays - 1));
            } else {
                pris = (hotel.getPris() * (attendingDays - 1)) + (konference.getPris() * attendingDays) + endeligPris;
            }
        }

        if (tilvalgs.size() > 0) {
            pris += (tilvalgsPris * (attendingDays - 1));
        }
        return pris;
    }

}
