package modelo;

public class AgendaModelo {
    private Contacto[] contactos;
    private int cantidad;
    private final int maxContactos = 100;

    public AgendaModelo() {
        this.contactos = new Contacto[maxContactos];
        this.cantidad = 0;
    }

    public boolean isLlena() {
        return cantidad >= maxContactos;
    }

    public boolean isVacia() {
        return cantidad == 0;
    }

    public void agregarContacto(String nombre, int numero) {
        if (!isLlena()) {
            contactos[cantidad] = new Contacto(nombre, numero);
            cantidad++;
        }
    }

    public Contacto[] getContactosActivos() {
        Contacto[] activos = new Contacto[cantidad];
        for (int i = 0; i < cantidad; i++) {
            activos[i] = contactos[i];
        }
        return activos;
    }

    public Contacto buscarPorNombre(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return contactos[i];
            }
        }
        return null;
    }

    public boolean actualizarNumero(String nombre, int nuevoNumero) {
        Contacto c = buscarPorNombre(nombre);
        if (c != null) {
            c.setNumero(nuevoNumero);
            return true;
        }
        return false;
    }
}