package application.model;

public class Tilvalg {
    private String info;
    private double pris;

    private Hotel hotel;
    private Tilmelding tilmelding;


    public Tilvalg(String info, double pris) {
        this.info = info;
        this.pris = pris;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public Hotel getHotel() {
        return hotel;
    }
    public void addTilmelding(Tilmelding tilmelding){
        if(this.tilmelding !=tilmelding){
            this.tilmelding = tilmelding;
        }
    }
    public void removeTilmelding(){
        this.tilmelding = null;
    }

    public void addHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            this.hotel = hotel;
        }
    }
    public void removeHotel(){
        this.hotel = null;
    }

}
