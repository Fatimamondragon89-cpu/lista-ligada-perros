package mx.unam.aragon.ico.edd.listas;

/** Demostración y comprobaciones ejecutables, sin dependencias externas. */
public class DemoListaLigada {
    private static int comprobaciones;
    private static void comprobar(boolean condicion, String mensaje) {
        if (!condicion) throw new AssertionError(mensaje);
        comprobaciones++;
    }
    private static void mostrar(String paso, ListaLigadaADT<Perro> lista) {
        System.out.println("\n" + paso);
        lista.transversal();
        System.out.println("Tamanio: " + lista.getTamanio());
    }
    public static void main(String[] args) {
        ListaLigadaADT<Perro> lista = new ListaLigadaADT<>();
        Perro labrador = new Perro("Labrador", 3, true);
        Perro pug = new Perro("Pug", 2, true);
        Perro husky = new Perro("Husky", 4, false);
        Perro beagle = new Perro("Beagle", 1, true);
        Perro pastor = new Perro("Pastor aleman", 5, true);
        Perro ausente = new Perro("Dalmata", 7, false);
        mostrar("1. Lista vacia", lista);
        comprobar(lista.estaVacia() && lista.getTamanio() == 0, "Estado inicial");
        comprobar(lista.buscar(ausente) == -1, "Busqueda en lista vacia");
        lista.eliminarElPrimero(); lista.eliminarElFinal();
        lista.actualizar(ausente, pug); lista.agregarDespuesDe(ausente, pug);
        comprobar(lista.estaVacia(), "Operaciones sobre lista vacia");
        lista.agregar(labrador); lista.agregarAlFinal(pug);
        mostrar("2. Agregar y agregarAlFinal", lista);
        comprobar(lista.getTamanio() == 2 && lista.buscar(pug) == 1, "Agregar al final");
        lista.agregarAlInicio(husky);
        mostrar("3. Agregar al inicio", lista);
        comprobar(lista.buscar(husky) == 0 && lista.buscar(labrador) == 1, "Inicio");
        lista.agregarDespuesDe(labrador, beagle);
        mostrar("4. Agregar despues del Labrador", lista);
        comprobar(lista.getTamanio() == 4 && lista.buscar(beagle) == 2 && lista.buscar(pug) == 3, "Insercion intermedia");
        System.out.println("Buscar un Beagle equivalente: " + lista.buscar(new Perro("Beagle", 1, true)));
        comprobar(lista.buscar(new Perro("Beagle", 1, true)) == 2, "Igualdad por atributos");
        lista.actualizar(pug, pastor);
        mostrar("5. Actualizar Pug por Pastor aleman", lista);
        comprobar(lista.buscar(pug) == -1 && lista.buscar(pastor) == 3, "Actualizar");
        lista.agregarDespuesDe(ausente, pug); lista.actualizar(ausente, pug);
        comprobar(lista.getTamanio() == 4 && lista.buscar(pug) == -1, "Referencia inexistente");
        lista.eliminarElPrimero();
        mostrar("6. Eliminar el primero", lista);
        comprobar(lista.buscar(husky) == -1 && lista.buscar(labrador) == 0, "Eliminar primero");
        lista.eliminarElFinal();
        mostrar("7. Eliminar el final", lista);
        comprobar(lista.getTamanio() == 2 && lista.buscar(pastor) == -1, "Eliminar final");
        lista.eliminarElFinal(); lista.eliminarElFinal();
        comprobar(lista.estaVacia(), "Eliminar ultimo nodo");
        lista.agregarAlInicio(pug); lista.eliminarElPrimero();
        comprobar(lista.estaVacia(), "Eliminar primero unico");
        lista.agregar(pug); lista.agregar(pug);
        lista.actualizar(new Perro("Pug", 2, true), beagle);
        comprobar(lista.buscar(beagle) == 0 && lista.buscar(pug) == 1, "Actualizar solo primera coincidencia");
        lista.agregarDespuesDe(pug, pastor);
        comprobar(lista.buscar(pastor) == 2, "Insertar despues del ultimo");
        lista.agregarDespuesDe(beagle, husky);
        comprobar(lista.buscar(husky) == 1, "Insertar despues del primero");
        lista.agregarAlInicio(null);
        comprobar(lista.buscar(null) == 0, "Busqueda de null");
        lista.actualizar(null, ausente);
        comprobar(lista.buscar(ausente) == 0, "Actualizar null");
        mostrar("8. Pruebas adicionales", lista);
        System.out.println("\nRESULTADO: " + comprobaciones + " comprobaciones correctas.");
    }
}
