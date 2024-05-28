/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

public class Libro {
    // Atributos del libro
    private String titulo;
    private String isbn;
    private String año;
    private String autor;

    // Constructor para inicializar los atributos del libro
    public Libro(String titulo, String isbn, String año, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.año = año;
        this.autor = autor;
    }

    // Métodos getter y setter para acceder y modificar los atributos del libro
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Método para representar el libro como una cadena de texto formateada
    @Override
    public String toString() {
        return String.format("%-20s | %-15s | %-10s | %-20s", "TITULO", "ISBN", "AÑO", "AUTOR") +
               "\n" +
               String.format("%-20s | %-15s | %-10s | %-20s", titulo, isbn, año, autor);
    }
}
