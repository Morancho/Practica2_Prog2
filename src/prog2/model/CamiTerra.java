package prog2.model;

public class CamiTerra extends AccesTerra {

    public CamiTerra(String nom, boolean estat, float longitud) {
        super(nom, estat, longitud);
    }
    //IMPLEMENTACIO ACCESIBILITAT
    @Override
    public boolean isAccessibilitat() {
        return false;
    }
}
