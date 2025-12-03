import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner src = new Scanner(System.in);
        boolean activo = true;

        String[] nombres = new String[100];
        int[] numeros = new int[100];

        int cantidad = 0;

        while (activo) {
            System.out.println("\n--- AGENDA TELEFÓNICA ---");
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
                    if (cantidad >= 100) {
                        System.out.println("La agenda está llena.");
                        break;
                    }

                    boolean numeroValido = false;
                    while (!numeroValido) {
                        System.out.println("Introduce el número de teléfono (9 dígitos):");
                        int tempNum = src.nextInt();
                        src.nextLine();

                        if (String.valueOf(tempNum).length() == 9) {
                            numeros[cantidad] = tempNum;
                            numeroValido = true;

                            System.out.println("Introduce el nombre y apellidos:");
                            nombres[cantidad] = src.nextLine();

                            System.out.println("Has añadido al contacto " + nombres[cantidad] + " correctamente.");

                            cantidad++;
                        } else {
                            System.out.println("Error: Introduce un número de teléfono válido de 9 dígitos.");
                        }
                    }
                    Thread.sleep(1000);
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE CONTACTOS ---");
                    if (cantidad == 0) {
                        System.out.println("No hay contactos guardados.");
                    } else {
                        for (int i = 0; i < cantidad; i++) {
                            System.out.println("Índice [" + i + "] -> Nombre: " + nombres[i] + " | Tlf: " + numeros[i]);
                        }
                    }
                    Thread.sleep(1500);
                    break;

                case 3:
                    break;

                case 4:
                    System.out.println("\n--- MODIFICAR CONTACTO ---");
                    if (cantidad == 0) {
                        System.out.println("No hay contactos guardados.");
                    } else {
                        for (int i = 0; i < cantidad; i++) {
                            System.out.println("Índice [" + i + "] -> Nombre: " + nombres[i] + " | Tlf: " + numeros[i]);
                        }
                        System.out.println("Qué contacto quieres modificar? [0-99]");

                    }

                    Thread.sleep(1000);
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
}