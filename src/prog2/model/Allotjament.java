package prog2.model;

public class Allotjament implements InAllotjament {

    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;



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

    @Override
    public long getEstadaMinima(Temp temp) {
        switch (temp) {
            case ALTA:
                return estadaMinimaALTA;
            case BAIXA:
                return estadaMinimaBAIXA;
            default:
                throw new Incidencia("Valor inesperado: " + temp);
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {

    }

    @Override
    public void tancarAllotjament(Incidencia in) {

    }

    @Override
    public void obrirAllotjament() {

    }
}
