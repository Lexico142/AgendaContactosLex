
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        System.out.println("Elige con un número:");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Mostrar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Salir");

        String opcion = src.nextLine();

        System.out.println("Has elegido la opción '" + opcion + "'");

    }
}