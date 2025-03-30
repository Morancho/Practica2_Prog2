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

    public ArrayList<Incidencia> getIncidencies(){
        return this.llistaIncidencies;
    }

    /**
     * Aquest mètode crea una incidència amb la informació passada com a paràmetres
     * (número d'identificador, tipus, l'allotjament on s'ha produït i la data) i l'afegeix a la llista.
     * A més, s'ha de comprovar que aquest allotjament no té ja una incidència si ja té una incidència s'ha de llançar una excepció.
     * Una vegada creada la incidència s'ha de tancar (no operatiu) l'allotjament corresponent.
     * @param num Número d'identificació de la incidència.
     * @param tipus Aquest String permet crear el enum TipusIncidencia
     * @param allotjament Allotjament on es produeix la incidència
     * @param data Data quan es produeix la incidència.
     * @throws ExcepcioCamping Per comprovar i avisar si l'allotjament ja té una incidència o si el tipus d’incidència que es vol afegir no existeix.
     */
    @Override
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping {

        //Comprobem si ja existeix una incidencia amb el mateix ID
        Iterator<Incidencia> it = llistaIncidencies.iterator();
        while(it.hasNext()) {
            Incidencia incidencia = it.next();
            if(incidencia.getNumero() == num){
                throw new ExcepcioCamping("Ja existeix una incidencia amb aquest ID: "+ num + " en llistaIncidencies.");
            }
        }

        //Comprobem que la incidencia no sigui en el mateix allotjament
        if(!isAllotjament(allotjament)){

            Incidencia incidencia = new Incidencia(num,allotjament,tipus,data);
            llistaIncidencies.add(incidencia);
        }
        else{
            throw new ExcepcioCamping("Ja existeix un allotjament amb aquest id: " + allotjament.getId()+ " en llistaIncidencies:");
        }
    }

    /**
     * Aquest mètode elimina una incidència de la llista i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
     * @param in Objecte de tipus Incidència
     * @throws ExcepcioCamping
     */
    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping {
        llistaIncidencies.remove(in);

    }

    /**
     * Itera sobre la llista d'incidències i retorna un String amb la informació de totes les incidències.
     * En cas que no hi hagi cap incidència llança una excepció.
     * @return String
     * @throws ExcepcioCamping
     */
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
    /**
     * Busca la incidència amb el número rebut per paràmetre i la retorna.
     * En cas que no existeixi llança una excepció.
     * @param num Número d'identificació de la incidència.
     * @return Objecte de tipus Incidència
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap incidència amb el número passat per paràmetre.
     */
    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioCamping {
        Iterator<Incidencia> it = llistaIncidencies.iterator();
        while(it.hasNext()) {
            Incidencia incidencia = it.next();
            if(incidencia.getNumero() == num){
                return incidencia;
            }

        }
        throw new ExcepcioCamping("No hi ha cap incidencia amb aquest ID");
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

    public ArrayList<Incidencia> getLlistaIncidencies() {
        return llistaIncidencies;
    }
}
