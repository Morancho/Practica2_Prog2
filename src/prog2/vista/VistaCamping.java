package prog2.vista;

import prog2.model.Camping;

public class VistaCamping {
    Camping camping;

    static private enum OpcionsMenuPrincipal {
        LLISTAR_ALLOTJAMENTS,
        LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_INCIDENCIES,
        MENU_SECUND_SORTIR
    };


    public VistaCamping(String nomCamping) {
        this.camping = new Camping(nomCamping);
    }

    public void gestioCamping() {

        String [] opcions =  {};

        Menu<String> menu = new Menu<String>(camping.getNomCamping(), opcions);

        menu.mostrarMenu();

    }
}
