package prog2.model;

public class Glamping extends Casa {

    private String material;
    private boolean casaMascota;

    //CONSTRUCTOR
    public Glamping(String nom, String idAllotjament, boolean estat, String iluminacio, float mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        super(nom, idAllotjament, 5, 3, estat, iluminacio, mida, habitacions, placesPersones);
        //ATRIBUTS NOUS
        setMaterial(material);
        setCasaMascota(casaMascota);

    }

    // Getter y Setter
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isCasaMascota() {
        return casaMascota;
    }

    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    // Implementació del mètode correcteFuncionament
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1) +
                ", material='" + material + "', casaMascota=" + casaMascota + "}";
    }
}
