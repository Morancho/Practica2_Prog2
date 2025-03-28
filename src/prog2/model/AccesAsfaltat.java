package prog2.model;

public abstract class AccesAsfaltat extends Acces {

    private float areaAsfalt;

    // Constructor
    public AccesAsfaltat(String nom, boolean estat, float areaAsfalt) {
        super(nom, estat);
        this.areaAsfalt = areaAsfalt;
    }

    // Getter
    public float getAreaAsfalt() {
        return areaAsfalt;
    }

    // Setter
    public void setAreaAsfalt(float areaAsfalt) {
        this.areaAsfalt = areaAsfalt;
    }

    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1)
                + ", Area Asfaltada: " + areaAsfalt + " m²}";
    }
}
