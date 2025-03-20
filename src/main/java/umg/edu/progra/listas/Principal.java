package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);
        
        lista.visualizar();        
        
        
        System.out.println("\n");
        System.out.println("primero: " + lista.leerPrimero());
        
        
        
        lista.eliminar(3);
        System.out.println("lista: " + lista);
        
        System.out.println("\n");
        
        Nodo dato = lista.buscarLista(4);  
        System.out.println("dato: " + dato);
        
        lista.insertarLista(dato, 10);
        System.out.println("lista " + lista);
        
        dato = lista.buscarLista(5);        
        System.out.println("dato " + dato);
        lista.insertarLista(dato, 600);
        
        System.out.println("lista " + lista);
        
        lista.visualizar();
        
        
        
        /* Ejercicio 1: Ordernar la lista de forma ascendente
         */
        
        System.out.println("\nOrdenar la lista de forma ascendente:");
        lista.ordenarLista();
        lista.visualizar();
        
         
        /* Ejercicio 2: Unir dos listas enlazadas
         */
        System.out.println("\nUnir dos listas enlazadas:");

        // Crear una segunda lista
        Lista lista2 = new Lista();
        lista2.insertarCabezaLista(7);
        lista2.insertarCabezaLista(8);
        lista2.insertarCabezaLista(9);

        System.out.println("Lista 1:");
        lista.visualizar();

        System.out.println("Lista 2:");
        lista2.visualizar();

        // Unir las dos listas
        lista.concatenarListas(lista2);
        System.out.println("Lista unida:");
        lista.visualizar();
        
         /* Ejercicio 3: Separa numeros pares e impares en dos listas enlazadas diferentes
         */
        System.out.println("\nSeparar números pares e impares en dos listas:");
        // Crear listas para pares e impares
        Lista listaPares = new Lista();
        Lista listaImpares = new Lista();

        // Separar pares e impares
        lista.separarParesImpares(listaPares, listaImpares);

        System.out.println("Lista original:");
        lista.visualizar();

        System.out.println("Lista de pares:");
        listaPares.visualizar();

        System.out.println("Lista de impares:");
        listaImpares.visualizar();

    }

}
