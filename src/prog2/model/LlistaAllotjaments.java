package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    private ArrayList<Allotjament> llistaAllotjaments;
    public LlistaAllotjaments () {

        llistaAllotjaments = new ArrayList<>();

    }
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        llistaAllotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        this.llistaAllotjaments.clear();

    }
    /*
    El mètode llistarAllotjaments de la classe LlistaAllotjaments rep un String estat
    que podrà ser "Operatiu", "No Operatiu" i "Tots".


    Aquesta informació s'ha de traslladar a un boolean estatBoolean per
    tal que al recòrrer la llista d'Allotjaments es pugui saber quins s'han
    de seleccionar per concatenar la seva informació al String de return.

     */

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        String result = "";



        Iterator<Allotjament> iterator = llistaAllotjaments.iterator();

        while (iterator.hasNext()) {
            Allotjament a = iterator.next();
            if(estat.equals("Tots")){
                result = result + a + "\n";
            }

            if (a.getEstat().equals(estat)) {
                result = result + a + "\n";
            }
        }
        return result;
    }

    @Override
    public boolean containsAllotjamentOperatiu() {

        boolean trobat = false;


        for (Allotjament a : llistaAllotjaments) {
            if (a.getEstat().equals("Operatiu")) {

                return true;
            }

        }


        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        return llistaAllotjaments.contains(allotjament);
    }

    @Override
    public  Allotjament getAllotjament(String id) throws ExcepcioCamping {
        Iterator<Allotjament> iterator = llistaAllotjaments.iterator();
        while (iterator.hasNext()) {
            Allotjament a = iterator.next();
            if (a.getId().equals(id)) {
                return a;
            }
        }

        return null;

    }

    public void updateAllotjamentEstat(Allotjament a, Incidencia incidencia) throws ExcepcioCamping{
        Iterator<Allotjament> iterator = llistaAllotjaments.iterator();
        while (iterator.hasNext()) {
            Allotjament allotjament = iterator.next();
            if (allotjament.getId().equals(a.getId())) {
                allotjament.tancarAllotjament(incidencia);
            }
        }
    }
    public void actualitzaEstatAccessos(){

    }
}
