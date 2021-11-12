package application.model;

public class Deltager extends Person{
    private boolean foredragsholder;

    public Deltager(String name, int age, boolean foredragsholder){
        super(name, age);
        this.foredragsholder = foredragsholder;
    }
}
