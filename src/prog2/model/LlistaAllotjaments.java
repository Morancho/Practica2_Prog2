package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments implements InLlistaAllotjaments, Serializable {
    private ArrayList<Allotjament> llistaAllotjaments;
    public LlistaAllotjaments () {

        this.llistaAllotjaments = new ArrayList<>();

    }
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        this.llistaAllotjaments.add(allotjament);
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
        int cont = 0;

        Iterator<Allotjament> iterator = llistaAllotjaments.iterator();


        while (iterator.hasNext()) {
            Allotjament allotjament = iterator.next();

            boolean operatiu = allotjament.getEstat();
            if (estat.equals("Tots") || (estat.equals("Operatiu") && operatiu) || (estat.equals("NoOperatiu") && !operatiu)) {
                result += allotjament.toString() + "\n";
                cont ++;
            }


        }
        if (cont == 0) {
            throw new ExcepcioCamping("No hi ha cap allotjament amb aquest estat.");
        }
        return result;

    }

    @Override
    public boolean containsAllotjamentOperatiu() {

        boolean trobat = false;
        Iterator<Allotjament> iterator = llistaAllotjaments.iterator();
        while (iterator.hasNext() && !trobat) {
            Allotjament allotjament = iterator.next();
            if(allotjament.getEstat()){
                trobat = true;
            }
        }


        return trobat;
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

        throw new ExcepcioCamping("Allotjament no trobat amb id: " + id);

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
    public ArrayList<Allotjament> getAllotjaments(){
        return this.llistaAllotjaments;
    }

}
