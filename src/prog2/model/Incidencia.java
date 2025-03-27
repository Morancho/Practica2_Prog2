package prog2.model;

import prog2.vista.ExcepcioCamping;

public class Incidencia {

    public static enum TipusIncidencia {
        Reparacio,
        Neteja,
        Tancament
    };


    private int numero;
    private String allotjament;
    private String data;
    private TipusIncidencia tipus;

    // Constructor
    public Incidencia(int numero, String allotjament, String data, String tipus) {
        this.numero = numero;
        this.allotjament = allotjament;
        this.data = data;
        switch (tipus) {
            case "Reparacio":
                this.tipus = TipusIncidencia.Reparacio;
                break;
            case "Neteja":
                this.tipus = TipusIncidencia.Neteja;
                break;
            case "Tancament":
                this.tipus = TipusIncidencia.Tancament;
                break;
        }
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getAllotjament() {
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

    public void setAllotjament(String allotjament) {
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
