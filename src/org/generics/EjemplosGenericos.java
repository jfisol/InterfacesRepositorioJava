package org.generics;

import org.figueroa.poointerfaces.modelo.Cliente;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* Se implementan los genericos para evitar emplear errores de tipo cast en java y se desarrolle de una forma responsabld
* */
public class EjemplosGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("Andress","Lautaro"));

        Cliente andress =clientes.iterator().next();

        //PROBAR EL ARREGLO DE COLECCIONES
        Cliente[] clientesArreglo = {new Cliente("Andres","Martinez"), new Cliente("Benito","Padilla")};
        Integer[] enterosArreglo = {1,2,3};

        List<Cliente> clientesLista = fromDoList(clientesArreglo);
        List<Integer> enterosLista = fromDoList(enterosArreglo);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::print);

    }

    //creamos una lista
    // la convencion <T> indican un método Generico
    public static <T>List<T> fromDoList(T[] c){//PARA TRABAJAR CON CUALQUIER OBJETO
        return Arrays.asList(c); //convierte un arreglo a una lista
    }
}
