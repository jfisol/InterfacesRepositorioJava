package org.figueroa.poointerfaces.repositorio.lista;

import org.figueroa.poointerfaces.modelo.Cliente;
import org.figueroa.poointerfaces.repositorio.AbstractaClienteListRepositorio;
import org.figueroa.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public  class ClienteListRepositorio extends AbstractaClienteListRepositorio<Cliente> {

 

    public ClienteListRepositorio() {

        this.datasource = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return this.datasource;
    }

    /*
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
*/
  /*  @Override
    public void crearCliente(Cliente t) {

        this.datasource.add(t);
    }*/

    @Override
    public void editarCliente(Cliente t) {
        Cliente clie = this.porId(t.getId());
        clie.setNombre(t.getNombre());
        clie.setApellido(t.getApellido());

    }

  /*  @Override
    public void eliminarCliente(Integer id) {
        Cliente clie = this.porId(id);
        datasource.remove(clie);

    }*/

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.datasource);
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC){
                resultado = ordenar(campo, a, b);
            } else if(dir == Direccion.DESC){
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    public static int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

   /* @Override
    public List<Cliente> listar(int desde, int hasta) {
        return this.datasource.subList(desde,hasta);
    }*/
}