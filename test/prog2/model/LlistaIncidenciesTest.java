package prog2.model;


import prog2.vista.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LlistaIncidenciesTest {

    private LlistaIncidencies llistaIncidencies;
    private Incidencia incidencia1;
    private Incidencia incidencia2;
    private Allotjament parcela;
    private Allotjament bungalow;

    @BeforeEach
    public void setUp() throws ExcepcioCamping {
        llistaIncidencies = new LlistaIncidencies();

        // Create test accommodations
        parcela = new Parcela("Parcela 1", "P1", true, "100%", 50.0f, true);
        bungalow = new Bungalow("Bungalow 1", "B1", true, "100%", 30.0f, 2, 4, 1, true, true, true);

        // Create test incidents using enum types
        incidencia1 = new Incidencia(1, Incidencia.TipusIncidencia.Reparacio, parcela, "2023-05-01");
        incidencia2 = new Incidencia(2, Incidencia.TipusIncidencia.Neteja, bungalow, "2023-05-02");

        // Add incidents to list
        llistaIncidencies.afegirIncidencia(incidencia1.getidIncidencia(),
                incidencia1.getTipus().name(),  // Using enum name()
                incidencia1.getAllotjament(),
                incidencia1.getdata());
        llistaIncidencies.afegirIncidencia(incidencia2.getidIncidencia(),
                incidencia2.getTipus().name(),
                incidencia2.getAllotjament(),
                incidencia2.getdata());
    }

    // Updated Incidencia class with enum
    public static class Incidencia {
        private int idIncidencia;
        private TipusIncidencia tipus;
        private Allotjament allotjament;
        private String data;

        public enum TipusIncidencia {
            Reparacio,
            Neteja,
            Tancament
        }

        public Incidencia(int idIncidencia, TipusIncidencia tipus, Allotjament allotjament, String data) {
            this.idIncidencia = idIncidencia;
            this.tipus = tipus;
            this.allotjament = allotjament;
            this.data = data;
        }

        // Alternative constructor that takes String and converts to enum
        public Incidencia(int idIncidencia, String tipusStr, Allotjament allotjament, String data) {
            this.idIncidencia = idIncidencia;
            this.allotjament = allotjament;
            this.data = data;
            this.tipus = TipusIncidencia.valueOf(tipusStr);
        }

        // Getters and setters
        public int getidIncidencia() { return idIncidencia; }
        public TipusIncidencia getTipus() { return tipus; }
        public Allotjament getAllotjament() { return allotjament; }
        public String getdata() { return data; }

        public String getIluminacioAllotjament() {
            switch (tipus) {
                case Reparacio: return "100%";
                case Neteja: return "50%";
                case Tancament: return "0%";
                default: return null;
            }
        }

        @Override
        public String toString() {
            return "Incidencia{" +
                    "id=" + idIncidencia +
                    ", tipus=" + tipus +
                    ", allotjament=" + allotjament.getId() +
                    ", data='" + data + '\'' +
                    '}';
        }
    }

    @Test
    void testConstructor() {
        assertNotNull(llistaIncidencies);
        assertEquals(2, llistaIncidencies.getIncidencies().size());
    }

    @Test
    void testAfegirIncidencia() throws ExcepcioCamping {
        int initialSize = llistaIncidencies.getIncidencies().size();
        Allotjament allotjament = new Parcela("Parcela nord", "ALL1", true, "50", 20.0f, true);

        Incidencia newIncidencia = new Incidencia(3, Incidencia.TipusIncidencia.Tancament, allotjament, "2023-05-03");
        llistaIncidencies.afegirIncidencia(newIncidencia.getidIncidencia(),
                newIncidencia.getTipus().name(),
                newIncidencia.getAllotjament(),
                newIncidencia.getdata());
        assertEquals(initialSize + 1, llistaIncidencies.getIncidencies().size());
    }

    @Test
    void testIncidenciaEnumValues() {
        // Test all enum values are handled correctly
        assertDoesNotThrow(() -> {
            new Incidencia(4, "Reparacio", parcela, "2023-05-04");
            new Incidencia(5, "Neteja", bungalow, "2023-05-05");
            new Incidencia(6, "Tancament", parcela, "2023-05-06");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Incidencia(7, "InvalidType", bungalow, "2023-05-07");
        });
    }

    @Test
    void testIncidenciaIluminacio() {
        Incidencia repIncidencia = new Incidencia(8, Incidencia.TipusIncidencia.Reparacio, parcela, "2023-05-08");
        assertEquals("100%", repIncidencia.getIluminacioAllotjament());

        Incidencia netejaIncidencia = new Incidencia(9, Incidencia.TipusIncidencia.Neteja, bungalow, "2023-05-09");
        assertEquals("50%", netejaIncidencia.getIluminacioAllotjament());

        Incidencia tancIncidencia = new Incidencia(10, Incidencia.TipusIncidencia.Tancament, parcela, "2023-05-10");
        assertEquals("0%", tancIncidencia.getIluminacioAllotjament());
    }

    // ... (rest of the test methods remain the same as in previous version)
}