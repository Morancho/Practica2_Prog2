package prog2.model;

import java.io.Serializable;

public abstract class Acces implements InAcces, Serializable {

    private String nom;
    private boolean estat;
    private boolean accessibilitat;
    private LlistaAllotjaments llistaAllotjaments;

    public Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
        this.llistaAllotjaments = new LlistaAllotjaments(); // Inicializa la lista para evitar NullPointerException
    }

    //Getters Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean getEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    //Metodes implementats
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

    public String toString() {
        return getClass().getSimpleName() + " {nom=" + nom + ", estat=" + estat + ", accessibilitat=" + accessibilitat + "}";
    }

}
