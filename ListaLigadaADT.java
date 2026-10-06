package mx.unam.aragon.ico.edd.listas;

import java.util.Objects;

/** Lista simplemente ligada genérica; las posiciones comienzan en cero. */
public class ListaLigadaADT<T> {
    private Nodo<T> head;

    public ListaLigadaADT() { head = null; }

    public boolean estaVacia() { return head == null; }

    public int getTamanio() {
        int contador = 0;
        Nodo<T> actual = head;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public void agregar(T dato) { agregarAlFinal(dato); }

    public void agregarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) { head = nuevo; return; }
        Nodo<T> actual = head;
        while (actual.getSiguiente() != null) actual = actual.getSiguiente();
        actual.setSiguiente(nuevo);
    }

    public void agregarAlInicio(T dato) {
        head = new Nodo<>(dato, head);
    }

    /** Inserta después de la primera coincidencia; si no existe, no modifica. */
    public void agregarDespuesDe(T referencia, T valor) {
        Nodo<T> actual = encontrar(referencia);
        if (actual != null) {
            actual.setSiguiente(new Nodo<>(valor, actual.getSiguiente()));
        }
    }

    public void eliminarElPrimero() {
        if (!estaVacia()) head = head.getSiguiente();
    }

    public void eliminarElFinal() {
        if (estaVacia()) return;
        if (head.getSiguiente() == null) { head = null; return; }
        Nodo<T> actual = head;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(null);
    }

    /** Devuelve la posición de la primera coincidencia, o -1 si no existe. */
    public int buscar(T valor) {
        int posicion = 0;
        Nodo<T> actual = head;
        while (actual != null) {
            if (Objects.equals(actual.getDato(), valor)) return posicion;
            posicion++;
            actual = actual.getSiguiente();
        }
        return -1;
    }

    public void actualizar(T aBuscar, T nuevoValor) {
        Nodo<T> actual = encontrar(aBuscar);
        if (actual != null) actual.setDato(nuevoValor);
    }

    private Nodo<T> encontrar(T valor) {
        Nodo<T> actual = head;
        while (actual != null) {
            if (Objects.equals(actual.getDato(), valor)) return actual;
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void transversal() {
        if (estaVacia()) { System.out.println("Vacia"); return; }
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print("|" + actual.getDato());
            actual = actual.getSiguiente();
        }
        System.out.println("| -> null");
    }
}
