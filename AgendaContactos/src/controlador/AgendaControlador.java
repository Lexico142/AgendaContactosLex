package controlador;
import modelo.AgendaModelo;
import vista.AgendaVista;
import modelo.Contacto;

public class AgendaControlador {
    private AgendaModelo modelo;
    private AgendaVista vista;

    public AgendaControlador(AgendaModelo modelo, AgendaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() throws InterruptedException {
        boolean activo = true;

        while (activo) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    anadir();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    modificar();
                    break;
                case 0:
                    vista.mostrarMensaje("¡Hasta pronto!");
                    activo = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void anadir() throws InterruptedException {
        if (modelo.isLlena()) {
            vista.mostrarMensaje("La agenda está llena.");
            return;
        }

        boolean numeroValido = false;
        while (!numeroValido) {
            int tempNum = vista.pedirNumero();

            if (String.valueOf(tempNum).length() == 9) {
                String tempNombre = vista.pedirTexto("Introduce el nombre y apellidos: ");
                modelo.agregarContacto(tempNombre, tempNum);
                vista.mostrarMensaje("Has añadido al contacto " + tempNombre + " correctamente.");
                numeroValido = true;
            } else {
                vista.mostrarMensaje("Error: Introduce un número de teléfono válido de 9 dígitos.");
            }
        }
        Thread.sleep(1000);
    }

    private void listar() {
        Contacto[] contactos = modelo.getContactosActivos();
        vista.mostrarLista(contactos);
    }

    private void buscar() {
        if (modelo.isVacia()) {
            vista.mostrarMensaje("\n=== BUSCAR CONTACTO ===\nNo hay contactos guardados.");
            return;
        }

        vista.mostrarMensaje("\n=== BUSCAR CONTACTO ===");
        String nombre = vista.pedirTexto("Introduce el nombre del contacto a buscar: ");
        Contacto c = modelo.buscarPorNombre(nombre);

        if (c != null) {
            vista.mostrarMensaje("Contacto encontrado: " + c.toString());
        } else {
            vista.mostrarMensaje("Contacto no encontrado.");
        }
    }

    private void modificar() {
        if (modelo.isVacia()) {
            vista.mostrarMensaje("\n=== MODIFICAR CONTACTO ===\nNo hay contactos guardados.");
            return;
        }

        vista.mostrarMensaje("\n=== MODIFICAR CONTACTO ===");
        String nombre = vista.pedirTexto("Introduce el nombre del contacto a modificar: ");
        Contacto c = modelo.buscarPorNombre(nombre);

        if (c != null) {
            vista.mostrarMensaje("Contacto encontrado: " + c.toString());
            int nuevoNum = vista.pedirNumero();

            if (String.valueOf(nuevoNum).length() == 9) {
                modelo.actualizarNumero(nombre, nuevoNum);
                vista.mostrarMensaje("Número de teléfono actualizado correctamente.");
            } else {
                vista.mostrarMensaje("Error: Número inválido.");
            }
        } else {
            vista.mostrarMensaje("Contacto no encontrado.");
        }
    }
}