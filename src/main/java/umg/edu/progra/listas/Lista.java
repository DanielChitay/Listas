package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;

    }

    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;

    }

    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }
    
	    /**
     * 1 - Método para invertir la lista enlazada
     * Guarda el siguiente nodo,
     * Invierte el enlace del nodo actual, despies mueve el puntero anterior al nodo actual
     * por consiguiente mueve el puntero actual al siguiente, y asi último nodo se convierte en el primero
     */
    public void invertirLista() {
        Nodo anterior = null;
        Nodo actual = primero;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.enlace; 
            actual.enlace = anterior;  
            anterior = actual;         
            actual = siguiente;       
        }
        primero = anterior; 
    }

    /**
     * 2 - Método para obtener el elemento en la posición n desde el final
     * 
     *   Mueve el puntero1 n posiciones adelante y localiza el elemento solicitado, para el
     *   ejemplo utilizamos el numero 2, es decir n = 2
     */
    public int obtenerElementoDesdeElFinal(int n) {
        Nodo puntero1 = primero;
        Nodo puntero2 = primero;

  
        for (int i = 0; i < n; i++) {
            if (puntero1 == null) {
                throw new IndexOutOfBoundsException("La posición está fuera de los límites de la lista");
            }
            puntero1 = puntero1.enlace;
        }

    
        while (puntero1 != null) {
            puntero1 = puntero1.enlace;
            puntero2 = puntero2.enlace;
        }

        return puntero2.dato;
    }

    /**
     * 3 - Método para eliminar duplicados en una lista enlazada
     * el while hace un recorrido por el nulo y saca de la lista los que se repitan
     */
    public void eliminarDuplicados() {
        Nodo actual = primero;

        while (actual != null && actual.enlace != null) {
            if (actual.dato == actual.enlace.dato) {
                actual.enlace = actual.enlace.enlace; 
            } else {
                actual = actual.enlace; 
            }
        }
    }

    /**
     * 4 - Método para obtener el tamaño de la lista enlazada
     * suma cada unidad de elemetno encontrada durante el bucle del nodo
     */
    public int obtenerTamaño() {
        int tamaño = 0;
        Nodo actual = primero;

        while (actual != null) {
            tamaño++;
            actual = actual.enlace;
        }

        return tamaño;
    }
   
    /**
     * * 1. Ordernar la lista de forma ascendente
     * Realiza una ciclo while para validar cada nodo e ir ordendandolos
     *  de forma ascendente
     */
    public void ordenarLista() {
    if (primero == null || primero.enlace == null) {
        return; 
    }

    Nodo actual = primero;
    while (actual != null) {
        Nodo siguiente = actual.enlace;
        while (siguiente != null) {
            if (actual.dato > siguiente.dato) {
                // Intercambiar los valores
                int temp = actual.dato;
                actual.dato = siguiente.dato;
                siguiente.dato = temp;
            }
            siguiente = siguiente.enlace;
        }
        actual = actual.enlace;
    }
}
    
    /**
     * 2. Unir dos listas enlazadas
     * se manda el parametro otraLista para que recibirla en
     * Principal.Java, Lee las dos y las une
     */
    public void concatenarListas(Lista otraLista) {
    if (primero == null) {
        primero = otraLista.leerPrimero();
    } else {
        Nodo actual = primero;
        while (actual.enlace != null) {
            actual = actual.enlace;
        }
        actual.enlace = otraLista.leerPrimero();
    }
}
    
     /**
     * 3. Separar pares e Impares
     * Ciclo que valida el resudo de cada nodo para ordenarlos
     * por par o impar e ir almacenandolo en una nueva 
     */
    public void separarParesImpares(Lista listaPares, Lista listaImpares) {
    Nodo actual = primero;
    while (actual != null) {
        if (actual.dato % 2 == 0) {
            listaPares.insertarCabezaLista(actual.dato); 
        } else {
            listaImpares.insertarCabezaLista(actual.dato); 
        }
        actual = actual.enlace;
    }
}
}
