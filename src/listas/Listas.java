package listas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import umg.edu.progra.listas.Lista;

public class Listas {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "LISTAS");

        ArrayList<Integer> listaEnteros = new ArrayList<>();

        // Capturar 10 valores del usuario
        int j = 0;
        while (j < 10) {
            listaEnteros.add(Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor: ")));
            j++;
        }

        // Mostrar los valores ingresados
        System.out.println("Valores ingresados:");
        for (Integer entero : listaEnteros) {
            System.out.println("El valor es: " + entero);
        }

        // Crear una instancia de la clase Lista
        Lista listaEnlazada = new Lista();

        // Insertar los valores en la lista enlazada
        for (Integer valor : listaEnteros) {
            listaEnlazada.insertarCabezaLista(valor);
        }

        // Probar los métodos de la lista enlazada
        System.out.println("\nLista enlazada original:");
        listaEnlazada.visualizar();

        // Mostrar Lista Invertida
        listaEnlazada.invertirLista(); // Invertir la lista una vez
        System.out.println("\nLista enlazada invertida:");
        listaEnlazada.visualizar(); // Mostrar la lista invertida

        // Obtener el elemento en la posición n desde el final
        int posicionDesdeElFinal = 2; 
        try {
            int valor = listaEnlazada.obtenerElementoDesdeElFinal(posicionDesdeElFinal);
            System.out.println("\nEl elemento en la posición (n = 2) " + posicionDesdeElFinal + " desde el final es: " + valor);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        
        // Mostrar Lista sin duplicados
        listaEnlazada.eliminarDuplicados(); // Eliminar duplicados una vez
        System.out.println("\nLista enlazada sin duplicados:");
        listaEnlazada.visualizar(); // Mostrar la lista sin duplicados

        // Mostrar Tamaño de Lista
        int tamaño = listaEnlazada.obtenerTamaño(); // Obtener el tamaño de la lista
        System.out.println("\nTamaño de lista: " + tamaño); // Imprimir el tamaño
   
    }
}