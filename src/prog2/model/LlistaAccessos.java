package prog2.model;

import prog2.vista.ExcepcioCamping;

import prog2.model.LlistaAllotjaments;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos, Serializable {

    private Acces acc;
    private ArrayList<Acces> llistaAccessos;
    public LlistaAccessos() {
        // Inicializamos la lista para evitar NullPointerException
        this.llistaAccessos = new ArrayList<>();
    }



    /**
     * Afegeix un accés rebut per paràmetre a la llista d'accessos.
     * @param acc Objecte de tipus Acces.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {

        this.llistaAccessos.add(acc);

    }

    /**
     * Buida la llista d'accessos
     */
    @Override
    public void buidar() {
        llistaAccessos.clear();

    }

    /**
     * Itera sobre la llista d'accessos i retorna un String amb la informació de tots els accessos amb l'estat rebut per paràmetre.
     * En cas que no hi hagi accessos en l'estat passat com a paràmetre llança una excepció.
     * @param estat boolean
     * @return String
     * @throws prog2.vista.ExcepcioCamping Aquest mètode llança una excepció en cas que no hi hagi accessos en l'estat passat com a parametre.
     */
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String result = "";
        int cont = 0;

        Iterator<Acces> it = llistaAccessos.iterator();

        while (it.hasNext()) {
            Acces acc = it.next();

            if(acc.getEstat() == estat){
                result += acc + "\n";
                cont++;
            }

        }
        if (cont == 0) {
            throw new ExcepcioCamping("No hi ha cap acces amb aquest estat.");
        }
        return result;
    }
    public boolean containtAccesosEstat(boolean estat){
        Iterator<Acces> it = llistaAccessos.iterator();
        while(it.hasNext()){
            Acces acc = it.next();

            if(acc.getEstat() == estat){
                return true;
            }
        }
        return false;
    }

    /**
     * Recorre tota la llista d'accessos i els tanca. Només decidirà obrir cadascun d'ells si permet l'accés a algun allotjament operatiu.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {

        /*
        while(it.hasNext()) {
            boolean oper = true;
            Acces acc = it.next();
            LlistaAllotjaments llistaAllotjaments = acc.getllistaAllotjament();
            Iterator<Allotjament> it2 = llistaAllotjaments.getAllotjaments().iterator();
            while(it2.hasNext()) {
                Allotjament allotjament = it2.next();

                if(!allotjament.getEstat()){

                    oper = false;
                }
            }
            acc.setEstat(oper);
        }

         */

        Iterator<Acces> it = llistaAccessos.iterator();

        while (it.hasNext()) {
            Acces acc = it.next();

            // Tanquem els accessos
            acc.setEstat(false);

            Iterator<Allotjament> it_allotjament = acc.getllistaAllotjament().getAllotjaments().iterator();
            while (it_allotjament.hasNext()) {
                Allotjament all = it_allotjament.next();

                if (all.getEstat()) {
                    acc.setEstat(true);
                    break;
                }

            }
        }
    }


    /**
     * Itera sobre la llista d'accessos i retorna el número d'accessos amb accessibilitat.
     * @return int
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        int num = 0;
        Iterator<Acces> it = llistaAccessos.iterator();
        while(it.hasNext()) {
            Acces acc = it.next();

            //Com no tinc clar si han de ser els que estan a més a més amb un allotjament operatiu deixo el cambi en comentari:
            if(acc.isAccessibilitat()){ //if (acc.isAccessibilitat() && acc.getEstat())
                num++;
            }
        }
        return num;
    }

    /**
     * Itera sobre la llista d'accessos, i pels accessos asfaltats suma els metres quadrats d'asfalt i ho retorna.
     * @return float amb els metres quadrats d'asfalt.
     * @throws prog2.vista.ExcepcioCamping Aquest mètode podria llançar una excepció si fos necessari.
     */
    @Override
    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        float num = 0.0f;

        Iterator<Acces> it = llistaAccessos.iterator();
        while(it.hasNext()){
            Acces acc = it.next();
            if(acc instanceof AccesAsfaltat){
                num += ((AccesAsfaltat) acc).getAreaAsfalt();

            }
        }
        return num;
    }

    public ArrayList<Acces> getLlistaAccessos() {
        return llistaAccessos;
    }
}
