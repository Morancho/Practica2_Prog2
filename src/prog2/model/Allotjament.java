package prog2.model;

import prog2.vista.ExcepcioCamping;

public abstract class Allotjament implements InAllotjament {

    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private boolean estat;
    private String iluminacio;



    //CONSTRUCTOR
    public Allotjament(String nom, String id, int estadaMinimaAlta, int estadaMinimaBaixa) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaAlta;
        this.estadaMinimaBAIXA = estadaMinimaBaixa;
    }

    //GETTERS SETTERS
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
                return 0;
        }
    }

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
    @Override
    public void tancarAllotjament(Incidencia in) {
        if (in != null) {
            this.estat = false;

            switch (in.getTipus()) {
                case Reparacio:
                    this.iluminacio = "0%";  // Apagar la llum si és una reparació
                    break;
                case Neteja:
                    this.iluminacio = "50%";  // Reduir la il·luminació si és per neteja
                    break;
                case Tancament:
                    this.iluminacio = "50%";  // Per tancament, reduir la il·luminació
                    break;
                default:
                    throw new ExcepcioCamping("Tipus de incidencia invalid");
            }
        }
    }


    @Override
    public void obrirAllotjament() {
        this.estat = true;
        this.iluminacio = "100%";
    }
}
