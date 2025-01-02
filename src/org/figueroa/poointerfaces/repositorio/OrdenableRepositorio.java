package org.figueroa.poointerfaces.repositorio;

import org.figueroa.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {

    List<T>listar(String campo, Direccion dir);


}
