package prog2.model;

public abstract class Casa extends Allotjament {
    private float mida;
    private int numHabitacions;
    private int placesPersones;

    // Constructor
    public Casa(String nom, String id, int estadaMinimaAlta, int estadaMinimaBaixa, boolean estat, String iluminacio, float mida, int numHabitacions, int placesPersones) {
        super(nom, id, estadaMinimaAlta, estadaMinimaBaixa, estat, iluminacio);
        setMida(mida);
        setNumHabitacions(numHabitacions);
        setCapacitatPersones(placesPersones);
    }

    //GETTERS Y SETTERS
    public void setMida(float mida) {
        this.mida = mida;
    }
    public float getMida() {
        return mida;
    }
    public int getNumHabitacions() {
        return numHabitacions;
    }
    public void setNumHabitacions(int numHabitacions) {
        this.numHabitacions = numHabitacions;
    }
    public int getCapacitatPersones() {
        return placesPersones;
    }
    public void setCapacitatPersones(int placesPersones) {
        this.placesPersones = placesPersones;
    }
}
