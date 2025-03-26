package umg.edu.progra.listas.doblementeEnlazada;

public class DoblementeEnlazada {

	private Nodo head;
	private Nodo tail;

	public DoblementeEnlazada() {
		this.head = null;
		this.tail = null;
	}

	public void insertAtEnd(int data) {
		Nodo newNode = new Nodo(data);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	public void insertAtBeginning(int data) {
		Nodo newNode = new Nodo(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public boolean delete(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				if (current == head) {
					head = current.next;
					if (head != null)
						head.prev = null;
				} else if (current == tail) {
					tail = current.prev;
					if (tail != null)
						tail.next = null;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean search(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void displayForward() {
		Nodo current = head;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void displayBackward() {
		Nodo current = tail;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.prev;
		}
		System.out.println("null");
	}
	
	// Método 1: Contar el número de nodos en la lista
        
        /**
         * Cuenta el número de nodos en la lista
         * @return Cantidad total de nodos
         */
        public int contarNodos() {
            int contador = 0;
            Nodo actual = head;
            while (actual != null) {
                contador++;
                actual = actual.next;
            }
            return contador;
        }
	// Método 2: Insertar un nodo después de un valor específico
        
        /**
        * Inserta un nuevo nodo después de un valor específico
        * creamos el parametro valorBuscado, valor  después del cual se insertará
        * creamos el parametro nuevo valor, Valor a insertar
        * @return true si se insertó, false si no se encontró el valor buscado
        */
       public boolean insertarDespuesDe(int valorBuscado, int nuevoValor) {
           Nodo actual = head;
           while (actual != null) {
               if (actual.data == valorBuscado) {
                   Nodo nuevoNodo = new Nodo(nuevoValor);

                   nuevoNodo.next = actual.next;
                   nuevoNodo.prev = actual;

                   if (actual.next != null) {
                       actual.next.prev = nuevoNodo;
                   } else {
                       tail = nuevoNodo; // Si insertamos después del último
                   }

                   actual.next = nuevoNodo;
                   return true;
               }
               actual = actual.next;
           }
           return false;
       }
	// Método 3: Revertir la lista doblemente enlazada
                /**
          * Revierte el orden de la lista doblemente enlazada
          */
         public void revertir() {
             Nodo actual = head;
             Nodo temp = null;

             // Intercambiamos head y tail
             head = tail;
             tail = actual;

             // Intercambiamos next y prev de cada nodo
             while (actual != null) {
                 temp = actual.prev;
                 actual.prev = actual.next;
                 actual.next = temp;
                 actual = actual.prev; // Avanzamos usando prev (que era next)
             }
         }

}
