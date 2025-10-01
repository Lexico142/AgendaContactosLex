import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner src = new Scanner(System.in);

        System.out.println("Elige con un número:");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Mostrar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Salir");

        int opcion = src.nextInt();
        src.nextLine();

        switch(opcion){
            case 1:
                while (true){
                    boolean numerovalido = false;

                    if (!numerovalido){
                        System.out.println("Introduce el número del contacto que quieras añadir");
                        String numero = src.nextLine();

                        if (numero.length() == 9){
                            System.out.println("Introduce el nombre y apellidos del contacto que quieras añadir");
                            String nombre = src.nextLine();
                            System.out.println("Has añadido al contacto " + nombre + " correctamente");
                            numerovalido = true;
                            break;
                        } else {
                            System.out.println("Introduce un número de teléfono válido");
                        }
                    }


                }

        }
    }
}
