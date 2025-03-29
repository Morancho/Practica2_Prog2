package prog2.vista;

import prog2.model.Camping;

import java.util.Scanner;

public class VistaCamping {
    Camping camping;

    static private enum OpcionsMenuPrincipal {
        MENU_LLISTES,
        AFEGIR_INCIDENCIA,
        ELIMINAR_INCIDENCIA,
        TOTAL_ACCESSOS_COTXE,
        METRES_QUADRATS_ASFALTAT,
        GUARDAR_CAMPING,
        RECUPERAR_CAMPING,
        SORTIR
    };

    static private enum OpcionsMenuSecundari {
        LLISTAR_ALLOTJAMENTS,
        LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_INCIDENCIES,
        MENU_SECUND_SORTIR
    };

    // Declarem descripcions personalitzades per a les opcions del menú principal
    static private String[] MenuPrincipal={
            "SubMenu de llistes",
            "Afegir una incidència",
            "Eliminar una incidència",
            "Calcular i mostrar el número total d’accessos que proporcionen accessibilitat amb cotxe",
            "Calcular i mostrar el número total de metres quadrats d’asfalt dels accessos asfaltats",
            "Guardar càmping",
            "Recuperar càmping",
            "Sortir de l’aplicació"};

    // Declarem descripcions personalitzades per a les opcions del menú secundari
    static private String[] MenuSecundari={
            "Llistar la informació de tots els allotjaments",
            "Llistar la informació dels allotjaments operatius",
            "Llistar la informació dels allotjaments no operatius",
            "Llistar la informació dels accessos oberts",
            "Llistar la informació dels accessos tancats",
            "Llistar la informació de les incidències actuals"};

    public VistaCamping(String nomCamping) {
        this.camping = new Camping(nomCamping);
    }

    public void gestioCamping() {


        Scanner sc = new Scanner(System.in);

        // Creem l'objecte per al menú. Li passem com a primer parà metre el nom del menú
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal", OpcionsMenuPrincipal.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(MenuPrincipal);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuPrincipal opcio = null;
        camping.inicialitzaDadesCamping();
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=menu.getOpcio(sc);

            /*
            MENU_LLISTES,
            AFEGIR_INCIDENCIA,
            ELIMINAR_INCIDENCIA,
            TOTAL_ACCESSOS_COTXE,
            METRES_QUADRATS_ASFALTAT,
            GUARDAR_CAMPING,
            RECUPERAR_CAMPING,
            SORTIR
             */

            switch(opcio) {
                case MENU_LLISTES:
                    // Cridem el métode de gestió del menú secundari
                    gestioMenuSecundari(sc);
                    break;
                case AFEGIR_INCIDENCIA:

                    System.out.println("\nAquests són els allotjaments disponibles:");
                    System.out.println(camping.llistarAllotjaments("Tots")); // Muestra los IDs disponibles

                    int num = -1;
                    String tipus = "";
                    String idAllotjament = "";
                    String data = "";

                    try {
                        System.out.print("\nIntrodueix el id de l'incidència: ");
                        num = sc.nextInt();
                        System.out.print("\nIntroduieix el tipus: Reparacio, Neteja, o Tancament: ");
                        tipus = sc.next();

                        boolean idValid = false;
                        while (!idValid) {
                            System.out.print("\nIntroduieix el id de l'allotjament o escriu 0 per sortir: ");
                            idAllotjament = sc.next();
                            if (idAllotjament.equals("0")) {
                                break;
                            }
                            System.out.print("\nIntroduieix la data: ");
                            data = sc.next();

                            // Intenta validar el ID. Si existe, continúa; si no, lanza error controlado
                            try {

                                camping.afegirIncidencia(num, tipus, idAllotjament, data);
                                idValid = true;
                            } catch (ExcepcioCamping e) {
                                System.out.println(e.getMessage());
                                System.out.println("Si us plau, introdueix un ID vàlid.");
                            }
                        }





                    } catch (Exception e) {
                        System.out.println("S'ha produït un error en afegir la incidència: " + e.getMessage());
                    }
                    break;


                case ELIMINAR_INCIDENCIA:
                    break;
                case TOTAL_ACCESSOS_COTXE:
                    System.out.println("Fins aviat!");
                    break;
                case METRES_QUADRATS_ASFALTAT:
                    System.out.println("Fins aviat!");
                    break;
                case GUARDAR_CAMPING:
                    System.out.println("Fins aviat!");
                    break;
                case RECUPERAR_CAMPING:
                    System.out.println("Fins aviat!");
                    break;
                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio!= OpcionsMenuPrincipal.SORTIR);
    }

    public void gestioMenuSecundari(Scanner sc) {

        // Creem l'objecte per al menú. Li passem com a primer parÃ metre el nom del menú
        Menu<OpcionsMenuSecundari> menu = new Menu<OpcionsMenuSecundari>("Menu Secundari", OpcionsMenuSecundari.values());

        // Assignem la descripció de les opcions
        menu.setDescripcions(MenuSecundari);

        // Obtenim una opció des del menú i fem les accions pertinents
        OpcionsMenuSecundari opcio = null;
        do {
            // Mostrem les opcions del menú
            menu.mostrarMenu();

            // Demanem una opcio
            opcio=menu.getOpcio(sc);

            /*
            LLISTAR_ALLOTJAMENTS,
            LLISTAR_ALLOTJAMENTS_OPERATIUS,
            LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
            LLISTAR_ACCESSOS_OBERTS,
            LLISTAR_ACCESSOS_TANCATS,
            LLISTAR_INCIDENCIES,
            MENU_SECUND_SORTIR
             */

            // Fem les accions necessàries
            switch(opcio) {
                case LLISTAR_ALLOTJAMENTS:
                    camping.llistarAllotjaments("Tots");
                    break;
                case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                   camping.llistarAllotjaments("Operatiu");
                    break;
                case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                    camping.llistarAllotjaments("NoOperatiu");
                    break;
                case LLISTAR_ACCESSOS_OBERTS:
                    camping.llistarAccessos("Obert");
                    break;
                case LLISTAR_ACCESSOS_TANCATS:
                    camping.llistarAccessos("Tancat");
                    break;
                case LLISTAR_INCIDENCIES:
                    camping.llistarIncidencies();
                    break;
                case MENU_SECUND_SORTIR:

                    break;
            }

        } while(opcio!= OpcionsMenuSecundari.MENU_SECUND_SORTIR);
    }
}
