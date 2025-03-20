package prog2.model;

public class Bungalow extends Casa {


    private int placesParquing;
    private boolean terrassa;
    private boolean tv;
    private boolean aireFred;


    //CONSTRUCTOR
    public Bungalow(String nom, String idAllotjament, String  mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        super(nom, idAllotjament, 7, 4, mida, habitacions, placesPersones);
        //ATRIBUTS NOUS
        setPlacesParquing(placesParquing);
        setTerrassa(terrassa);
        setTv(tv);
        setAireFred(aireFred);
    }
    // Getter y Setter
    public int getPlacesParquing() {
        return placesParquing;
    }
    public void setPlacesParquing(int placesParquing) {
        this.placesParquing = placesParquing;
    }
    public boolean getTerrassa() {
        return terrassa;
    }
    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }
    public boolean isTv() {
        return tv;
    }
    public void setTv(boolean tv) {
        this.tv = tv;
    }
    public boolean isAireFred() {
        return aireFred;
    }
    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    public int getHabitacions(){
        return getNumHabitacions();
    }
    public int getPlacesPersones(){
        return getCapacitatPersones();
    }
    public boolean isTerrassa(){
        return terrassa;
    }
    // Implementació del mètode correcteFuncionament
    public boolean correcteFuncionament(){
        return aireFred;
    }

    @Override
    public String toString() {
        return super.toString() + " Bungalow{placesParquing=" + placesParquing +
                ", terrassa=" + terrassa + ", tv=" + tv + ", aireFred=" + aireFred + "}";
    }

}
