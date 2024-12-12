package org.figueroa.poointerfaces.repositorio;

import org.figueroa.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements CrudRepositorio, OrdenableRepositorio,PaginableRepositorio{

   private List<Cliente>datasource;

    public ClienteListRepositorio() {

        this.datasource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return this.datasource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado = null;
        for(Cliente cli: datasource){
            if (cli.getId().equals(id)){
                resultado = cli;
            }
        }
        return resultado;
    }

    @Override
    public void crearCliente(Cliente cliente) {

        this.datasource.add(cliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        Cliente clie = this.porId(cliente.getId());
        clie.setNombre(cliente.getNombre());
        clie.setApellido(cliente.getApellido());

    }

    @Override
    public void eliminarCliente(Integer id) {
        Cliente clie = this.porId(id);
        datasource.remove(clie);

    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente>ListaOrdenada =new ArrayList<>(this.datasource);

        //Cualquier implementacion de un list tiene el objeto de tipo Sort
        ListaOrdenada.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {
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

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return this.datasource.subList(desde,hasta);
    }
}
