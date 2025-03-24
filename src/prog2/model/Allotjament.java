package prog2.model;

import javax.management.modelmbean.InvalidTargetObjectTypeException;

public class Allotjament implements InAllotjament {

    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private boolean estat;



    //CONSTRUCTOR
    public Allotjament(String nom, String id, int estadaMinimaAlta, int estadaMinimaBaixa) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaAlta;
        this.estadaMinimaBAIXA = estadaMinimaBaixa;
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
    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public boolean getEstat() {
        return estat;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        switch (temp) {
            case ALTA:
                return estadaMinimaALTA;
            case BAIXA:
                return estadaMinimaBAIXA;
            default:
                return 0;
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA, long estadaMinimaBAIXA) {
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
    }

    @Override
    public void tancarAllotjament(Incidencia in) {
        switch (in.getTipus()) {
            case Reparacio:
                break;
            case Neteja:
                break;
            case Tancament:
                break;
            default:
                ExcepcioCamping("Tipus d'incidència desconegut. No es pot tancar l'allotjament.");
                break;
        }
    }


    @Override
    public void obrirAllotjament() {

    }
}
