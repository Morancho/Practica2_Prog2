package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces {
    ArrayList<Acces> llistaAccessos;

    @Override
    public void afegirAllotjament(Allotjament allotjament) {

    }

    @Override
    public void tancarAcces() {

    }

    @Override
    public void obrirAcces() {

    }

    @Override
    public boolean isAccessibilitat() {
        return false;
    }

    public LlistaAllotjaments getllistaAllotjament() {
        return llistaAccessos;
    }
}
