package prog2.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IncidenciaTest {

    @Test
    void testConstructorAndGetters() {
        Allotjament allotjament = new Parcela("Parcela nord", "ALL1", true, "50", 20.0f, true);
        Incidencia incidencia = new Incidencia(1, allotjament, "Reparacio", "2025/03/29");

        assertEquals(1, incidencia.getNumero());
        assertEquals(allotjament, incidencia.getAllotjament());
        assertEquals("2025/03/29", incidencia.getData());
        assertEquals(Incidencia.TipusIncidencia.Reparacio, incidencia.getTipus());
    }

    @Test
    void testSetters() {
        Allotjament allotjament = new Parcela("Parcela nord", "ALL1", true, "50", 20.0f, true);

        Incidencia incidencia = new Incidencia(2, allotjament, "Neteja", "2025/03/29");

        incidencia.setNumero(10);
        assertEquals(10, incidencia.getNumero());
        assertEquals(allotjament, incidencia.getAllotjament());

        incidencia.setData("2025/04/01");
        assertEquals("2025/04/01", incidencia.getData());


        assertEquals(Incidencia.TipusIncidencia.Neteja, incidencia.getTipus());
    }

    @Test
    void testGetIluminacioAllotjament() {
        Allotjament allotjament = new Parcela("Parcela nord", "ALL1", true, "50", 20.0f, true);

        Incidencia incidencia1 = new Incidencia(1, allotjament, "Reparacio", "2025/03/29");
        assertEquals("100%", incidencia1.getIluminacioAllotjament());

        Incidencia incidencia2 = new Incidencia(2, allotjament, "Neteja", "2025/03/29");
        assertEquals("50%", incidencia2.getIluminacioAllotjament());

        Incidencia incidencia3 = new Incidencia(3, allotjament, "Tancament", "2025/03/29");
        assertEquals("0%", incidencia3.getIluminacioAllotjament());
    }

    @Test
    void testToString() {
        Allotjament allotjament = new Parcela("Parcela nord", "ALL1", true, "50", 20.0f, true);

        Incidencia incidencia = new Incidencia(1, allotjament, "Reparacio", "2025/03/29");

        String expected = "Incidencia{numero=1, allotjament= " + allotjament +
                ", data= 2025/03/29, tipus= Reparacio}";
        assertEquals(expected, incidencia.toString());
    }
}
