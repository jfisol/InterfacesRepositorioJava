package org.generics.Class;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion implements Iterable {

    private List objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList();
    }

    public void add (Object objeto){
        if (this.objetos.size() <= max ){
          this.objetos.add(objeto);
        }else{
            throw new RuntimeException("No hay mas espacio");
        }
    }

    //metodo obligacion de la interfaz iterable
    @Override
    public Iterator iterator() {
        return this.objetos.iterator();
    }
}
