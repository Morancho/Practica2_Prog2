package prog2.model;

public class Camping implements InCamping {
    @Override
    public String getNomCamping() {
        return "";
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        return "";
    }

    @Override
    public void afegirIncidencia(int num, String tipus, String idAllotjament, String data) throws ExcepcioCamping {

    }

    @Override
    public void eliminarIncidencia(int num) throws ExcepcioCamping {

    }

    @Override
    public int calculaAccessosAccessibles() {
        return 0;
    }

    @Override
    public float calculaMetresQuadratsAsfalt() {
        return 0;
    }

    @Override
    public void save(String camiDesti) throws ExcepcioCamping {

    }

    @Override
    public void inicialitzaDadesCamping() {

    }
}
