package org.figueroa.poointerfaces.repositorio;

import org.figueroa.poointerfaces.modelo.BaseEntity;
import org.figueroa.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractaClienteListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T>{

   protected List<T>datasource;

    public AbstractaClienteListRepositorio() {

        this.datasource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.datasource;
    }

    @Override
    public T porId(Integer id) {
        T resultado = null;
        for(T t: datasource){
            if (t.getId().equals(id)){
                resultado = t;
            }
        }
        return resultado;
    }

    @Override
    public void crearCliente(T t) {

        this.datasource.add(t);
    }

  /*  @Override
    public void editarCliente(T t) {
        Cliente clie = this.porId(t.getId());
        clie.setNombre(t.getNombre());
        clie.setApellido(t.getApellido());

    }*/

    @Override
    public void eliminarCliente(Integer id) {
        T clie = this.porId(id);
        datasource.remove(clie);

    }

  /*  @Override
    public List<T> listar(String campo, Direccion dir) {
        List<T>ListaOrdenada =new ArrayList<>(this.datasource);

        //Cualquier implementacion de un list tiene el objeto de tipo Sort
        ListaOrdenada.sort(new Comparator<T>() {
            @Override
            public int compare(T a, T b) {
                int resultado = 0;
                if (dir == Direccion.ASC){
                    switch (campo){
                        case "id" ->
                            resultado = a.getId().compareTo(b.getId());

                        case "nombre" ->
                            resultado = a.getNombre().compareTo(b.getNombre());
                        case "apellido" ->
                            resultado = a.getApellido().compareTo(b.getApellido());
                    }

                }else if(dir == Direccion.DESC){
                    switch (campo){
                        case "id" ->
                                resultado = b.getId().compareTo(a.getId());

                        case "nombre" ->
                                resultado = b.getNombre().compareTo(a.getNombre());
                        case "apellido" ->
                                resultado = b.getApellido().compareTo(a.getApellido());
                    }
                }
                return resultado;
            }
        });
        return ListaOrdenada;
    }
*/
    @Override
    public List<T> listar(int desde, int hasta) {
        return this.datasource.subList(desde,hasta);
    }
}
