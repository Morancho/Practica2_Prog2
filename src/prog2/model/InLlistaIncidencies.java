
package prog2.model;

import prog2.vista.ExcepcioCamping;

/**
 * Interfície que defineix les operacions bàsiques d'una llista d'incidències.
 */
public interface InLlistaIncidencies {
    
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
    public void afegirIncidencia(int num, String tipus, Allotjament allotjament, String data) throws ExcepcioCamping;
    /**
    * Aquest mètode elimina una incidència de la llista i actualitza l'estat de l'allotjament mitjançant el mètode obrirAllotjament de la classe Allotjament.
    * @param in Objecte de tipus Incidència
    * @throws ExcepcioCamping
     */
    public void eliminarIncidencia(Incidencia in) throws ExcepcioCamping;
    
    /**
     * Itera sobre la llista d'incidències i retorna un String amb la informació de totes les incidències. 
     * En cas que no hi hagi cap incidència llança una excepció. 
     * @return String
     * @throws ExcepcioCamping
     */
    public String llistarIncidencies() throws ExcepcioCamping;
    
    /**
     * Busca la incidència amb el número rebut per paràmetre i la retorna. 
     * En cas que no existeixi llança una excepció.
     * @param num Número d'identificació de la incidència.
     * @return Objecte de tipus Incidència
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap incidència amb el número passat per paràmetre.
     */
    public Incidencia getIncidencia(int num) throws ExcepcioCamping;
}
