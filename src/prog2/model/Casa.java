package prog2.model;

public abstract class Casa extends Allotjament {
    private String mida;
    private int numHabitacions;
    private int capacitatPersones;

    // Constructor
    public Casa(String nom, String id, int estadaMinimaAlta, int estadaMinimaBaixa, String mida, int numHabitacions, int capacitatPersones) {
        super(nom, id, estadaMinimaAlta, estadaMinimaBaixa);
        setMida(mida);
        setNumHabitacions(numHabitacions);
        setCapacitatPersones(capacitatPersones);
    }

    //GETTERS Y SETTERS
    public void setMida(String mida) {
        this.mida = mida;
    }
    public String getMida() {
        return mida;
    }
    public int getNumHabitacions() {
        return numHabitacions;
    }
    public void setNumHabitacions(int numHabitacions) {
        this.numHabitacions = numHabitacions;
    }
    public int getCapacitatPersones() {
        return capacitatPersones;
    }
    public void setCapacitatPersones(int capacitatPersones) {
        this.capacitatPersones = capacitatPersones;
    }
}
