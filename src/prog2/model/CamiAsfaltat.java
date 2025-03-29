package prog2.model;

public class CamiAsfaltat extends AccesAsfaltat {

    public CamiAsfaltat(String nom, boolean estat, float areaAsfalt) {
        super(nom, estat, areaAsfalt, false);
    }
    //IMPLEMENTACIO ACCESIBILITAT
    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
