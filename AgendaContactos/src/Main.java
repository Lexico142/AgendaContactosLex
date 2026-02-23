import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner src = new Scanner(System.in);
        boolean activo = true;

        Contacto[] agenda = new Contacto[100];
        int cantidad = 0;

        while (activo) {
            System.out.println("\n=== AGENDA TELEFÓNICA ===");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Modificar contacto");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int opcion = src.nextInt();
            src.nextLine();

            switch (opcion) {
                case 1:
                    cantidad = anadirContacto(agenda, cantidad, src);
                    break;

                case 2:
                    listarContactos(agenda, cantidad);
                    break;

                case 3:
                    buscarContacto(agenda, cantidad, src);
                    break;

                case 4:
                    modificarContacto(agenda, cantidad, src);
                    break;

                case 0:
                    System.out.println("¡Hasta pronto!");
                    activo = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        src.close();
    }

    static int anadirContacto(Contacto[] agenda, int cantidad, Scanner src) throws InterruptedException {
        if (cantidad >= agenda.length) {
            System.out.println("La agenda está llena.");
            return cantidad;
        }

        boolean numeroValido = false;
        while (!numeroValido) {
            System.out.println("Introduce el número de teléfono (9 dígitos):");
            int tempNum = src.nextInt();
            src.nextLine();

            if (String.valueOf(tempNum).length() == 9) {
                System.out.println("Introduce el nombre y apellidos:");
                String tempNombre = src.nextLine();

                agenda[cantidad] = new Contacto(tempNombre, tempNum);

                System.out.println("Has añadido al contacto " + agenda[cantidad].getNombre() + " correctamente.");

                numeroValido = true;
                cantidad++;
            } else {
                System.out.println("Error: Introduce un número de teléfono válido de 9 dígitos.");
            }
        }
        Thread.sleep(1000);
        return cantidad;
    }

    static void listarContactos(Contacto[] agenda, int cantidad) {
        System.out.println("\n--- LISTA DE CONTACTOS ---");
        if (cantidad == 0) {
            System.out.println("No hay contactos guardados.");
        } else {
            for (int i = 0; i < cantidad; i++) {
                System.out.println("Índice [" + i + "] -> " + agenda[i]);
            }
        }
    }

    static void buscarContacto(Contacto[] agenda, int cantidad, Scanner src) {
        System.out.println("\n=== BUSCAR CONTACTO ===");
        if (cantidad == 0) {
            System.out.println("No hay contactos guardados.");
            return;
        }

        System.out.print("Introduce el nombre del contacto a buscar: ");
        String nombreBuscado = src.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < cantidad; i++) {
            if (agenda[i].getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Contacto encontrado: " + agenda[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }

    static void modificarContacto(Contacto[] agenda, int cantidad, Scanner src) {
        System.out.println("\n=== MODIFICAR CONTACTO ===");
        if (cantidad == 0) {
            System.out.println("No hay contactos guardados.");
            return;
        }

        System.out.print("Introduce el nombre del contacto a modificar: ");
        String nombreBuscado = src.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < cantidad; i++) {
            if (agenda[i].getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Contacto encontrado: " + agenda[i]);
                System.out.print("Introduce el nuevo número de teléfono (9 dígitos): ");
                int nuevoNum = src.nextInt();
                src.nextLine();

                if (String.valueOf(nuevoNum).length() == 9) {
                    agenda[i].setNumero(nuevoNum);
                    System.out.println("Número de teléfono actualizado correctamente.");
                } else {
                    System.out.println("Error: Número inválido.");
                }
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }
}