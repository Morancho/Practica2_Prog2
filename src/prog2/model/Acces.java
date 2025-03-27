package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces {

    private String nom;
    private boolean estat;
    private LlistaAllotjaments llistaAllotjaments;

    @Override
    public void afegirAllotjament(Allotjament allotjament) {
        llistaAllotjaments.afegirAllotjament(allotjament);
    }

    @Override
    public void tancarAcces() {
        this.estat = false;
    }

    @Override
    public void obrirAcces() {
        this.estat = true;
    }

    @Override
    public abstract boolean isAccessibilitat();

    public LlistaAllotjaments getllistaAllotjament() {
        return llistaAllotjaments;
    }
}
