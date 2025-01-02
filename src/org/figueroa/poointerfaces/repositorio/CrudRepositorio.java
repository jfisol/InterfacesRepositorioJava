package org.figueroa.poointerfaces.repositorio;

import org.figueroa.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio<T> {

     List<T> listar();
     T porId(Integer id);

     void crearCliente(T cliente);

     void editarCliente(T cliente);

     void eliminarCliente(Integer id);


}
