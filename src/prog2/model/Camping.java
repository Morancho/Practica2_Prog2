package prog2.model;
import prog2.vista.*;

import java.io.*;

import java.util.*;

public class Camping implements InCamping, Serializable {
    private String nomCamping;
    LlistaAllotjaments llistaAllotjaments = new LlistaAllotjaments();
    LlistaIncidencies llistaIncidencies = new LlistaIncidencies();
    LlistaAccessos llistaAccessos = new LlistaAccessos();





    public Camping (String nom) {
        this.nomCamping = nom;
    }

    @Override
    public String getNomCamping() {
        return nomCamping;
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return llistaAllotjaments.llistarAllotjaments(estat);
    }





    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        if(infoEstat.equals("Obert")){
            return llistaAccessos.llistarAccessos(true);
        }
        else if(infoEstat.equals("Tancat")){
            return llistaAccessos.llistarAccessos(false);
        }
        else{
            throw new ExcepcioCamping("No existeix l'estat: " + infoEstat);
        }

    }

    @Override
    public String llistarIncidencies() throws ExcepcioCamping {
        return llistaIncidencies.llistarIncidencies();
    }

    @Override
    public void afegirIncidencia(int num, String tipus, String idAllotjament, String data) throws ExcepcioCamping {
        System.out.println("Buscant allotjament amb ID: " + idAllotjament);

        // Validamos si el ID del alojamiento existe antes de proceder
        Allotjament allotjament;
        try {
            allotjament = llistaAllotjaments.getAllotjament(idAllotjament); // Llamada al método de búsqueda
        } catch (ExcepcioCamping e) {
            // Mensaje claro para el usuario si el ID no existe
            throw new ExcepcioCamping("Error: No existeix l'allotjament amb id: " + idAllotjament + ". Si us plau, comprova el ID.");
        }

        // Comprobar si ya existe una incidencia con el 'num' introducido
        if (llistaIncidencies.getIncidencia(num) != null) {
            throw new ExcepcioCamping("Error: Ja existeix una incidència amb l'id: " + num);
        }

        // Añadimos la incidencia y actualizamos listas
        llistaIncidencies.afegirIncidencia(num, tipus, allotjament, data);
        Incidencia inc = llistaIncidencies.getIncidencia(num);
        llistaAllotjaments.updateAllotjamentEstat(allotjament, inc);
        llistaAccessos.actualitzaEstatAccessos();
    }



    @Override
    public void eliminarIncidencia(int num) throws ExcepcioCamping {
        try {


            Incidencia inc = llistaIncidencies.getIncidencia(num);
            llistaIncidencies.eliminarIncidencia(inc);
            inc.getAllotjament().obrirAllotjament();
            llistaAccessos.actualitzaEstatAccessos();
        }
        catch (ExcepcioCamping e) {
            throw new ExcepcioCamping(e.getMessage());
        }
    }

    @Override
    public int calculaAccessosAccessibles() {
        return llistaAccessos.calculaAccessosAccessibles();
    }

    @Override
    public float calculaMetresQuadratsAsfalt() {
        return llistaAccessos.calculaMetresQuadratsAsfalt();
    }




    @Override
    public void inicialitzaDadesCamping() {



        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        llistaAccessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        llistaAccessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        llistaAccessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        llistaAccessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        llistaAccessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        llistaAccessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc12);


        /* Pistes */
        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);



    }
    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        File fitxer = new File(camiDesti+".txt");

        // Guardar l'objecte serialitzat
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fitxer))) {
            oos.writeObject(this);
            System.out.println("Camping guardat correctament en " + camiDesti);
        } catch (IOException e) {
            throw new ExcepcioCamping("Error al guardar el camping: " + e.getMessage());
        }

        // Ruta per guardar l'arxiu .txt en el directori "prog2/model"
        File fitxerText = new File("src/prog2/model/" + camiDesti + ".txt");

        // Verificar si l'arxiu .txt ja existeiz+x
        if (fitxerText.exists()) {
            System.out.println("Archivo de texto encontrado: " + fitxerText.getName());
        } else {
            // Si no existeix, el creem.
            try {
                if (fitxerText.createNewFile()) {
                    System.out.println("Archivo de texto creado: " + fitxerText.getName());
                } else {
                    System.out.println("Error al crear el archivo de texto.");
                }
            } catch (IOException e) {
                throw new ExcepcioCamping("Error al crear el archivo de texto: " + e.getMessage());
            }
        }

        // Escriure en el .txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fitxerText, true))) {
            // Escriure el nom del Camping
            writer.write("Nom del Camping:");
            writer.newLine();
            writer.write(nomCamping);
            writer.newLine();



            // Guardar la llista d'allotjaments amb llistarAllotjaments
            writer.write("Allotjaments:");
            writer.newLine();
            writer.write(llistarAllotjaments("Tots"));
            writer.newLine();



            // Guardar la llista d'accessos amb llistarAccessos
            writer.write("Accessos:");
            writer.newLine();
            writer.write(llistarAccessos("Obert")); //
            writer.newLine();




            //Guardar les incidències amb llistarIncidencies
            writer.write("Incidències:");
            writer.newLine();
            writer.write(llistarIncidencies());
            writer.newLine();


            System.out.println("Dades guardades correctament en " + fitxerText.getName());
        } catch (IOException e) {
            throw new ExcepcioCamping("Error al escriure al fitxer: " + e.getMessage());
        }
    }

    public static Camping load(String camiOrigen) throws ExcepcioCamping {
        Camping camp = null;
        // completar el codi
        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {
            fin = new FileInputStream(camiOrigen+".txt");
            ois = new ObjectInputStream(fin);
            camp = (Camping) ois.readObject();

        } catch (IOException e) {
            System.out.println(e.getMessage());


        } catch (ClassNotFoundException e) {
            throw new ExcepcioCamping("No s'ha trobat la classe camping al fitxer.");

        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());

            }

            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return camp;
    }

}
