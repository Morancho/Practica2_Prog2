
package prog2.model;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaAccessosTest {

    private LlistaAccessos llistaAccessos;
    private Acces acces1;
    private Acces acces2;
    private AccesAsfaltat accesAsfaltat1;
    private AccesAsfaltat accesAsfaltat2;
    private Allotjament parcela;
    private Allotjament bungalow;

    @BeforeEach
    public void setUp() throws ExcepcioCamping {
        llistaAccessos = new LlistaAccessos();

        // Create test access paths
        acces1 = new CamiTerra("CT1", true, 100.0f);
        acces2 = new CarreteraTerra("CRT1", true, 150.0f, 3.0f);
        accesAsfaltat1 = new CamiAsfaltat("CA1", true, 200.0f);
        accesAsfaltat2 = new CarreteraAsfaltada("CRA1", true, 300.0f, 10000.0f);

        // Create test accommodations
        parcela = new Parcela("Parcela 1", "P1", true, "100%", 70.0f, true);
        bungalow = new Bungalow("Bungalow 1", "B1", true, "100%", 30.0f, 2, 4, 1, true, true, true);

        // Add accommodations to access paths
        acces1.afegirAllotjament(parcela);
        acces2.afegirAllotjament(bungalow);
        accesAsfaltat1.afegirAllotjament(parcela);
        accesAsfaltat2.afegirAllotjament(bungalow);

        // Add access paths to the list
        llistaAccessos.afegirAcces(acces1);
        llistaAccessos.afegirAcces(acces2);
        llistaAccessos.afegirAcces(accesAsfaltat1);
        llistaAccessos.afegirAcces(accesAsfaltat2);
    }

    @Test
    void testConstructor() {
        assertNotNull(llistaAccessos);
        assertEquals(4, llistaAccessos.getLlistaAccessos().size());
    }

    @Test
    void testAfegirAcces() throws ExcepcioCamping {
        int initialSize = llistaAccessos.getLlistaAccessos().size();
        Acces newAcces = new CamiTerra("CT2", true, 60.0f);
        llistaAccessos.afegirAcces(newAcces);
        assertEquals(initialSize + 1, llistaAccessos.getLlistaAccessos().size());
    }

    @Test
    void testBuidar() {
        llistaAccessos.buidar();
        assertEquals(0, llistaAccessos.getLlistaAccessos().size());
    }

    @Test
    void testLlistarAccessosOberts() throws ExcepcioCamping {
        String result = llistaAccessos.llistarAccessos(true);
        assertNotNull(result);
        assertTrue(result.contains("CT1") || result.contains("CRT1") ||
                result.contains("CA1") || result.contains("CRA1"));
    }

    @Test
    void testLlistarAccessosTancats() throws ExcepcioCamping {
        // Close all access paths
        for (Acces acces : llistaAccessos.getLlistaAccessos()) {
            acces.tancarAcces();
        }

        assertThrows(ExcepcioCamping.class, () -> {
            llistaAccessos.llistarAccessos(true);
        });
    }

    @Test
    void testActualitzaEstatAccessos() throws ExcepcioCamping {
        // Make all accommodations non-operative
        parcela.setEstat(false);
        bungalow.setEstat(false);

        llistaAccessos.actualitzaEstatAccessos();

        for (Acces acces : llistaAccessos.getLlistaAccessos()) {
            assertFalse(acces.getEstat());
        }

        // Make one accommodation operative
        parcela.setEstat(true);
        llistaAccessos.actualitzaEstatAccessos();

        boolean foundOpen = false;
        for (Acces acces : llistaAccessos.getLlistaAccessos()) {
            if (acces.getEstat()) {
                foundOpen = true;
                break;
            }
        }
        assertTrue(foundOpen);
    }

    @Test
    void testCalculaAccessosAccessibles() throws ExcepcioCamping {
        int accessibleCount = llistaAccessos.calculaAccessosAccessibles();
        assertEquals(2, accessibleCount); // All are accessible in setup


        Acces nonAccessible = new CarreteraAsfaltada("CT6", true, 50.0f, 5000.0f);
        llistaAccessos.afegirAcces(nonAccessible);
        assertEquals(3, llistaAccessos.calculaAccessosAccessibles());
    }

    @Test
    void testCalculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        float expectedAsphalt = accesAsfaltat1.getAreaAsfalt() + accesAsfaltat2.getAreaAsfalt();
        float actualAsphalt = llistaAccessos.calculaMetresQuadratsAsfalt();
        assertEquals(expectedAsphalt, actualAsphalt);
    }



    @Test
    void testLlistarAccessosEmptyList() throws ExcepcioCamping {
        llistaAccessos.buidar();
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAccessos.llistarAccessos(true);
        });
    }
}
