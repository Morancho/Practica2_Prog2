package prog2.model;

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
    public Incidencia(int numero, String allotjament, String data, TipusIncidencia tipus) {
        this.numero = numero;
        this.allotjament = allotjament;
        this.data = data;
        this.tipus = tipus;
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

    // Mètode toString
    public String toString() {
        return "Incidencia{numero=" + numero + ", allotjament= " + allotjament +
                ", data= " + data + ", tipus= " + tipus + "}";
    }
}
