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

    /**
     * Itera sobre la llista d'accessos, i pels accessos asfaltats suma els metres quadrats d'asfalt i ho retorna.
     * @return float amb els metres quadrats d'asfalt.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        this.llistaAllotjaments.add(allotjament);
    }

    /**
     * Buida la llista d'allotjaments.
     */
    @Override
    public void buidar() {
        this.llistaAllotjaments.clear();

    }

    /**
     * Itera sobre la llista d'allotjaments i retorna un String amb la informació de tots els allotjaments amb l'estat rebut per paràmetre.
     * En cas que no hi hagi allotjaments en l'estat passat com a paràmetre llança una excepció.
     * @param estat
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi allotjaments en l'estat passat com a paràmetre.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        String result = "";
        int cont = 0;

        Iterator<Allotjament> iterator = llistaAllotjaments.iterator();


        while (iterator.hasNext()) {
            Allotjament allotjament = iterator.next();

            boolean operatiu = allotjament.getEstat();
            if (estat.equals("Tots") || (estat.equals("Operatiu") && operatiu) || (estat.equals("No Operatiu") && !operatiu)) {
                result += allotjament.toString() + "\n";
                cont ++;
            }


        }
        if (cont == 0) {
            throw new ExcepcioCamping("No hi ha cap allotjament amb aquest estat.");
        }
        return result;

    }

    /**
     * Mira si la llista d'allotjaments conté algun allotjament operatiu.
     * @return boolean
     */
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

    /**
     * Mira si la llista d'allotjaments conté l'allotjament rebut per paràmetre i retorna un booleà amb la informació.
     * @param allotjament
     * @return boolean
     */
    @Override
    public boolean contains(Allotjament allotjament) {
        return llistaAllotjaments.contains(allotjament);
    }

    /**
     * Busca l'allotjament amb el nom rebut per paràmetre i el retorna. En cas que no existeixi llança una excepció.
     * @param id String amb el id de l'allotjament
     * @return  Objecte de tipus Allotjament
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
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
