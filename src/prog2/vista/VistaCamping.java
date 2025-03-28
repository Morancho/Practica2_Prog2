package prog2.vista;

import prog2.model.Camping;

public class VistaCamping {
    Camping camping;

    static private enum OpcionsMenuPrincipal {
        LLISTAR_ALLOTJAMENTS,
        LLISTAR_ALLOTJAMENTS_OPERATIUS ,
        MENU_PRINCIPAL_SUBMENU1,
        MENU_PRINCIPAL_SORTIR};




    public VistaCamping(String nomCamping) {
        this.camping = new Camping(nomCamping);
    }

    public void gestioCamping() {

        String [] opcions =  {};

        Menu<String> menu = new Menu<String>(camping.getNomCamping(), opcions);

        menu.mostrarMenu();

    }
}
