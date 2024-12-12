package org.figueroa.poointerfaces.repositorio;

import org.figueroa.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {

     List<Cliente> listar();
     Cliente porId(Integer id);

     void crearCliente(Cliente cliente);

     void editarCliente(Cliente cliente);

     void eliminarCliente(Integer id);


}
