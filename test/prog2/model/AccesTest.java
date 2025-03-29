package prog2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccesTest {
    Acces acces = new CamiTerra("CamiTerra", true, 10);
    @Test
    void afegirAllotjament() {
        acces = new CamiTerra("CamiTerra", true, 10);
        Allotjament allotjament = new Parcela("Parcela nord", "ALL1", true, "50", 20.0f, true);
        acces.afegirAllotjament(allotjament);
        assertEquals(allotjament, acces.getllistaAllotjament().getAllotjament("ALL1"));
    }

    @Test
    void tancarAcces() {
        acces.tancarAcces();
        assertFalse(acces.getEstat());
    }

    @Test
    void obrirAcces() {
        acces.obrirAcces();
        assertTrue(acces.getEstat());
    }

    @Test
    void isAccessibilitat() {
        assertFalse(acces.isAccessibilitat());
    }
}