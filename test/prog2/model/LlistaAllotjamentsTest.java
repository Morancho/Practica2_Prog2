package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import static org.junit.jupiter.api.Assertions.*;

class LlistaAllotjamentsTest {
    private LlistaAllotjaments llista;
    private Parcela parcela1;
    private Bungalow bungalow1;

    @BeforeEach
    void setUp() throws ExcepcioCamping {
        llista = new LlistaAllotjaments();

        // Crear algunos allotjaments de prueba
        parcela1 = new Parcela("Parcela Nord", "ALL1", true, "100%", 64.0f, true);
        bungalow1 = new Bungalow("Bungalow Nord", "ALL2", true, "100%", 22f,
                2, 4, 1, true, true, true);

        llista.afegirAllotjament(parcela1);
        llista.afegirAllotjament(bungalow1);
    }

    @Test
    void testAfegirAllotjament() throws ExcepcioCamping {
        assertEquals(2, llista.getAllotjaments().size());

        Parcela novaParcela = new Parcela("Parcela Sud", "ALL3", true, "100%", 64.0f, true);
        llista.afegirAllotjament(novaParcela);

        assertEquals(3, llista.getAllotjaments().size());
        assertTrue(llista.getAllotjaments().contains(novaParcela));
    }

    @Test
    void testBuidar() {
        llista.buidar();
        assertEquals(0, llista.getAllotjaments().size());
    }

    @Test
    void testLlistarAllotjamentsOperatius() throws ExcepcioCamping {
        String result = llista.llistarAllotjaments("Operatiu");
        assertTrue(result.contains("Parcela Nord"));
        assertTrue(result.contains("Bungalow Nord"));
    }

    @Test
    void testLlistarAllotjamentsNoOperatius() throws ExcepcioCamping {
        // Cerramos un allotjament para probar
        parcela1.tancarAllotjament(new Incidencia(1, parcela1, "Reparacio", "01/01/2023"));

        String result = llista.llistarAllotjaments("No Operatiu");
        assertTrue(result.contains("Parcela Nord"));
        assertFalse(result.contains("Bungalow Nord")); // Este sigue operativo
    }

    @Test
    void testLlistarAllotjamentsTots() throws ExcepcioCamping {
        String result = llista.llistarAllotjaments("Tots");
        assertTrue(result.contains("Parcela Nord"));
        assertTrue(result.contains("Bungalow Nord"));
    }

    @Test
    void testLlistarAllotjamentsEstatInvalid() {
        assertThrows(ExcepcioCamping.class, () -> {
            llista.llistarAllotjaments("EstatInvalid");
        });
    }

    @Test
    void testContainsAllotjamentOperatiu() {
        assertTrue(llista.containsAllotjamentOperatiu());

        // Cerramos todos los allotjaments
        llista.getAllotjaments().forEach(a ->
                a.tancarAllotjament(new Incidencia(1, a, "Tancament", "12/03/2024")));

        assertFalse(llista.containsAllotjamentOperatiu());
    }

    @Test
    void testContains() {
        assertTrue(llista.contains(parcela1));
        assertTrue(llista.contains(bungalow1));

        Parcela parcelaNoExistente = new Parcela("No existe", "ALL99", true, "100%", 50.0f, false);
        assertFalse(llista.contains(parcelaNoExistente));
    }

    @Test
    void testGetAllotjament() throws ExcepcioCamping {
        assertEquals(parcela1, llista.getAllotjament("ALL1"));
        assertEquals(bungalow1, llista.getAllotjament("ALL2"));
    }

    @Test
    void testGetAllotjamentNoExistent() {
        assertThrows(ExcepcioCamping.class, () -> {
            llista.getAllotjament("ALL99");
        });
    }

    @Test
    void testUpdateAllotjamentEstat() throws ExcepcioCamping {
        Incidencia incidencia = new Incidencia(1, parcela1, "Neteja", "04/10/2021");
        llista.updateAllotjamentEstat(parcela1, incidencia);

        Allotjament actualizado = llista.getAllotjament("ALL1");
        assertFalse(actualizado.getEstat());
        assertEquals("50%", actualizado.getIluminacio());
    }

    @Test
    void testGetAllotjaments() {
        assertEquals(2, llista.getAllotjaments().size());
        assertTrue(llista.getAllotjaments().contains(parcela1));
        assertTrue(llista.getAllotjaments().contains(bungalow1));
    }
}