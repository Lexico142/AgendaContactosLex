package vista;

import modelo.Contacto;

import java.util.Scanner;

public class AgendaVista {
    private Scanner scanner;

    public AgendaVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n=== AGENDA TELEFÓNICA ===");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Modificar contacto");
        System.out.println("0. Salir");
        System.out.print("Opción: ");

        if (scanner.hasNextInt()) {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } else {
            scanner.nextLine();
            return -1;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int pedirNumero() {
        System.out.print("Introduce el número de teléfono (9 dígitos): ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            scanner.nextLine();
            return num;
        } else {
            scanner.nextLine();
            return 0;
        }
    }

    public String pedirTexto(String instruccion) {
        System.out.print(instruccion);
        return scanner.nextLine();
    }

    public void mostrarLista(Contacto[] contactos) {
        System.out.println("\n=== LISTA DE CONTACTOS ===");
        if (contactos.length == 0) {
            System.out.println("No hay contactos guardados.");
        } else {
            for (int i = 0; i < contactos.length; i++) {
                System.out.println("Índice [" + i + "] -> " + contactos[i]);
            }
        }
    }

}
