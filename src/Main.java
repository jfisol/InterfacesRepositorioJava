import org.figueroa.poointerfaces.modelo.Cliente;
import org.figueroa.poointerfaces.repositorio.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        CrudRepositorio repo = new ClienteListRepositorio(); //Clase principal; donde se encuentran todos los métodos
        repo.crearCliente(new Cliente("Pepito","Sanchez"));
        repo.crearCliente(new Cliente("Juanito","Soto"));
        repo.crearCliente(new Cliente("SArita","Conor"));
        repo.crearCliente(new Cliente("Pepito2","Sanchez"));

        List<Cliente> cliente =repo.listar();

        cliente.forEach(c -> System.out.println(c));

        System.out.println("================ LISTA PAGINACION ===========");
        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(1,3);
        paginable.forEach(System.out::println);//opcion lambda

        System.out.println("================ LISTA ORDENABLE ===========");

        List<Cliente> ordenar = ((OrdenableRepositorio)repo).listar("id",Direccion.DESC);
        ordenar.forEach(System.out::println);

        System.out.println("=======EDITAR CLIENTE============");

        Cliente clienteEditar = new Cliente("Peregil","Soho");
        clienteEditar.setId(4);
        repo.editarCliente(clienteEditar);

        cliente.forEach(c -> System.out.println(c));

      /*  System.out.println("=======ELIMINAR CLIENTE============");

        repo.eliminarCliente(4);
        System.out.println("Cliente eliminado");
        cliente.forEach(System.out::println);*/

    }
}