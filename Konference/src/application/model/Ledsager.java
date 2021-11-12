package application.model;

public class Ledsager extends Person{
    private boolean ledsager;

    public Ledsager(String name, int age, boolean ledsager){
        super(name, age);
        this.ledsager = ledsager;
    }
}
