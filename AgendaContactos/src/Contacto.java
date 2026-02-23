class Contacto {
    private String nombre;
    private int numero;

    public Contacto(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() { return nombre; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Número: " + numero;
    }
}