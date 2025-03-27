package prog2.model;

public class Parcela extends Allotjament {
    private float mida;
    private boolean connexioElectrica;

    // Constructor

    public Parcela(String nom, String id, boolean estat, String iluminacio, float mida, boolean connexioElectrica) {
        super(nom, id, 4, 2, estat, iluminacio);

        this.mida = mida;
        this.connexioElectrica = connexioElectrica;
    }

    public float getMida() {
        return mida;
    }
    public void setMida(float mida) {
        this.mida = mida;
    }
    public boolean isConnexioElectrica() {
        return connexioElectrica;
    }
    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica = connexioElectrica;
    }


    // Implementació del mètode correcteFuncionament
    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica;
    }

    @Override
    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() + ", estada mínima en temp ALTA: "
                + getEstadaMinimaALTA() + ", estada mínima en temp BAIXA: "
                + getEstadaMinimaBAIXA() + ". Parcela{mida=" + mida + ", connexioElectrica=" + connexioElectrica + "}";
    }
}