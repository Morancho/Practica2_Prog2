package prog2.model;

public class MobilHome extends Casa {
    private boolean terrassaAmbBarbacoa;

    // Constructor
    public MobilHome(String nom, String idAllotjament, boolean estat, String iluminacio, float mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom, idAllotjament, 5, 3, estat, iluminacio, mida,  habitacions, placesPersones);
        //ATRIBUTS NOUS
        setTerrassaAmbBarbacoa(terrassaBarbacoa);
    }


    //GETTERS Y SETTERS
    public boolean isTerrassaAmbBarbacoa() {
        return terrassaAmbBarbacoa;
    }

    public void setTerrassaAmbBarbacoa(boolean terrassaAmbBarbacoa) {
        this.terrassaAmbBarbacoa = terrassaAmbBarbacoa;
    }


    // Implementació del mètode correcteFuncionament
    @Override
    public boolean correcteFuncionament() {
        return terrassaAmbBarbacoa;
    }

    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1) +
                ", terrassaAmbBarbacoa=" + terrassaAmbBarbacoa + "}";
    }
}