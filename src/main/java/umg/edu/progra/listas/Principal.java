package main.java.umg.edu.progra.listas;
import umg.edu.progra.listas.doblementeEnlazada.DoblementeEnlazada;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import umg.edu.progra.listas.Lista;
import umg.edu.progra.listas.Nodo;

/**
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {
        String opcion = JOptionPane.showInputDialog(
            "SELECCIONE EL MODO DE EJECUCIÓN:\n" +
            "1. Modo pruebas automáticas\n" +
            "2. Modo interactivo (ingreso manual de datos)\n" +
            "3. Pruebas listas doblemente enlazadas\n" +
            "4. Salir");

        
        switch(opcion) {
            case "1":
                ejecutarModoPruebas();
                break;
            case "2":
                ejecutarModoInteractivo();
                break;
            case "3":
                ejecutarPruebasDoblementeEnlazadas();
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Programa terminado");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    private static void ejecutarModoPruebas() {
        System.out.println("=== MODO PRUEBAS AUTOMÁTICAS ===");
        
        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);
        
        // Operaciones básicas
        System.out.println("\nLista inicial:");
        lista.visualizar();
        
        System.out.println("\nPrimer elemento: " + lista.leerPrimero());
        
        lista.eliminar(3);
        System.out.println("\nLista después de eliminar el 3:");
        lista.visualizar();
        
        // Búsqueda e inserción
        Nodo dato = lista.buscarLista(4);  
        System.out.println("\nBuscando el 4: " + dato);
        
        lista.insertarLista(dato, 10);
        System.out.println("\nInsertando 10 después del 4:");
        lista.visualizar();
        
        dato = lista.buscarLista(5);        
        lista.insertarLista(dato, 600);
        System.out.println("\nInsertando 600 después del 5:");
        lista.visualizar();
        
        // Ejercicio 1: Ordenar lista
        System.out.println("\nOrdenando la lista de forma ascendente:");
        lista.ordenarLista();
        lista.visualizar();
         
        // Ejercicio 2: Unir listas
        System.out.println("\nUniendo dos listas enlazadas:");
        Lista lista2 = new Lista();
        lista2.insertarCabezaLista(7);
        lista2.insertarCabezaLista(8);
        lista2.insertarCabezaLista(9);

        System.out.println("Lista 1:");
        lista.visualizar();
        System.out.println("Lista 2:");
        lista2.visualizar();

        lista.concatenarListas(lista2);
        System.out.println("Lista unida:");
        lista.visualizar();
        
        // Ejercicio 3: Separar pares e impares
        System.out.println("\nSeparando números pares e impares:");
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

    private static void ejecutarModoInteractivo() {
        System.out.println("=== MODO INTERACTIVO ===");
        JOptionPane.showMessageDialog(null, "LISTAS - MODO INTERACTIVO");

        ArrayList<Integer> listaEnteros = new ArrayList<>();

        // Capturar 10 valores del usuario
        for (int j = 0; j < 10; j++) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el valor #" + (j+1) + ":");
                listaEnteros.add(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
                j--; // Repetir esta iteración
            }
        }

        // Mostrar valores ingresados
        StringBuilder sb = new StringBuilder("Valores ingresados:\n");
        for (Integer entero : listaEnteros) {
            sb.append(" - ").append(entero).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
        System.out.println(sb.toString());

        // Crear lista enlazada
        Lista listaEnlazada = new Lista();
        for (Integer valor : listaEnteros) {
            listaEnlazada.insertarCabezaLista(valor);
        }

        // Operaciones con la lista
        System.out.println("\nLista enlazada original:");
        listaEnlazada.visualizar();

        // Invertir lista
        listaEnlazada.invertirLista();
        System.out.println("\nLista enlazada invertida:");
        listaEnlazada.visualizar();
        JOptionPane.showMessageDialog(null, "Lista invertida creada");

        // Obtener elemento desde el final
        try {
            int posicion = 2; // Puedes hacer esto configurable
            int valor = listaEnlazada.obtenerElementoDesdeElFinal(posicion);
            String msg = "Elemento en posición " + posicion + " desde el final: " + valor;
            JOptionPane.showMessageDialog(null, msg);
            System.out.println("\n" + msg);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        // Eliminar duplicados
        listaEnlazada.eliminarDuplicados();
        System.out.println("\nLista sin duplicados:");
        listaEnlazada.visualizar();
        JOptionPane.showMessageDialog(null, "Duplicados eliminados");

        // Mostrar tamaño
        int tamaño = listaEnlazada.obtenerTamaño();
        String msgTamaño = "Tamaño final de la lista: " + tamaño;
        JOptionPane.showMessageDialog(null, msgTamaño);
        System.out.println("\n" + msgTamaño);
    }
    
        private static void ejecutarPruebasDoblementeEnlazadas() {
        DoblementeEnlazada listaDoble = new DoblementeEnlazada();
        
        // Insertamos valores
        listaDoble.insertAtBeginning(10);
        listaDoble.insertAtEnd(20);
        listaDoble.insertAtEnd(30);
        listaDoble.insertAtBeginning(5);
        
        // Mostramos la lista
        System.out.println("\n=== PRUEBAS LISTA DOBLEMENTE ENLAZADA ===");
        System.out.println("Lista hacia adelante:");
        listaDoble.displayForward();
        System.out.println("Lista hacia atrás:");
        listaDoble.displayBackward();
        
        // Probamos contar nodos
        System.out.println("\nNúmero de nodos: " + listaDoble.contarNodos());
        
        // Insertamos después de un valor
        System.out.println("\nInsertando 15 después de 10:");
        listaDoble.insertarDespuesDe(10, 15);
        listaDoble.displayForward();
        
        // Revertimos la lista
        System.out.println("\nLista revertida:");
        listaDoble.revertir();
        listaDoble.displayForward();
        
        // Probamos búsqueda
        System.out.println("\n¿Existe el valor 20? " + listaDoble.search(20));
        System.out.println("¿Existe el valor 99? " + listaDoble.search(99));
        
        // Probamos eliminación
        System.out.println("\nEliminando 20:");
        listaDoble.delete(20);
        listaDoble.displayForward();
        
        JOptionPane.showMessageDialog(null, 
            "Pruebas de lista doblemente enlazada completadas.\n" +
            "Revisa la consola para ver los resultados.");
    }
}