package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;

public class Incidencia implements Serializable {

    public static enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    };


    private int numero;
    private Allotjament allotjament;
    private String data;
    private TipusIncidencia tipus;

    // Constructor
    public Incidencia(int numero, Allotjament allotjament, String tipus, String data) {
        this.numero = numero;
        this.allotjament = allotjament;
        this.data = data;
        try {
            this.tipus = TipusIncidencia.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("Tipus d'incidència invàlid: " + tipus);
        }
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public String getData() {
        return data;
    }

    public TipusIncidencia getTipus() {
        return tipus;
    }

    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTipus(TipusIncidencia tipus) {
        this.tipus = tipus;
    }

    public String getIluminacioAllotjament() {
        switch (tipus) {
            case Reparacio:
                return "100%";
            case Neteja:
                return "50%";
            case Tancament:
                return "0%";
            default:
                throw new ExcepcioCamping("ERROR: Tipus de Incidencia incorrecte");
        }
    }

    // Mètode toString
    public String toString() {
        return "Incidencia{numero=" + numero + ", allotjament= " + allotjament +
                ", data= " + data + ", tipus= " + tipus + "}";
    }
}
