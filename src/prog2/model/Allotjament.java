package prog2.model;

import prog2.vista.ExcepcioCamping;



public class Allotjament implements InAllotjament {

    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private String estat;


    //CONSTRUCTOR
    public Allotjament(String nom, String id, int estadaMinimaAlta, int estadaMinimaBaixa) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaAlta;
        this.estadaMinimaBAIXA = estadaMinimaBaixa;
        this.estat = "Operatiu";
    }
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;

    }

    @Override
    public long getEstadaMinima(Temp temp) {
        switch (temp) {
            case ALTA:
                return estadaMinimaALTA;
            case BAIXA:
                return estadaMinimaBAIXA;
            default:
                throw new ExcepcioCamping("Valor inesperado: " + temp);
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA, long estadaMinimaBAIXA) {
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
    }

    @Override
    public void tancarAllotjament(Incidencia in) {

    }

    @Override
    public void obrirAllotjament() {

    }
    public String getEstat() {
        return estat;
    }

    public long getEstadaMinimaBAIXA() {
        return estadaMinimaBAIXA;
    }
    public long getEstadaMinimaALTA() {
        return estadaMinimaALTA;
    }
    public String toString(){
        return "Nom="+getNom()+", Id="+getId()+", estada mínima en temp ALTA: "+getEstadaMinimaALTA()+", estada mínima en temp BAIXA: "+getEstadaMinimaBAIXA()+".";
        //"Nom=Allotjament Test, Id=ID001, estada mínima en temp ALTA: 5, estada mínima en temp BAIXA: 3."
    }
}

