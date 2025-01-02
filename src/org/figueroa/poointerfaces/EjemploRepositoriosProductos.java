package org.figueroa.poointerfaces;

import org.figueroa.poointerfaces.modelo.Cliente;
import org.figueroa.poointerfaces.modelo.Producto;
import org.figueroa.poointerfaces.repositorio.Direccion;
import org.figueroa.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.figueroa.poointerfaces.repositorio.OrdenableRepositorio;
import org.figueroa.poointerfaces.repositorio.PaginableRepositorio;
import org.figueroa.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.figueroa.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositoriosProductos {
    public static void main(String[] args) {

        OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio(); //Clase principal; donde se encuentran todos los métodos
        repo.crearCliente(new Producto("Prodicto 1",50.50));
        repo.crearCliente(new Producto("Producto 2",30));
        repo.crearCliente(new Producto("Producto 3",60.50));
        repo.crearCliente(new Producto("Producto 4",35.20));

        List<Producto> producto =repo.listar();

        producto.forEach(c -> System.out.println(c));

        System.out.println("================ LISTA PAGINACION ===========");
        List<Producto> paginable = repo.listar(1,3);
        paginable.forEach(System.out::println);//opcion lambda

        System.out.println("================ LISTA ORDENABLE ===========");

        List<Producto> ordenar = repo.listar("id",Direccion.DESC);
        ordenar.forEach(System.out::println);

        System.out.println("=======EDITAR CLIENTE============");

        Producto prodEditar = new Producto("Peregil",1.50);
        prodEditar.setId(4);
        repo.editarCliente(prodEditar);

        producto.forEach(c -> System.out.println(c));

      /*  System.out.println("=======ELIMINAR CLIENTE============");

        repo.eliminarCliente(4);
        System.out.println("Cliente eliminado");
        cliente.forEach(System.out::println);*/

    }
}