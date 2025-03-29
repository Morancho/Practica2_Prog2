package prog2.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.model.Allotjament;
import prog2.model.InAllotjament;

class AllotjamentTest {

    private Allotjament allotjament;

    @BeforeEach
    void setUp() {
        // Creem una instància anònima d'Allotjament per a tests

        allotjament = new Allotjament("Allotjament Test", "ID001", 5, 3, true, "50") {
            @Override
            public boolean correcteFuncionament() {
                return false;
            }
        };

    }

    @Test
    void constructorValid() {
        assertEquals("Allotjament Test", allotjament.getNom());
        assertEquals("ID001", allotjament.getId());
        assertEquals(5, allotjament.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(3, allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA));
    }



    @Test
    void testSetEstadaMinima() {
        allotjament.setEstadaMinima(6, 4);
        assertEquals(6, allotjament.getEstadaMinima(InAllotjament.Temp.ALTA));
        assertEquals(4, allotjament.getEstadaMinima(InAllotjament.Temp.BAIXA));
    }







    @Test
    void tancarAllotjament() {
        Incidencia incidencia = new Incidencia(1, allotjament, "Neteja", "13/06/2024");
        allotjament.tancarAllotjament(incidencia);
        assertFalse(allotjament.getEstat());
    }

    @Test
    void obrirAllotjament() {
        allotjament.obrirAllotjament();
        assertTrue(allotjament.getEstat());
    }
}



