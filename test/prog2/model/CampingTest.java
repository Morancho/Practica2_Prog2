package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class CampingTest {
    private Camping camping;

    @BeforeEach
    void setUp() {
        camping = new Camping("Camping Green");
        camping.inicialitzaDadesCamping();
    }

    @Test
    void testGetNomCamping() {
        assertEquals("Camping Green", camping.getNomCamping());
    }

    @Test
    void testLlistarAllotjaments() throws ExcepcioCamping {
        String result = camping.llistarAllotjaments("Operatiu");
        assertNotNull(result);
        assertTrue(result.contains("Parcel·la Nord"));
        assertTrue(result.contains("Bungalow Nord"));
    }

    @Test
    void testLlistarAccessosOberts() throws ExcepcioCamping {
        String result = camping.llistarAccessos("Obert");
        assertNotNull(result);
        assertTrue(result.contains("A1"));
        assertTrue(result.contains("A2"));
    }

    @Test
    void testAfegirIncidenciaValida() {
        try {
            // Tipos válidos según enunciado: "Reparacio", "Neteja", "Tancament"
            camping.afegirIncidencia(1, "Reparacio", "ALL1", "01/01/2023");

            String incidencias = camping.llistarIncidencies();
            assertTrue(incidencias.contains("ALL1"));
            assertTrue(incidencias.contains("Reparacio"));

            // Verificar que el alojamiento ahora está no operativo
            String noOperatius = camping.llistarAllotjaments("No Operatiu");
            assertTrue(noOperatius.contains("ALL1"));

        } catch (ExcepcioCamping e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    @Test
    void testAfegirIncidenciaTipusInvalid() {
        Exception exception = assertThrows(ExcepcioCamping.class, () -> {
            camping.afegirIncidencia(1, "Averia", "ALL1", "01/01/2023");
        });

        assertEquals("Error: Tipus d'incidència invàlid: Averia", exception.getMessage());
    }

    @Test
    void testAfegirIncidenciaAllotjamentNoExistent() {
        Exception exception = assertThrows(ExcepcioCamping.class, () -> {
            camping.afegirIncidencia(1, "Reparacio", "ALL99", "01/01/2023");
        });

        assertTrue(exception.getMessage().contains("Error"));
    }

    @Test
    void testEliminarIncidencia() {
        try {
            camping.afegirIncidencia(1, "Neteja", "ALL3", "01/01/2023");
            camping.eliminarIncidencia(1);

            //Com sols hem afegit una incidencia i després ha estat eliminat, la llista queda buida
            assertThrows(ExcepcioCamping.class, () -> camping.llistarIncidencies());

            // Verificar que el alojamiento vuelve a estar operativo
            String operatius = camping.llistarAllotjaments("Operatiu");
            assertTrue(operatius.contains("ALL3"));

        } catch (ExcepcioCamping e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    @Test
    void testCalculaAccessosAccessibles() {
        int accessosInicials = camping.calculaAccessosAccessibles();
        assertEquals(6, accessosInicials);

        try {

            camping.afegirIncidencia(1, "Tancament", "ALL3", "01/01/2023");
            int nousAccessos = camping.calculaAccessosAccessibles();
            //Com no cambia si és accessible amb cotxe o no és el mateix (encara que hem deixat en comentari el cambi que s'hauria de fer si
            // volem afeigr seogns el seu estat)
            assertEquals(6, nousAccessos);
        } catch (ExcepcioCamping e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    @Test
    void testCalculaMetresQuadratsAsfalt() {
        float metres = camping.calculaMetresQuadratsAsfalt();
        // Según tabla: 200+800+350+800+100+800 = 3050
        assertEquals(3050.0f, metres, 0.01);
    }

    @Test
    void testSaveAndLoad() {
        try {
            // Guardar camping
            camping.save("testCampingGreen");

            // Cargar camping
            Camping loadedCamping = Camping.load("testCampingGreen");

            // Verificar que se cargó correctamente
            assertNotNull(loadedCamping);
            assertEquals(camping.getNomCamping(), loadedCamping.getNomCamping());
            assertEquals(camping.calculaMetresQuadratsAsfalt(),
                    loadedCamping.calculaMetresQuadratsAsfalt());

        } catch (ExcepcioCamping e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }

    @Test
    void testIluminacioPerTipusIncidencia() {
        try {
            // Reparació -> 100% iluminació
            camping.afegirIncidencia(1, "Reparacio", "ALL1", "01/01/2023");
            String allotjaments = camping.llistarAllotjaments("No Operatiu");
            System.out.println(allotjaments);
            assertTrue(allotjaments.contains("100%"));

            // Neteja -> 50% iluminació
            camping.afegirIncidencia(2, "Neteja", "ALL2", "01/01/2023");
            allotjaments = camping.llistarAllotjaments("No Operatiu");
            System.out.println(allotjaments);
            assertTrue(allotjaments.contains("50%"));

            // Tancament -> 0% iluminació
            camping.afegirIncidencia(3, "Tancament", "ALL3", "01/01/2023");
            allotjaments = camping.llistarAllotjaments("No Operatiu");
            System.out.println(allotjaments);
            assertTrue(allotjaments.contains("0%"));

        } catch (ExcepcioCamping e) {
            fail("No debería lanzar excepción: " + e.getMessage());
        }
    }
}