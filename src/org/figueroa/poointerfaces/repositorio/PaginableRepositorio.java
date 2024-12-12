package org.figueroa.poointerfaces.repositorio;

import org.figueroa.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {

    List<Cliente> listar(int desde, int hasta);

}
