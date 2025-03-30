package prog2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog2.vista.ExcepcioCamping;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LlistaAccessosTest {

    private LlistaAccessos llista;
    private Acces accesA, accesB;
    private AccesAsfaltat asfaltatA, asfaltatB;
    private Allotjament tenda, cabana;

    @BeforeEach
    public void setUp() throws ExcepcioCamping {
        llista = new LlistaAccessos();

        accesA = new CamiTerra("T1", true, 80.0f);
        accesB = new CarreteraTerra("T2", true, 120.0f, 2.5f);
        asfaltatA = new CamiAsfaltat("A1", true, 180.0f);
        asfaltatB = new CarreteraAsfaltada("A2", true, 250.0f, 8000.0f);

        tenda = new Parcela("Tenda", "TND", true, "80%", 50.0f, false);
        cabana = new Bungalow("Cabana", "CAB", true, "90%", 40.0f, 3, 5, 2, false, false, true);

        accesA.afegirAllotjament(tenda);
        accesB.afegirAllotjament(cabana);
        asfaltatA.afegirAllotjament(tenda);
        asfaltatB.afegirAllotjament(cabana);

        llista.afegirAcces(accesA);
        llista.afegirAcces(accesB);
        llista.afegirAcces(asfaltatA);
        llista.afegirAcces(asfaltatB);
    }

    @Test
    void testConstructor() {
        assertEquals(4, llista.getLlistaAccessos().size());
    }

    @Test
    void testAfegirAcces() throws ExcepcioCamping {
        int midaInicial = llista.getLlistaAccessos().size();
        Acces nouAcces = new CamiTerra("T3", true, 70.0f);
        llista.afegirAcces(nouAcces);
        assertEquals(midaInicial + 1, llista.getLlistaAccessos().size());
    }

    @Test
    void testBuidar() {
        llista.buidar();
        assertTrue(llista.getLlistaAccessos().isEmpty());
    }

    @Test
    void testLlistarAccessosOberts() throws ExcepcioCamping {
        String resultat = llista.llistarAccessos(true);
        assertFalse(resultat.isEmpty(), "La llista d'accessos oberts no hauria d'estar buida.");
    }



    @Test
    void testActualitzaEstatAccessos() throws ExcepcioCamping {
        tenda.setEstat(false);
        cabana.setEstat(false);
        llista.actualitzaEstatAccessos();
        llista.getLlistaAccessos().forEach(acces -> assertFalse(acces.getEstat()));

        tenda.setEstat(true);
        llista.actualitzaEstatAccessos();
        assertTrue(llista.getLlistaAccessos().stream().anyMatch(Acces::getEstat));
    }

    @Test
    void testCalculaAccessosAccessibles() throws ExcepcioCamping {
        assertEquals(2, llista.calculaAccessosAccessibles());

        Acces nouAcces = new CarreteraAsfaltada("T4", true, 60.0f, 4000.0f);
        llista.afegirAcces(nouAcces);
        assertEquals(3, llista.calculaAccessosAccessibles());
    }

    @Test
    void testCalculaMetresQuadratsAsfalt() {
        float asfaltEsperat = asfaltatA.getAreaAsfalt() + asfaltatB.getAreaAsfalt();
        float asfaltReal = llista.calculaMetresQuadratsAsfalt();
        assertEquals(asfaltEsperat, asfaltReal, 0.001f);
    }

    @Test
    void testLlistarAccessosEmptyList() throws ExcepcioCamping {
        llista.buidar();
        assertThrows(ExcepcioCamping.class, () -> llista.llistarAccessos(true));
    }
}
