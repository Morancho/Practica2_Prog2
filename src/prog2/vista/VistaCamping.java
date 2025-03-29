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



                    int num = -1;
                    String tipus = "";
                    String idAllotjament = "";
                    String data = "";

                    try {


                        boolean idValid = false;
                        while (!idValid) {
                            System.out.print("\nIntrodueix el id de l'incidència: ");
                            num = sc.nextInt();
                            System.out.print("\nIntroduieix el tipus: Reparacio, Neteja, o Tancament: ");
                            tipus = sc.next();
                            System.out.print("\nIntroduieix el id de l'allotjament: ");
                            idAllotjament = sc.next();
                            if (idAllotjament.equals("0")) {
                                break;
                            }
                            System.out.print("\nIntroduieix la data: ");
                            data = sc.next();

                            // Intenta validar añadiendo incidencia, si no puede, lanza error controlado
                            try {

                                camping.afegirIncidencia(num, tipus, idAllotjament, data);
                                idValid = true;
                            } catch (ExcepcioCamping e) {
                                System.out.println(e.getMessage());
                                sc.nextLine();
                                break;

                            }
                        }





                    } catch (Exception e) {
                        System.err.println("S'ha produït un error en afegir la incidència: " + e.getMessage());
                        sc.nextLine();
                    }
                    break;


                case ELIMINAR_INCIDENCIA:

                    try {
                        System.out.println("Introdueix l'id de l'incidencia a eliminar: ");
                        num = sc.nextInt();
                        camping.eliminarIncidencia(num);
                    } catch(ExcepcioCamping  e){
                        System.err.println(e.getMessage());
                        sc.nextLine();

                    } catch (Exception e) {
                        System.err.println("S'ha produït un error en eliminar la incidència: " + e.getMessage());

                        sc.nextLine();
                    }

                    break;
                case TOTAL_ACCESSOS_COTXE:
                    System.out.println("El numero d'accesssos accessibles amb cotxe es: " + camping.calculaAccessosAccessibles());

                    break;
                case METRES_QUADRATS_ASFALTAT:
                    System.out.println("El numero total de metres quadrats d'asfalt són: " + camping.calculaMetresQuadratsAsfalt());
                    break;
                case GUARDAR_CAMPING:
                    System.out.println("Introdueix el nom del fitxer:");
                    String nomFitxer = sc.nextLine();
                    try {
                        camping.save(nomFitxer);
                    } catch (ExcepcioCamping e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case RECUPERAR_CAMPING:

                    System.out.println("Introdueix el nom del fitxer:");
                    nomFitxer = sc.nextLine();
                    camping=Camping.load(nomFitxer);

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
                    try {
                        String allotjaments = camping.llistarAllotjaments("Tots");
                        if (allotjaments.isEmpty()) {
                            System.out.println("No hi ha allotjaments disponibles.");
                        } else {
                            System.out.println(allotjaments);
                        }
                    } catch (Exception e) {
                        System.err.println("S'ha produït un error en llistar allotjaments: " + e.getMessage());
                    }
                    break;

                case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                    try {
                        String allotjamentsOperatius = camping.llistarAllotjaments("Operatiu");
                        if (allotjamentsOperatius.isEmpty()) {
                            System.out.println("No hi ha allotjaments operatius.");
                        } else {
                            System.out.println(allotjamentsOperatius);
                        }
                    } catch (Exception e) {
                        System.err.println("S'ha produït un error en llistar allotjaments operatius: " + e.getMessage());
                    }
                    break;

                case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                    try {
                        String allotjamentsNoOperatius = camping.llistarAllotjaments("NoOperatiu");
                        if (allotjamentsNoOperatius.isEmpty()) {
                            System.out.println("No hi ha allotjaments no operatius.");
                        } else {
                            System.out.println(allotjamentsNoOperatius);
                        }
                    } catch (Exception e) {
                        System.err.println("S'ha produït un error en llistar allotjaments no operatius: " + e.getMessage());
                    }
                    break;

                case LLISTAR_ACCESSOS_OBERTS:
                    try {
                        String accessosOberts = camping.llistarAccessos("Obert");
                        if (accessosOberts.isEmpty()) {
                            System.out.println("No hi ha accessos oberts.");
                        } else {
                            System.out.println(accessosOberts);
                        }
                    } catch (Exception e) {
                        System.err.println("S'ha produït un error en llistar accessos oberts: " + e.getMessage());
                    }
                    break;

                case LLISTAR_ACCESSOS_TANCATS:
                    try {
                        String accessosTancats = camping.llistarAccessos("Tancat");
                        if (accessosTancats.isEmpty()) {
                            System.out.println("No hi ha accessos tancats.");
                        } else {
                            System.out.println(accessosTancats);
                        }
                    } catch (Exception e) {
                        System.err.println("S'ha produït un error en llistar accessos tancats: " + e.getMessage());
                    }
                    break;

                case LLISTAR_INCIDENCIES:
                    try {
                        String incidencies = camping.llistarIncidencies();
                        if (incidencies.isEmpty()) {
                            System.out.println("No hi ha incidències registrades.");
                        } else {
                            System.out.println(incidencies);
                        }
                    } catch (Exception e) {
                        System.err.println("S'ha produït un error en llistar incidències: " + e.getMessage());
                    }
                    break;

            }

        } while(opcio!= OpcionsMenuSecundari.MENU_SECUND_SORTIR);
    }
}
