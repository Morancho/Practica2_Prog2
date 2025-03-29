package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaIncidencies implements InLlistaIncidencies, Serializable {
    private ArrayList<Incidencia> llistaIncidencies;

    public LlistaIncidencies() {
        llistaIncidencies = new ArrayList<>();
    }
    @Override
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {


        if(!isAllotjament(allotjament)){

            Incidencia incidencia = new Incidencia(num,allotjament,tipus,data);
            llistaIncidencies.add(incidencia);
        }
        else{
            throw new ExcepcioCamping("Ja existeix un allotjament amb aquest id: " + allotjament.getId()+ " en llistaIncidencies:");
        }
    }

    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        llistaIncidencies.remove(in);

    }

    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        String result = "";
        Iterator<Incidencia> it = llistaIncidencies.iterator();
        while(it.hasNext()) {
            Incidencia incidencia = it.next();
            result += incidencia.toString();
        }
        if(result.equals("")){
            throw new ExcepcioCamping("No hi ha incidencies");
        }
        else {
            return result;
        }
    }

    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        Iterator<Incidencia> it = llistaIncidencies.iterator();
        while(it.hasNext()) {
            Incidencia incidencia = it.next();
            if(incidencia.getNumero() == num){
                return incidencia;
            }

        }
        return null;
    }
    public boolean isAllotjament(Allotjament allotjament){
        Iterator<Incidencia> it = llistaIncidencies.iterator();
        while(it.hasNext()) {
            Incidencia incidencia = it.next();
            if(incidencia.getAllotjament() == allotjament){
                return true;
            }
        }
        return false;
    }
}
