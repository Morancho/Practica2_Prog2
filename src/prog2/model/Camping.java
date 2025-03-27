package prog2.model;
import prog2.vista.*;

import java.util.ArrayList;

public class Camping implements InCamping {
    private String nomCamping;
    LlistaAllotjaments llistaAllotjaments = new LlistaAllotjaments();
    LlistaIncidencies llistaIncidencies = new LlistaIncidencies();




    public Camping (String nom) {
        this.nomCamping = nom;


    }

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
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);

        if(allotjament != null || !llistaAllotjaments.contains(allotjament)){
            throw new ExcepcioCamping("No existeix l'allotjament amb id: " + idAllotjament);
        } else if (llistaIncidencies.getIncidencia(num) != null) {
            throw new ExcepcioCamping("Ja existeix una incidencia amb l'id: " + num);

        } else{
            llistaIncidencies.afegirIncidencia(num, tipus, allotjament, data);

            Incidencia inc = llistaIncidencies.getIncidencia(num);
            llistaAllotjaments.updateAllotjamentEstat(allotjament,inc);

        }
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
