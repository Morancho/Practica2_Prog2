package prog2.model;

import prog2.vista.ExcepcioCamping;

import prog2.model.LlistaAllotjaments;

import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos {

    private Acces acc;
    private ArrayList<Acces> llistaAccessos;


    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {

    }

    @Override
    public void buidar() {

    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        return "";
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        Iterator<Acces> it = llistaAccessos.iterator();

        while(it.hasNext()) {
            Acces acc = it.next();
            // close every access
            acc.tancarAcces();
            // Luego, revise la lista de allotjaments por acceso y verifique
            // si hay alguna operación de allotjaments que use este acceso, vuelva a abrirlo.
            LlistaAllotjaments llistaAllotjamentsPerAccess = acc.getllistaAllotjament();
            if(llistaAllotjamentsPerAccess.containsAllotjamentOperatiu()) {
                acc.obrirAccess();
            }
        }
    }

    @Override
    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        return 0;
    }

    @Override
    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        return 0;
    }
}
