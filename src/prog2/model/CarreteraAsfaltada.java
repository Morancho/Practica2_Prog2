package prog2.model;

public class CarreteraAsfaltada extends AccesAsfaltat {

    private float pesMaxim;

    public CarreteraAsfaltada(String nom, boolean estat, float areaAsfalt, float pesMaxim) {
        super(nom, estat, areaAsfalt, true);
        this.pesMaxim = pesMaxim;
    }

    //GETTERS SETTERS

    public float getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(float pesMaxim) {
        this.pesMaxim = pesMaxim;
    }
    //IMPLEMENTACIO ACCESIBILITAT
    @Override
    public boolean isAccessibilitat() {
        return true;
    }
}
