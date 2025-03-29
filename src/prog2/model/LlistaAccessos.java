package prog2.model;

import prog2.vista.ExcepcioCamping;

import prog2.model.LlistaAllotjaments;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class LlistaAccessos implements InLlistaAccessos, Serializable {

    private Acces acc;
    private ArrayList<Acces> llistaAccessos;
    public LlistaAccessos() {
        // Inicializamos la lista para evitar NullPointerException
        this.llistaAccessos = new ArrayList<>();
    }




    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {

        this.llistaAccessos.add(acc);

    }

    @Override
    public void buidar() {
        llistaAccessos.clear();

    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        String result = "";
        int cont = 0;
        Iterator<Acces> it = llistaAccessos.iterator();


        while (it.hasNext()) {
            Acces acc = it.next();

            if(acc.getEstat() == estat){
                result += acc + "\n";
                cont++;
            }

        }
        if (cont == 0) {
            throw new ExcepcioCamping("No hi ha cap acces amb aquest estat.");
        }
        return result;
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        Iterator<Acces> it = llistaAccessos.iterator();

        while(it.hasNext()) {
            boolean oper = true;
            Acces acc = it.next();
            LlistaAllotjaments llistaAllotjaments = acc.getllistaAllotjament();
            Iterator<Allotjament> it2 = llistaAllotjaments.getAllotjaments().iterator();
            while(it2.hasNext()) {
                Allotjament allotjament = it2.next();
                System.out.println(allotjament.getNom() + ".............."+ allotjament.getEstat());
                if(!allotjament.getEstat()){

                    oper = false;
                }
            }
            acc.setEstat(oper);


        }
    }

    @Override
    public int calculaAccessosAccessibles() throws ExcepcioCamping {
        int num = 0;
        Iterator<Acces> it = llistaAccessos.iterator();
        while(it.hasNext()) {
            Acces acc = it.next();
            if(acc.isAccessibilitat()){
                num++;
            }
        }
        return num;
    }

    @Override
    public float calculaMetresQuadratsAsfalt() throws ExcepcioCamping {
        float num = 0.0f;

        Iterator<Acces> it = llistaAccessos.iterator();
        while(it.hasNext()){
            Acces acc = it.next();
            if(acc instanceof AccesAsfaltat){
                num += ((AccesAsfaltat) acc).getAreaAsfalt();

            }
        }
        return num;
    }

    public ArrayList<Acces> getAccessos(){
        return this.llistaAccessos;
    }
}
