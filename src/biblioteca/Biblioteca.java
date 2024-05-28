/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package biblioteca;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Biblioteca {
    
    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada(); // Crear una lista doblemente enlazada para almacenar los libros
        Scanner scanner = new Scanner(System.in); // Crear un objeto Scanner para leer la entrada del usuario
        
        while (true) { // Bucle infinito para mostrar el menú y procesar las opciones
            System.out.println("**************************************");
            System.out.println("************* BIBLIOTECA**************");
            System.out.println("**************************************");
            System.out.println("!------ **  Elija la opcion  ** -----!");
            System.out.println("!------------------------------------!");
            System.out.println("!    1. Agregar libro al principio   !");
            System.out.println("!    2. Agregar libro al final       !");
            System.out.println("!    3. Eliminar libro por titulo    !");
            System.out.println("!    4. Eliminar libro por ISBN      !");
            System.out.println("!    5. Editar libro por ISBN        !");
            System.out.println("!    6. Mostrar lista de libros      !");
            System.out.println("!    7. Salir                        !");
            System.out.println("**************************************");
            
            int opcion = -1; // Variable para almacenar la opción seleccionada por el usuario
            try {
                opcion = scanner.nextInt(); // Leer la opción seleccionada
                if (opcion < 1 || opcion > 7) { // Validar que la opción esté en el rango permitido
                    System.out.println("Opcion no valida  ");
                    System.out.println("Por favor, ingrese un numero entre 1 y 7.");
                    continue; // Volver al inicio del bucle si la opción no es válida
                }
            } catch (InputMismatchException e) { // Capturar excepciones de entrada no válida
                System.out.println("Opcion no válida. ");
                System.out.println("Por favor, ingrese un numero entre 1 y 7.");
                scanner.next(); // Limpiar el scanner
                continue; // Volver al inicio del bucle si se produce una excepción
            }
            
            scanner.nextLine(); // Consumir la nueva línea después de leer la opción
            
            switch (opcion) { // Procesar la opción seleccionada
                case 1:
                    while (true) { // Bucle para agregar un libro al principio de la lista
                        System.out.print("Ingrese el titulo del libro: ");
                        String titulo1 = scanner.nextLine();
                        System.out.print("Ingrese el ISBN del libro: ");
                        String isbn1 = scanner.nextLine();
                        System.out.print("Ingrese el año del libro: ");
                        String año1 = scanner.nextLine();
                        System.out.print("Ingrese el autor del libro: ");
                        String autor1 = scanner.nextLine();
                        
                        if (!lista.buscarisbn(isbn1) && !lista.buscartitulo(titulo1)) { // Verificar si el ISBN y el título no existen
                            if (titulo1.equals("") || isbn1.equals("") || año1.equals("") || autor1.equals("")) { // Verificar que no haya campos vacíos
                                System.out.println("ERROR UN ESPACIO INGRESADO ESTA VACIO ");
                            } else {
                                lista.agregarAlPrincipio(new Libro(titulo1, isbn1, año1, autor1)); // Agregar el libro al principio de la lista
                                System.out.println("Libro agregado al principio de la lista.");
                                System.out.println("LIBRO AGREGADO CON EXITO");
                                break; // Salir del bucle si el libro se agregó con éxito
                            }
                        } else {
                            System.out.println("ERROR ISBN O EL TITULO YA EXISTEN INGRESE UNO DIFERENTE ");
                            break; // Salir del bucle si el ISBN o el título ya existen
                        }
                    }
                    break;
                
                case 2:
                    while (true) { // Bucle para agregar un libro al final de la lista
                        System.out.print("Ingrese el titulo del libro: ");
                        String titulo2 = scanner.nextLine();
                        System.out.print("Ingrese el ISBN del libro: ");
                        String isbn2 = scanner.nextLine();
                        System.out.print("Ingrese el año del libro: ");
                        String año2 = scanner.nextLine();
                        System.out.print("Ingrese el autor del libro: ");
                        String autor2 = scanner.nextLine();
                        
                        if (!lista.buscarisbn(isbn2) && !lista.buscartitulo(titulo2)) { // Verificar si el ISBN y el título no existen
                            if (titulo2.equals("") || isbn2.equals("") || año2.equals("") || autor2.equals("")) { // Verificar que no haya campos vacíos
                                System.out.println("ERROR UN ESPACIO INGRESADO ESTA VACIO ");
                            } else {
                                lista.agregarAlFinal(new Libro(titulo2, isbn2, año2, autor2)); // Agregar el libro al final de la lista
                                System.out.println("Libro agregado al final de la lista.");
                                System.out.println("LIBRO AGREGADO CON EXITO");
                                break; // Salir del bucle si el libro se agregó con éxito
                            }
                        } else {
                            System.out.println("ERROR ISBN O EL TITULO YA EXISTEN INGRESE UNO DIFERENTE ");
                            break; // Salir del bucle si el ISBN o el título ya existen
                        }
                    }
                    break;
                
                case 3:
                    System.out.print("Ingrese el titulo del libro a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    lista.eliminarPorTitulo(tituloEliminar); // Eliminar el libro por título
                    break;
                
                case 4:
                    System.out.print("Ingrese el ISBN del libro a eliminar: ");
                    String isbnEliminar = scanner.nextLine();
                    lista.eliminarPorIsbn(isbnEliminar); // Eliminar el libro por ISBN
                    break;
                
                case 5:
                    System.out.print("Ingrese el ISBN del libro a editar: ");
                    String isbnEditar = scanner.nextLine();
                    
                    if (!lista.buscarisbn(isbnEditar)) { // Verificar si el libro existe
                        System.out.println("Libro no encontrado.");
                        break;
                    }
                    
                    System.out.print("Ingrese el nuevo titulo del libro: ");
                    System.out.print("O deje en blanco para no cambiar: ");
                    String nuevoTitulo = scanner.nextLine();
                    
                    System.out.print("Ingrese el nuevo ISBN del libro: ");
                    System.out.print("O deje en blanco para no cambiar: ");
                    String nuevoIsbn = scanner.nextLine();
                    System.out.print("Ingrese el nuevo año del libro: ");
                    System.out.print("O deje en blanco para no cambiar: ");
                    String nuevoAño = scanner.nextLine();
                    System.out.print("Ingrese el nuevo autor del libro: ");
                    System.out.print("O deje en blanco para no cambiar: ");
                    String nuevoAutor = scanner.nextLine();
                    
                    lista.editarLibro(isbnEditar, nuevoTitulo, nuevoIsbn, nuevoAño, nuevoAutor); // Editar la información del libro
                    break;
                
                case 6:
                    lista.mostrarLista(); // Mostrar la lista de libros
                    break;
                
                case 7:
                    System.out.println("Chuta.");
                    System.out.println("Saliendo del sistema.");
                    scanner.close(); // Cerrar el scanner
                    return; // Salir del programa
                
                default:
                    System.out.println("Opcion no valida."); // Manejar opción no válida (aunque este caso no debería ocurrir)
            }
        }
    }
}
