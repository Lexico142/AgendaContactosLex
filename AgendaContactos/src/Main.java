import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner src = new Scanner(System.in);
        boolean activo = true;
        String numero = "waza";
        String nombre = "";

        while (activo) {
        System.out.println("Elige con un número:");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Mostrar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Salir");
        System.out.print("Opción: ");
        int opcion = src.nextInt();

        src.nextLine();


            switch (opcion) {
                case 1:
                    while (true) {
                        System.out.println("Introduce el número del contacto que quieras añadir");
                        numero = src.nextLine();

                        if (numero.length() == 9) {
                            System.out.println("Introduce el nombre y apellidos del contacto que quieras añadir");
                            nombre = src.nextLine();
                            System.out.println("Has añadido al contacto " + nombre + " correctamente\n");
                            Thread.sleep(1000);
                            break;
                        } else {
                            System.out.println("Introduce un número de teléfono válido");
                        }
                    }
                    break;

                case 2:
                    System.out.println("Has elegido 'Mostrar contactos'");
                    System.out.println("A continuación se imprimirán todos tus contactos");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Número: " + numero + "\n");

                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("Has elegido 'Buscar contacto'");
                    System.out.print("Buscar: ");
                    break;
                case 4:
                    System.out.println("Has elegido 'salir', hasta pronto!");
                    activo = false;
                    break;
            }
        }
    }
}