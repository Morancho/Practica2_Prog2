package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    private ArrayList<Allotjament> allotjaments;
    public LlistaAllotjaments () {

        allotjaments = new ArrayList<>();

    }
    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        allotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        allotjaments.clear();

    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        StringBuilder result = new StringBuilder();
        boolean trobat = false;


        for (Allotjament a : allotjaments) {
            if (a.getEstat().equals(estat)) {
                result.append(a.toString()).append("\n");  // o utilitza el mètode a.getInformacio() si existeix
                trobat = true;
            }

        }

        if (!trobat) {
            throw new ExcepcioCamping("No s'han trobat allotjaments en l'estat: " + estat);
        }

        return result.toString();
    }

    @Override
    public boolean containsAllotjamentOperatiu() {

        boolean trobat = false;


        for (Allotjament a : allotjaments) {
            if (a.getEstat().equals("Operatiu")) {

                return true;
            }

        }


        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        return allotjaments.contains(allotjament);
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament allotjament : allotjaments) {
            if (id.equals(allotjament.getId())) {// Compara amb l'string no nul
                return allotjament;
            }
        }
        return null;

    }
}
