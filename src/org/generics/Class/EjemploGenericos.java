package org.generics.Class;
public class EjemploGenericos {
    public static void main(String[] args) {
        Camion transporteCaballos = new Camion(5);
        transporteCaballos.add(new Animal("Caballos","Equinos"));
        transporteCaballos.add(new Animal("Caballos Españoles","Equinos"));
        transporteCaballos.add(new Animal("Caballos","Equinos"));
        transporteCaballos.add(new Animal("Caballos Pura Sangre","Equinos"));

        for (Object o: transporteCaballos){
            Animal a = (Animal) o;
            System.out.println(" -Nombre Animal : ["+a.getNombre() +"] -Tipo Animal: "+ a.getTipo());
        }
    }
}
