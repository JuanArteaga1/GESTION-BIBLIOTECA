/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

public class ListaDobleEnlazada {

    private Nodo cabeza; // Referencia al primer nodo de la lista
    private Nodo cola;   // Referencia al último nodo de la lista

    // Agregar libro al principio de la lista
    public void agregarAlPrincipio(Libro libro) {
        Nodo nuevoNodo = new Nodo(libro); // Crear un nuevo nodo con el libro
        if (cabeza == null) { // Si la lista está vacía
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
            cabeza = nuevoNodo;
        }
    }

    // Agregar libro al final de la lista
    public void agregarAlFinal(Libro libro) {
        Nodo nuevoNodo = new Nodo(libro); // Crear un nuevo nodo con el libro
        if (cola == null) { // Si la lista está vacía
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
    }

    // Eliminar libro por título
    public void eliminarPorTitulo(String titulo) {
        Nodo actual = cabeza; // Empezar desde la cabeza de la lista
        while (actual != null) {
            if (actual.getLibro().getTitulo().equals(titulo)) {
                eliminarNodo(actual); // Llamar al método para eliminar el nodo
                System.out.println("Libro eliminado con exito.");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Libro no encontrado: " + titulo);
    }

    // Eliminar libro por ISBN
    public void eliminarPorIsbn(String isbn) {
        Nodo actual = cabeza; // Empezar desde la cabeza de la lista
        while (actual != null) {
            if (actual.getLibro().getIsbn().equals(isbn)) {
                eliminarNodo(actual); // Llamar al método para eliminar el nodo
                System.out.println("Libro eliminado con exito.");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("Libro no encontrado: " + isbn);
    }

    // Método privado para eliminar un nodo específico
    private void eliminarNodo(Nodo nodo) {
        if (nodo.getAnterior() != null) {
            nodo.getAnterior().setSiguiente(nodo.getSiguiente());
        } else { // Si el nodo es la cabeza de la lista
            cabeza = nodo.getSiguiente();
        }
        if (nodo.getSiguiente() != null) {
            nodo.getSiguiente().setAnterior(nodo.getAnterior());
        } else { // Si el nodo es la cola de la lista
            cola = nodo.getAnterior();
        }
    }

    // Mostrar la lista de libros
    public void mostrarLista() {
        Nodo actual = cabeza; // Empezar desde la cabeza de la lista
        while (actual != null) {
            System.out.println(actual.getLibro());
            actual = actual.getSiguiente();
        }
    }

    // Buscar libro por ISBN
    public boolean buscarisbn(String isbn) {
        Nodo actual = cabeza; // Empezar desde la cabeza de la lista
        while (actual != null) {
            if (actual.getLibro().getIsbn().equals(isbn)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Buscar libro por título
    public boolean buscartitulo(String titulo) {
        Nodo actual = cabeza; // Empezar desde la cabeza de la lista
        while (actual != null) {
            if (actual.getLibro().getTitulo().equals(titulo)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Editar libro por ISBN
    public boolean editarLibro(String isbn, String nuevoTitulo, String nuevoIsbn, String nuevoAño, String nuevoAutor) {
        Nodo actual = cabeza; // Empezar desde la cabeza de la lista
        boolean encontrado = false;
        while (actual != null) {
            if (actual.getLibro().getIsbn().equals(isbn)) {
                encontrado = true;
                // Editar los campos del libro si no están vacíos
                if (!nuevoTitulo.isEmpty()) {
                    actual.getLibro().setTitulo(nuevoTitulo);
                }
                if (!nuevoIsbn.isEmpty()) {
                    actual.getLibro().setIsbn(nuevoIsbn);
                }
                if (!nuevoAño.isEmpty()) {
                    actual.getLibro().setAño(nuevoAño);
                }
                if (!nuevoAutor.isEmpty()) {
                    actual.getLibro().setAutor(nuevoAutor);
                }
                System.out.println("Libro editado con éxito.");
                break;
            }
            actual = actual.getSiguiente();
        }
        if (!encontrado) {
            System.out.println("Libro no encontrado: " + isbn);
        }
        return encontrado;
    }
}
