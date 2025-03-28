package prog2.model;

public abstract class AccesTerra extends Acces {

    private float longitud;

    // Constructor
    public AccesTerra(String nom, boolean estat, float longitud) {
        super(nom, estat);
        this.longitud = longitud;
    }

    // Getter
    public float getLongitud() {
        return longitud;
    }

    // Setter
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1)
                + ", Longitud: " + longitud + " m}";
    }

}
