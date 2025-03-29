package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;

public abstract class Allotjament implements InAllotjament, Serializable {

    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private boolean estat;
    private String iluminacio;





    //CONSTRUCTOR
    public Allotjament(String nom, String id, int estadaMinimaAlta, int estadaMinimaBaixa, boolean estat, String iluminacio) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaAlta;
        this.estadaMinimaBAIXA = estadaMinimaBaixa;
        this.estat = estat;
        this.iluminacio = iluminacio;

    }

    //GETTERS SETTERS

    /**
     * Obté el nom de l'allotjament.
     * @return el nom de l'allotjament.
     */
    @Override
    public String getNom() {
        return nom;
    }

    /**
     * Estableix el nom de l'allotjament.
     * @param nom el nom a assignar.
     */
    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obté l'identificador únic de l'allotjament.
     * @return l'identificador únic de l'allotjament.
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * Estableix l'identificador únic de l'allotjament.
     * @param id l'identificador a assignar.
     */
    @Override
    public void setId(String id) {
        this.id = id;

    }

    /**
     * Obté l'estada mínima segons la temporada.
     * @param temp la temporada (ALTA o BAIXA).
     * @return el valor de l'estada mínima per a la temporada indicada.
     */
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

    /**
     * Estableix l'estada mínima per a cada temporada.
     * @param estadaMinimaALTA_ l'estada mínima en temporada alta.
     * @param estadaMinimaBAIXA_ l'estada mínima en temporada baixa.
     */
    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA = estadaMinimaALTA_;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;

    }

    public long getEstadaMinimaBAIXA() {
        return estadaMinimaBAIXA;
    }
    public long getEstadaMinimaALTA() {
        return estadaMinimaALTA;
    }

    public abstract boolean correcteFuncionament();
    public boolean getEstat() {
        return estat;
    }

    public String getIluminacio() {
        return iluminacio;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public void setIluminacio(String iluminacio) {
        this.iluminacio = iluminacio;
    }

    //METODES ADICIONALS PRACTICA 2

    /**
     * Modifica l'estat de l'allotjament a No Operatiu i la il·luminació depenent de la incidència rebuda com a paràmetre
     * @param in Objecte de tipus Incidencia.
     */
    @Override
    public void tancarAllotjament(Incidencia in) {
        if (in != null) {


            switch (in.getTipus()) {
                case Reparacio:
                    this.iluminacio = "0%";  // Apagar la llum si és una reparació
                    this.estat = false;
                    break;
                case Neteja:
                    this.iluminacio = "50%";  // Reduir la il·luminació si és per neteja
                    this.estat = false;
                    break;
                case Tancament:
                    this.iluminacio = "50%";  // Per tancament, reduir la il·luminació
                    this.estat = false;
                    break;
                default:
                    throw new ExcepcioCamping("Tipus de incidencia invalid");
            }
        }
    }

    /**
     * Modifica l'estat de l'allotjament a Operatiu i la il·luminació al 100%
     */
    @Override
    public void obrirAllotjament() {
        this.estat = true;
        this.iluminacio = "100%";
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " {Nom=" + getNom() + ", Id=" + getId() +
                ", estada mínima en temp ALTA: " + getEstadaMinimaALTA() +
                ", estada mínima en temp BAIXA: " + getEstadaMinimaBAIXA() + "}";
    }

}
